package story_game.save_mechanics.settings;

import story_game.save_mechanics.SaveHandler;

public class SettingsContainer {
    private static SettingsFile settings = SaveHandler.loadSettings();

    private SettingsContainer() {
    }

    public static SettingsFile getSettings() {
        return settings;
    }

    public static void setSettings(SettingsFile newSettings) {
        settings = newSettings;
    }
}
