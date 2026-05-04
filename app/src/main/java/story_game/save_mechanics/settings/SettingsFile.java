package story_game.save_mechanics.settings;

import com.google.gson.Gson;

import story_game.save_mechanics.SaveHandler.Saveable;

public class SettingsFile implements Saveable {
    private AudioSettings audioSettings = new AudioSettings();

    private class AudioSettings {
        public double musicVolume = 100;
        public double sfxVolume = 100;
    }

    public AudioSettings getAudioSettings() {
        return audioSettings;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
