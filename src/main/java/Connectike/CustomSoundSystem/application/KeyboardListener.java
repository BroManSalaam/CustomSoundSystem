package Connectike.CustomSoundSystem.application;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map.Entry;

import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;

public class KeyboardListener {

	
	private static GlobalKeyboardHook keyboardHook = new GlobalKeyboardHook(false); // use false here to switch to hook instead of raw input
	
	// list of handlers
	public static HashMap<Character, GlobalKeyAdapter> eventHandlers = new HashMap<Character, GlobalKeyAdapter>();
	
	// WILL DISABLE ALL TEXT FIELDS
	public static void listKeyboards() {
		System.out.println("Global keyboard hook successfully started");
		System.out.println("Connected Keyboards: ");
		for(Entry<Long,String> keyboard:GlobalKeyboardHook.listKeyboards().entrySet())
			System.out.format("\t %d: %s\n", keyboard.getKey(), keyboard.getValue());
		
	}
		
	public static void addKeyPressListener(final char key) {
		
		eventHandlers.put(key, new GlobalKeyAdapter() {

			@Override
			public void keyPressed(GlobalKeyEvent event) {
				if(event.getVirtualKeyCode() == KeyEvent.getExtendedKeyCodeForChar(key)) {
					System.out.println("key press on "+ key);
				}
			}
		});
		
		keyboardHook.addKeyListener(eventHandlers.get(key));
		
		System.out.println("release handler added for key " + key);
	}
	
	public static void removeListener(char key) {
		eventHandlers.remove(key);
		keyboardHook.removeKeyListener(eventHandlers.get(key));
	}
	
	public static void addKeyReleaseListener(final char key) {
		
		eventHandlers.put(key, new GlobalKeyAdapter() {

			@Override
			public void keyReleased(GlobalKeyEvent event) {
				if(event.getVirtualKeyCode() == KeyEvent.getExtendedKeyCodeForChar(key)) {
					System.out.println("key press on "+ key);
					SoundSystem.playSound(key);
				}
			}
		});
		
		keyboardHook.addKeyListener(eventHandlers.get(key));
		
		System.out.println("release handler added for key " + key);
	}
	
}
