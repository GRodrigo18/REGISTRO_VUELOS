 
package VISTA;
import javax.swing.JFrame;
public class frm_Registrousuario extends JFrame{
   
    public frm_Registrousuario()
    {
        iniComponets();
        this.setLocationRelativeTo(null);
    }
    
     public void iniComponets()
    {
        setSize(400, 500);
        setTitle("Login");
        setLayout(null);
        
    }
     public static void main(String[] args) {
        frm_Registrousuario ventana=new frm_Registrousuario();
                    ventana.setVisible(true);
    }
  
}
