package Connectike.CustomSoundSystem.application;
import java.io.Serializable;

/**
 * A Serializable class that holds 3 pieces of data
 * 
 * <li> name - wording that appears to the user on the application to identify the sound</li>
 * <li> URL - the file path to the sound</li>
 * <li> key - the keystroke that is associated with the sound played</li>
 * 
 *
 */
public class Sound implements Serializable {

	public String name;
	public final String url;
	public final char key;
	
	public Sound(final String name, final String url, final char key) {
		this.url = url;
		this.name = name;
		this.key = key;
	}
	
	private static final long serialVersionUID = -2415632557091074799L;
}
