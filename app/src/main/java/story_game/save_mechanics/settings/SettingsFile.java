package story_game.save_mechanics.settings;

import com.google.gson.Gson;

import story_game.save_mechanics.SaveHandler.Saveable;

public class SettingsFile implements Saveable {
    private AudioSettings audioSettings;

    /**
     * Settings file includes all the settings the must be kept between game
     * launches.
     * 
     * @param settingsFile Settings file to copy.
     */
    public SettingsFile(SettingsFile settingsFile) {
        audioSettings = new AudioSettings(settingsFile.audioSettings);
    }

    /**
     * Settings file includes all the settings the must be kept between game
     * launches. This constructor uses the default values.
     */
    public SettingsFile() {
        audioSettings = new AudioSettings(1, 1);
    }

    /**
     * @return The settings relating to audio.
     */
    public AudioSettings getAudioSettings() {
        return audioSettings;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
