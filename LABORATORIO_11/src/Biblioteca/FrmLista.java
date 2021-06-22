package Biblioteca;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FrmLista extends JFrame {
    
    public FrmLista()
    {
        initComponents();
        setLocationRelativeTo(null);
        modelo=(DefaultTableModel)tabla.getModel();
    }

    public void initComponents(){
        setSize(440,320);
        setLayout(null);
        setTitle("CONTACTOS REGISTRADOS");
        
        btnCerrar = new JButton("CERRAR");
        btnCerrar.setBounds(300, 230, 100, 30);
        btnCerrar.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
                {
                   cerrar();
                }
        });
        add(btnCerrar);
        
        tabla = new JTable();
        barra = new JScrollPane();
        modelo = new DefaultTableModel(null,titulo);
        tabla.setModel(modelo);
        
        barra.setViewportView(tabla);
        tabla.setModel(modelo); 
        
        barra=new JScrollPane();
        barra.setBounds(30,70,600,200);
        modelo=new DefaultTableModel(null,titulo);
        add(barra); 
        
        barra.setViewportView(tabla);
        barra.setBounds(10,20,400,200);
        add(barra);
    }
    public void cerrar()
    {
        dispose();
    }
     public static void main(String[] args) {
         FrmLista ventana=new FrmLista();
            ventana.setVisible(true);
    }
    JButton btnCerrar;
    JTable tabla;
    JScrollPane barra;
    public static  DefaultTableModel modelo;
    String titulo[]= {"CODIGO","APELLIDOS","NOMBRES"};
}
