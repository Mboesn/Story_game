package story_game.gui.window;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import story_game.gui.window.SaveMenuWindow.SaveMenuType;
import story_game.save_mechanics.settings.SettingsContainer;
import story_game.sound_system.AudioHandler;
import story_game.sound_system.Music;

public class MainMenuWindow extends Application {

    @Override
    public void start(Stage mainMenuStage) throws Exception {
        // Updates all the game settings based on loaded settings
        SettingsContainer.updateSettings();

        AudioHandler.playMusic(Music.DEFAULT);

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(FXMLPaths.MAIN_MENU.getPath()));
            AnchorPane anchorPane = loader.<AnchorPane>load();
            Scene scene = new Scene(anchorPane);

            mainMenuStage.setOnCloseRequest(e -> {
                e.consume();
                new ExitConfirmationAlert(e, mainMenuStage);
            });

            mainMenuStage.setScene(scene);
            mainMenuStage.show();

        } catch (Exception e) {
            System.out.println("Unable to load main menu \nError: " + e);
        }
    }

    /** Sends to game window using a fresh save file */
    @FXML
    public void newGame(ActionEvent event) {
        // SaveMenuWindow save = new SaveMenuWindow();
        // Node source = (Node) event.getSource();
        // Scene scene = source.getScene();
        // save.show((Stage) scene.getWindow(), SaveMenuType.NEW_GAME);
        // mainMenuStage.close();
    }

    /** Opens the save file window allowing you to choose what save file to load */
    @FXML
    public void loadGame() {
        // if (mainMenuStage != null) {
        // SaveMenuWindow save = new SaveMenuWindow();
        // save.show(mainMenuStage, SaveMenuType.LOAD_GAME);
        // mainMenuStage.close();
        // }
    }

    /**
     * Opens the achievements window which lists all completed and uncompleted
     * achievements.
     */
    @FXML
    public void achievements(ActionEvent event) {
        // AchievementsWindow achievementsWindow = new AchievementsWindow();
        // achievementsWindow.show();
        guiUtil.loadPopup(FXMLPaths.ACHIEVEMENTS_WINDOW, event);
    }

    /** Opens the settings window. */
    @FXML
    public void options(ActionEvent event) {
        guiUtil.loadPopup(FXMLPaths.SETTINGS, event);
    }

    /** Closes the game */
    @FXML
    public void exit(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        new ExitConfirmationAlert(event, stage);
    }
}
