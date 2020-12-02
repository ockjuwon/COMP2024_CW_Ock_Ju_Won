package frogger.model;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class MusicPlayer {
	MediaPlayer mediaPlayer;
	
	public MusicPlayer() throws MalformedURLException {
		String musicURL = "src/main/resources/bgm.mp3";
		File musicFile = new File(musicURL);
		Media sound = new Media(musicFile.toURI().toURL().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setOnEndOfMedia(new Runnable() {
			@Override
			public void run() {
				mediaPlayer.seek(Duration.ZERO);
			}
		});
	}
	
	public void playMusic() {
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}
	
	public void stopMusic() {
		mediaPlayer.stop();
	}

}
