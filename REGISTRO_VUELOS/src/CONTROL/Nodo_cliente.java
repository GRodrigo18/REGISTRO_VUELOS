 
package CONTROL;
import MODELO.Cliente;
public class Nodo_cliente {
    private Cliente Elemento;
    private Nodo_cliente izq, der;
    
    public Nodo_cliente(Cliente Elemento)
    {
        this.Elemento=Elemento;
        izq = der =null;
    }

    public Cliente getElemento() {
        return Elemento;
    }

    public void setElemento(Cliente Elemento) {
        this.Elemento = Elemento;
    }

    public Nodo_cliente getIzq() {
        return izq;
    }

    public void setIzq(Nodo_cliente izq) {
        this.izq = izq;
    }

    public Nodo_cliente getDer() {
        return der;
    }

    public void setDer(Nodo_cliente der) {
        this.der = der;
    }
}
