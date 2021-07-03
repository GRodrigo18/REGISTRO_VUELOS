package CONTROL;
import MODELO.ClienteM;
import javax.swing.table.DefaultTableModel;
public class ArbolMaleta 
{
    private NodoMaleta Raiz;
    
    public ArbolMaleta()
    {
        Raiz=null;
    }

    public void setRaiz(NodoMaleta Raiz) 
    {
        this.Raiz = Raiz;
    }
    
    public NodoMaleta getRaiz() 
    {
        return Raiz;
    }
    
    public NodoMaleta Agregar(NodoMaleta Nodo, ClienteM Elemento)
    {
        if(Nodo==null)
        {
            NodoMaleta Nuevo=new NodoMaleta(Elemento);
            return Nuevo;
        }
        else
        {
            if(Elemento.getNomCompleto().compareTo(Nodo.getElemento().getNomCompleto())>0)
            {
                Nodo.setDer(Agregar(Nodo.getDer(),Elemento));
            }
            else
            {
                Nodo.setIzq(Agregar(Nodo.getIzq(), Elemento));
            }
        }
        return Nodo;
    }
    
    public NodoMaleta BuscarApeNom(String Dato)
    {
        NodoMaleta aux=Raiz;
        while(aux!=null)
        {
            if(aux.getElemento().getNomCompleto().startsWith(Dato))
            {
                return aux;
            }
            else
            {
                if(Dato.compareTo(aux.getElemento().getNomCompleto())>0)
                {
                    aux=aux.getDer();
                }
                else
                {
                    aux=aux.getIzq();
                }
            }
        }
        return null;
    }
   
    public void Listar_InOrder(NodoMaleta Nodo, DefaultTableModel modTabla)
    {
        if(Nodo!=null)
        {
            Listar_InOrder(Nodo.getIzq(), modTabla);
            modTabla.addRow(Nodo.getElemento().getRegistro());
            Listar_InOrder(Nodo.getDer(), modTabla);
        }
            
    }
    
    public NodoMaleta BuscarMayorIzquierda(NodoMaleta Aux)
    {
        if(Aux!=null)
        {
            while(Aux.getDer()!=null)
            {
                Aux=Aux.getDer();
            }
        }
        return Aux;
    }
    
    public NodoMaleta EliminarMayorIZquierda(NodoMaleta Aux)
    {
        if(Aux==null)
            return null;
        else if(Aux.getDer()!=null)
        {
            Aux.setDer(EliminarMayorIZquierda(Aux.getDer()));
            return Aux;
        }
        return Aux.getIzq();
    }
    
    public NodoMaleta Eliminar(NodoMaleta Aux,String Dato)
    {
        if(Aux==null)
        {
            return null;
        }
        if(Dato.compareTo(Aux.getElemento().getNomCompleto())<0)
        {
            Aux.setIzq(Eliminar(Aux.getIzq(),Dato));
        }
        else if(Dato.compareTo(Aux.getElemento().getNomCompleto())>0)
        {
            Aux.setDer(Eliminar(Aux.getDer(), Dato));
        }
        else if(Aux.getIzq()!=null && Aux.getDer()!=null)
        {
            Aux.setElemento(BuscarMayorIzquierda(Aux.getIzq()).getElemento());
            Aux.setIzq(EliminarMayorIZquierda(Aux.getIzq()));
        }
        else
        {
            Aux=(Aux.getIzq()!=null)?
                    Aux.getIzq():Aux.getDer();
        }
        return Aux;
    }
}