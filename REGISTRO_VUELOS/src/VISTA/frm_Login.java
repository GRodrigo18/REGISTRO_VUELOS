 
package VISTA;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class frm_Login extends JFrame implements ActionListener{

    JLabel lbln1,lbln2,lbln3;
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
        setLayout(null);
        this.getContentPane().setBackground(new java.awt.Color(160, 174, 175));
        
        lbln1=new JLabel("Ingrese Usuario:");
        lbln1.setBounds(50, 270,250,30);
        lbln1.setFont(new java.awt.Font("Sitka Subheading", 3, 17));
        add(lbln1);
        
        lbln2=new JLabel("Contraseña:");
        lbln2.setBounds(50, 320,200,30);
        lbln2.setFont(new java.awt.Font("Sitka Subheading", 3, 17));
        add(lbln2);
        
        lbln3=new JLabel();
        lbln3.setIcon(new ImageIcon("C:\\Users\\bgrad\\OneDrive\\Documentos\\NETBEANS\\REGISTRO_VUELOS\\REGISTRO_VUELOS\\src\\IMAGENES\\avion.png"));
        lbln3.setBounds(0, -20, 300, 300);
        add(lbln3);
        
        txTUser=new JTextField();
        txTUser.setBounds(190, 270, 150, 30);
        txTUser.setFont(new java.awt.Font("Sitka Subheading", 3, 16));
        add(txTUser);
        
        txtContra=new JPasswordField();
        txtContra.setBounds(190, 320, 150, 30);
        txtContra.setFont(new java.awt.Font("Sitka Subheading", 3, 16));
        add(txtContra);
        
        btnIngresar=new JButton("Ingresar");
        btnIngresar.setFont(new java.awt.Font("Sitka Subheading", 3, 18));
        btnIngresar.setBounds(120, 370, 150, 30);
        btnIngresar.addActionListener(this);
        add(btnIngresar);
        
        btnSalir=new JButton("Salir");
        btnSalir.setFont(new java.awt.Font("Sitka Subheading", 3, 18));
        btnSalir.setBounds(270, 420, 100, 30);
        btnSalir.addActionListener(this);
        add(btnSalir);
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
