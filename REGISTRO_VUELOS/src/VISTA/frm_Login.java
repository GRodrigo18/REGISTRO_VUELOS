 
package VISTA;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class frm_Login extends JFrame implements ActionListener{

    JLabel lbln1,lbln2;
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
        
        lbln1=new JLabel("Ingrese Usuario:");
        lbln1.setBounds(50, 250,250,30);
        lbln1.setFont(new java.awt.Font("Sitka Subheading", 3, 14));
        add(lbln1);
        
        lbln2=new JLabel("Contraseña:");
        lbln2.setBounds(50, 300,200,30);
        lbln2.setFont(new java.awt.Font("Sitka Subheading", 3, 14));
        add(lbln2);
        
        txTUser=new JTextField();
        txTUser.setBounds(170, 250, 150, 30);
        txTUser.setFont(new java.awt.Font("Sitka Subheading", 3, 14));
        add(txTUser);
        
        txtContra=new JPasswordField();
        txtContra.setBounds(170, 300, 150, 30);
        txtContra.setFont(new java.awt.Font("Sitka Subheading", 3, 14));
        add(txtContra);
        
        btnIngresar=new JButton("Ingresar");
        btnIngresar.setFont(new java.awt.Font("Sitka Subheading", 3, 18));
        btnIngresar.setBounds(50, 360, 150, 30);
        btnIngresar.addActionListener(this);
        add(btnIngresar);
        
        btnSalir=new JButton("Salir");
        btnSalir.setFont(new java.awt.Font("Sitka Subheading", 3, 18));
        btnSalir.setBounds(220, 360, 100, 30);
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
            frm_Registro_vuelo pn = new frm_Registro_vuelo();
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
