package story_game.gui.window;

import javafx.event.ActionEvent;
import story_game.gui.window.SaveMenuWindow.SaveMenuType;
import story_game.save_mechanics.save_file.SaveFile;

public class SaveMenu {
    public static void newGame(ActionEvent event) {
        SaveMenuWindow.saveMenuType = SaveMenuType.NEW_GAME;
        guiUtil.loadPopup(FXMLPaths.SAVE_MENU, event);
    }

    public static void saveGame(ActionEvent event, SaveFile saveFile) {
        SaveMenuWindow.saveMenuType = SaveMenuType.SAVE_GAME;
        guiUtil.loadPopup(FXMLPaths.SAVE_MENU, event);
    }

    public static void loadGame(ActionEvent event) {
        SaveMenuWindow.saveMenuType = SaveMenuType.LOAD_GAME;
        guiUtil.loadPopup(FXMLPaths.SAVE_MENU, event);
    }
}
