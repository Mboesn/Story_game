package story_game.gui.window;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ExitConfirmationAlert {

    /**
     * Opens a confirmation alert asking the user if he wishes to close a given
     * stage.
     * 
     * @param title   The Title of the dialog.
     * @param header  The Title of the dialog.
     * @param content The string to show in the dialog content area.
     * 
     * @return True if window closed
     */
    private static boolean confirmExit(String title, String header, String content) {
        Alert exitConfirmationAlert = new Alert(AlertType.CONFIRMATION);
        exitConfirmationAlert.setTitle(title);
        exitConfirmationAlert.setHeaderText(header);
        exitConfirmationAlert.setContentText(content);

        Optional<ButtonType> isExit = exitConfirmationAlert.showAndWait();

        return isExit.isPresent() && isExit.get() == ButtonType.OK;
    }

    /**
     * Opens a confirmation alert asking the user if he wishes to close a given
     * stage
     * 
     * @param stage stage to close if OK is selected
     * 
     * @return True if window closed
     */
    public static boolean confirmExit() {
        return confirmExit("Are you sure?", "You are about to exit",
                "All unsaved progress will be deleted");
    }

    /**
     * Opens a confirmation alert asking the user if he wishes to close a given
     * stage
     * 
     * @param stage stage to close if OK is selected
     * 
     * @return True if window closed
     */
    public static boolean confirmExit(Stage stage) {
        boolean exit = confirmExit("Are you sure?", "You are about to exit",
                "All unsaved progress will be deleted");
        if (exit)
            stage.close();
        return exit;
    }

    /**
     * Opens a confirmation alert asking the user if he wishes to close a given
     * stage
     * 
     * @param stage stage to close if OK is selected
     * 
     * @return True if window closed
     */
    public static boolean confirmExit(Pane pane) {
        boolean exit = confirmExit("Are you sure?", "You are about to exit", "All unsaved progress will be deleted");
        if (exit)
            ((Pane) pane.getParent()).getChildren().remove(pane);
        return exit;
    }
}
