package story_game.gui.window;

import javafx.event.Event;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import story_game.gui.util.OnClickFunction;

public class ExitConfirmationAlert {

    /**
     * Opens a confirmation alert asking the user if he wishes to close a given
     * stage.
     */
    private ExitConfirmationAlert(Event event, OnClickFunction... onExit) {
        ExitConfirmationWindow.onExit = () -> {
            for (OnClickFunction onClickFunction : onExit) {
                onClickFunction.onClick();
            }
        };
        guiUtil.loadPopup(FXMLPaths.EXIT, event);
    }

    /**
     * Opens a confirmation alert asking the user if he wishes to close a given
     * stage
     * 
     * @param stage stage to close if OK is selected
     * 
     * @return True if window closed
     */
    public ExitConfirmationAlert(Event event, Stage stage, OnClickFunction... onExit) {
        ExitConfirmationWindow.exitFunction = () -> stage.close();
        temp(event, onExit);
        // this(event, onExit);
        // TODO: upgrade to java 26
    }

    /**
     * Opens a confirmation alert asking the user if he wishes to close a given
     * stage
     * 
     * @param stage stage to close if OK is selected
     * 
     * @return True if window closed
     */
    public ExitConfirmationAlert(Event event, Pane pane, OnClickFunction... onExit) {
        ExitConfirmationWindow.exitFunction = () -> guiUtil.closePopup(pane);
        temp(event, onExit);
        // this(event, onExit);
    }

    private void temp(Event event, OnClickFunction... onExit) {
        ExitConfirmationWindow.onExit = () -> {
            for (OnClickFunction onClickFunction : onExit) {
                onClickFunction.onClick();
            }
        };
        guiUtil.loadPopup(FXMLPaths.EXIT, event);
    }
}
