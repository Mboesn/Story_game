package story_game.gui.window;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import story_game.gui.util.OnClickFunction;

public class SaveOverrideConfirmationWindow {
    public static OnClickFunction overrideSaveFunction = () -> {
    };

    @FXML
    private Pane saveOverrideConfirmationPane;

    @FXML
    public void cancel() {
        guiUtil.closePopup(saveOverrideConfirmationPane);
    }

    @FXML
    public void override() {
        overrideSaveFunction.onClick();
        overrideSaveFunction = () -> {};
        cancel();
    }
}
