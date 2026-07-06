package story_game.gui.controllers.exit_confirmation;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import story_game.gui.util.OnClickFunction;
import story_game.gui.util.PopupHandler;

/**
 * Open this up when needing to confirm exiting something.
 */
public class ExitConfirmationCtrl {
    protected static OnClickFunction onExit = () -> {
    };
    protected static OnClickFunction exitFunction = () -> {
    };

    @FXML
    private Pane exitPane;

    @FXML
    /**
     * Cancels the exit.
     */
    public void cancel() {
        onExit = () -> {
        };
        exitFunction = () -> {
        };
        PopupHandler.closePopup(exitPane);
    }

    @FXML
    /**
     * Calls the functions set for exit.
     */
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
