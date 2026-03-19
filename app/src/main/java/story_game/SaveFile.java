package story_game;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

import story_game.scene_flags.SceneOneFlags;

public class SaveFile {
    private PlayerCharacter character;
    private SceneOneFlags sceneOneFlags;

    public SaveFile() {
        this.character = new PlayerCharacter();
    }

    public PlayerCharacter getCharacter() {
        return this.character;
    }

    public SceneOneFlags sceneOneFlags() {
        return this.sceneOneFlags;
    }
    
    /**
     * Saves the game to a new file given a path
     * @param dirPath the path to folder in which to save the game
     * @param fileName the name of the json file
     */
    public void saveGame(String dirPath, String fileName) {
        Gson gson = new Gson();

        String filePath = dirPath + "/" + fileName + ".json";

        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(this, writer);
            System.out.println("saved to: " + filePath);
        }
        catch (IOException  e) {
            System.out.println("failed to save to: " + filePath +" \n error: " + e);
        }
    }

    public String chooseFile() {
        
        return "";
    }
}
