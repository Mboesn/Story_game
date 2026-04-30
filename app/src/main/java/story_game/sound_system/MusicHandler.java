package story_game.sound_system;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MusicHandler {
    private static MediaPlayer mediaPlayer;

    public static void playMusic(Music music) {
        try {
            Media media = new Media(new File(music.getPath()).toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            mediaPlayer.play();
        } catch (Exception e) {
            System.out.println("Failed to play music: " + music.getPath() + "\nerror: " + e);
        }
    }

    public static void stopMusic() {
        try {
            mediaPlayer.stop();
        } catch (Exception e) {
            System.out.println("Failed to stop music.\nerror: " + e);
        }
    }
}
