package story_game.gui.window;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import story_game.Constants;
import story_game.save_mechanics.SaveFile;

public class GameWindow {
    public void show(SaveFile saveFile) {
        final double sceneWidth = 1000;
        final double sceneHeight = 600;

        Stage stage = new Stage();
        VBox root = new VBox();
        Scene scene = new Scene(root, sceneWidth, sceneHeight);
        stage.setScene(scene);
        stage.setTitle(Constants.GAME_NAME);
        stage.setOnCloseRequest(e -> {
            e.consume();
            ExitConfirmationAlert.confirmExit(stage);
        });

        //TODO: add everything
        
        // blocks all other windows till settings has been finished
        stage.initModality(Modality.NONE);

        stage.show();
    }
}
