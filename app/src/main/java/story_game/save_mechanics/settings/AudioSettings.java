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

    public double getMusicVolume() {
        return musicVolume;
    }

    public void setMusicVolume(double musicVolume) {
        this.musicVolume = Math.max(0, Math.min(1, musicVolume));
    }

    public double getSFXVolume() {
        return sfxVolume;
    }

    public void setSFXVolume(double sfxVolume) {
        this.sfxVolume = Math.max(0, Math.min(1, sfxVolume));
    }

}
