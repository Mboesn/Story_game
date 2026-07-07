package story_game.save_mechanics.settings;

public class AudioSettings {
    private double musicVolume;
    private double sfxVolume;

    /**
     * All settings relating to audio.
     * 
     * @param musicVolume Volume of the music in game, between 0 and 1.
     * @param sfxVolume   Volume of the sound effects in game, between 0 and 1.
     */
    public AudioSettings(double musicVolume, double sfxVolume) {
        setMusicVolume(musicVolume);
        setSFXVolume(sfxVolume);
    }

    /**
     * All settings relating to audio.
     * 
     * @param audioSettings Audio settings to copy.
     */
    public AudioSettings(AudioSettings audioSettings) {
        this(audioSettings.musicVolume, audioSettings.sfxVolume);
    }

    /**
     * @return Volume of the music between 0 and 1.
     */
    public double getMusicVolume() {
        return musicVolume;
    }

    /**
     * @param musicVolume Sets the volume of the music between 0 and 1.
     */
    public void setMusicVolume(double musicVolume) {
        this.musicVolume = Math.max(0, Math.min(1, musicVolume));
    }

    /**
     * @return Volume of the SFX between 0 and 1.
     */
    public double getSFXVolume() {
        return sfxVolume;
    }

    /**
     * @param musicVolume Sets the volume of the SFX between 0 and 1.
     */
    public void setSFXVolume(double sfxVolume) {
        this.sfxVolume = Math.max(0, Math.min(1, sfxVolume));
    }

}
