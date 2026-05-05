package story_game.gui.window;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import story_game.gui.util.ButtonCustom;
import story_game.save_mechanics.settings.SettingsContainer;
import story_game.save_mechanics.settings.SettingsFile;
import story_game.sound_system.AudioHandler;

public class SettingsWindow {

    public void show() {
        SettingsFile tempSettingsFile = new SettingsFile(SettingsContainer.getSettings());
        final double sceneWidth = 400;
        final double sceneHeight = 250;
        final double buttonSpacing = 10;

        Stage stage = new Stage();
        VBox root = new VBox();
        Scene scene = new Scene(root, sceneWidth, sceneHeight);

        ObservableList<Node> rootList = root.getChildren();

        stage.setScene(scene);
        stage.setTitle("Settings");

        Label musicLabel = new Label("Music: " + (int) (tempSettingsFile.getAudioSettings().musicVolume * 100) + "%");
        Slider musicSlider = new Slider(0, 1, tempSettingsFile.getAudioSettings().musicVolume);
        musicSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            tempSettingsFile.getAudioSettings().musicVolume = newVal.doubleValue();
            AudioHandler.setMusicVolume(newVal.doubleValue());
            musicLabel.setText("Music: " + (int) (newVal.doubleValue() * 100) + "%");
        });
        rootList.add(new HBox(buttonSpacing, musicLabel, musicSlider));

        Label sfxLabel = new Label("SFX: " + (int) (tempSettingsFile.getAudioSettings().sfxVolume * 100) + "%");
        Slider sfxSlider = new Slider(0, 1, tempSettingsFile.getAudioSettings().sfxVolume);
        sfxSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            tempSettingsFile.getAudioSettings().sfxVolume = newVal.doubleValue();
            sfxLabel.setText("SFX: " + (int) (newVal.doubleValue() * 100) + "%");
        });
        rootList.add(new HBox(buttonSpacing, sfxLabel, sfxSlider));

        ButtonCustom saveBtn = ButtonCustom.createButtonCustom("Save",
                e -> {
                    SettingsContainer.updateSettings(tempSettingsFile);
                    stage.close();
                });

        // If closed without saving reset settings
        stage.setOnCloseRequest(e -> {
            e.consume();
            if (ExitConfirmationAlert.confirmExit(stage))
                SettingsContainer.updateSettings();
        });

        ButtonCustom backBtn = ButtonCustom.createButtonCustom("Back",
                e -> {
                    if (ExitConfirmationAlert.confirmExit(stage))
                        SettingsContainer.updateSettings();
                });
        rootList.add(new HBox(saveBtn, backBtn));

        ButtonCustom defaultBtn = ButtonCustom.createButtonCustom("Reset to default",
                e -> {
                    if (ExitConfirmationAlert.confirmExit(stage, "Reset settings",
                            "You are about to reset your settings", "Are you sure? This can not be undone."))
                        SettingsContainer.updateSettings(new SettingsFile());
                });
        rootList.add(defaultBtn);

        // blocks all other windows till settings has been finished
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }
}
