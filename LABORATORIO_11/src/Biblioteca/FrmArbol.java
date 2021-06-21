package Biblioteca;
import Biblioteca.FrmLista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FrmArbol extends JFrame {
    
    Arbol objArbol = new Arbol();
    //----------------------------------------------------------
    JLabel lblcodigo,lblnombre,lblapellidos;
    JTextField txtcodigo,txtNombre,txtApellidos;
    JButton btnAgregar,btnListar,btnBuscar,btnEliminar,btnSalir;
    DefaultTableModel Modtabla;
    
    public FrmArbol(){
        setDefaultCloseOperation(FrmArbol.EXIT_ON_CLOSE);
        setSize(500,350);
        setTitle("MANTENIMIENTO DE CONTACTOS");
        setLocationRelativeTo(null);
        initComponents();
    }
    public void initComponents(){  
        
        JTabbedPane pestañas=new JTabbedPane();
 
        JPanel DatosG=new JPanel();
        pestañas.addTab("Datos Generales", DatosG);
        
        JLabel lblcodigo=new JLabel("CODIGO:");
        lblcodigo.setBounds(20, 50, 200, 30);
        add(lblcodigo);
 
        JLabel lblapellidos=new JLabel("APELLIDOS:");
        lblapellidos.setBounds(20, 90, 200, 30);
        add(lblapellidos);
                
        JLabel lblnombre=new JLabel("NOMBRES:");
        lblnombre.setBounds(20, 130, 200, 30);
        add(lblnombre);
        
        JTextField txtcodigo=new JTextField();
        txtcodigo.setBounds(100, 50, 100, 25);
        add(txtcodigo);
        
        JTextField txtApellidos=new JTextField();
        txtApellidos.setBounds(100,90, 170, 25);
        add(txtApellidos);
        
        JTextField txtNombre=new JTextField();
        txtNombre.setBounds(100, 130, 170, 25);
        add(txtNombre);
        
        JPanel DatosAdi=new JPanel();
        pestañas.addTab("Datos Adicionales", DatosAdi);

        btnAgregar=new JButton("REGISTRAR");
        btnAgregar.setBounds(350, 50, 120, 35);
        btnAgregar.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
                {
                   FrmLista lista=new FrmLista();
                   lista.setLocationRelativeTo(null);
                   lista.setVisible(true);
                   AGREGAR();
                }
        });
        add(btnAgregar);
                
        btnBuscar=new JButton("BUSCAR");
        btnBuscar.setBounds(350, 90, 120, 35);
        btnBuscar.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
                {
                    Buscar();
                }
        });
        add(btnBuscar);
        
        btnEliminar=new JButton("ELIMINAR");
        btnEliminar.setBounds(350, 130, 120, 35);
        btnEliminar.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
                {
                    Eliminar();
                }
        });
        add(btnEliminar);
        
        btnListar=new JButton("LISTAR");
        btnListar.setBounds(350, 170, 120, 35);
        btnListar.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
                {
                     
                }
        });
        add(btnListar);
        
        btnSalir=new JButton("SALIR");
        btnSalir.setBounds(350, 260, 120, 35);
        btnSalir.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
                {
                    Salir();
                }
        });
        add(btnSalir);
        
        getContentPane().add(pestañas);
    }   
    public void AGREGAR()
    {
        Object[] Registro = {txtcodigo.getText(),
                             txtApellidos.getText(),
                             txtNombre.getText()
                            };
        Cliente Elemento = new Cliente(Registro);
        objArbol.setRaiz(objArbol.Agregar(objArbol.getRaiz(), Elemento));
        
        Limpiar_Tablas();
        
        objArbol.Listar_InOrder(objArbol.getRaiz(), Modtabla);
    }
    public void Limpiar_controles()
    {
        txtcodigo.setText("");
        
    }
    public void Limpiar_Tablas()
    {
        Modtabla.setRowCount(0);
    }
    public void CargarDatos(Nodo Auxiliar)
    {
       if (Auxiliar != null)
       {
            txtcodigo.setText(Auxiliar.getElemento().getCodigo());
            txtApellidos.setText(Auxiliar.getElemento().getApellidos());
            txtNombre.setText(Auxiliar.getElemento().getNombres());
       }
    }
    public void Buscar()
    {
      String Cadena = JOptionPane.showInputDialog("Apellido a Buscar:  ");
      Nodo Auxiliar = objArbol.BuscarApeNom(Cadena);
      if(Auxiliar != null)
          CargarDatos(Auxiliar);
      else 
          JOptionPane.showMessageDialog(this, "El dato no existe");
    }
    public void Eliminar()
    {
        
    }
    public void Salir()
    {
         dispose();
    }
    public static void main(String[] args) {
 
        FrmArbol ventana=new FrmArbol();
            ventana.setVisible(true);
    }
}
