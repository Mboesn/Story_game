package story_game.gui.window;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import story_game.Constants;
import story_game.save_mechanics.SaveFile;

public class GameWindow {
    public void show(SaveFile saveFile) {
        Stage stage = new Stage();
        VBox root = new VBox();
        Scene scene = new Scene(root, 1000, 600);

        System.out.println(saveFile);

        stage.setScene(scene);
        stage.setTitle(Constants.GAME_NAME);
        // blocks all other windows till settings has been finished
        stage.initModality(Modality.NONE);
        stage.show();        
    }
}
