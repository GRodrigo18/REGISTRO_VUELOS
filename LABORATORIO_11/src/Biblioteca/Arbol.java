package Biblioteca;

import javax.swing.table.DefaultTableModel;

public class Arbol {
    
    private Nodo Raiz;

    public Arbol() 
    {
        Raiz = null;
    }
    
    public void setRaiz (Nodo Raiz) {
        this.Raiz = Raiz;
    }
    
    public Nodo getRaiz() {
        return Raiz;
    }
   
    public Nodo Agregar(Nodo Nodo, Cliente Elemento)
    {
        if (Nodo == null)
        {
            Nodo Nuevo = new Nodo(Elemento);
            return Nuevo;
        }
        else
        {
            if(Elemento.getNomCompleto().compareTo(Nodo.getElemento().getNomCompleto())>0)
            {
                Nodo.setder(Agregar(Nodo.getder(), Elemento));
            }
            else
            {
                Nodo.setizq(Agregar(Nodo.getizq(), Elemento));
            }
        }
        return Nodo;     
    }
    
    public Nodo BuscarApeNom(String Dato)
    {
        Nodo Auxiliar = Raiz;
        
        while (Auxiliar != null)
        {
            if (Auxiliar.getElemento().getNomCompleto().startsWith(Dato))
            {
                return Auxiliar;
            }
            else
            {
                if(Dato.compareTo(Auxiliar.getElemento().getNomCompleto())>0)
                    Auxiliar = Auxiliar.getder();
                else
                    Auxiliar = Auxiliar.getizq();
            }
        }
        return null;
    }
    
    public void Listar_InOrder(Nodo Nodo, DefaultTableModel Modtabla)
    {
        if (Nodo != null)
        {
            Listar_InOrder(Nodo.getizq(), Modtabla);
            Modtabla.addRow(Nodo.getElemento().getRegistro());
            Listar_InOrder(Nodo.getder(), Modtabla);
        }
    }
    
    public Nodo BuscarMayorIzquierda(Nodo Auxiliar)
    {
        if(Auxiliar != null)
        {
            while (Auxiliar.getder() != null)
            {
                Auxiliar = Auxiliar.getder();
            }
        }
        return Auxiliar;
    }
    
    public Nodo EliminarMayorIzquierda(Nodo Auxiliar)
    {
        if(Auxiliar == null)
            return null;
        else if (Auxiliar.getder() != null)
        {
            Auxiliar.setder(EliminarMayorIzquierda(Auxiliar.getder()));
            return Auxiliar;
        }
        return Auxiliar.getizq();
    }
    public Nodo Eliminar(Nodo Auxiliar, String Dato)
    {
        if(Auxiliar == null)
            return null;
        
        if (Dato.compareTo(Auxiliar.getElemento().getNomCompleto())<0)
        {
            Auxiliar.setizq(Eliminar(Auxiliar.getizq(), Dato));
        }
        else if (Dato.compareTo(Auxiliar.getElemento().getNomCompleto())>0)
        {
            Auxiliar.setder(Eliminar(Auxiliar.getder(), Dato));
        }
        else if (Auxiliar.getizq()!=null && Auxiliar.getder() != null)
        {
            Auxiliar.setElemento(BuscarMayorIzquierda(Auxiliar.getizq()).getElemento());
            Auxiliar.setizq(EliminarMayorIzquierda(Auxiliar.getizq()));
        }
        else
            Auxiliar = (Auxiliar.getizq() != null) ?
                    Auxiliar.getizq() : Auxiliar.getder();
        return Auxiliar;
    }
}
