package Connectike.CustomSoundSystem.application.managers;

import java.io.File;

import Connectike.CustomSoundSystem.application.KeyboardListener;
import Connectike.CustomSoundSystem.application.SoundSystem;
import Connectike.CustomSoundSystem.controllers.MainController;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

/**
 * class for organizing and manipulating buttons on the stage
 * 
 *
 */
public class ButtonManager {

	public static void addSoundButton(final MainController controller, final File f) {
		
		System.out.println("adding sound button...");
		
		final HBox hbox = new HBox();
		
		final Button b = new Button();
		final TextField tf = new TextField("touch me!");
		
		tf.setEditable(true);
				
		hbox.getChildren().add(b);
		hbox.getChildren().add(tf);
		
		
		controller.getvBox_soundContainer().getChildren().add(hbox);
		
		Platform.runLater(new Runnable() {
		    public void run() {
		        tf.requestFocus();
		        System.out.println("text field focused");
		    }
		});
		
		b.setOnMouseClicked(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent event) {

				if(event.getClickCount() == 2) {					
					System.out.println("double click!");
					hbox.getChildren().remove(tf);
					b.setPrefWidth(20);
				}
			}
		});
		
		tf.setOnKeyPressed(new EventHandler<KeyEvent>() {
		    public void handle(KeyEvent keyEvent) {
		    	
		        if (keyEvent.getCode() == KeyCode.ENTER)  {
		            String input = tf.getText();
		            
		            // get rid of it if there's more than one key
		            if(input.length() > 1) {
		            	System.out.println("input too big");
		            	controller.getvBox_soundContainer().getChildren().remove(hbox);
		            }
		            
		            SoundSystem.addSound(input.charAt(0), f.getAbsolutePath());
		            KeyboardListener.addKeyReleaseListener(input.charAt(0));

		            b.setText(f.getName().substring(0, 10) + " - " + input.toUpperCase());
		            
		            hbox.getChildren().remove(tf);
		            
		            b.setPrefWidth(controller.getvBox_soundContainer().getWidth());
		        }
		    }
		});
		System.out.println("event handler added to text field");
	}
	
	/**
	 * loop through the files in the /resources/sound folder and add buttons for them all
	 */
	public static void loadSoundButtons() {
		
	}
}
