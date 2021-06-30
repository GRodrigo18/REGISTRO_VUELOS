package VISTA;
import CONTROL.ArbolMaleta;
import CONTROL.NodoMaleta;
import MODELO.ClienteM;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField; 
import javax.swing.table.DefaultTableModel;

public class frm_Maleta extends JFrame
{
    ArbolMaleta objArbol=new ArbolMaleta();
    DefaultTableModel ModTabla;
    int Operacion;
   
    JLabel lbl_Apellidos, lbl_Nombres, lbl_DNI, lbl_Equipaje,lbl_Precio;
    JTextField TxtDNI, TxtApellidos, TxtNombres;
    JButton Btn_Nuevo, Btn_Agregar, Btn_Cancelar, Btn_Buscar, Btn_Eliminar, Btn_Salir, Btn_Actualizar,Btn_Imprimir,Btn_Precios,Btn_Calcular;
    JComboBox CboEquipaje,CboPrecio;
    JTable Tbl_Datos; 
    JScrollPane barra;
    DefaultTableModel Mod_Tabla;
    String titulo[]={"Apellidos","Nombres","N° DNI","Equipaje en KG adicional","Precio en Soles"};
    
    
    
    public frm_Maleta()
    {
        initComponents();
        setLocationRelativeTo(null);
        Estado_Controles(false);
        Estado_Controles(false);
        ModTabla=(DefaultTableModel) Tbl_Datos.getModel();
    }
    
    public void Limpiar_Controles()
    {
        TxtDNI.setText("");
        TxtApellidos.setText("");
        TxtNombres.setText("");
        CboEquipaje.setSelectedIndex(0);
        CboPrecio.setSelectedIndex(0);
    }
    
    public final void Estado_Controles(boolean Estado)
    {
        TxtDNI.setEnabled(Estado);
        TxtApellidos.setEnabled(Estado);
        TxtNombres.setEnabled(Estado);
        CboEquipaje.setEnabled(Estado);
        CboPrecio.setEnabled(Estado);
        Btn_Nuevo.setEnabled(!Estado);
        Btn_Agregar.setEnabled(Estado);
        Btn_Cancelar.setEnabled(Estado);
        Btn_Buscar.setEnabled(!Estado);
        Btn_Eliminar.setEnabled(!Estado);
        Btn_Salir.setEnabled(!Estado);
        Tbl_Datos.setEnabled(!Estado);
    }
    
    public void Limpiar_Tabla()
    {
        ModTabla.setRowCount(0);
    }
    
    public void CargarDatos(NodoMaleta Aux)
    {
        if(Aux!=null)
        {
            TxtApellidos.setText(Aux.getElemento().getApellidos());
            TxtNombres.setText(Aux.getElemento().getNombres());
            TxtDNI.setText(Aux.getElemento().getDNI());
            CboEquipaje.setSelectedItem(Aux.getElemento().getEquipaje());
            CboPrecio.setSelectedItem(Aux.getElemento().getPrecio());
        }
    }
    
    private void initComponents() 
    {
        setSize(700,550);
        setTitle("Equipaje de viaje");
        setLayout(null);
        this.getContentPane().setBackground(new java.awt.Color(58, 83, 155));
        
        //BOTONES
        Btn_Actualizar=new JButton("Actualizar");
        Btn_Actualizar.setBounds(500,20,150,30);
        Btn_Actualizar.setBackground(new java.awt.Color(102, 153, 255));
        Btn_Actualizar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Actualizar();
            }
        }
        );
        add(Btn_Actualizar);
        
               
        Btn_Nuevo=new JButton("Nuevo");
        Btn_Nuevo.setBounds(500,50,150,30);
        Btn_Nuevo.setBackground(new java.awt.Color(102, 153, 255));
        Btn_Nuevo.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Estado_Controles(true);
                Limpiar_Controles();
                TxtApellidos.requestFocus();
            }
        }
        );
        add(Btn_Nuevo);
        
        Btn_Agregar=new JButton("Agregar");
        Btn_Agregar.setBounds(500,80,150,30);
        Btn_Agregar.setBackground(new java.awt.Color(102, 153, 255));
        Btn_Agregar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Object[] Registro={TxtApellidos.getText(),TxtNombres.getText(),TxtDNI.getText(),CboEquipaje.getSelectedItem().toString(),CboPrecio.getSelectedItem().toString()};
                ClienteM Elemento=new ClienteM(Registro);
                if(TxtApellidos.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"Ingresar el Apellidos");
                    TxtApellidos.requestFocus();
                }
                else if(TxtNombres.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Ingresar el Nombres");
                    TxtNombres.requestFocus();
                }
                else if(TxtDNI.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Ingresar el N° DNI");
                    TxtDNI.requestFocus();
                }
                else if(CboEquipaje.getItemCount()==0)
                {
                    JOptionPane.showMessageDialog(null, "Seleccione el peso del equipaje");
                    CboEquipaje.requestFocus();
                }
                else if(CboPrecio.getItemCount()==0)
                {
                    JOptionPane.showMessageDialog(null,"Seleccione el precio");
                    CboPrecio.requestFocus();
                }
                else
                {
                objArbol.setRaiz(objArbol.Agregar(objArbol.getRaiz(), Elemento));
                Limpiar_Tabla();
                objArbol.Listar_InOrder(objArbol.getRaiz(), ModTabla);
                Limpiar_Controles();
                Estado_Controles(false);
                }
            }
        }
        );
        add(Btn_Agregar);
        
        Btn_Cancelar=new JButton("Cancelar");
        Btn_Cancelar.setBounds(500,110,150,30);
        Btn_Cancelar.setBackground(new java.awt.Color(102, 153, 255));
        Btn_Cancelar.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                Limpiar_Controles();
                Estado_Controles(false);
            }
        }
        );
        add(Btn_Cancelar);
        
        Btn_Buscar=new JButton("Buscar");
        Btn_Buscar.setBounds(500,140,150,30);
        Btn_Buscar.setBackground(new java.awt.Color(102, 153, 255));
        Btn_Buscar.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String Cadena=JOptionPane.showInputDialog("Apellido a buscar");
                NodoMaleta Aux=objArbol.BuscarApeNom(Cadena);
                if(Aux!=null)
                {
                    CargarDatos(Aux);
                }
                else
                {
                    JOptionPane.showMessageDialog(rootPane,"El dato Buscado no existe");
                }
            }
        }
        );
        add(Btn_Buscar);
        
        Btn_Eliminar=new JButton("Eliminar");
        Btn_Eliminar.setBounds(500,170,150,30);
        Btn_Eliminar.setBackground(new java.awt.Color(102, 153, 255));
        Btn_Eliminar.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                int Fila=Tbl_Datos.getSelectedRow();
                if(Fila!=-1)
                {
                    String Cadena=ModTabla.getValueAt(Fila,0)+"  "+
                            ModTabla.getValueAt(Fila, 1);
                    
                    objArbol.setRaiz(objArbol.Eliminar(objArbol.getRaiz(), Cadena));
                    Limpiar_Tabla();
                    objArbol.Listar_InOrder(objArbol.getRaiz(), ModTabla);
                }
            }
        }
        );
        add(Btn_Eliminar);
        
        Btn_Imprimir=new JButton("Imprimir");
        Btn_Imprimir.setBounds(500, 200, 150,30);
        Btn_Imprimir.setBackground(new java.awt.Color(102, 153, 255));
        Btn_Imprimir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
               try {
                 Tbl_Datos.print(); // Imprime el jTable
                 } catch (PrinterException ex) { }
            }
        });
        add(Btn_Imprimir);
        
        Btn_Precios=new JButton("Precios");
        Btn_Precios.setBounds(500,230,150,30);
        Btn_Precios.setBackground(new java.awt.Color(102, 153, 255));
        Btn_Precios.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JOptionPane.showMessageDialog(null,
                        "Peso de la maleta      Precio en S/."
                        +"\n4Kg                                        20"
                        +"\n8Kg                                        40"
                        +"\n10Kg                                      50"
                        +"\n12Kg                                      60"
                        +"\n14Kg                                      70"
                        +"\n16Kg                                      80"
                        +"\n18Kg                                      90"
                        +"\n24Kg                                      120",
                        "Panel de precios", WIDTH);
            }
        }
        );
        add(Btn_Precios);
        
        Btn_Calcular=new JButton("Calcular");
        Btn_Calcular.setBounds(350,230,150,30);
        Btn_Calcular.setBackground(new java.awt.Color(102, 153, 255));
        Btn_Calcular.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Total();
            }
        }
        );
        add(Btn_Calcular);
        
        Btn_Salir=new JButton("Salir");
        Btn_Salir.setBounds(500,260,150,30);
        Btn_Salir.setBackground(new java.awt.Color(102, 153, 255));
        Btn_Salir.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dispose();
            }
        }
        );
        add(Btn_Salir);
               
        //FILAS DE TEXTO Y AREAS DE TEXTO
                
        lbl_Apellidos=new JLabel("Apellidos: ");
        lbl_Apellidos.setBounds(90,50,100,30);
        lbl_Apellidos.setForeground(new java.awt.Color(204, 255, 255));
        add(lbl_Apellidos);        
        TxtApellidos=new JTextField();
        TxtApellidos.setBounds(190,50,150,30);
        add(TxtApellidos);
        
        lbl_Nombres=new JLabel("Nombres: ");
        lbl_Nombres.setBounds(90,90,100,30);
        lbl_Nombres.setForeground(new java.awt.Color(204, 255, 255));
        add(lbl_Nombres);  
        TxtNombres=new JTextField();
        TxtNombres.setBounds(190,90,150,30);
        add(TxtNombres);
                      
        lbl_DNI=new JLabel("N° DNI: ");
        lbl_DNI.setBounds(90,130,100,30);
        lbl_DNI.setForeground(new java.awt.Color(204, 255, 255));
        add(lbl_DNI);                
        TxtDNI=new JTextField();
        TxtDNI.setBounds(190,130,150,30);
        add(TxtDNI);
        
        lbl_Equipaje=new JLabel("Equipaje Adicional:");
        lbl_Equipaje.setBounds(80,170,150,30);
        lbl_Equipaje.setForeground(new java.awt.Color(204, 255, 255));
        add(lbl_Equipaje);
        String b[]={"Seleccionar","4","8","10","12","14","16","18","24"};
        CboEquipaje=new JComboBox<>(b);
        CboEquipaje.setBounds(190,170,150,30);      
        add(CboEquipaje);
                
        lbl_Precio=new JLabel("Precio en S/.");
        lbl_Precio.setBounds(80,210,150,30);
        lbl_Precio.setForeground(new java.awt.Color(204, 255, 255));
        add(lbl_Precio);
        String c[]={"Seleccionar","20","40","50","60","70","80","90","120"}; 
        CboPrecio=new JComboBox<>(c);
        CboPrecio.setBounds(190,210,150,30);       
        add(CboPrecio);
        
        
        //CUERPO DE LA TABLA
        
        Tbl_Datos=new JTable();
        barra=new JScrollPane();
        Mod_Tabla=new DefaultTableModel(null,titulo);
        Tbl_Datos.setModel(Mod_Tabla);
        Tbl_Datos.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                Tbl_DatosMouseClicked(evt);
            }
            private void Tbl_DatosMouseClicked(MouseEvent evt)
            {
                int fila=Tbl_Datos.getSelectedRow();
                TxtApellidos.setText(Tbl_Datos.getValueAt(fila,0).toString());
                TxtNombres.setText(Tbl_Datos.getValueAt(fila,1).toString());
                TxtDNI.setText(Tbl_Datos.getValueAt(fila,2).toString());
                CboEquipaje.setToolTipText(Tbl_Datos.getValueAt(fila,3).toString());
                CboPrecio.setToolTipText(Tbl_Datos.getValueAt(fila,4).toString());
            }
        });
        
        barra.setViewportView(Tbl_Datos);
        barra.setBounds(50,300,600,200);
        add(barra);
    }
    public static void main(String[] args) 
    {
        frm_Maleta ventana=new frm_Maleta();
        ventana.setVisible(true);
    }
    public void Actualizar()
    {
        Actualizar(Tbl_Datos,TxtApellidos.getText(),TxtNombres.getText(),TxtDNI.getText(),CboEquipaje.getToolTipText(),CboPrecio.getToolTipText());
    }
    
    public void Actualizar(JTable Tabla,String Apellidos,String Nombres, String Telefono,String Equipaje,String Precio)
    {
        int fila=Tabla.getSelectedRow();
        for(int i=0;i<Tabla.getColumnCount();i++)
        {
            Tabla.setValueAt(Apellidos,fila,0);
            Tabla.setValueAt(Nombres,fila,1);
            Tabla.setValueAt(Telefono,fila,2);
            Tabla.setValueAt(Equipaje,fila,3);
            Tabla.setValueAt(Precio,fila,4);
        }
    }
    private void Total()
    {
        double t=0;
        double p=0;
        if(Tbl_Datos.getRowCount()>0)
        {
            for(int i=0; i<Tbl_Datos.getRowCount();i++)
            {
                p=Double.parseDouble(Tbl_Datos.getValueAt(i,4).toString());
                t+=p;
            }
            JOptionPane.showMessageDialog(null,"El total es:"+t);
        }
        
    }
}