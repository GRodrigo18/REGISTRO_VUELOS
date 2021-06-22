 
package VISTA;
import CONTROL.Arbol_cliente;
import CONTROL.Nodo_cliente;
import MODELO.Cliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class frm_Registro_vuelo extends JFrame implements Runnable{

    String hora,minutos,segundos;
    Thread hilo;
    //1. crear atributos 
    Arbol_cliente objArbol = new Arbol_cliente(); //Instancia del arbol
    int operacion; //operacion (nuevo  editar)
    
    
    public frm_Registro_vuelo()
    {
        iniComponets();
        this.setLocationRelativeTo(null);
        //2. Llame al metodo Estad_controles  en (Estado 1)//
        //Estado_Controles(true);
        
        lblfechactual.setText(fecha());
        
        hilo=new Thread(this);
        hilo.start();
        setVisible(true);
    }
     public void iniComponets()
    {
        setSize(950, 850);
        setTitle("-REGISTRO VUELOS-");
        setLayout(null);
        this.getContentPane().setBackground(new java.awt.Color(204, 255, 255));
        
        
        lbln1 =new JLabel("REGISTRO DE VUELOS");
        lbln1.setBounds(300, 10, 400, 50);
        lbln1.setForeground(new java.awt.Color(51, 102, 255));
        lbln1.setFont(new java.awt.Font("Rockwell Extra Bold", 3, 30));
        add(lbln1);
        
        lbln2 =new JLabel("TIPO DE DOCUMENTO:");
        lbln2.setBounds(50, 70, 200, 30);
        lbln2.setFont(new java.awt.Font("Sitka Subheading", 3, 17));
        add(lbln2);
        
        lbln3 =new JLabel("NÚMERO DE DOCUMENTO:");
        lbln3.setBounds(50, 110, 250, 30);
        lbln3.setFont(new java.awt.Font("Sitka Subheading", 3, 17));
        add(lbln3);
        
        lbln4 =new JLabel("PASAPORTE:");
        lbln4.setBounds(50, 150, 200, 30);
        lbln4.setFont(new java.awt.Font("Sitka Subheading", 3, 17));
        add(lbln4);
        
        lbl5 =new JLabel("NOMBRES:");
        lbl5.setBounds(50, 190, 200, 30);
        lbl5.setFont(new java.awt.Font("Sitka Subheading", 3, 17));
        add(lbl5);
        
        lbl6 =new JLabel("APELLIDOS:");
        lbl6.setBounds(50, 230, 200, 30);
        lbl6.setFont(new java.awt.Font("Sitka Subheading", 3, 17));
        add(lbl6);
        
        lbl7 =new JLabel("SEXO:");
        lbl7.setBounds(50, 270, 200, 30);
        lbl7.setFont(new java.awt.Font("Sitka Subheading", 3, 17));
        add(lbl7);
        
        lbl8 =new JLabel("ORIGEN:");
        lbl8.setBounds(50, 310, 200, 30);
        lbl8.setFont(new java.awt.Font("Sitka Subheading", 3, 17));
        add(lbl8);
        
        lbl9 =new JLabel("DESTINO:");
        lbl9.setBounds(50, 350, 200, 30);
        lbl9.setFont(new java.awt.Font("Sitka Subheading", 3, 17));
        add(lbl9);
        
        lbl10 =new JLabel("FECHA DE SALIDA:");
        lbl10.setBounds(50, 390, 500, 30);
        lbl10.setFont(new java.awt.Font("Sitka Subheading", 3, 17));
        add(lbl10);
         
        lbl11 =new JLabel("FECHA DE RETORNO:");
        lbl11.setBounds(50, 430, 500, 30);
        lbl11.setFont(new java.awt.Font("Sitka Subheading", 3, 17));
        add(lbl11);
        
        lblfcha =new JLabel("FECHA");
        lblfcha.setBounds(550, 65, 180,45);
        lblfcha.setForeground(new java.awt.Color(0, 102, 102));
        lblfcha.setFont(new java.awt.Font("Roboto Light", 3, 17));
        add(lblfcha);
        
        lblhora =new JLabel("HORA");
        lblhora.setBounds(750, 65, 180,45);
        lblhora.setForeground(new java.awt.Color(0, 102, 102));
        lblhora.setFont(new java.awt.Font("Roboto Light", 3, 17));
        add(lblhora);
        
        lblfechactual =new JLabel("DO/MM/YYYY");
        lblfechactual.setBounds(550, 95, 180,45);
        lblfechactual.setForeground(new java.awt.Color(0, 102, 102));
        lblfechactual.setFont(new java.awt.Font("Roboto Light", 3, 17));
        add(lblfechactual);
        
        lblhoraactual =new JLabel("00:00:00");
        lblhoraactual.setBounds(750, 95, 180,45);
        lblhoraactual.setForeground(new java.awt.Color(0, 102, 102));
        lblhoraactual.setFont(new java.awt.Font("Roboto Light", 3, 17));
        add(lblhoraactual);
        
        txtnumdocu=new JTextField();
        txtnumdocu.setBounds(290, 110, 150, 30);
        txtnumdocu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {//evento para que solo valide numeros
                 
                ValidarLongitudCadena(txtnumdocu.getText(),8, evt);
                ValidarLetrasNumeros(Character.isLetter(evt.getKeyChar()), evt);
            }
        });
        txtnumdocu.setFont(new java.awt.Font("Roboto Light", 3, 16));
        add(txtnumdocu); 
        
        txtpasaporte=new JTextField();
        txtpasaporte.setBounds(290, 150, 150, 30);
        txtpasaporte.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {//evento para que solo valide numeros
                ValidarLongitudCadena(txtpasaporte.getText(),12, evt);
                ValidarLetrasNumeros(Character.isLetter(evt.getKeyChar()), evt);
                 
            }
        });
        txtpasaporte.setFont(new java.awt.Font("Roboto Light", 3, 16));
        add(txtpasaporte); 
        
        txtnombres=new JTextField();
        txtnombres.setBounds(290, 190, 150, 30);
        txtnombres.addKeyListener(new java.awt.event.KeyAdapter() {
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
        txtnombres.setFont(new java.awt.Font("Sitka Subheading", 3, 16));
        add(txtnombres); 
        
        txtapellidos=new JTextField();
        txtapellidos.setBounds(290, 230, 150, 30);
        txtapellidos.addKeyListener(new java.awt.event.KeyAdapter() {
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
        txtapellidos.setFont(new java.awt.Font("Sitka Subheading", 3, 16));
        add(txtapellidos); 
        
        txtfechsalida=new JTextField();
        txtfechsalida.setBounds(290, 390, 150, 30);
        txtfechsalida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {//evento para que solo valide numeros
                ValidarLongitudCadena(txtfechsalida.getText(),8, evt);
                ValidarLetrasNumeros(Character.isLetter(evt.getKeyChar()), evt);            }
        });
        txtfechsalida.setFont(new java.awt.Font("Sitka Subheading", 3, 16));
        add(txtfechsalida); 
        
        txtfecharetorno=new JTextField();
        txtfecharetorno.setBounds(290, 430, 150, 30);
        txtfecharetorno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {//evento para que solo valide numeros
                ValidarLongitudCadena(txtfecharetorno.getText(),8, evt);
                ValidarLetrasNumeros(Character.isLetter(evt.getKeyChar()), evt);
            }
        });
        txtfecharetorno.setFont(new java.awt.Font("Sitka Subheading", 3, 16));
        add(txtfecharetorno);
        
        
        Btn_nuevo=new JButton("Nuevo");
        Btn_nuevo.setBounds(500, 230, 180,50);
        Btn_nuevo.setBackground(new java.awt.Color(102, 153, 255));
        Btn_nuevo.setIcon(new ImageIcon("C:\\Users\\bgrad\\OneDrive\\Documentos\\NETBEANS\\REGISTRO_VUELOS\\REGISTRO_VUELOS\\src\\IMAGENES\\anadir-grupo.png"));
        Btn_nuevo.setFont(new java.awt.Font("Roboto Light", 3, 18));
        Btn_nuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
              Nuevo();
            }
        });
        add(Btn_nuevo);
          
        Btn_Agregar=new JButton("Agregar");
        Btn_Agregar.setBounds(500, 155, 180,50);
        Btn_Agregar.setBackground(new java.awt.Color(102, 153, 255));
        Btn_Agregar.setIcon(new ImageIcon("src\\IMAGENES\\agregar-archivo.png"));
        Btn_Agregar.setFont(new java.awt.Font("Roboto Light", 3, 18));
        Btn_Agregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
              Agregar();
            }
        });
        add(Btn_Agregar);
        
        Btn_Buscar=new JButton("Buscar");
        Btn_Buscar.setBounds(700, 230, 180,50);
        Btn_Buscar.setBackground(new java.awt.Color(102, 153, 255));
        Btn_Buscar.setIcon(new ImageIcon("src\\IMAGENES\\seo.png"));
        Btn_Buscar.setFont(new java.awt.Font("Roboto Light", 3, 18));
        Btn_Buscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
                Buscar();
            }
        });
        add(Btn_Buscar);
        
        Btn_Cancelar=new JButton("Cancelar");
        Btn_Cancelar.setBounds(700, 155, 180,50);
        Btn_Cancelar.setBackground(new java.awt.Color(102, 153, 255));
        Btn_Cancelar.setIcon(new ImageIcon("src\\IMAGENES\\cancelar.png"));
        Btn_Cancelar.setFont(new java.awt.Font("Roboto Light", 3, 18));;
        Btn_Cancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
                Cancelar();
            }
        });
        add(Btn_Cancelar);
        
        Btn_imprimir=new JButton("IMPRIMIR");
        Btn_imprimir.setBounds(600, 370, 180,45);
        Btn_imprimir.setBackground(new java.awt.Color(153, 204, 255));
        Btn_imprimir.setIcon(new ImageIcon("src\\IMAGENES\\impresion.png"));
        Btn_imprimir.setFont(new java.awt.Font("Roboto Light", 3, 18));
        Btn_imprimir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
               try {
                 Tbl_Datos.print(); // Imprime el jTable
                 } catch (PrinterException ex) { }
            }
        });
        add(Btn_imprimir);
        
        Btn_Eliminar=new JButton("Eliminar");
        Btn_Eliminar.setBounds(500, 300, 180,45);
        Btn_Eliminar.setBackground(new java.awt.Color(102, 153, 255));
        Btn_Eliminar.setIcon(new ImageIcon("src\\IMAGENES\\borrar.png"));
        Btn_Eliminar.setFont(new java.awt.Font("Roboto Light", 3, 18));
        Btn_Eliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
               Eliminar();
            }
        });
        add(Btn_Eliminar);
        
        Btn_Salir=new JButton("Salir");
        Btn_Salir.setBounds(700, 300, 180,45);
        Btn_Salir.setBackground(new java.awt.Color(102, 153, 255));
        Btn_Salir.setIcon(new ImageIcon("src\\IMAGENES\\salida.png"));
        Btn_Salir.setFont(new java.awt.Font("Roboto Light", 3, 18));
        Btn_Salir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
                Salir();
            }
        });
        add(Btn_Salir);
        
    
        String a[]={"Seleccione","DNI","CARNET DE EXTRANJERIA"};
        cbotipodocu=new JComboBox<>(a);
        cbotipodocu.setBounds(290,70, 150, 30);
        cbotipodocu.setFont(new java.awt.Font("Sitka Subheading", 3, 16));
        add(cbotipodocu);
        
        String b[]={"Seleccione","Masculino","Femenino"};
        cbosexo=new JComboBox<>(b);
        cbosexo.setBounds(290, 270, 150, 30);
        cbosexo.setFont(new java.awt.Font("Sitka Subheading", 3, 16));
        add(cbosexo); 
        
        
        String c[]={"Seleccione","Lima","Amazonas","Ancash","Apurimac","Arequipa",
                    "Ayacucho","Cajamarca","Callao","Huancavelica"};
        cboorigen=new JComboBox<>(c);
        cboorigen.setBounds(290, 310, 150, 30);
        cboorigen.setFont(new java.awt.Font("Sitka Subheading", 3, 16));
        add(cboorigen);
        
        String d[]={"Seleccione","Tokio","New York","Los Angeles","Paris","Seul",
                    "Londres","Moscu","Boston","Barcelona","Bogota"};
        cbodestino=new JComboBox<>(d);
        cbodestino.setBounds(290, 350, 150, 30);
        cbodestino.setFont(new java.awt.Font("Sitka Subheading", 3, 16));
        add(cbodestino);
        
        Tbl_Datos=new JTable(ModTabla);
        barra=new JScrollPane();
        ModTabla=new DefaultTableModel(null,titulo);
        Tbl_Datos.setModel(ModTabla);
        
        barra.setViewportView(Tbl_Datos);
        barra.setBounds(50,490,850,300);
        add(barra);         
    }
    public static String fecha()
    {
        Date fecha=new Date();
        SimpleDateFormat formatofecha=new SimpleDateFormat("dd/MM/YYYY");
        return formatofecha.format(fecha);
    }
    public void hora()
    {
       Calendar calendario=new GregorianCalendar();
       Date horactual=new Date();
       calendario.setTime(horactual);
       hora=calendario.get(Calendar.HOUR_OF_DAY)>9?""+
            calendario.get(Calendar.HOUR_OF_DAY):"0"+
            calendario.get(Calendar.HOUR_OF_DAY);
       minutos=calendario.get(Calendar.MINUTE)>9?""+
               calendario.get(Calendar.MINUTE):"0"+
               calendario.get(Calendar.MINUTE);
       segundos=calendario.get(Calendar.SECOND)>9?""+
                calendario.get(Calendar.SECOND):"0"+
                calendario.get(Calendar.SECOND);
    }
    public void run()
    {
        Thread current=Thread.currentThread();
        while(current==hilo){
            hora();
            lblhoraactual.setText(hora+":"+minutos+":"+segundos);
        }
    }
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_Registro_vuelo().setVisible(true);
            }
        });
    }
    
     // metodos 
    public void ValidarLongitudCadena(String cadena,int tamanio,KeyEvent ev)
    {
        if(cadena.trim().length()==tamanio){ev.consume();}
    }
    public void ValidarLetrasNumeros(boolean dt, KeyEvent e){
        if(dt){e.consume();}
    }
    public void Limpiar_Controles()
    {
        //3.implemete el metodo que borre el contenido de las cajas de texto y combobox
        cbotipodocu.setSelectedIndex(0);
        txtnumdocu.setText("");
        txtpasaporte.setText("");
        txtnombres.setText("");
        txtapellidos.setText("");
        cbosexo.setSelectedIndex(0);
        cboorigen.setSelectedIndex(0);
        cbodestino.setSelectedIndex(0);
        txtfechsalida.setText("");
        txtfecharetorno.setText("");
        cbotipodocu.requestFocus();
    }
    
    public final void Estado_Controles (boolean Estado)
    {
        //4.Implemete el metodo que realice el cambio de estado(habilitar/Deshabilitar)
        /*Estado 1--->(variable Estado == false)
          Estado 2--->(variable Estado == true)
        */
        
        cbotipodocu.setEnabled(Estado);
        txtnumdocu.setEnabled(Estado);
        txtpasaporte.setEnabled(Estado);
        txtnombres.setEnabled(Estado);
        txtapellidos.setEnabled(Estado);
        cbosexo.setEnabled(Estado);
        cboorigen.setEnabled(Estado);
        cbodestino.setEnabled(Estado);
        txtfechsalida.setEnabled(Estado);
        txtfecharetorno.setEnabled(Estado);
        Btn_nuevo.setEnabled(Estado);
        Btn_Agregar.setEnabled(Estado);
        Btn_Cancelar.setEnabled(Estado);
        Btn_Buscar.setEnabled(Estado);
        Btn_Eliminar.setEnabled(Estado);
        Btn_Salir.setEnabled(Estado);
        Tbl_Datos.setEnabled(Estado);
    }
    public void hanilitar()
    {
       Btn_nuevo.setEnabled(true);
   
        cbotipodocu.setEnabled(true);
        txtnumdocu.setEnabled(true);
        txtpasaporte.setEnabled(true);
        txtnombres.setEnabled(true);
        txtapellidos.setEnabled(true);
        cbosexo.setEnabled(true);
        cboorigen.setEnabled(true);
        cbodestino.setEnabled(true);
        txtfechsalida.setEnabled(true);
        txtfecharetorno.setEnabled(true);
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
       cbotipodocu.setEnabled(false);
       txtnumdocu.setEnabled(false);
       txtpasaporte.setEnabled(false);
       txtnombres.setEnabled(false);
       txtapellidos.setEnabled(false);
       cbosexo.setEnabled(false);
       cboorigen.setEnabled(false);
       cbodestino.setEnabled(false);
       txtfechsalida.setEnabled(false);
       txtfecharetorno.setEnabled(false);
       Btn_Cancelar.setEnabled(false);
    }
    
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
            
           
            txtnumdocu.setText(Auxiliar.getElemento().getNumdocu());
            txtpasaporte.setText(Auxiliar.getElemento().getPasaporte());
            txtnombres.setText(Auxiliar.getElemento().getNombres());
            txtapellidos.setText(Auxiliar.getElemento().getApellidos());
            
            txtfechsalida.setText(Auxiliar.getElemento().getFechsali());
            txtfecharetorno.setText(Auxiliar.getElemento().getFechretor());
          
        }
    }
    
    //METODOS DE BOTONES
    public void Nuevo()//BOTON NUEVO
    {
        //7.Llame al emtodo Estado_Controles en (Estado 2) y Limpiar contreoles
        hanilitar();
        Limpiar_Controles();
        //8.Posiciones el cursor en el control txtapellidos
        cbotipodocu.requestFocus();
    }
    public void Agregar()//BOTON AGREGAR
    {
        //9.Agregue los datos en un modo del arbol
        Object[] Registro={cbotipodocu.getSelectedItem().toString(),
                           txtnumdocu.getText(),
                           txtpasaporte.getText(),
                           txtnombres.getText(),
                           txtapellidos.getText(),
                           cbosexo.getSelectedItem().toString(),
                           cboorigen.getSelectedItem().toString(),
                           cbodestino.getSelectedItem().toString(),
                           txtfechsalida.getText(),
                           txtfecharetorno.getText()
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
        Deshablitar();
    }
    //BOTON CANCELAR
    public void Cancelar()
    {
        //14.llamar al metodo Limpiar_Controles
        Limpiar_Controles();
        //15.llamar al metodo Estado_Controles(Estado 1)
        Deshablitar();
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
                           ModTabla.getValueAt(fila, 1)+ " "+
                           ModTabla.getValueAt(fila, 2)+ " "+
                           ModTabla.getValueAt(fila, 3)+ " "+
                           ModTabla.getValueAt(fila, 4)+ " "+
                           ModTabla.getValueAt(fila, 5)+ " "+
                           ModTabla.getValueAt(fila, 6)+ " "+
                           ModTabla.getValueAt(fila, 7)+ " "+
                           ModTabla.getValueAt(fila, 8)+ " "+
                           ModTabla.getValueAt(fila, 9)
                           ;
            objArbol.setRaiz(objArbol.Eliminar(objArbol.getRaiz(), Cadena));
            Limpiar_Tabla();
            objArbol.Listar_InOrder(objArbol.getRaiz(), ModTabla);
        }
        
    }
    //BOTON SALIR
    public void Salir()
    {
        //19.Cerrar el dialogo
        dispose();
    }
    
    JLabel lbln1,lbln2,lbln3,lbln4,lbl5,lbl6,lbl7,lbl8,lbl9,lbl10,lbl11,
           lblfcha,lblhora,lblfechactual,lblhoraactual;
    JTextField txtnumdocu,txtpasaporte,txtnombres,txtapellidos,
            txtfechsalida,txtfecharetorno;
    JComboBox cbosexo,cbotipodocu,cboorigen,cbodestino;
    JButton Btn_nuevo,Btn_Agregar,Btn_Cancelar,Btn_Buscar,Btn_Eliminar,Btn_Salir,
            Btn_imprimir;
    JTable Tbl_Datos;
    JScrollPane barra;
    DefaultTableModel ModTabla;
        String []titulo={"Tipo doc","N°documento","Pasaporte","Nombres",
            "Apellidos","Sexo","Origen","Destino","Salida","Retorno"};
}
