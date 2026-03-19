package story_game.save_mechanics;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.gson.Gson;
import story_game.save_mechanics.scene_flags.SceneOneFlags;

public class SaveFile {
    private PlayerCharacter character;
    private SceneOneFlags sceneOneFlags;
    private transient String defaultSavePath;

    public SaveFile() {
        this.character = new PlayerCharacter();
        this.sceneOneFlags = new SceneOneFlags();
        this.defaultSavePath = System.getenv("LOCALAPPDATA") + "/" + "Super_cool_app";
    }

    public PlayerCharacter getCharacter() {
        return this.character;
    }

    public SceneOneFlags sceneOneFlags() {
        return this.sceneOneFlags;
    }

    /**
     * Saves the game to a new file given a path
     * 
     * @param dirPath  the path to folder in which to save the game
     * @param fileName the name of the json file
     * 
     * @returns a string of save file in Json format
     */
    public String saveGame(String dirPath, String fileName) {
        Gson gson = new Gson();

        Path dir = Paths.get(dirPath);
        String filePath = dirPath + "/" + fileName + ".json";

        try {
        // if a directory doesn't exist create it
            if (!Files.isDirectory(dir))
                Files.createDirectory(dir);
        } catch (Exception e) {
            System.out.println("failed to save to: " + filePath + " \n error: " + e);
            return e.toString();
        }

        try (FileWriter writer = new FileWriter(filePath)) {
            // save the save file
            gson.toJson(this, writer);

            System.out.println("saved to: " + filePath);

            return gson.toJson(this);
        } catch (IOException e) {
            System.out.println("failed to save to: " + filePath + " \n error: " + e);
            return e.toString();
        }
    }

    /**
     * Saves the game to a new file using the default path
     * 
     * @param fileName the name of the json file
     * 
     * @returns a string of save file in Json format
     */
    public String saveGame(String fileName) {
        return saveGame(this.defaultSavePath, fileName);
    }
}
