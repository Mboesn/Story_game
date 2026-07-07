package story_game.gui.controllers.save_menu;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import story_game.gui.util.OnClickFunction;
import story_game.gui.util.PopupHandler;

/**
 * Asks the user to confirm that they wish to override a save.
 */
public class SaveOverrideConfirmationCtrl {
    public static OnClickFunction overrideSaveFunction = () -> {
    };

    @FXML
    private Pane saveOverrideConfirmationPane;

    /**
     * Closes this window without overriding save.
     */
    @FXML
    public void cancel() {
        PopupHandler.closePopup(saveOverrideConfirmationPane);
    }

    /**
     * Overrides the save and then closes this window.
     */
    @FXML
    public void override() {
        overrideSaveFunction.onClick();
        overrideSaveFunction = () -> {
        };
        cancel();
    }
}
