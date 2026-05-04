package story_game.save_mechanics.settings;

import com.google.gson.Gson;

import story_game.save_mechanics.SaveHandler.Saveable;

public class SettingsFile implements Saveable {
    private AudioSettings audioSettings;

    public SettingsFile() {
        audioSettings = new AudioSettings(1, 1);
    }

    public SettingsFile(SettingsFile settingsFile) {
        audioSettings = new AudioSettings(settingsFile.audioSettings);
    }

    public class AudioSettings {
        public double musicVolume;
        public double sfxVolume;

        public AudioSettings(double musicVolume, double sfxVolume) {
            this.musicVolume = musicVolume;
            this.sfxVolume = sfxVolume;
        }

        public AudioSettings(AudioSettings audioSettings) {
            this(audioSettings.musicVolume, audioSettings.sfxVolume);
        }
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
