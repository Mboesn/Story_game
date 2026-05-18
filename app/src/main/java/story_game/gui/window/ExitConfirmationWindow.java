package story_game.gui.window;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import story_game.gui.util.OnClickFunction;

public class ExitConfirmationWindow {
    public static OnClickFunction onExit = () -> {
    };
    public static OnClickFunction exitFunction = () -> {
    };

    @FXML
    private Pane exitPane;

    @FXML
    public void cancel() {
        guiUtil.closePopup(exitPane);
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
