package story_game.save_mechanics.settings;

import story_game.save_mechanics.SaveHandler;
import story_game.sound_system.AudioHandler;

/**
 * This class contains the active settings file used by the game.
 */
public class SettingsContainer {
    private static SettingsFile settings = SaveHandler.loadSettings();

    /**
     * @return The current settings file.
     */
    public static SettingsFile getSettings() {
        return settings;
    }

    /**
     * Updates settings to a new settings file and updates all functions in code
     * accordingly.
     * 
     * @param newSettings The settings to copy.
     */
    public static void updateSettings(SettingsFile newSettings) {
        settings = new SettingsFile(newSettings);
        AudioHandler.setMusicVolume(settings.getAudioSettings().musicVolume);
        SaveHandler.saveSettings(newSettings);
    }

    /**
     * Using the old settings updates all functions in code accordingly. Used when
     * aborting a change to the settings.
     */
    public static void updateSettings() {
        updateSettings(settings);
    }
}
