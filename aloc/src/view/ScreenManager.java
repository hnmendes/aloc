package view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
	@Author: rique
*/

public class ScreenManager {
	
	private static ScreenManager instance;
	
	private Stage primaryStage;
	
	private Scene loginScene;
	private LoginController loginController;
	
	private Scene coordenadorScene;
	private CoordenadorController coordenadorController;
	
	private Scene addDisciplinaScene;
	private AddDisciplinaCoordController addDisciplinaController;
	
	private Scene editDisciplinaScene;
	private EditDisciplinaCoordController editDisciplinaController;
	
	private Scene addProfessorScene;
	private AddProfessorCoordController addProfessorController;
	
	//Mainscreen controller
	
	public static ScreenManager getInstance() {
		
		if(instance == null) {
			instance = new ScreenManager();
		}
		
		return instance;
	}
	
	private ScreenManager() { 
        this.initialize(); 
    }
	
	private void initialize() {
		
		try {
			
			FXMLLoader fxmlLoader = new FXMLLoader();
			AnchorPane loginPane = fxmlLoader.load(getClass().getResource("/view/Login.fxml").openStream());
			this.loginScene = new Scene(loginPane);
			this.setLoginController((LoginController) fxmlLoader.getController());
			
			fxmlLoader = new FXMLLoader();
			AnchorPane coordenadorPane = fxmlLoader.load(getClass().getResource("/view/CoordenadorFXML.fxml").openStream());
			this.setCoordenadorScene(new Scene(coordenadorPane));
			this.setCoordenadorController((CoordenadorController) fxmlLoader.getController());
			
			fxmlLoader = new FXMLLoader();
			AnchorPane addProfessorPane = fxmlLoader.load(getClass().getResource("/view/AddProfessorCoordFXML.fxml").openStream());
			this.setAddProfessorScene(new Scene(addProfessorPane));
			this.setAddProfessorController((AddProfessorCoordController) fxmlLoader.getController());
			
			fxmlLoader = new FXMLLoader();
			AnchorPane editDisciplinaPane = fxmlLoader.load(getClass().getResource("/view/EditDisciplinaCoordFXML.fxml").openStream());
			this.setEditDisciplinaScene(new Scene(editDisciplinaPane));
			this.setEditDisciplinaController((EditDisciplinaCoordController) fxmlLoader.getController());
			
			fxmlLoader = new FXMLLoader();
			AnchorPane addDisciplinaPane = fxmlLoader.load(getClass().getResource("/view/AddDisciplinaCoordFXML.fxml").openStream());
			this.setEditDisciplinaScene(new Scene(addDisciplinaPane));
			this.setEditDisciplinaController((EditDisciplinaCoordController) fxmlLoader.getController());
			
		}catch (IOException e) {
            e.printStackTrace();
        }
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public Scene getLoginScene() {
		return loginScene;
	}

	public void setLoginScene(Scene myScene) {
		this.loginScene = myScene;
	}

	public LoginController getLoginController() {
		return loginController;
	}

	public void setLoginController(LoginController loginController) {
		this.loginController = loginController;
	}

	public Scene getCoordenadorScene() {
		return coordenadorScene;
	}

	public void setCoordenadorScene(Scene coordenadorScene) {
		this.coordenadorScene = coordenadorScene;
	}

	public CoordenadorController getCoordenadorController() {
		return coordenadorController;
	}

	public void setCoordenadorController(CoordenadorController coordenadorController) {
		this.coordenadorController = coordenadorController;
	}

	public Scene getAddDisciplinaScene() {
		return addDisciplinaScene;
	}

	public void setAddDisciplinaScene(Scene addDisciplinaScene) {
		this.addDisciplinaScene = addDisciplinaScene;
	}

	public AddDisciplinaCoordController getAddDisciplinaController() {
		return addDisciplinaController;
	}

	public void setAddDisciplinaController(AddDisciplinaCoordController addDisciplinaController) {
		this.addDisciplinaController = addDisciplinaController;
	}

	public Scene getEditDisciplinaScene() {
		return editDisciplinaScene;
	}

	public void setEditDisciplinaScene(Scene editDisciplinaScene) {
		this.editDisciplinaScene = editDisciplinaScene;
	}

	public EditDisciplinaCoordController getEditDisciplinaController() {
		return editDisciplinaController;
	}

	public void setEditDisciplinaController(EditDisciplinaCoordController editDisciplinaController) {
		this.editDisciplinaController = editDisciplinaController;
	}

	public Scene getAddProfessorScene() {
		return addProfessorScene;
	}

	public void setAddProfessorScene(Scene addProfessorScene) {
		this.addProfessorScene = addProfessorScene;
	}

	public AddProfessorCoordController getAddProfessorController() {
		return addProfessorController;
	}

	public void setAddProfessorController(AddProfessorCoordController addProfessorController) {
		this.addProfessorController = addProfessorController;
	}
	
	
}

