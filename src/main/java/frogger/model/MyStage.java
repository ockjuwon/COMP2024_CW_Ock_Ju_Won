package frogger.model;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class MyStage extends World{
	MediaPlayer mediaPlayer;
	@Override
	public void act(long now) {
		
	}
	
	public MyStage() {

		playMusic();
		mediaPlayer.setOnEndOfMedia(new Runnable() {

			@Override
			public void run() {
				mediaPlayer.seek(Duration.ZERO);

			}

		});
	}
	
	public void playMusic() {
		String musicFile = "src/main/resources/Frogger Main Song Theme (loop).mp3";
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}
	
	public void stopMusic() {
		mediaPlayer.stop();
	}

}
