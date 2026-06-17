package story_game.gui.controllers.exit_confirmation;

import javafx.event.Event;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import story_game.gui.util.FXMLPaths;
import story_game.gui.util.OnClickFunction;
import story_game.gui.util.PopupHandler;

public class ExitConfirmationFunctions {

    /**
     * Opens a confirmation alert asking the user if he wishes to close a given
     * stage.
     */
    public ExitConfirmationFunctions(Event event, OnClickFunction... onExit) {
        ExitConfirmationCtrl.exitFunction = () -> {
        };
        ExitConfirmationCtrl.onExit = () -> {
            for (OnClickFunction onClickFunction : onExit) {
                onClickFunction.onClick();
            }
        };
        PopupHandler.loadPopup(FXMLPaths.EXIT, event);
    }

    /**
     * Opens a confirmation alert asking the user if he wishes to close a given
     * stage
     * 
     * @param stage stage to close if OK is selected
     * 
     * @return True if window closed
     */
    public ExitConfirmationFunctions(Event event, Stage stage, OnClickFunction... onExit) {
        ExitConfirmationCtrl.exitFunction = () -> stage.close();
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
    public ExitConfirmationFunctions(Event event, Pane pane, OnClickFunction... onExit) {
        ExitConfirmationCtrl.exitFunction = () -> PopupHandler.closePopup(pane);
        temp(event, onExit);
        // this(event, onExit);
    }

    private void temp(Event event, OnClickFunction... onExit) {
        ExitConfirmationCtrl.onExit = () -> {
            for (OnClickFunction onClickFunction : onExit) {
                onClickFunction.onClick();
            }
        };
        PopupHandler.loadPopup(FXMLPaths.EXIT, event);
    }
}
