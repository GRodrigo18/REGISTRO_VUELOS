 
package VISTA;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.*;
public class frm_Login extends JFrame implements ActionListener{
    
    JPanel jpanel1,Jpanel2;
    JLabel lbln1,lbln2,lbln3,lbln4,lbln5;
    JTextField txTUser;
    JButton btnIngresar,btncancelar,btnsalir,btnminimizar;
    JPasswordField txtContra;
    
    public frm_Login()
    {
        iniComponets();
        this.setLocationRelativeTo(null);
    }
    public void iniComponets()
    {
        setSize(400, 510);
        setTitle("Login");
        getContentPane().setLayout(null);
        setUndecorated(true);
        this.getContentPane().setBackground(new java.awt.Color(210, 77, 87));
        
        
        //todos los label
        lbln1=new JLabel("Ingrese Usuario:");
        lbln1.setBounds(45, 260,250,30);
        lbln1.setForeground(new java.awt.Color(255, 255, 255));
        lbln1.setFont(new java.awt.Font("Sitka Subheading", 3, 18));
        add(lbln1);
        
        lbln2=new JLabel("Contraseña:");
        lbln2.setBounds(80, 310,200,30);
        lbln2.setForeground(new java.awt.Color(255, 255, 255));
        lbln2.setFont(new java.awt.Font("Sitka Subheading", 3, 18));
        add(lbln2);
        
        lbln3=new JLabel();
        lbln3.setIcon(new ImageIcon("src\\IMAGENES\\avion.png"));
        lbln3.setBounds(125, 21, 300, 300);
        add(lbln3);
        
        lbln4=new JLabel("Login Usuarios");
        lbln4.setFont(new java.awt.Font("Sitka Subheading", 1, 30)); // NOI18N
        lbln4.setForeground(new java.awt.Color(0, 0, 0));
        lbln4.setBounds(10,4,400,60);
        add(lbln4);
        
        lbln5=new JLabel("Crear una nueva cuenta");
        lbln5.setFont(new java.awt.Font("Sitka Subheading", 1, 16)); // NOI18N
        lbln5.setForeground(new java.awt.Color(255, 255, 255));
        lbln5.setBounds(125,410,400,60);
        lbln5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbln5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbln5MouseClicked(evt);
            }
            private void lbln5MouseClicked(MouseEvent evt) {
                frm_Registrousuario rgf=new frm_Registrousuario();
                rgf.setVisible(true);
            }
        });
        add(lbln5);
        
        
         //Todas las cajas de texto
        txTUser=new JTextField();
        txTUser.setBounds(190, 260, 150, 30);
        txTUser.addKeyListener(new java.awt.event.KeyAdapter() {
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
        txTUser.setFont(new java.awt.Font("Sitka Subheading", 3, 15));
        txTUser.setBackground(new java.awt.Color(108, 122, 137));
        add(txTUser);
       
        txtContra=new JPasswordField();
        txtContra.setBounds(190, 310, 150, 30);
        txtContra.setFont(new java.awt.Font("Sitka Subheading", 3, 15));
        txtContra.setBackground(new java.awt.Color(108, 122, 137));
        add(txtContra);
        
        
        //Todos los botones
        btnIngresar=new JButton("Ingresar");
        btnIngresar.setFont(new java.awt.Font("Sitka Subheading", 1, 18));
        btnIngresar.setBounds(210, 370, 130, 35);
        btnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresar.setBackground(new java.awt.Color(34, 167, 240));
        btnIngresar.addActionListener(this);
        add(btnIngresar);
        
        btncancelar=new JButton("Cancelar");
        btncancelar.setFont(new java.awt.Font("Sitka Subheading", 3, 18));
        btncancelar.setBounds(60, 370, 130, 35);
        btncancelar.setForeground(new java.awt.Color(255, 255, 255));
        btncancelar.setBackground(new java.awt.Color(192, 57, 43));
        btncancelar.addActionListener(this);
        add(btncancelar);
        
        btnminimizar=new JButton();
        btnminimizar.setOpaque(false);
        btnminimizar.setContentAreaFilled(false);
        btnminimizar.setBorderPainted(false);
        btnminimizar.setIcon(new ImageIcon("src\\IMAGENES\\minimi.png"));
        btnminimizar.setBounds(270, 3, 62, 61);
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
        btnsalir.setBounds(330, 3, 62, 61);
        btnsalir.addActionListener(this);
        add(btnsalir);
        
        jpanel1=new JPanel();
        jpanel1.setBackground(new java.awt.Color(82, 179, 217));
        jpanel1.setBounds(0, 0, 500, 70);
        add(jpanel1);
        
        Jpanel2=new JPanel();
        Jpanel2.setBackground(new java.awt.Color(58, 83, 155));
        Jpanel2.setBounds(0, 60, 500, 500);
        add(Jpanel2);
    }
    public static void main(String[] args) {
       frm_Login ventana=new frm_Login();
                    ventana.setVisible(true);
    }
    //Metodos 
     public void Salir()
    {
        this.dispose();
    }
    public void Ingresar()
    {
        String Usuario = "admin";
        String Contraseña = "1234";
        
        String Pass = new String(txtContra.getPassword());
        if(txTUser.getText().equals(Usuario)&& Pass.equals(Contraseña)){
            Menu pn = new Menu();
            pn.setVisible(true);
            dispose();
        }
        else{
            JOptionPane.showMessageDialog(null, "Usuario y contraseña incorrecto");
        } 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
          if (e.getSource()== btnIngresar)
         {
             Ingresar();
         }
         if (e.getSource()== btnsalir)
         {
             Salir();
         }
         if (e.getSource()== btncancelar)
         {
             Salir();
         }
    }

}
