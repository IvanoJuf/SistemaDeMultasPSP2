package model;

public class Monto {
    
    private float costo;

    public Monto(float costo) {
        this.costo = costo;
    }

    Monto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Monto{" + "costo=" + costo + '}';
    }
    
     
    
}
