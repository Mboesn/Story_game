package story_game.gui.controllers.exit_confirmation;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import story_game.gui.util.OnClickFunction;
import story_game.gui.util.PopupHandler;

public class ExitConfirmationCtrl {
    public static OnClickFunction onExit = () -> {
    };
    public static OnClickFunction exitFunction = () -> {
    };

    @FXML
    private Pane exitPane;

    @FXML
    public void cancel() {
        PopupHandler.closePopup(exitPane);
    }

    @FXML
    public void exit() {
        onExit.onClick();
        onExit = () -> {};
        exitFunction.onClick();
        exitFunction = () -> {};
        cancel();
    }
}
