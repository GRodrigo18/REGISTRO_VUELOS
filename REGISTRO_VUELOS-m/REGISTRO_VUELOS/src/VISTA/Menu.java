 
package VISTA;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.*;
public class Menu extends JFrame implements ActionListener{

    JPanel jpanel1,Jpanel2;
    JLabel lbln1;
    JButton btnregistrovuelo,btnEquipaje,btnsalir,btnminimizar;
    
        
    public Menu(){
        initComponents();
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        setUndecorated(true);
    }
    public void initComponents(){  
        
        setSize(800,600);
        setTitle("REGISTRO DE VUELOS");
        setLayout(null); 
        
        lbln1=new JLabel("Menú Principal");
        lbln1.setFont(new java.awt.Font("Sitka Subheading", 1, 30)); // NOI18N
        lbln1.setForeground(new java.awt.Color(0, 0, 0));
        lbln1.setBounds(10,4,400,60);
        add(lbln1);
        
        btnregistrovuelo=new JButton("Registro");
        btnregistrovuelo.setBounds(50, 150, 200,200);
        btnregistrovuelo.setBackground(new java.awt.Color(102, 153, 255));
        btnregistrovuelo.setIcon(new ImageIcon("src\\IMAGENES\\registro.png"));
        btnregistrovuelo.setFont(new java.awt.Font("Roboto Light", 3, 18));
        add(btnregistrovuelo);
        
        btnEquipaje=new JButton("Equipaje");
        btnEquipaje.setBounds(300, 150, 200,200);
        btnEquipaje.setBackground(new java.awt.Color(102, 153, 255));
        btnEquipaje.setIcon(new ImageIcon("src\\IMAGENES\\registro.png"));
        btnEquipaje.setFont(new java.awt.Font("Roboto Light", 3, 18));
        btnEquipaje.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Equipaje();
            }
        }
        );
        add(btnEquipaje);
        
        btnminimizar=new JButton();
        btnminimizar.setOpaque(false);
        btnminimizar.setContentAreaFilled(false);
        btnminimizar.setBorderPainted(false);
        btnminimizar.setIcon(new ImageIcon("src\\IMAGENES\\minimi.png"));
        btnminimizar.setBounds(650, 3, 62, 61);
        btnminimizar.addActionListener(this);
        btnminimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnminimizarMouseClicked(evt);
            }
            private void btnminimizarMouseClicked(MouseEvent evt) {
                this.setState(JFrame.ICONIFIED);
            }
            private void setState(int ICONIFIED) {
                setExtendedState(WIDTH);
            }
        });
        add(btnminimizar);
        
        btnsalir=new JButton();
        btnsalir.setOpaque(false);
        btnsalir.setContentAreaFilled(false);
        btnsalir.setBorderPainted(false);
        btnsalir.setIcon(new ImageIcon("src\\IMAGENES\\cerrar.png"));
        btnsalir.setBounds(725, 3, 62, 61);
        btnsalir.addActionListener(this);
        add(btnsalir);
         
        jpanel1=new JPanel();
        jpanel1.setBackground(new java.awt.Color(82, 179, 217));
        jpanel1.setBounds(0, 0, 800, 70);
        add(jpanel1);
        
        Jpanel2=new JPanel();
        Jpanel2.setBackground(new java.awt.Color(58, 83, 155));
        Jpanel2.setBounds(0, 60, 800, 800);
        add(Jpanel2);
         
    }
    public static void main(String[] args) {
         Menu principal = new Menu();
              principal.setVisible(true);
    }
    
    
    public void Salir()
    {
        this.dispose();
    }
    public void registrovuelo()
    {
        frm_Registro_vuelo rgv=new frm_Registro_vuelo();
        rgv.setVisible(true);
    }
    public void Equipaje()
    {
        frm_Maleta eq=new frm_Maleta();
        eq.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
          if (e.getSource()== btnregistrovuelo)
         {
             registrovuelo();
         }
         if (e.getSource()== btnsalir)
         {
             Salir();
         }

    }
}
