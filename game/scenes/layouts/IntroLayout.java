package game.scenes.layouts;

import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
/**
 * 
 * @author Leibniz H. Berihuete
 * 
 * Date Started: 5/31/2016 8:20 PM
 * Last Modification: 5/31/2016 10:28 PM
 * 
 * IntroLayout class
 * This class is a layout that contains an
 * introductory video of the game.
 */
public class IntroLayout extends Pane{
	// Location of the video:
	private static final String VIDEO_LINK = "";
	
	// Three necessary components to use:
	private Media media;	
	private MediaPlayer mediaPlayer;
	private MediaView mediaView;
	
	/**
	 * Default Constructor
	 * This constructor initializes
	 * the video using three components:
	 * 1. media - contains video link
	 * 2. mediaPlayer - contains the media & methods to control the video
	 * 3. mediaView - necessary in order to view/display the video.
	 */
	public IntroLayout() {
		media = new Media(VIDEO_LINK);
		mediaPlayer = new MediaPlayer(media);
		mediaView = new MediaView(mediaPlayer);
		
		// Add the mediaView to this layout(IntroLayout):
		this.getChildren().add(mediaView);		
	}
	
	
	
/* ******************************************
 *               VIDEO CONTROLS
 * ******************************************/
	
	/**
	 * play Method
	 *  it plays the video
	 */
	public void play() {
		mediaPlayer.play();
		System.out.println("From: IntroLayout: Video Playing..."); // debugging
	}
	
	/**
	 * pause Method
	 *  it pauses the video
	 */
	public void pause() {
		mediaPlayer.pause();
		System.out.println("From: IntroLayout: Video paused..."); // debugging
	}
	
	/**
	 * stop Method
	 *  it stops the video
	 */
	public void stop() {
		mediaPlayer.stop();
		System.out.println("From: IntroLayout: Video stopped..."); // debugging
	}
	
	
	
}
