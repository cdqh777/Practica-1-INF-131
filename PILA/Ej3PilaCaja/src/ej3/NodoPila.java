package ej3;

public class NodoPila {
    private Caja caja;
    private NodoPila siguiente;
    
    public NodoPila(Caja caja) {
        this.caja = caja;
        this.siguiente = null;
    }
    
    public Caja getCaja() {
        return caja;
    }
    
    public NodoPila getSiguiente() {
        return siguiente;
    }
    
    public void setSiguiente(NodoPila siguiente) {
        this.siguiente = siguiente;
    }
}