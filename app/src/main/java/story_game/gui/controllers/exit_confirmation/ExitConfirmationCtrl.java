package story_game.gui.controllers.exit_confirmation;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import story_game.gui.util.OnClickFunction;
import story_game.gui.util.PopupHandler;

public class ExitConfirmationCtrl {
    protected static OnClickFunction onExit = () -> {
    };
    protected static OnClickFunction exitFunction = () -> {
    };

    @FXML
    private Pane exitPane;

    @FXML
    public void cancel() {
        onExit = () -> {
        };
        exitFunction = () -> {
        };
        PopupHandler.closePopup(exitPane);
    }

    @FXML
    public void exit() {
        onExit.onClick();
        onExit = () -> {
        };
        exitFunction.onClick();
        exitFunction = () -> {
        };
        cancel();
    }
}
