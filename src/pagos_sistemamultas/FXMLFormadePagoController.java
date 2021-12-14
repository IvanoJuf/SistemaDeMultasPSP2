package pagos_sistemamultas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

public class FXMLFormadePagoController implements Initializable {
    
    @FXML
    private RadioButton rbtnpaypal;
    @FXML
    private RadioButton rbtntc;
    @FXML
    private Button btnpago;
    @FXML
    private ToggleGroup tgselected;
    @FXML
    private AnchorPane ap;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    @FXML
    private void seleccionaPago(){
        if(rbtnpaypal.isSelected()){
            //JOptionPane.showMessageDialog(null, "PayPal","Sistema de Pagos",JOptionPane.WARNING_MESSAGE);
            try{
	        
	    FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLPayPal.fxml"));
	    AnchorPane root = (AnchorPane)loader.load();	
	        	
	    FXMLPayPalController controlador = (FXMLPayPalController)loader.getController();

	    ap.getChildren().clear();
	    ap.getChildren().add(root);
			      
	    } catch (IOException e) {

		e.printStackTrace();
	    }
        }else if(rbtntc.isSelected()){
            try{
	    FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLPagosVista.fxml"));
	    AnchorPane root = (AnchorPane)loader.load();
	          	
	    FXMLPagosVistaController controlador = (FXMLPagosVistaController)loader.getController();

	    ap.getChildren().clear();
	    ap.getChildren().add(root);
			      
	    } catch (IOException e) {

		e.printStackTrace();
	    }
        }
        
    }
    
}
