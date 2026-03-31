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
     */
    public static void confirmExit(Stage stage) {
        Alert exitConfirmationAlert = new Alert(AlertType.CONFIRMATION);
        exitConfirmationAlert.setTitle("Are you sure?");
        exitConfirmationAlert.setHeaderText("You are about to exit?");
        exitConfirmationAlert.setContentText("All unsaved progress will be deleted");

        Optional<ButtonType> isExit = exitConfirmationAlert.showAndWait();
        if (isExit.isPresent() && isExit.get() == ButtonType.OK)
            stage.close();
    }
}
