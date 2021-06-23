 
package VISTA;
import javax.swing.*;
public class frm_Registro extends JFrame{

    public frm_Registro()
    {
        iniComponets();
        this.setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        frm_Registro ventana=new frm_Registro();
                    ventana.setVisible(true);
    }
     public void iniComponets()
    {
        setSize(350, 450);
        setTitle("Registro");
        //getContentPane().setLayout(null);
        //setUndecorated(true);
    }
}
