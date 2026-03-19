package story_game.save_mechanics;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.gson.Gson;

public class SaveHandler {

    private static final transient String defaultSavePath = System.getenv("LOCALAPPDATA") + "/" + "Super_cool_app";

    /**
     * Saves the game to a new file given a path
     * 
     * @param saveFile save file to save
     * @param fileName the name of the json file
     * @param dirPath  the path to folder in which to save the game
     * 
     * @returns a string of save file in Json format or error exception
     */
    public static String saveGame(SaveFile saveFile, String fileName, String dirPath) {
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
            gson.toJson(saveFile, writer);

            System.out.println("saved to: " + filePath);

            return gson.toJson(saveFile);
        } catch (IOException e) {
            System.out.println("failed to save to: " + filePath + " \n error: " + e);
            return e.toString();
        }
    }

    /**
     * Saves the game to a new file using the default path
     * 
     * @param saveFile save file to save
     * @param fileName the name of the json file
     * 
     * @returns a string of save file in Json format
     */
    public static String saveGame(SaveFile saveFile, String fileName) {
        return saveGame(saveFile, fileName, defaultSavePath);
    }

    /**
     * load a save file from a given path and file
     * 
     * @param fileName the name of the json file
     * @param dirPath  the path to folder in which to save the game
     * 
     * @return the loaded save fill, return null if failed to load.
     */
    public static SaveFile loadGame(String fileName, String dirPath) {
        Gson gson = new Gson();
        String filePath = dirPath + "/" + fileName + ".json";

        try (FileReader reader = new FileReader(filePath)) {
            // loads the save file
            SaveFile save = gson.fromJson(reader, SaveFile.class);
            System.out.println("loaded: " + filePath);

            return save;
        } catch (IOException e) {
            System.out.println("failed to load: " + filePath + " \n error: " + e);
            return null;
        }
    }

    /**
     * load a save file using default save path, overrides all values to be equal to
     * the save file
     * 
     * @param fileName the name of the json file
     * 
     * @return the loaded save fill, return null if failed to load.
     */
    public static SaveFile loadGame(String fileName) {
        return loadGame(fileName, defaultSavePath);
    }
}
