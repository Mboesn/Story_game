package story_game.gui.window;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class ExitConfirmationAlert {

    /**
     * Opens a confirmation alert asking the user if he wishes to close a given
     * stage
     * 
     * @param stage stage to close if OK is selected
     * 
     * @return True if window closed
     */
    public static boolean confirmExit(Stage stage, String title, String header, String content) {
        Alert exitConfirmationAlert = new Alert(AlertType.CONFIRMATION);
        exitConfirmationAlert.setTitle(title);
        exitConfirmationAlert.setHeaderText(header);
        exitConfirmationAlert.setContentText(content);

        Optional<ButtonType> isExit = exitConfirmationAlert.showAndWait();

        boolean exit = isExit.isPresent() && isExit.get() == ButtonType.OK;
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
    public static boolean confirmExit(Stage stage) {
        return confirmExit(stage, "Are you sure?", "You are about to exit", "All unsaved progress will be deleted");
    }
}