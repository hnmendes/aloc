package view;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
	@Author: rique
*/

public class ScreenManager {
	
	private static ScreenManager instance;
	
	private Stage primaryStage;
	
	private Scene myScene;
	
	//Mainscreen controller
	
	
	
	
	public static ScreenManager getInstance() {
		
		if(instance == null) {
			instance = new ScreenManager();
		}
		
		return instance;
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public Scene getMyScene() {
		return myScene;
	}

	public void setMyScene(Scene myScene) {
		this.myScene = myScene;
	}
	
	
}

