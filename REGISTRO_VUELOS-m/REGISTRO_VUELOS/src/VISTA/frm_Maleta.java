package VISTA;
import CONTROL.ArbolMaleta;
import CONTROL.NodoMaleta;
import MODELO.ClienteM;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import javax.swing.ImageIcon;
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
    String titulo[]={"Apellidos","Nombres","N° DNI","Equipaje Adicional","Precio en S/."};
    
    
    public frm_Maleta()
    {
        initComponents();
        setLocationRelativeTo(null);
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
        setSize(670,550);
        setTitle("Equipaje de viaje");
        setLayout(null);
        this.getContentPane().setBackground(new java.awt.Color(58, 83, 155));
        
        //BOTONES
        Btn_Actualizar=new JButton("Actualizar");
        Btn_Actualizar.setBounds(330, 50, 150,35);
        Btn_Actualizar.setBackground(new java.awt.Color(35, 203, 167));
        Btn_Actualizar.setIcon(new ImageIcon("src\\IMAGENES\\actualizar.png"));
        Btn_Actualizar.setFont(new java.awt.Font("Roboto Light", 3, 18));
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
        Btn_Nuevo.setBounds(490,50,140,35);
        Btn_Nuevo.setBackground(new java.awt.Color(35, 203, 167));
        Btn_Nuevo.setIcon(new ImageIcon("src\\IMAGENES\\agregar-archivo.png"));
        Btn_Nuevo.setFont(new java.awt.Font("Roboto Light", 3, 18));
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
        Btn_Agregar.setBounds(330,100,150,35);
        Btn_Agregar.setBackground(new java.awt.Color(35, 203, 167));
        Btn_Agregar.setIcon(new ImageIcon("src\\IMAGENES\\agregar.png"));
        Btn_Agregar.setFont(new java.awt.Font("Roboto Light", 3, 18));
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
        Btn_Cancelar.setBounds(490,100,140,35);
        Btn_Cancelar.setBackground(new java.awt.Color(35, 203, 167));
        Btn_Cancelar.setIcon(new ImageIcon("src\\IMAGENES\\cancelar.png"));
        Btn_Cancelar.setFont(new java.awt.Font("Roboto Light", 3, 18));
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
        Btn_Buscar.setBounds(490,150,140,35);
        Btn_Buscar.setBackground(new java.awt.Color(35, 203, 167));
        Btn_Buscar.setIcon(new ImageIcon("src\\IMAGENES\\lupa.png"));
        Btn_Buscar.setFont(new java.awt.Font("Roboto Light", 3, 18));
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
        Btn_Eliminar.setBounds(330,150,150,35);
        Btn_Eliminar.setBackground(new java.awt.Color(35, 203, 167));
        Btn_Eliminar.setIcon(new ImageIcon("src\\IMAGENES\\eliminar (1).png"));
        Btn_Eliminar.setFont(new java.awt.Font("Roboto Light", 3, 18));
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
        Btn_Imprimir.setBounds(330, 200, 150,35);
        Btn_Imprimir.setBackground(new java.awt.Color(25, 181, 254));
        Btn_Imprimir.setIcon(new ImageIcon("src\\IMAGENES\\impresion.png"));
        Btn_Imprimir.setFont(new java.awt.Font("Roboto Light", 3, 18));
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
        Btn_Precios.setBounds(490,460,140,35);
        Btn_Precios.setBackground(new java.awt.Color(210, 77, 87));
        Btn_Precios.setForeground(new java.awt.Color(204, 255, 255));
        Btn_Precios.setIcon(new ImageIcon("src\\IMAGENES\\precios.png"));
        Btn_Precios.setFont(new java.awt.Font("Roboto Light", 3, 18));
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
        Btn_Calcular.setBounds(330,460,150,35);
        Btn_Calcular.setBackground(new java.awt.Color(210, 77, 87));
        Btn_Calcular.setForeground(new java.awt.Color(204, 255, 255));
        Btn_Calcular.setIcon(new ImageIcon("src\\IMAGENES\\calcular.png"));
        Btn_Calcular.setFont(new java.awt.Font("Roboto Light", 3, 18));
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
        Btn_Salir.setBounds(490,200,140,35);
        Btn_Salir.setBackground(new java.awt.Color(35, 203, 167));
        Btn_Salir.setIcon(new ImageIcon("src\\IMAGENES\\salida.png"));
        Btn_Salir.setFont(new java.awt.Font("Roboto Light", 3, 18));
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
        lbl_Apellidos.setBounds(25,50,100,30);
        lbl_Apellidos.setForeground(new java.awt.Color(204, 255, 255));
        lbl_Apellidos.setFont(new java.awt.Font("Sitka Subheading", 3, 14));
        add(lbl_Apellidos);        
        TxtApellidos=new JTextField();
        TxtApellidos.setBounds(165,50,150,30);
        TxtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {//evento para que solo letras
                 char validar=evt.getKeyChar();
                 if(Character.isDigit(validar))
                 {
                    getToolkit().beep();
                    evt.consume();
                    
                    JOptionPane.showMessageDialog(rootPane,"Ingresar solo Letras");
                 }
                
            }
        });
        add(TxtApellidos);
        
        lbl_Nombres=new JLabel("Nombres: ");
        lbl_Nombres.setBounds(25,90,100,30);
        lbl_Nombres.setForeground(new java.awt.Color(204, 255, 255));
        lbl_Nombres.setFont(new java.awt.Font("Sitka Subheading", 3, 14));
        add(lbl_Nombres);  
        TxtNombres=new JTextField();
        TxtNombres.setBounds(165,90,150,30);
        TxtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {//evento para que solo letras
                 char validar=evt.getKeyChar();
                 if(Character.isDigit(validar))
                 {
                    getToolkit().beep();
                    evt.consume();
                    
                    JOptionPane.showMessageDialog(rootPane,"Ingresar solo Letras");
                 }
                
            }
        });
        add(TxtNombres);
                      
        lbl_DNI=new JLabel("N° DNI: ");
        lbl_DNI.setBounds(25,130,100,30);
        lbl_DNI.setForeground(new java.awt.Color(204, 255, 255));
        lbl_DNI.setFont(new java.awt.Font("Sitka Subheading", 3, 14));
        add(lbl_DNI);                
        TxtDNI=new JTextField();
        TxtDNI.setBounds(165,130,150,30);
        TxtDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {//evento para que solo valide numeros
                 
                ValidarLongitudCadena(TxtDNI.getText(),8, evt);
                ValidarLetrasNumeros(Character.isLetter(evt.getKeyChar()), evt);
            }
        });
        add(TxtDNI);
        
        lbl_Equipaje=new JLabel("Equipaje Adicional:");
        lbl_Equipaje.setBounds(25,170,150,30);
        lbl_Equipaje.setForeground(new java.awt.Color(204, 255, 255));
        lbl_Equipaje.setFont(new java.awt.Font("Sitka Subheading", 3, 14));
        add(lbl_Equipaje);
        String b[]={"Seleccionar","4","8","10","12","14","16","18","24"};
        CboEquipaje=new JComboBox<>(b);
        CboEquipaje.setBounds(165,170,150,30);      
        add(CboEquipaje);
                
        lbl_Precio=new JLabel("Precio En S/.:");
        lbl_Precio.setBounds(25,210,150,30);
        lbl_Precio.setForeground(new java.awt.Color(204, 255, 255));
        lbl_Precio.setFont(new java.awt.Font("Sitka Subheading", 3, 14));
        add(lbl_Precio);
        String c[]={"Seleccionar","20","40","50","60","70","80","90","120"}; 
        CboPrecio=new JComboBox<>(c);
        CboPrecio.setBounds(165,210,150,30);       
        add(CboPrecio);
        
        
        //CUERPO DE LA TABLA
        
        Tbl_Datos=new JTable();
        barra=new JScrollPane();
        Mod_Tabla=new DefaultTableModel(null,titulo);
        Color mycolor=new Color(245, 215, 110);
        Tbl_Datos.setBackground(mycolor);
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
        barra.setBounds(25,250,605,200);
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
            JOptionPane.showMessageDialog(null,"El total es: S/"+t);
        }
        
    }
    public void ValidarLongitudCadena(String cadena,int tamanio,KeyEvent ev)
    {
        if(cadena.trim().length()==tamanio){ev.consume();}
    }
    public void ValidarLetrasNumeros(boolean dt, KeyEvent e){
        if(dt){e.consume();}
    }
}