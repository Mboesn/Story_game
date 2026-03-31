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
        final double sceneWidth = 300;
        final double sceneHeight = 500;

        final double buttonSpacing = 15;
        final double backButtonInset = 30;

        Stage stage = new Stage();
        VBox root = new VBox();
        Scene scene = new Scene(root, sceneWidth, sceneHeight);

        LoadSaveButton save1 = new LoadSaveButton("Save 1", stage);
        LoadSaveButton save2 = new LoadSaveButton("Save 2", stage);
        LoadSaveButton save3 = new LoadSaveButton("Save 3", stage);

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

    private class LoadSaveButton extends ButtonCustom {

        /**
         * Creates a button that loads a save file when pressed
         * 
         * @param text              Name of the space file. add whitespaces according to
         *                          button name,
         *                          code will ignore when loading
         * @param loadSaveMenuStage the windows stage, used to close the window after
         *                          loading save
         */
        public LoadSaveButton(String text, Stage loadSaveMenuStage) {
            super(text);

            setOnMouseClicked(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent event) {
                    // loads the save file, removes white space from the text
                    SaveFile save = SaveHandler.loadGame(text.replaceAll("\\s+", ""));
                    if (save != null) {
                        GameWindow game = new GameWindow();
                        game.show(save);
                        loadSaveMenuStage.close();
                    } else {
                        System.out.println("failed to load save: " + text);
                    }
                }
            });
        }
    }
}
