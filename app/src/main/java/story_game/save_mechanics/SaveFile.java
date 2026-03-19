package story_game.save_mechanics;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

import javafx.application.Application;
import javafx.stage.Stage;
import story_game.save_mechanics.scene_flags.SceneOneFlags;

public class SaveFile extends Application {
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
     * 
     * @param dirPath  the path to folder in which to save the game
     * @param fileName the name of the json file
     */
    public void saveGame(String dirPath, String fileName) {
        Gson gson = new Gson();

        String filePath = dirPath + "/" + fileName + ".json";

        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(this, writer);
            System.out.println("saved to: " + filePath);
        } catch (IOException e) {
            System.out.println("failed to save to: " + filePath + " \n error: " + e);
        }
    }

    /** creates a window in order to choose a save folder */
    @Override
    public void start(Stage stage) {
        try {
            stage.setTitle("file chooser");
            
        } catch (Exception e) {
            System.out.println("Failed to selected a save folder \n error: " + e);
        }
    }
}
