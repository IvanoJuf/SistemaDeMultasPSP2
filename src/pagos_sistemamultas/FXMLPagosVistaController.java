package pagos_sistemamultas;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SkinBase;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import model.ValidaDatos;
import java.time.ZoneId;
import java.util.Date;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import model.Monto;
import model.binTarjetas;
import model.ticket;

public class FXMLPagosVistaController implements Initializable {
    
    
    @FXML
    private Button btnpagar;
    
    @FXML
    private Label lbtitular;
        
    @FXML
    private Label lbtarjeta;
        
      
    @FXML
    private Label lbcvv;
    
    @FXML
    private TextField tftitular ;
        
    @FXML
    private TextField tftarjeta ;
        
    @FXML
    private ChoiceBox<String> tfmes ;
        
    @FXML
    private TextField tfanio ;
           
    @FXML
    private PasswordField pfcvv ;
    @FXML
    private Label lbmonto;
    @FXML
    private Pane panetitulo;
    @FXML
    private Label lbtitulo;
    @FXML
    private Label tffolio;
    @FXML
    private AnchorPane ap;
    
    private final String[] mes = {"01-Ene","02-Feb","03-Mar","04-Abr","05-May","06-Jun","07-Jul","08-Ago",
                            "09-Sep","10-Oct","11-Nov","12-Dic"};
            
    Date date = new Date();
    LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    int month = localDate.getMonthValue();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        inicializaDatos(null);
        
    //Se agrega el arreglo de meses al choiceBox    
    tfmes.getItems().addAll(mes);
    //SE agrega un titulo al choiceBox
 //   Platform.runLater(() -> {
  //  SkinBase<ChoiceBox<String>> skin = (SkinBase<ChoiceBox<String>>) tfmes.getSkin();
    // children contain only "Label label" and "StackPane openButton"
 //   for (Node child : skin.getChildren()) {
   //     if (child instanceof Label) {
    /*        Label label = (Label) child;
            if (label.getText().isEmpty()) {
                label.setText("mes");
            }
            return;
        }
    }
});*/
}   
    @FXML
    private void validarTarjeta(){

        if(ValidaDatos.validarNombre(tftitular.getText()) && ValidaDatos.validarTarjeta(tftarjeta.getText()) && 
             ValidaDatos.validarAnio(tfanio.getText()) && !tfmes.getSelectionModel().isEmpty() && 
             ValidaDatos.validarCvv(pfcvv.getText()) && caducoTarjeta() == false && encuentraBanco() == true){
            
           // JOptionPane.showMessageDialog(null, "Procesando pago","Sistema de Pagos",JOptionPane.WARNING_MESSAGE);
            ticket t = new ticket();
            t.creaTicket();
        }if(tftitular.getText().isEmpty() || ValidaDatos.validarNombre(tftitular.getText()) == false){
            tftitular.setText(null);
            tftitular.setStyle("-fx-prompt-text-fill: red;");
            tftitular.setPromptText("*Campo incorrecto");
        }if(tftarjeta.getText().isEmpty() || ValidaDatos.validarTarjeta(tftarjeta.getText()) == false){ 
            tftarjeta.setText(null);
            tftarjeta.setStyle("-fx-prompt-text-fill: red;");
            tftarjeta.setPromptText("*Campo incorreto");
        }if(tfmes.getSelectionModel().isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe seleccionar el mes","Sistema de Pagos",JOptionPane.WARNING_MESSAGE);
        }if(caducoTarjeta() == true){
            JOptionPane.showMessageDialog(null,"La tarjeta caduco","Sistema de Pagos",JOptionPane.WARNING_MESSAGE);
        }
        if(tfanio.getText().isEmpty() || ValidaDatos.validarAnio(tfanio.getText()) == false){
            tfanio.setText(null);
            tfanio.setStyle("-fx-prompt-text-fill: red;");
            tfanio.setPromptText("*Campo incorrecto");
        }if(pfcvv.getText().isEmpty() || ValidaDatos.validarCvv(pfcvv.getText()) == false){
            pfcvv.setText(null);
            pfcvv.setStyle("-fx-prompt-text-fill: red;");
            pfcvv.setPromptText("*Campo incorrecto");
        }
    }
  
    private boolean caducoTarjeta(){
        String numeroMes = tfmes.getValue().substring(0,2);
        int numeroEntero = Integer.valueOf(numeroMes);
        
        String anio = tfanio.getText();
        int anioEntero = Integer.valueOf(anio);
        
        if(numeroEntero<month && anioEntero == 21){
            return true;
        }else{
            return false;
        }  
    }
    
    public boolean encuentraBanco(){
        binTarjetas bin = new binTarjetas();
        
        String cadenaTarjeta = tftarjeta.getText().substring(0, 4);
        int enteroTarjeta = Integer.valueOf(cadenaTarjeta);
       
        if("BBVA".equals(bin.tipoBanco(enteroTarjeta))){
            Icon icono = new ImageIcon(getClass().getResource("/image/BBVA.png"));
            JOptionPane.showMessageDialog(null,null,"Pago realizado con",JOptionPane.WARNING_MESSAGE,icono);
            return true;
            
        }else if("BNMX".equals(bin.tipoBanco(enteroTarjeta))){
            Icon icono = new ImageIcon(getClass().getResource("/image/banamex.png"));
            JOptionPane.showMessageDialog(null,null,"Pago realizado con",JOptionPane.WARNING_MESSAGE,icono);
            return true;
        }else if("HSBC".equals(bin.tipoBanco(enteroTarjeta))){
            Icon icono = new ImageIcon(getClass().getResource("/image/HSBC.png"));
            JOptionPane.showMessageDialog(null,null,"Pago realizado con",JOptionPane.WARNING_MESSAGE,icono);  
            return true;
            
        }else if("BNRT".equals(bin.tipoBanco(enteroTarjeta))){
            Icon icono = new ImageIcon(getClass().getResource("/image/banorte.png"));
           JOptionPane.showMessageDialog(null,null,"Pago realizado con",JOptionPane.WARNING_MESSAGE,icono);
            return true;
            
        }else if("SANT".equals(bin.tipoBanco(enteroTarjeta))){
            Icon icono = new ImageIcon(getClass().getResource("/image/santander.png"));
            JOptionPane.showMessageDialog(null,null,"Pago realizado con",JOptionPane.WARNING_MESSAGE,icono);
            return true;
            
        }else if("INB".equals(bin.tipoBanco(enteroTarjeta))){
            Icon icono = new ImageIcon(getClass().getResource("/image/inbursa.jpg"));
            JOptionPane.showMessageDialog(null,null,"Pago realizado con",JOptionPane.WARNING_MESSAGE,icono);
            return true;
        }else{
            JOptionPane.showMessageDialog(null,"La tarjeta no existe","Error",JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }
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
    
        public void inicializaDatos(Monto multa) {
        //comentar
        String m = "1200";
        //comentar
        lbmonto.setText("$"+m);
        
    	//lbmonto.setText(String.valueOf(multa.getCosto()));

    }
}
