package pagos_sistemamultas;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import model.Monto;
import model.ValidaDatos;
import model.ticket;

public class FXMLPayPalController implements Initializable {
    
    @FXML
    private Label lbtotal;
    @FXML
    private TextField tfcorreo;
    @FXML
    private PasswordField pfpass;
    @FXML
    private Button btnpagarcon;
    @FXML
    private AnchorPane ap;
    @FXML
    private ImageView imgregresa;
    @FXML
    private Hyperlink hlregistra;
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inicializaDatos(null);
    }    
    
    @FXML
    private void validaCuenta(){
        if(ValidaDatos.validarCorreo(tfcorreo.getText()) && ValidaDatos.validarPassword(pfpass.getText())){ 
            JOptionPane.showMessageDialog(null, "Procesando pago","Sistema de Pagos",JOptionPane.WARNING_MESSAGE);
            ticket t = new ticket();
            t.creaTicket();
        }if(tfcorreo.getText().isEmpty() || ValidaDatos.validarCorreo(tfcorreo.getText()) == false){
            tfcorreo.setText(null);
            tfcorreo.setStyle("-fx-prompt-text-fill: red;");
            tfcorreo.setPromptText("*Campo incorrecto");
        }if(pfpass.getText().isEmpty() || ValidaDatos.validarPassword(pfpass.getText()) == false){
            pfpass.setText(null);
            pfpass.setStyle("-fx-prompt-text-fill: red;");
            pfpass.setPromptText("*Campo incorreto");
        }
    }
    
    @FXML
    public void regresaVentana(){   
        try{
	    FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLFormadePago.fxml"));
	    AnchorPane root = (AnchorPane)loader.load();	    	
	    FXMLFormadePagoController controlador = (FXMLFormadePagoController)loader.getController();

	    ap.getChildren().clear();
	    ap.getChildren().add(root);
			      
	    } catch (IOException e) {
		e.printStackTrace();
	    }
    }    
    
    @FXML
    public void registra(ActionEvent event) throws URISyntaxException, IOException{
        Desktop.getDesktop().browse(new URI("https://www.paypal.com/mx/webapps/mpp/account-selection"));
    }
    
    public void inicializaDatos(Monto multa) {
        
        //comentar
        String m = "1200";
        //comentar
        lbtotal.setText("$"+m);
        
    	//lbtotal.setText(String.valueOf(multa.getCosto()));

    }
}
