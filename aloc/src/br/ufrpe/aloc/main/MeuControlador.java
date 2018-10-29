package br.ufrpe.aloc.main;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import com.gluonhq.charm.glisten.control.TextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
	@Author: rique
*/

public class MeuControlador implements Initializable {
	
	
	@FXML
	private Button button;
	
	@FXML
	private TextField textField;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	public void showDateTime(ActionEvent event) {
		
		System.out.println("Botão clicado.");
		
		
		
		LocalDateTime data = LocalDateTime.now();
		
		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		
		
		
		String dataeHoraFormatado = data.format(formatter);
		
		
		
		this.textField.setText(dataeHoraFormatado);
	}
}

