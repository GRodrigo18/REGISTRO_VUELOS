 
package VISTA;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Menu extends JFrame{
    JMenuBar barra;
    JMenu archivo, mantenimiento;   
    JMenuItem salir, Boleta, registro;
    
    public Menu(){
        initComponents();
        setLocationRelativeTo(null);
    }
    public void initComponents(){  
        
        setSize(450,320);
        setTitle("REGISTRO DE VUELOS");
        setLayout(null); 
        
        barra=new JMenuBar();
        
        archivo=new JMenu(); 
        mantenimiento=new JMenu();
        
        salir=new JMenuItem();  
        Boleta=new JMenuItem();
        registro=new JMenuItem();
          
        archivo.setText(" ARCHIVO ");
        
        salir.setText("Salir");
        salir.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e)
                {
                    salir();
                }
        });
        add(salir);       
        
        mantenimiento.setText(" MANTENIMIENTO ");
        
        Boleta.setText("Boleta");
        Boleta.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e)
                {
                  archivo();
                }
        });
        add(Boleta); 
            
        registro.setText("Registro");
        registro.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e)
                {
                  mantem();
                }
        });
        add(registro); 
        
        archivo.add(salir);
        mantenimiento.add(registro);
        mantenimiento.add(Boleta);
        
        barra.add(archivo);
        barra.add(mantenimiento);
        setJMenuBar(barra);    
    }
    public static void main(String[] args) {
         Menu principal = new Menu();
              principal.setVisible(true);
    }
    public void salir()
     {
         dispose();
     }
    public void mantem(){
       frm_Registro_vuelo principalA=new frm_Registro_vuelo();
                principalA.setLocationRelativeTo(null);
                principalA.setVisible(true);
    }
      
    public void archivo(){
       frm_Boleta principalL=new frm_Boleta();
              principalL.setLocationRelativeTo(null);
              principalL.setVisible(true);
    }
}