package story_game.gui.controllers.save_menu;

import javafx.event.ActionEvent;
import story_game.gui.controllers.save_menu.SaveMenuCtrl.SaveMenuType;
import story_game.gui.controllers.save_menu.SaveMenuCtrl.SaveType;
import story_game.gui.util.FXMLPaths;
import story_game.gui.util.PopupHandler;
import story_game.save_mechanics.save_file.SaveFile;

public class SaveMenuFunctions {
    public static void newGame(ActionEvent event) {
        SaveMenuCtrl.saveMenuType = SaveMenuType.NEW_GAME;
        PopupHandler.loadPopup(FXMLPaths.SAVE_MENU, event);
    }

    public static void saveGame(ActionEvent event, SaveFile saveFile) {
        SaveMenuCtrl.saveMenuType = SaveMenuType.SAVE_GAME;
        PopupHandler.loadPopup(FXMLPaths.SAVE_MENU, event);
    }

    public static void loadGame(ActionEvent event) {
        SaveMenuCtrl.saveMenuType = SaveMenuType.LOAD_GAME;
        PopupHandler.loadPopup(FXMLPaths.SAVE_MENU, event);
    }

    public static void quickSave(SaveFile saveFile, SaveType saveType) {
        SaveMenuCtrl.quickSave(saveFile, saveType);
    }

    public static void quickLoad() {
        SaveMenuCtrl.quickLoad();
    }
}
