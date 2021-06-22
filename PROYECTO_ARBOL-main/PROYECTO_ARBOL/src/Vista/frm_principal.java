 
package Vista;
import Control.Arbol_cliente;
import Control.Nodo_cliente;
import Modelo.Cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
 
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class frm_principal extends JFrame implements ActionListener{
    //1. crear atributos 
    Arbol_cliente objArbol = new Arbol_cliente(); //Instancia del arbol
    int operacion; //operacion (nuevo  editar)
    
    public frm_principal()
    {
        iniComponets();
        this.setLocationRelativeTo(null);
        //2. Llame al metodo Estad_controles  en (Estado 1)//
        Estado_Controles(true);
    }
    
    public void iniComponets()
    {
        setSize(550, 450);
        setTitle("ventana Principal");
        setLayout(null);
        
        Btn_nuevo=new JButton("Nuevo");
        Btn_nuevo.setBounds(400, 40, 100,30);
        Btn_nuevo.addActionListener(this);
        add(Btn_nuevo);
        
        Btn_Agregar=new JButton("Agregar");
        Btn_Agregar.setBounds(400, 90, 100,30);
        Btn_Agregar.addActionListener(this);
        add(Btn_Agregar);
        
        Btn_Cancelar=new JButton("Cancelar");
        Btn_Cancelar.setBounds(400, 140, 100,30);
        Btn_Cancelar.addActionListener(this);
        add(Btn_Cancelar);
        
        Btn_Buscar=new JButton("Buscar");
        Btn_Buscar.setBounds(400, 190, 100,30);
        Btn_Buscar.addActionListener(this);
        add(Btn_Buscar);
        
        Btn_Eliminar=new JButton("Eliminar");
        Btn_Eliminar.setBounds(400, 240, 100,30);
        Btn_Eliminar.addActionListener(this);
        add(Btn_Eliminar);
        
        Btn_Modificar=new JButton("Modificar");
        Btn_Modificar.setBounds(400, 290, 100,30);
        Btn_Modificar.addActionListener(this);
        add(Btn_Modificar);
        
        Btn_Salir=new JButton("Salir");
        Btn_Salir.setBounds(400, 340, 100,30);
        Btn_Salir.addActionListener(this);
        add(Btn_Salir);
        
        
        lblapellido =new JLabel("Apeliidos:");
        lblapellido.setBounds(50, 40, 100, 30);
        add(lblapellido);
        
        lblnombre =new JLabel("Nombres:");
        lblnombre.setBounds(50, 80, 100, 30);
        add(lblnombre);
        
        lbltelefono =new JLabel("Telefono:");
        lbltelefono.setBounds(50, 120, 100, 30);
        add(lbltelefono);
        
        Txt_Apellidos=new JTextField();
        Txt_Apellidos.setBounds(190, 40, 200, 30);
        add(Txt_Apellidos);
        
        Txt_Nombres=new JTextField();
        Txt_Nombres.setBounds(190, 80, 200, 30);
        add(Txt_Nombres);
        
        Txt_Telefono=new JTextField();
        Txt_Telefono.setBounds(190, 120, 200, 30);
        add(Txt_Telefono);
        
        Tbl_Datos=new JTable();
        barra=new JScrollPane();
        ModTabla=new DefaultTableModel(null,titulo);
        
        Tbl_Datos.setModel(ModTabla);
        Tbl_Datos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tbl_DatosMouseClicked(evt);
            }

            private void Tbl_DatosMouseClicked(MouseEvent evt) {
                int fila= Tbl_Datos.getSelectedRow();
                Txt_Apellidos.setText(Tbl_Datos.getValueAt(fila,0).toString());
                Txt_Nombres.setText(Tbl_Datos.getValueAt(fila,1).toString());
                Txt_Telefono.setText(Tbl_Datos.getValueAt(fila,2).toString());
            }
        });
        barra.setViewportView(Tbl_Datos);
        barra.setBounds(50, 170, 340, 200);
        add(barra);
       
    }
    
    public static void main(String[] args) {
        frm_principal ventana=new frm_principal(); 
                         ventana.setVisible(true);
    }
    
    // metodos 
    public void Limpiar_Controles()
    {
        //3.implemete el metodo que borre el contenido de las cajas de texto
        Txt_Apellidos.setText("");
        Txt_Nombres.setText("");
        Txt_Telefono.setText("");
    }
    
    public final void Estado_Controles (boolean Estado)
    {
        //4.Implemete el metodo que realice el cambio de estado(habilitar/Deshabilitar)
        /*Estado 1--->(variable Estado == false)
          Estado 2--->(variable Estado == true)
        */
        
        Txt_Apellidos.setEnabled(Estado);
        Txt_Nombres.setEnabled(Estado);
        Txt_Telefono.setEnabled(Estado);
        Btn_nuevo.setEnabled(Estado);
        Btn_Agregar.setEnabled(Estado);
        Btn_Cancelar.setEnabled(Estado);
        Btn_Buscar.setEnabled(Estado);
        Btn_Eliminar.setEnabled(Estado);
        Btn_Salir.setEnabled(Estado);
        Tbl_Datos.setEnabled(Estado);
    }
    /*public void habilitar()
    {
       Btn_nuevo.setEnabled(true);
   
        Txt_Nombres.setEnabled(true);
        Txt_Telefono.setEnabled(true);
        Txt_Apellidos.setEnabled(true);
        Btn_nuevo.setEnabled(true);
        Btn_Agregar.setEnabled(true);
        Btn_Cancelar.setEnabled(true);
        Btn_Buscar.setEnabled(true);
        Btn_Eliminar.setEnabled(true);
        Btn_Salir.setEnabled(true);
        Tbl_Datos.setEnabled(true);
    }
    public void Deshablitar()
    {
       Btn_Agregar.setEnabled(false);
       Txt_Nombres.setEnabled(false);
        Txt_Telefono.setEnabled(false);
        Txt_Apellidos.setEnabled(false);
       Btn_Cancelar.setEnabled(false);
    }*/
    
    public void Limpiar_Tabla()
    {
        //5.Implemente el metodo que elimine todos los registros de la tabla
        ModTabla.setRowCount(0);
    }
    
    public void CargarDatos(Nodo_cliente Auxiliar)
    {
        //6.Implemente el metodo que al recibir un nodo verifique que no este vacio 
        // y carge el contenido del nodo en los controles
        if(Auxiliar != null)
        {
            Txt_Apellidos.setText(Auxiliar.getElemento().getApellidos());
            Txt_Nombres.setText(Auxiliar.getElemento().getNombres());
            Txt_Telefono.setText(Auxiliar.getElemento().getTelefono());
        }
    }
     
    
    //METODOS DE BOTONES
    public void Nuevo()//BOTON NUEVO
    {
        //7.Llame al emtodo Estado_Controles en (Estado 2) y Limpiar contreoles
        //habilitar();
        Limpiar_Controles();
        //8.Posiciones el cursor en el control txtapellidos
        Txt_Apellidos.requestFocus();
    }
    public void Agregar()//BOTON AGREGAR
    {
        //9.Agregue los datos en un modo del arbol
        Object[] Registro={Txt_Apellidos.getText(),
                           Txt_Nombres.getText(),
                           Txt_Telefono.getText()
                            };
        Cliente Elemento =new Cliente(Registro);
        objArbol.setRaiz(objArbol.Agregar(objArbol.getRaiz(), Elemento));
        //10.Llame al metodo Limpiar_tabla
        Limpiar_Tabla();
        //11.Actualizar la tabla utilizando el metodo "Listar_InOrder" enviar el
        //de la tanla y el nodo raiz
        objArbol.Listar_InOrder(objArbol.getRaiz(), ModTabla);
        //12.llamar al metodo Limpiar_controles
        Limpiar_Controles();
        //13.llamar el metodo Estado_Controles en (Estado 1)
        //Deshablitar();
    }
    //BOTON CANCELAR
    public void Cancelar()
    {
        //14.llamar al metodo Limpiar_Controles
        Limpiar_Controles();
        //15.llamar al metodo Estado_Controles(Estado 1)
        //Deshablitar();
    }
    //BOTON BUSCAR
    public void Buscar()
    {
        //16.Realice la operación de busqueda. 
        //1.solicitara el nombre a buscar
        //2.declarar una variable auxiliar tipo nodo que recibira el resultado de buscar
        //3.verificar el valor de la variable auxiliar, solo si es diferente a null llama
        //al metodo Cargar_Datos de lo contrario mostrara un mensaje indicando que no existe
        String Cadena = JOptionPane.showInputDialog("Apellido a Buscar:  ");
        Nodo_cliente Auxiliar = objArbol.BuscarApeNom(Cadena);
        if(Auxiliar != null)
            CargarDatos(Auxiliar);
        else 
            JOptionPane.showMessageDialog(this, "El Dato Buscando no existe");
    }
    //BOTON ELIMINAR
    public void Eliminar()
    {
        /*17.Realizar la operación de eliminacion. Para ello debera:
            (a)Obtener el numero de la fila seleccionada en la tabla
            (b) Si el valor de la fila es diferente de -1(que significa tiene 
                una fila seleccionada)
            (c)Cree una cadena compuesta de las dos primeras columnas de la 
                fila seleccionada
            (d)LLame al metodo "Eliminar" de ls instancia Arbol enviado el nodo
                raiz y el elemento que sera eliminando
            (e)LLame al metodo Limpiar_Tabla
            (f)Actualizar la tabla utilizando el emtodo "Listar_InOrder".
                No olvidar que al llamar a este metodo debera de enviar 
                el modelo de la tabla y el nodo raiz
                                                                        */
        int fila = Tbl_Datos.getSelectedRow();
        if (fila != -1)
        {
            String Cadena= ModTabla.getValueAt(fila, 0)+ " "+
                           ModTabla.getValueAt(fila, 1);
            objArbol.setRaiz(objArbol.Eliminar(objArbol.getRaiz(), Cadena));
            Limpiar_Tabla();
            objArbol.Listar_InOrder(objArbol.getRaiz(), ModTabla);
        }
    }
    //BOTON MODIFICAR
    public void ActualizarDatosTabla(JTable tab,String ape,String nomb,String tel)
    {
        int fila=tab.getSelectedRow();
        for(int i=0;i<tab.getColumnCount();i++)
        {
            tab.setValueAt(ape,fila,0);
            tab.setValueAt(nomb,fila,1);
            tab.setValueAt(tel,fila,2);
        }
    }
    public void Modificar()
    {
        ActualizarDatosTabla(Tbl_Datos, Txt_Apellidos.getText(),
                             Txt_Nombres.getText(), Txt_Telefono.getText());
    }
    //BOTON SALIR
    public void Salir()
    {
        //19.Cerrar el dialogo
        dispose();
    }
    
    JButton Btn_nuevo,Btn_Agregar,Btn_Cancelar,Btn_Buscar,Btn_Eliminar
            ,Btn_Salir,Btn_Modificar;
    JLabel lblapellido,lblnombre,lbltelefono;
    JTextField Txt_Apellidos,Txt_Nombres,Txt_Telefono;
    JTable Tbl_Datos;
    JScrollPane barra;
    DefaultTableModel ModTabla;
        String []titulo={"Apellidos","Nombres","Teléfono"};
        
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
       if(e.getSource()== Btn_nuevo)
       {
           Nuevo();
       }
       if(e.getSource()== Btn_Agregar)
       {
           Agregar();
       }
       if(e.getSource()== Btn_Cancelar)
       {
           Cancelar();
       }
       if(e.getSource()== Btn_Buscar)
       {
           Buscar();
       }
       if(e.getSource()== Btn_Eliminar)
       {
           Eliminar();
       }
       if(e.getSource()== Btn_Modificar)
       {
           Modificar();
       }
       if(e.getSource()== Btn_Salir)
       {
           Salir();
       }
    }

}
