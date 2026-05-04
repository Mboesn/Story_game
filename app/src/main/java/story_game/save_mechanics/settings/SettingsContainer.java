package story_game.save_mechanics.settings;

import story_game.save_mechanics.SaveHandler;
import story_game.sound_system.AudioHandler;

public class SettingsContainer {
    private static SettingsFile settings = SaveHandler.loadSettings();

    public static SettingsFile getSettings() {
        return settings;
    }

    public static void updateSettings(SettingsFile newSettings) {
        settings = newSettings;
        AudioHandler.setMusicVolume(settings.getAudioSettings().musicVolume);
        SaveHandler.saveSettings(newSettings);
    }

    public static void updateSettings() {
        updateSettings(settings);
    }
}
