 
package VISTA;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class frm_Login extends JFrame implements ActionListener{
    
    JPanel jpanel1,Jpanel2;
    JLabel lbln1,lbln2,lbln3,lbln4;
    JTextField txTUser;
    JButton btnIngresar,btnSalir;
    JPasswordField txtContra;
    
    public frm_Login()
    {
        iniComponets();
        this.setLocationRelativeTo(null);
    }
    public void iniComponets()
    {
        setSize(400, 500);
        setTitle("Login");
        getContentPane().setLayout(null);
        setUndecorated(true);
        this.getContentPane().setBackground(new java.awt.Color(160, 174, 175));
        
        lbln1=new JLabel("Ingrese Usuario:");
        lbln1.setBounds(50, 250,250,30);
        lbln1.setFont(new java.awt.Font("Sitka Subheading", 3, 17));
        add(lbln1);
        
        lbln2=new JLabel("Contraseña:");
        lbln2.setBounds(50, 300,200,30);
        lbln2.setFont(new java.awt.Font("Sitka Subheading", 3, 17));
        add(lbln2);
        
        lbln3=new JLabel();
        lbln3.setIcon(new ImageIcon("C:\\Users\\bgrad\\OneDrive\\Documentos\\NETBEANS\\REGISTRO_VUELOS\\REGISTRO_VUELOS\\src\\IMAGENES\\avion.png"));
        lbln3.setBounds(125, -20, 300, 300);
        add(lbln3);
        
        lbln4=new JLabel("Login Usuarios");
        lbln4.setFont(new java.awt.Font("Sitka Subheading", 0, 24)); // NOI18N
        lbln4.setForeground(new java.awt.Color(255, 255, 255));
        lbln4.setBounds(5,0,400,60);
        add(lbln4);
        
        txTUser=new JTextField();
        txTUser.setBounds(190, 250, 150, 30);
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
        txTUser.setFont(new java.awt.Font("Sitka Subheading", 3, 16));
        add(txTUser);
        
        txtContra=new JPasswordField();
        txtContra.setBounds(190, 300, 150, 30);
        txtContra.setFont(new java.awt.Font("Sitka Subheading", 3, 16));
        add(txtContra);
        
        btnIngresar=new JButton("Ingresar");
        btnIngresar.setFont(new java.awt.Font("Sitka Subheading", 3, 18));
        btnIngresar.setBounds(120, 370, 150, 30);
        btnIngresar.setBorder(null);
        btnIngresar.addActionListener(this);
        add(btnIngresar);
        
        btnSalir=new JButton("Salir");
        btnSalir.setFont(new java.awt.Font("Sitka Subheading", 3, 18));
        btnSalir.setBounds(270, 420, 100, 30);
        btnSalir.addActionListener(this);
        add(btnSalir);
        
        jpanel1=new JPanel();
        jpanel1.setBackground(new java.awt.Color(248, 148, 6));
        jpanel1.setBounds(0, 0, 400, 60);
        add(jpanel1);
        
        Jpanel2=new JPanel();
        Jpanel2.setBackground(new java.awt.Color(44, 62, 80));
        Jpanel2.setBounds(0, 60, 400, 500);
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
         if (e.getSource()== btnSalir)
         {
             Salir();
         }
    }

}
