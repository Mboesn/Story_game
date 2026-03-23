package story_game.gui.window;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SettingsWindow {

    public void show() {
        Stage stage = new Stage();

        
        VBox root = new VBox();

        Scene scene = new Scene(root, 400, 250);

        stage.setScene(scene);
        stage.setTitle("Settings");
        // blocks all other windows till settings has been finished
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

}
