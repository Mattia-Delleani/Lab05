package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInput;

    @FXML
    private Button btnCerca;

    @FXML
    private TextArea txtCorretti;

    @FXML
    private TextArea txtSbagliati;

    @FXML
    private Button btnReset;

    @FXML
    void doAnagramma(ActionEvent event) {
    	
    	txtCorretti.setDisable(false);
    	txtCorretti.clear();
    	txtSbagliati.setDisable(false);
    	txtSbagliati.clear();
    	
    	StringTokenizer input = new StringTokenizer(txtInput.getText());
    	
    	if(!input.hasMoreElements()) {
    		txtCorretti.setText("Valore di input non valido.\nInserire una parola!");
    		return ;
    	}
    	String parola = input.nextToken();
    	if(input.hasMoreElements()) {
    		txtCorretti.setText("Valore di input non valido.\nInserire solo una parola!");
    		return ;
    	}
    	for(String tempS: this.model.getAnagrammiCorretti(parola)) {
    		txtCorretti.appendText(tempS +"\n");
    		
    	}
    	for(String tempS:this.model.getSbagliati()) {
    		txtSbagliati.appendText(tempS +"\n");
    		
    	}
    	
    }

    @FXML
    void doReset(ActionEvent event) {

    	txtInput.clear();
    	txtCorretti.setDisable(true);
    	txtCorretti.clear();
    	txtSbagliati.setDisable(true);
    	txtSbagliati.clear();
    }

    @FXML
    void initialize() {
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCerca != null : "fx:id=\"btnCerca\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtSbagliati != null : "fx:id=\"txtSbagliati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Model model) {
		
		
		this.model= model;
	}
}
