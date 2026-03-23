package story_game.gui.window;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import story_game.gui.util.ButtonCustom;
import story_game.save_mechanics.SaveFile;
import story_game.save_mechanics.SaveHandler;

/**
 * This window lists all available saves, allowing to load a new one or save the
 * current one
 */
public class LoadSaveMenuWindow {
    public void show(Stage mainMenuStage) {

        final double buttonSpacing = 15;
        final double backButtonInset = 30;

        Stage stage = new Stage();
        VBox root = new VBox();
        Scene scene = new Scene(root, 300, 500);

        SaveButton save1 = new SaveButton("Save 1");
        SaveButton save2 = new SaveButton("Save 2");
        SaveButton save3 = new SaveButton("Save 3");

        ButtonCustom back = new ButtonCustom("Back");

        back.setOnMouseClicked(e -> {
            mainMenuStage.show();
            stage.close();
        });

        ObservableList<Node> list = root.getChildren();

        list.addAll(save1, save2, save3);

        // Makes the back button be more down
        VBox.setMargin(back, new Insets(backButtonInset, 0, 0, 0));
        list.add(back);

        root.setSpacing(buttonSpacing);
        root.setAlignment(Pos.CENTER);
        root.setFillWidth(true);

        stage.setScene(scene);
        stage.setTitle("Load save");
        // blocks all other windows till settings has been finished
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    // a button with all the logic to load a save file.
    private class SaveButton extends ButtonCustom {
        public SaveButton(String text) {
            super(text);

            setOnMouseClicked(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent event) {
                    // loads the games, removes white space from the text
                    SaveFile save = SaveHandler.loadGame(text.replaceAll("\\s+", ""));
                    GameWindow game = new GameWindow();
                    game.show(save);
                }
            });
        }
        // TODO: make button logic
    }
}
