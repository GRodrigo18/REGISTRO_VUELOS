package Biblioteca;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MenuA extends JFrame {

    JMenuBar barra;
    JMenu archivo, mantenimiento;   
    JMenuItem salir, contactos;
    
    public MenuA(){
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public void initComponents(){  
        
        setSize(450,320);
        setTitle("LIBRETA DE CONTACTOS");
        setLayout(null); 
        
        barra=new JMenuBar();
        
        archivo=new JMenu(); 
        mantenimiento=new JMenu();
        
        salir=new JMenuItem();  
        contactos=new JMenuItem();
          
        archivo.setText(" Archivo ");
        
        salir.setText("Salir");
        salir.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e)
                {
                    salir();
                }
        });
        add(salir);       
        
        mantenimiento.setText(" Mantenimiento ");
        
        contactos.setText("Contactos");
        contactos.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e)
                {
                  archivo();
                }
        });
        add(contactos); 
        
        archivo.add(salir);
        mantenimiento.add(contactos);
        
        barra.add(archivo);
        barra.add(mantenimiento);
        setJMenuBar(barra);    
    }
    public static void main(String[] args) {
        MenuA principal = new MenuA();
              principal.setVisible(true);
    }
     public void salir()
     {
         dispose();
     }
    public void archivo(){
       FrmArbol principalA=new FrmArbol();
                principalA.setLocationRelativeTo(null);
                principalA.setVisible(true);
    }
}
