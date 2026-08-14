package story_game.gui.controllers.main_menu;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import story_game.Constants;
import story_game.gui.controllers.exit_confirmation.ExitConfirmationFunctions;
import story_game.gui.controllers.save_menu.SaveMenuFunctions;
import story_game.gui.util.FXMLPaths;
import story_game.gui.util.PopupHandler;
import story_game.gui.util.StageHandler;
import story_game.save_mechanics.settings.SettingsContainer;
import story_game.sound_system.AudioHandler;
import story_game.sound_system.Music;

/**
 * The opening screen and menu of the game. Launch this in main.
 */
public class MainMenuCtrl extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        StageHandler.stage = stage;

        stage.setTitle(Constants.Names.GAME_NAME);

        // Updates all the game settings based on loaded settings
        SettingsContainer.updateSettings();

        AudioHandler.playMusic(Music.DEFAULT);

        try {
            setupMainMenuStage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(FXMLPaths.MAIN_MENU.getPath()));
            StackPane anchorPane = loader.<StackPane>load();
            Scene scene = new Scene(anchorPane);

            // Load and add the global stylesheet
            scene.getStylesheets().add(getClass().getResource(Constants.GLOBAL_CSS_PATH).toExternalForm());

            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println("Unable to load main menu \nError: " + e);
        }
    }

    /**
     * Sets the stage to match the main-menu settings. Call before launching the
     * stage or switching to this scene.
     */
    public static void setupMainMenuStage() {
        StageHandler.stage.setMaximized(true);
        StageHandler.stage.setOnCloseRequest(e -> {
            e.consume();
            new ExitConfirmationFunctions(e, StageHandler.stage);
        });
    }

    /** Sends to game window using a fresh save file */
    @FXML
    public void newGame(ActionEvent event) {
        SaveMenuFunctions.newGame(event);
    }

    /** Opens the save file window allowing you to choose what save file to load */
    @FXML
    public void loadGame(ActionEvent event) {
        SaveMenuFunctions.loadGame(event);
    }

    /**
     * Opens the achievements window which lists all completed and uncompleted
     * achievements.
     */
    @FXML
    public void achievements(ActionEvent event) {
        PopupHandler.loadPopup(FXMLPaths.ACHIEVEMENTS_WINDOW, event);
    }

    /** Opens the settings window. */
    @FXML
    public void options(ActionEvent event) {
        PopupHandler.loadPopup(FXMLPaths.SETTINGS, event);
    }

    /** Closes the game */
    @FXML
    public void exit(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        new ExitConfirmationFunctions(event, stage);
    }
}
