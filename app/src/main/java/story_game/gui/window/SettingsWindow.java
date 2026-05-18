package story_game.gui.window;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import story_game.save_mechanics.settings.SettingsContainer;
import story_game.save_mechanics.settings.SettingsFile;
import story_game.sound_system.AudioHandler;

public class SettingsWindow {
    SettingsFile tempSettingsFile;
    @FXML
    private Label musicLbl;
    @FXML
    private Slider musicSlider;
    @FXML
    private Label sfxLbl;
    @FXML
    private Slider sfxSlider;
    @FXML
    private Pane settingsPane;

    public static Pane getSettingsPane(Scene scene) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(SettingsWindow.class.getResource(FXMLPaths.SETTINGS.getPath()));
            Pane anchorPane = loader.<Pane>load();
            AnchorPane.setTopAnchor(anchorPane, 0.0);
            AnchorPane.setBottomAnchor(anchorPane, 0.0);
            AnchorPane.setLeftAnchor(anchorPane, 0.0);
            AnchorPane.setRightAnchor(anchorPane, 0.0);
            return anchorPane;
        } catch (Exception e) {
            System.out.println("Failed to open settings\nError: " + e);
            return null;
        }
    }

    @FXML
    public void initialize() {
        tempSettingsFile = new SettingsFile(SettingsContainer.getSettings());
        musicLbl.setText("Music: " + (int) (tempSettingsFile.getAudioSettings().getMusicVolume() * 100) + "%");
        musicSlider.setValue(tempSettingsFile.getAudioSettings().getMusicVolume());
        musicSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            tempSettingsFile.getAudioSettings().setMusicVolume(newVal.doubleValue());
            AudioHandler.setMusicVolume(newVal.doubleValue());
            musicLbl.setText("Music: " + (int) (newVal.doubleValue() * 100) + "%");
        });

        sfxLbl.setText("SFX: " + (int) (tempSettingsFile.getAudioSettings().getSFXVolume() * 100) + "%");
        sfxSlider.setValue(tempSettingsFile.getAudioSettings().getSFXVolume());
        sfxSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            tempSettingsFile.getAudioSettings().setSFXVolume(newVal.doubleValue());
            sfxLbl.setText("SFX: " + (int) (newVal.doubleValue() * 100) + "%");
        });
    }

    /** Saves the settings */
    @FXML
    public void save() {
        try {
            SettingsContainer.updateSettings(tempSettingsFile);
            ((Pane) settingsPane.getParent()).getChildren().remove(settingsPane);
        } catch (Exception e) {
            System.out.println("Couldn't save settings.\nError: " + e);
        }
    }

    /** Sets settings to default. */
    @FXML
    public void reset() {
        try {
            if (ExitConfirmationAlert.confirmExit()) {
                SettingsContainer.updateSettings(new SettingsFile());
                ((Pane) settingsPane.getParent()).getChildren().remove(settingsPane);
            }
        } catch (Exception e) {
            System.out.println("Couldn't save settings.\nError: " + e);
        }
    }

    /** Closes the game */
    @FXML
    public void exit() {
        ExitConfirmationAlert.confirmExit(settingsPane);
    }
}
