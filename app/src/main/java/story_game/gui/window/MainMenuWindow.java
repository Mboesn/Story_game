package story_game.gui.window;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import story_game.Constants;
import story_game.gui.util.ButtonCustom;
import story_game.save_mechanics.SaveFile;

/**
 * The scene for the main menu of the game.
 * this should be launched when the game is started.
 */
public class MainMenuWindow extends Application {
    @Override
    public void start(Stage mainMenuStage) throws Exception {
        final double sceneWidth = 1000;
        final double sceneHeight = 600;

        final double buttonSpacing = 15;

        VBox root = new VBox();
        Scene mainMenuScene = new Scene(root, sceneWidth, sceneHeight);
        mainMenuStage.setTitle(Constants.GAME_NAME);
        mainMenuStage.setOnCloseRequest(e -> {
            e.consume();
            ExitConfirmationAlert.confirmExit(mainMenuStage);
        });

        // Game's title card
        Text titleText = new Text();
        titleText.setFont(new Font(45));
        titleText.setText(Constants.GAME_NAME);

        // Sends to game window using a fresh save file
        ButtonCustom newGame = new ButtonCustom("New game");
        newGame.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                GameWindow game = new GameWindow();
                game.show(new SaveFile());
                mainMenuStage.close();
            }
        });

        // Opens the save file window allowing you to choose what save file to load
        ButtonCustom loadGame = new ButtonCustom("Load game");

        loadGame.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                LoadSaveMenuWindow save = new LoadSaveMenuWindow();
                save.show(mainMenuStage);
                mainMenuStage.close();
            }
        });

        // Opens the settings window.
        ButtonCustom settings = new ButtonCustom("Settings");

        settings.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                SettingsWindow settings = new SettingsWindow();
                settings.show();
            }
        });

        // Closes the game
        ButtonCustom exit = new ButtonCustom("Exit");
        exit.setOnMouseClicked(e -> ExitConfirmationAlert.confirmExit(mainMenuStage));

        ObservableList<Node> list = root.getChildren();

        list.addAll(titleText, newGame, loadGame, settings, exit);
        root.setSpacing(buttonSpacing);
        root.setAlignment(Pos.CENTER);
        root.setFillWidth(true);

        mainMenuStage.setScene(mainMenuScene);
        mainMenuStage.show();
    }
}
