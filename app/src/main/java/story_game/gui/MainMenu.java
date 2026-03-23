package story_game.gui;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import story_game.Constants;

/**
 * The scene for the main menu of the game.
 * this should be launched when the game is started.
 */
public class MainMenu extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox();
        Scene mainMenu = new Scene(root, 1000, 600);
        // Setting the title to Stage.
        primaryStage.setTitle(Constants.gameName);

        // Creating a Text object
        Text titleText = new Text();

        // Setting font to the text
        titleText.setFont(new Font(45));

        // Setting the text to be added.
        titleText.setText(Constants.gameName);

        final double buttonWidth = 200;

        // TODO: add button functions

        // Sends to game window using a fresh save file
        Button newGame = new Button("New game");
        newGame.setMaxWidth(buttonWidth);

        // Opens the save file window allowing you to choose what save file to load
        Button loadGame = new Button("Load game");
        loadGame.setMaxWidth(buttonWidth);

        // Opens the settings window.
        Button settings = new Button("Settings");
        settings.setMaxWidth(buttonWidth);

        settings.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                SettingsMenu settings = new SettingsMenu();
                settings.show();
            }
        }));

        // Closes the game
        Button exit = new Button("Exit");
        exit.setMaxWidth(buttonWidth);

        // TODO: make a are you sure? window
        exit.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                primaryStage.close();
            }
        }));

        ObservableList<Node> list = root.getChildren();

        list.addAll(titleText, newGame, loadGame, settings, exit);
        root.setAlignment(Pos.CENTER);
        root.setFillWidth(true);

        primaryStage.setScene(mainMenu);
        primaryStage.show();
    }
}
