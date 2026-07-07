package story_game.gui.controllers.save_menu;

import javafx.event.ActionEvent;
import story_game.gui.controllers.save_menu.SaveMenuCtrl.SaveMenuType;
import story_game.gui.controllers.save_menu.SaveMenuCtrl.SaveType;
import story_game.gui.util.FXMLPaths;
import story_game.gui.util.PopupHandler;
import story_game.save_mechanics.save_file.SaveFile;

/**
 * Use this class to launch the save menu window.
 */
public class SaveMenuFunctions {
    /**
     * Creates a new save file and saves it to a chosen save location.
     */
    public static void newGame(ActionEvent event) {
        SaveMenuCtrl.saveMenuType = SaveMenuType.NEW_GAME;
        PopupHandler.loadPopup(FXMLPaths.SAVE_MENU, event);
    }

    /**
     * Saves a given save file to a chosen save location.
     * 
     * @param saveFile Save file to save.
     */
    public static void saveGame(ActionEvent event, SaveFile saveFile) {
        SaveMenuCtrl.saveMenuType = SaveMenuType.SAVE_GAME;
        PopupHandler.loadPopup(FXMLPaths.SAVE_MENU, event);
    }

    /**
     * Loads a chosen save file.
     */
    public static void loadGame(ActionEvent event) {
        SaveMenuCtrl.saveMenuType = SaveMenuType.LOAD_GAME;
        PopupHandler.loadPopup(FXMLPaths.SAVE_MENU, event);
    }

    /**
     * Saves a save file automatically to the newest quick-save/auto-save.
     * 
     * @param saveFile Save file to save.
     * @param saveType The type of save to save to.
     */
    public static void quickSave(SaveFile saveFile, SaveType saveType) {
        SaveMenuCtrl.quickSave(saveFile, saveType);
    }

    /**
     * Automatically loads the newest quick-save file.
     */
    public static void quickLoad() {
        SaveMenuCtrl.quickLoad();
    }
}
