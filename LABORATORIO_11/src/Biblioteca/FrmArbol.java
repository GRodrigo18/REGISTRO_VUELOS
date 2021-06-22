package Biblioteca;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FrmArbol extends JFrame {

    Arbol objArbol =new Arbol();
    int operacion;
      
    public FrmArbol(){
        setDefaultCloseOperation(FrmArbol.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }
    public void initComponents(){  
        
        setSize(500,400);
        setTitle("MANTENIMIENTO DE CONTACTOS");
        setLayout(null);
        
        lblcodigo=new JLabel("CODIGO:");
        lblcodigo.setBounds(20,20, 200, 30);
        add(lblcodigo);
        
        lblapellidos=new JLabel("APELLIDO:");
        lblapellidos.setBounds(20, 50, 200, 30);
        add(lblapellidos);
       
        lblnombre=new JLabel("NOMBRE:");
        lblnombre.setBounds(20, 80, 200, 30);
        add(lblnombre);
        
        txtcodigo=new JTextField();
        txtcodigo.setBounds(80,22, 120, 20);
        add(txtcodigo);
        
        txtApellidos=new JTextField();
        txtApellidos.setBounds(80, 52, 120, 20);
        add(txtApellidos);
        
        txtApellidos=new JTextField();
        txtApellidos.setBounds(80, 82, 120, 20);
        add(txtApellidos);
        
        btnAgregar=new JButton("AGREGAR");
        btnAgregar.setBounds(300,30,110,30);
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
                    agregar();
            }
        });
        add(btnAgregar);
        
        btnBuscar=new JButton("BUSCAR");
        btnBuscar.setBounds(300,70,110,30);
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
                    buscar();
            }
        });
        add(btnBuscar);
        
        btnEliminar=new JButton("ELIMINAR");
        btnEliminar.setBounds(300,110,110,30);
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
                    eliminarFila();
            }
        });
        add(btnEliminar);
        
        btnListar=new JButton("LISTAR");
        btnListar.setBounds(300,150,110,30);
        btnListar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
                    listar();
                    lis();
            }
        });
        add(btnListar);
        
        btnSalir=new JButton("CERRAR");
        btnSalir.setBounds(400,200,110,30);
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
                    salir();
            }
        });
        add(btnSalir);
        
        scroll=new JScrollPane();
        scroll.setBounds(20,150,350,200);
        modTabla=new DefaultTableModel(null,titulo);
        add(scroll);            
        
        tablas1=new JTable();
        scroll.setViewportView(tablas1);
        tablas1.setModel(modTabla);        
    }
    
    public void limpiarControl(){
        
        txtcodigo.setText("");
        txtApellidos.setText("");
        txtNombre.setText("");
    }

    private void Estado_control(boolean estado) {
       
        txtcodigo.setEnabled(estado);
        txtApellidos.setEnabled(estado);
        txtNombre.setEnabled(estado);
        btnAgregar.setEnabled(estado);
        btnBuscar.setEnabled(!estado);
        btnEliminar.setEnabled(!estado);
        btnListar.setEnabled(!estado);
        tablas1.setEnabled(!estado);
    }
    
    public void limpiarTabla(){
        modTabla.setRowCount(0);
    }
    
    public void cargarDatos(Nodo aux){
       
        if(aux!=null){
            txtcodigo.setText(aux.getElemento().getCodigo());
            txtApellidos.setText(aux.getElemento().getApellidos());
            txtNombre.setText(aux.getElemento().getNombres());
        }
    }
    public void agregar(){
        Object[] Regis={txtcodigo.getText(),
                        txtApellidos.getText(),
                        txtNombre.getText()};
        
        Cliente Elemento=new Cliente(Regis);
        objArbol.setRaiz(objArbol.Agregar(objArbol.getRaiz(),Elemento));
        limpiarTabla();
        
        objArbol.Listar_InOrder(objArbol.getRaiz(), modTabla);
        limpiarControl();
        Estado_control(false);  
    
    }
    
    public void buscar(){
        String cadena=JOptionPane.showInputDialog("Nombre a buscar:");
        Nodo aux=objArbol.BuscarApeNom(cadena);
        if(aux!=null)
            cargarDatos(aux);
        else
            JOptionPane.showMessageDialog(this,"El dato buscado no existe");
    }
    
    public void eliminar(){
        int Fila=tablas1.getSelectedRow();
        if(Fila!=-1){
            String cadena=modTabla.getValueAt(Fila,0)+" "+
                    modTabla.getValueAt(Fila,1);
            objArbol.setRaiz(objArbol.Eliminar(objArbol.getRaiz(), cadena));
            limpiarTabla();
            objArbol.Listar_InOrder(objArbol.getRaiz(), modTabla);
        }
    }
    void eliminarFila(){
          DefaultTableModel modelo=(DefaultTableModel)tablas1.getModel();
          modelo.removeRow(this.tablas1.getSelectedRow());
         
     }
     
    public void listar(){
      int fila=tablas1.getSelectedRow();
           
           if(fila>=0){
               String dato[]=new String[3];
               dato[0]=tablas1.getValueAt(fila,0).toString();
               dato[1]=tablas1.getValueAt(fila,1).toString();
               dato[2]=tablas1.getValueAt(fila,2).toString();
               
                FrmLista.modelo.addRow(dato);
                modTabla.removeRow(fila);
                                
           }
    }
    
    public void salir(){
        dispose();
    }
    
    public void lis(){
        FrmLista principalL=new FrmLista();
                 principalL.setLocationRelativeTo(null);
                 principalL.setVisible(true);
    }
     
    public static void main(String[] args) {
 
        FrmArbol ventana=new FrmArbol();
            ventana.setVisible(true);
    }
    
    JLabel lblcodigo,lblnombre,lblapellidos;
    JTextField txtcodigo,txtNombre,txtApellidos;
    JButton btnAgregar,btnListar,btnBuscar,btnEliminar,btnSalir;
    JTable tablas1;
    DefaultTableModel modTabla;
    JScrollPane scroll;
    String titulo[]={"CÓDIGO", "APELLIDOS", "NOMBRES"};
}
