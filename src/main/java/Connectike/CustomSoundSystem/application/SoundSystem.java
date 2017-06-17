package Connectike.CustomSoundSystem.application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * class for coordinating managing, and storing different sounds
 *
 */
public class SoundSystem {
	
	private static MediaPlayer mp;

	public static HashMap<Character, String> sounds = new HashMap<Character, String>();
	
	public static void addSound(char key, String url) {
		getSounds().put(key, url);
	}
	
	/**
	 * play the given audio file
	 * 
	 * @param url
	 */
	public static void playSound(final String url) {
		
		Media sound = new Media(new File(url).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.play();
	}
	
	public static void playSound(final char key) {
		
		Media sound = new Media(new File(sounds.get(key)).toURI().toString());
		mp = new MediaPlayer(sound);
		
		mp.play();
	}

	public static HashMap<Character, String> getSounds() {
		return sounds;
	}
	
	/**
	 * take a given sound and serialize the data into the /application/ser/ folder
	 * 
	 * @param s
	 */
	public static void serializeSound(Sound s) {
		
		try {
			FileOutputStream fileOut = new FileOutputStream("/application/ser/" + s.name + ".ser" );
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(s);
			out.close();
			fileOut.close();
			System.out.printf("serialized data is saved in /application/ser/" + s.name + ".ser" );
		} catch(IOException i) {
			i.printStackTrace();
	    }
	}
	
	/**
	 * loads the serialized data from the /ser file into the sounds hash table
	 */
	public static void loadSounds() {
		
		Sound s = null;
		
		try {
			FileInputStream fileIn = new FileInputStream("/tmp/employee.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			s = (Sound) in.readObject();
			in.close();
			fileIn.close();
			
		} catch(IOException i) {
			i.printStackTrace();
			return;
		} catch(ClassNotFoundException c) {
			System.out.println("Employee class not found");
			c.printStackTrace();
			return;
		}
	}

	public static MediaPlayer getMp() {
		return mp;
	}

	public static void setMp(MediaPlayer mp) {
		SoundSystem.mp = mp;
	}
	
	
}
