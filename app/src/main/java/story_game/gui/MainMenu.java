package story_game.gui;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
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
        Group root = new Group();
        Scene mainMenu = new Scene(root, 1000, 600);
        // Setting the title to Stage.
        primaryStage.setTitle(Constants.gameName);

        // Creating a Text object
        Text text = new Text();

        // Setting font to the text
        text.setFont(new Font(45));

        // setting the position of the text
        text.setX(350);
        text.setY(150);

        // Setting the text to be added.
        text.setText(Constants.gameName);

        // TODO: add button functions
        // create a button
        Button newGame = new Button("new game");
        newGame.setLayoutX(475);
        newGame.setLayoutY(200);

        // create a button
        Button loadGame = new Button("load game");
        loadGame.setLayoutX(475);
        loadGame.setLayoutY(250);

        // create a button
        Button settings = new Button("settings");
        settings.setLayoutX(475);
        settings.setLayoutY(300);

        Button exit = new Button("exit");
        exit.setLayoutX(475);
        exit.setLayoutY(350);

        // closes the game
        // TODO: make a are you sure? window
        exit.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                primaryStage.close();
            }
        }));
        // Retrieving the observable list object
        ObservableList<Node> list = root.getChildren();

        list.add(text);
        list.add(newGame);
        list.add(loadGame);
        list.add(settings);
        list.add(exit);

        // Setting the scene to Stage
        primaryStage.setScene(mainMenu);

        // Displaying the stage
        primaryStage.show();

    }

}
