package story_game.gui.controllers.exit_confirmation;

import javafx.event.Event;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import story_game.gui.util.FXMLPaths;
import story_game.gui.util.OnClickFunction;
import story_game.gui.util.PopupHandler;

public class ExitConfirmationFunctions {

    /**
     * Opens a ExitConfirmation window and closes a given pane.
     * 
     * @param event  event that called ExitConfirmationFunctions.
     * @param onExit extra functions to call when exiting.
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
     * Opens a ExitConfirmation window and closes a given stage.
     * 
     * @param event  event that called ExitConfirmationFunctions.
     * @param stage  stage to close.
     * @param onExit extra functions to call when exiting.
     */
    public ExitConfirmationFunctions(Event event, Stage stage, OnClickFunction... onExit) {
        ExitConfirmationCtrl.exitFunction = () -> stage.close();
        temp(event, onExit);
        // this(event, onExit);
        // TODO: upgrade to java 26
    }

    /**
     * Opens a ExitConfirmation window and closes a given pane.
     * 
     * @param event  event that called ExitConfirmationFunctions.
     * @param pane   pane to close.
     * @param onExit extra functions to call when exiting.
     */
    public ExitConfirmationFunctions(Event event, Pane pane, OnClickFunction... onExit) {
        ExitConfirmationCtrl.exitFunction = () -> PopupHandler.closePopup(pane);
        temp(event, onExit);
        // this(event, onExit);
    }

    /**
     * Temporary method holding the closing method till the code ins upgraded to
     * java 26 and we can call the first constructor after calling code;
     * 
     * @param event  event that called ExitConfirmationFunctions.
     * @param onExit extra functions to call when exiting.
     */
    private void temp(Event event, OnClickFunction... onExit) {
        ExitConfirmationCtrl.onExit = () -> {
            for (OnClickFunction onClickFunction : onExit) {
                onClickFunction.onClick();
            }
        };
        PopupHandler.loadPopup(FXMLPaths.EXIT, event);
    }
}
