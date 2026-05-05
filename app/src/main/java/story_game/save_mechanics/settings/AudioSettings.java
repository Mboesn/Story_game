package story_game.save_mechanics.settings;

public class AudioSettings {
    public double musicVolume;
    public double sfxVolume;

    /**
     * All settings relating to audio.
     * 
     * @param musicVolume Volume of the music in game, between 0 and 1.
     * @param sfxVolume   Volume of the sound effects in game, between 0 and 1.
     */
    public AudioSettings(double musicVolume, double sfxVolume) {
        this.musicVolume = musicVolume;
        this.sfxVolume = sfxVolume;
    }

    /**
     * All settings relating to audio.
     * 
     * @param audioSettings Audio settings to copy.
     */
    public AudioSettings(AudioSettings audioSettings) {
        this(audioSettings.musicVolume, audioSettings.sfxVolume);
    }
}