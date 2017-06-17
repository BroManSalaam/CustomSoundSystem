package Connectike.CustomSoundSystem.controllers;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import Connectike.CustomSoundSystem.application.managers.ButtonManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

public class MainController implements Initializable {

	// panes
	@FXML
	private Pane pane_leftContainer;
	
	@FXML 
	private Pane pane_bottomSpacing;
	
	// buttons
	
	@FXML
	private Button button_addSound;
	
	@FXML
	private Button button_removeSound;
	
	// VBoxes
	
	@FXML
	private VBox vBox_soundContainer;
	
	// HBoxes
	
	@FXML
	private HBox hBox_leftButtonContainer;
	
	

	
	public static HashMap<Button, Character> buttonKeys = new HashMap<Button, Character>();

	
	public void initialize(URL arg0, ResourceBundle arg1) {

		System.out.println("main controller has been initialized");
	}
	
	public void addSound(ActionEvent e) {
		System.out.println("adding sound...");
		
		FileChooser fc = new FileChooser();

		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("SOUND files (*.mp3)", "*.mp3");
		fc.getExtensionFilters().add(extFilter);
		
		
		File soundFile = fc.showOpenDialog(null);	
		
		if(soundFile.exists() && soundFile.isFile() && soundFile != null) {

			ButtonManager.addSoundButton(this, soundFile);
			
		} else {
			System.out.println("no file has been selected.");
		}
	}
	
	public void removeSound(ActionEvent e) {

	}

	public Pane getPane_leftContainer() {
		return pane_leftContainer;
	}

	public void setPane_leftContainer(Pane pane_leftContainer) {
		this.pane_leftContainer = pane_leftContainer;
	}

	public Pane getPane_bottomSpacing() {
		return pane_bottomSpacing;
	}

	public void setPane_bottomSpacing(Pane pane_bottomSpacing) {
		this.pane_bottomSpacing = pane_bottomSpacing;
	}

	public Button getButton_addSound() {
		return button_addSound;
	}

	public void setButton_addSound(Button button_addSound) {
		this.button_addSound = button_addSound;
	}

	public Button getButton_removeSound() {
		return button_removeSound;
	}

	public void setButton_removeSound(Button button_removeSound) {
		this.button_removeSound = button_removeSound;
	}

	public VBox getvBox_soundContainer() {
		return vBox_soundContainer;
	}

	public void setvBox_soundContainer(VBox vBox_soundContainer) {
		this.vBox_soundContainer = vBox_soundContainer;
	}

	public HBox gethBox_leftButtonContainer() {
		return hBox_leftButtonContainer;
	}

	public void sethBox_leftButtonContainer(HBox hBox_leftButtonContainer) {
		this.hBox_leftButtonContainer = hBox_leftButtonContainer;
	}

	public static HashMap<Button, Character> getButtonKeys() {
		return buttonKeys;
	}

	public static void setButtonKeys(HashMap<Button, Character> buttonKeys) {
		MainController.buttonKeys = buttonKeys;
	}
	
	
}
