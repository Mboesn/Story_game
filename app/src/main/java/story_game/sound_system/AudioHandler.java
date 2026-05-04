package story_game.sound_system;

import java.io.File;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import story_game.save_mechanics.settings.SettingsContainer;

/**
 * This class contains all the function relating to controlling the audio of the
 * game.
 */
public class AudioHandler {
    private static MediaPlayer mediaPlayer;

    /**
     * Plays a given music file on loop.
     * 
     * @param music the music to play
     */
    public static void playMusic(Music music) {
        try {
            Media media = new Media(new File(music.getPath()).toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setVolume(SettingsContainer.getSettings().getAudioSettings().musicVolume);
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            mediaPlayer.play();
        } catch (Exception e) {
            System.out.println("Failed to play music: " + music.getPath() + "\nerror: " + e);
        }
    }

    /**
     * Stops playing music.
     */
    public static void stopMusic() {
        try {
            mediaPlayer.stop();
        } catch (Exception e) {
            System.out.println("Failed to stop music.\nerror: " + e);
        }
    }

    /**
     * Plays a given sound effect, does not disrupt the music.
     * 
     * @param sfx The sounds effect to play.
     */
    public static void playSFX(SFX sfx) {
        try {
            AudioClip clip = new AudioClip(new File(sfx.getPath()).toURI().toString());
            clip.setVolume(SettingsContainer.getSettings().getAudioSettings().sfxVolume);
            clip.play();
        } catch (Exception e) {
            System.out.println("Failed to play music: " + sfx.getPath() + "\nerror: " + e);
        }
    }

    public static void setMusicVolume(double volume) {
        // if music is playing update volume
        if (mediaPlayer != null)
            mediaPlayer.setVolume(volume);
    }
}
