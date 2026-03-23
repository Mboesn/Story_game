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

/**
 * The scene for the main menu of the game.
 * this should be launched when the game is started.
 */
public class MainMenuWindow extends Application {

    @Override
    public void start(Stage mainMenuStage) throws Exception {

        final double buttonSpacing = 15;

        VBox root = new VBox();
        Scene mainMenu = new Scene(root, 1000, 600);
        // Setting the title to Stage.
        mainMenuStage.setTitle(Constants.GAME_NAME);

        // Creating a Text object
        Text titleText = new Text();

        // Setting font to the text
        titleText.setFont(new Font(45));

        // Setting the text to be added.
        titleText.setText(Constants.GAME_NAME);

        // TODO: add button functions

        // Sends to game window using a fresh save file
        ButtonCustom newGame = new ButtonCustom("New game");

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

        // TODO: make a are you sure? window
        exit.setOnMouseClicked(e -> mainMenuStage.close());

        ObservableList<Node> list = root.getChildren();

        list.addAll(titleText, newGame, loadGame, settings, exit);
        root.setSpacing(buttonSpacing);
        root.setAlignment(Pos.CENTER);
        root.setFillWidth(true);

        mainMenuStage.setScene(mainMenu);
        mainMenuStage.show();
    }
}
