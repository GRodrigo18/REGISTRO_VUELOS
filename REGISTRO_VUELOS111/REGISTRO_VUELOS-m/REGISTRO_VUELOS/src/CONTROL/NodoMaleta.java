package CONTROL;

import MODELO.ClienteM;

public class NodoMaleta
{
    private ClienteM Elemento;
    private NodoMaleta izq, der;
    
    public NodoMaleta(ClienteM Elemento)
    {
        this.Elemento=Elemento;
        izq=der=null;
    }
   
    public NodoMaleta getDer()
    {
        return der;
    }
    
    public void setDer(NodoMaleta der)
    {
        this.der=der;
    }
    
    public ClienteM getElemento()
    {
        return Elemento;
    }

    public void setElemento(ClienteM Elemento) 
    {
        this.Elemento = Elemento;
    }

    public NodoMaleta getIzq() 
    {
        return izq;
    }

    public void setIzq(NodoMaleta izq) 
    {
        this.izq = izq;
    }
}