package model;

public class ValidaDatos {
    
    public static boolean validarNombre(String nombre){
        return nombre.matches("^[A-ZÁÉÍÓÚa-záéíóú]+[ ][A-ZÁÉÍÓÚa-záéíóú]+[ ][A-ZÁÉÍÓÚa-záéíóú]+[ ]?([A-ZÁÉÍÓÚa-záéíóú]+)?$");                
    }
    
    public static boolean validarTarjeta(String tarjeta){
        return tarjeta.matches("^[4-5]+[0-679][0-9]{2}+([-]?+[0-9]{4}){3}$");  
    }
    
    public static boolean validarAnio(String anio){
        return anio.matches("^[2][1-9]$");
    }
    
    public static boolean validarCvv(String cvv){
        return cvv.matches("^[0-9]{3}$");
    }  
    
        
    public static boolean validarCorreo(String correo){
        return correo.matches("^[A-ZÁÉÍÓÚa-záéíóú0-9]+[_-]?([_-]?[A-ZÁÉÍÓÚa-záéíóú0-9_-]+)?[@][a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$$");                
    }
    
    public static boolean validarPassword(String password){
        return password.matches("^([0-9]+)?[A-ZÁÉÍÓÚa-záéíóú0-9]+$");  
    }
}
