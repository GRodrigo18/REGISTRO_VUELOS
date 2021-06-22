package Biblioteca;

public class Nodo {

    private Cliente Elemento;
    private Nodo izq, der;

    public Nodo(Cliente Elemento) 
    {
        this.Elemento = Elemento;
        izq = der = null;
    }
    
    public Nodo getder() {
        return der;}
    
    public void setder(Nodo der) {
        this.der = der;}
    
    public Cliente getElemento() {
        return Elemento;}
    
    public void setElemento(Cliente Elemento) {
        this.Elemento = Elemento;}
    
    public Nodo getizq() {
        return izq;}
    
    public void setizq(Nodo izq) {
        this.izq = izq;}
    
}
