 
package CONTROL;
import MODELO.Cliente;
import javax.swing.table.DefaultTableModel;

public class Arbol_cliente {
    private Nodo_cliente Raiz;
    
    public Arbol_cliente()
    {
        Raiz = null;
    }

    public Nodo_cliente getRaiz() {
        return Raiz;
    }

    public void setRaiz(Nodo_cliente Raiz) {
        this.Raiz = Raiz;
    }
    
    //METODO AGREGAR
    public Nodo_cliente Agregar(Nodo_cliente Nodo, Cliente Elemento)
    {
        if(Nodo == null)
        {
            Nodo_cliente Nuevo= new Nodo_cliente(Elemento);
            return Nuevo;
        }
        else
        {
            if(Elemento.getNombreCompleto().compareTo
                                            (Nodo.getElemento().getNombreCompleto())>0)
            {
                Nodo.setDer(Agregar(Nodo.getDer(), Elemento));
            }
            else
            {
                Nodo.setIzq(Agregar(Nodo.getIzq(), Elemento));
            }
        }
        return Nodo;
    }
    
    //METODO BUSCARApeNom
    public Nodo_cliente BuscarApeNom(String Dato)
    {
        Nodo_cliente Auxiliar = Raiz;
        
        while(Auxiliar != null)
        {
            if(Auxiliar.getElemento().getNombreCompleto().startsWith(Dato))
            {
                return Auxiliar;
            }
            else
            {
                if(Dato.compareTo(Auxiliar.getElemento().getNombreCompleto())<0)
                    Auxiliar= Auxiliar.getDer();
                else
                    Auxiliar= Auxiliar.getIzq();
            }
        }
        return null;
    }
    
    //METODO LISTAR_inOrder
    public void Listar_InOrder (Nodo_cliente Nodo, DefaultTableModel modTabla)
    {
        if(Nodo !=null)
        {
            Listar_InOrder(Nodo.getIzq(), modTabla);
            modTabla.addRow(Nodo.getElemento().getRegistro());
            Listar_InOrder(Nodo.getDer(), modTabla);
        }
    }
    
    //METODO BuscarMayorIzquierda
    public Nodo_cliente BuscarMayorIzquierda(Nodo_cliente Auxiliar)
    {
        if(Auxiliar !=null)
        {
            while(Auxiliar.getDer() != null)
            {
                Auxiliar = Auxiliar.getDer();
            }
        }
        return Auxiliar;
    }
    
    //Metodo ElimianrMayorIzaquierda 
    public Nodo_cliente EliminarMayorIzquierda (Nodo_cliente Auxiliar)
    {
        if(Auxiliar == null)
            return null;
        else if(Auxiliar.getDer() != null)
        {
            Auxiliar.setDer(EliminarMayorIzquierda(Auxiliar.getDer()));
            return Auxiliar;
        }
        return Auxiliar.getIzq();
    }
    
    //METODO Eliminar
    public Nodo_cliente Eliminar(Nodo_cliente Auxiliar, String Dato)
    {
        if(Auxiliar == null)
            return null;
        if (Dato.compareTo(Auxiliar.getElemento().getNombreCompleto()) <0)
        {
            Auxiliar.setIzq(Eliminar(Auxiliar.getIzq(),Dato));
        }
        else if (Dato.compareTo(Auxiliar.getElemento().getNombreCompleto()) <0)
        {
            Auxiliar.setDer(Eliminar(Auxiliar.getDer(),Dato));
        }
        else if (Auxiliar.getIzq() != null && Auxiliar.getDer() != null)
        {
            Auxiliar.setElemento(BuscarMayorIzquierda(Auxiliar.getIzq()).getElemento());
            Auxiliar.setIzq(EliminarMayorIzquierda(Auxiliar.getIzq()));
        }
        else
            Auxiliar=( Auxiliar.getIzq() != null) ?
                       Auxiliar.getIzq() : Auxiliar.getDer();
        return Auxiliar;
    }
}
