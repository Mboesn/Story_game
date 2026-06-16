package story_game.gui.controllers.save_menu;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import story_game.gui.util.OnClickFunction;
import story_game.gui.util.PopupHandler;

public class SaveOverrideConfirmationCtrl {
    public static OnClickFunction overrideSaveFunction = () -> {
    };

    @FXML
    private Pane saveOverrideConfirmationPane;

    @FXML
    public void cancel() {
        PopupHandler.closePopup(saveOverrideConfirmationPane);
    }

    @FXML
    public void override() {
        overrideSaveFunction.onClick();
        overrideSaveFunction = () -> {};
        cancel();
    }
}
