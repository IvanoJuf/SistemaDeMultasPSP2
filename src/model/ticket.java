package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class ticket {

   // Date f = new Date();
    SimpleDateFormat formato = new SimpleDateFormat("dd-MM-YYYY");
    String fecha = formato.format(new Date());
    
    int hora = LocalTime.now().getHour();
    int minute = LocalTime.now().getMinute();
    int numeroAleatorio = (int) (Math.random()*9999);
    
    public void creaTicket(){
        File f;
        FileWriter w;
        BufferedWriter bw;
        PrintWriter wr;
        
        try {
            f = new File("Comprobante.txt");
            w = new FileWriter(f);
            bw = new BufferedWriter(w);
            wr = new PrintWriter(bw);
            
            wr.write("*****************************************");
            wr.write("\n*          COMPROBANTE DE PAGO          *");
            wr.append("\n*          CONSULTA DE MULTAS           *");
            wr.append("\n*****************************************\n*                                       *");
            wr.append("\n* FECHA: "+fecha+"                     *");
            wr.append("\n* HORA : "+hora+":"+minute+"                          *");
            wr.append("\n* FOLIO: 00"+numeroAleatorio+"                         *");
            wr.append("\n*---------------------------------------*\n*                                       *");
            wr.append("\n* PAGO REALIZADO EN LA APP:             *");
            wr.append("\n* Sistema de consulta de multas         *");
            wr.append("\n*                                       *");
            wr.append("\n* IMPORTE: $1200"+"                        *");
            wr.append("\n*---------------------------------------*");
            wr.append("\n*             DevSolutions              *");
            wr.append("\n*         devsolution@gmail.com         *");
            wr.append("\n*          Tel: 55-33-22-11-00          *");
            wr.append("\n*---------------------------------------*");
            wr.close();
            bw.close();  
        } catch (Exception e) {
        }

    }   
}