package story_game.save_mechanics;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

import org.reflections.Reflections;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;

import story_game.Constants;
import story_game.text.Page;

public class SaveHandler {
    // This path leads to the game folder in the local appdata
    private static final String defaultSavePath = System.getenv("LOCALAPPDATA") + "/" + Constants.GAME_NAME;
    // This path leads to the pages package
    private static final String pagesPackage = "story_game.text.pages";
    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapterFactory(createFactory())
            .setPrettyPrinting()
            .create();

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

        Path dir = Paths.get(dirPath);
        String filePath = dirPath + "/" + fileName + ".json";

        try {
            // if a directory doesn't exist create it
            if (!Files.isDirectory(dir))
                Files.createDirectory(dir);
        } catch (Exception e) {
            System.out.println("failed to create path: " + filePath + " \n error: " + e);
            return e.toString();
        }

        try (FileWriter writer = new FileWriter(filePath)) {
            // save the save file
            gson.toJson(saveFile, writer);

            System.out.println("saved to: " + filePath);

            // returns a string version of json file, this does not affect the saved file
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
     * @return the loaded save file, return null if failed to load.
     */
    public static SaveFile loadGame(String fileName, String dirPath) {

        String filePath = dirPath + "/" + fileName + ".json";

        try (FileReader reader = new FileReader(filePath)) {
            // loads the save file
            try {
                SaveFile save = gson.fromJson(reader, SaveFile.class);
                System.out.println("loaded: " + filePath);
                return save;
            } catch (Exception e) {
                System.out.println("failed to deserialize: " + filePath + " \n error: " + e);
                return null;
            }
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

    /**
     * Creates a TypeAdapterFactory which tells the Gson object what are the
     * subclasses of Page
     * this is used in order to save the current page
     * 
     * @return TypeAdapterFactory to save in the Gson object
     */
    private static TypeAdapterFactory createFactory() {
        Reflections reflections = new Reflections(pagesPackage);
        Set<Class<? extends Page>> subclasses = reflections.getSubTypesOf(Page.class);

        RuntimeTypeAdapterFactory<Page> factory = RuntimeTypeAdapterFactory.of(Page.class, "type");
        for (Class<? extends Page> clazz : subclasses) {
            factory.registerSubtype(clazz, clazz.getSimpleName());
        }
        return factory;
    }
}
