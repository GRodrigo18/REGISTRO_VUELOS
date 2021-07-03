package VISTA;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
public class frm_Viajes extends JPanel
{
    
    JButton Btn_Salir,Btn_Registro;
    JLabel lbl_Origen,lbl_Destinos;
    
    public frm_Viajes()
    {
        initComponents();
        setLayout(null);
        
    }
    
    private void initComponents() 
    {   
        
        this.setBackground(new java.awt.Color(58, 83, 155));
        
       //BOTONES
        Btn_Registro=new JButton("Registro");
        Btn_Registro.setBounds(200,450,150,35);
        Btn_Registro.setIcon(new ImageIcon("src\\IMAGENES\\registro.png"));
        Btn_Registro.setFont(new java.awt.Font("Roboto Light", 3, 20));
        Btn_Registro.setBackground(new java.awt.Color(102, 153, 255));
        Btn_Registro.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                RegistroVuelo();
            }
        });
        add(Btn_Registro);
        
        Btn_Salir=new JButton("Salir");
        Btn_Salir.setBounds(600,450,150,35);
        Btn_Salir.setIcon(new ImageIcon("src\\IMAGENES\\puertasalida.png"));
        Btn_Salir.setFont(new java.awt.Font("Roboto Light", 3, 20));
        Btn_Salir.setBackground(new java.awt.Color(102, 153, 255));
        Btn_Salir.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                Window w = SwingUtilities.getWindowAncestor(frm_Viajes.this);
                w.setVisible(false);
            }
        });
        add(Btn_Salir);
        
        
        //LABELS
        
        lbl_Origen=new JLabel("Origen de viajes disponibles");
        lbl_Origen.setBounds(200,100,250,30);
        lbl_Origen.setForeground(new java.awt.Color(204, 255, 255));
        lbl_Origen.setFont(new java.awt.Font("Sitka Subheading", 3, 17));
        add(lbl_Origen);
        
        
        lbl_Origen=new JLabel("Lima");
        lbl_Origen.setBounds(200,120,100,30);
        lbl_Origen.setIcon(new ImageIcon("src\\IMAGENES\\puertasalida.png"));
        lbl_Origen.setFont(new java.awt.Font("Sitka Subheading", 3, 13));
        lbl_Origen.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {  
        try 
                {

                Desktop.getDesktop().browse(new URI("https://www.munlima.gob.pe/"));

                } 
                catch (URISyntaxException ex) 
                {

                 System.out.println(ex);

                }
                catch(IOException ex){

                System.out.println(e);

        }

            }  
        }); 
        add(lbl_Origen);
        
        lbl_Origen=new JLabel("Amazonas");
        lbl_Origen.setBounds(200,140,100,30);
        lbl_Origen.setFont(new java.awt.Font("Sitka Subheading", 3, 13));
        lbl_Origen.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {  
        try 
                {

                Desktop.getDesktop().browse(new URI("http://www.regionamazonas.gob.pe/sisadport/portal/index.html#/home"));

                } 
                catch (URISyntaxException ex) 
                {

                 System.out.println(ex);

                }
                catch(IOException ex){

                System.out.println(e);

        }

            }  
        }); 
        add(lbl_Origen);
        
        lbl_Origen=new JLabel("Ancash");
        lbl_Origen.setBounds(200,160,100,30);
        lbl_Origen.setFont(new java.awt.Font("Sitka Subheading", 3, 13));
        lbl_Origen.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {  
        try 
                {

                Desktop.getDesktop().browse(new URI("https://www.regionancash.gob.pe/"));

                } 
                catch (URISyntaxException ex) 
                {

                 System.out.println(ex);

                }
                catch(IOException ex){

                System.out.println(e);

        }

            }  
        }); 
        add(lbl_Origen);
        
        lbl_Origen=new JLabel("Apurimac");
        lbl_Origen.setBounds(200,180,100,30);
        lbl_Origen.setFont(new java.awt.Font("Sitka Subheading", 3, 13));
        lbl_Origen.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {  
        try 
                {

                Desktop.getDesktop().browse(new URI("http://www.regionapurimac.gob.pe/"));

                } 
                catch (URISyntaxException ex) 
                {

                 System.out.println(ex);

                }
                catch(IOException ex){

                System.out.println(e);

        }

            }  
        }); 
        add(lbl_Origen);
        
        lbl_Origen=new JLabel("Arequipa");
        lbl_Origen.setBounds(200,200,100,30);
        lbl_Origen.setFont(new java.awt.Font("Sitka Subheading", 3, 13));
        lbl_Origen.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {  
        try 
                {

                Desktop.getDesktop().browse(new URI("https://www.regionarequipa.gob.pe/"));

                } 
                catch (URISyntaxException ex) 
                {

                 System.out.println(ex);

                }
                catch(IOException ex){

                System.out.println(e);

        }

            }  
        }); 
        add(lbl_Origen);
        
        lbl_Origen=new JLabel("Ayacucho");
        lbl_Origen.setBounds(200,220,100,30);
        lbl_Origen.setFont(new java.awt.Font("Sitka Subheading", 3, 13));
        lbl_Origen.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {  
        try 
                {

                Desktop.getDesktop().browse(new URI("https://www.regionayacucho.gob.pe/index.php?option=com_content&view=article&id=132"));

                } 
                catch (URISyntaxException ex) 
                {

                 System.out.println(ex);

                }
                catch(IOException ex){

                System.out.println(e);

        }

            }  
        }); 
        add(lbl_Origen);
        
        lbl_Origen=new JLabel("Cajamarca");
        lbl_Origen.setBounds(200,240,100,30);
        lbl_Origen.setFont(new java.awt.Font("Sitka Subheading", 3, 13));
        lbl_Origen.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {  
        try 
                {

                Desktop.getDesktop().browse(new URI("https://www.regioncajamarca.gob.pe/"));

                } 
                catch (URISyntaxException ex) 
                {

                 System.out.println(ex);

                }
                catch(IOException ex){

                System.out.println(e);

        }

            }  
        }); 
        add(lbl_Origen);
        
        lbl_Origen=new JLabel("Callao");
        lbl_Origen.setBounds(200,260,100,30);
        lbl_Origen.setFont(new java.awt.Font("Sitka Subheading", 3, 13));
        lbl_Origen.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {  
        try 
                {

                Desktop.getDesktop().browse(new URI("https://www.municallao.gob.pe/"));

                } 
                catch (URISyntaxException ex) 
                {

                 System.out.println(ex);

                }
                catch(IOException ex){

                System.out.println(e);

        }

            }  
        }); 
        add(lbl_Origen);
        
        lbl_Origen=new JLabel("Huancavelica");
        lbl_Origen.setBounds(200,280,100,30);
        lbl_Origen.setFont(new java.awt.Font("Sitka Subheading", 3, 13));
        lbl_Origen.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {  
        try 
                {

                Desktop.getDesktop().browse(new URI("https://www.regionhuancavelica.gob.pe/"));

                } 
                catch (URISyntaxException ex) 
                {

                 System.out.println(ex);

                }
                catch(IOException ex){

                System.out.println(e);

        }

            }  
        }); 
        add(lbl_Origen);
        
        
        
        //DESTINOS
             
        
        lbl_Destinos=new JLabel("Destinos disponibles");
        lbl_Destinos.setBounds(600,100,250,30);
        lbl_Destinos.setForeground(new java.awt.Color(204, 255, 255));
        lbl_Destinos.setFont(new java.awt.Font("Sitka Subheading", 3, 17));        
        add(lbl_Destinos);
        
        lbl_Destinos=new JLabel("Tokio");
        lbl_Destinos.setBounds(600,120,100,30);
        lbl_Destinos.setFont(new java.awt.Font("Sitka Subheading", 3, 13));
        lbl_Destinos.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {  
        try 
                {

                Desktop.getDesktop().browse(new URI("https://www.gotokyo.org/es/index.html"));

                } 
                catch (URISyntaxException ex) 
                {

                 System.out.println(ex);

                }
                catch(IOException ex){

                System.out.println(e);

        }

            }  
        }); 
        add(lbl_Destinos);
     
        lbl_Destinos=new JLabel("New York");
        lbl_Destinos.setBounds(600,140,100,30);
        lbl_Destinos.setFont(new java.awt.Font("Sitka Subheading", 3, 13));
        lbl_Destinos.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {  
        try 
                {

                Desktop.getDesktop().browse(new URI("https://www1.nyc.gov/"));

                } 
                catch (URISyntaxException ex) 
                {

                 System.out.println(ex);

                }
                catch(IOException ex){

                System.out.println(e);

        }

            }  
        }); 
        add(lbl_Destinos);
        
        lbl_Destinos=new JLabel("Los Angeles");
        lbl_Destinos.setBounds(600,160,100,30);
        lbl_Destinos.setFont(new java.awt.Font("Sitka Subheading", 3, 13));
        lbl_Destinos.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {  
        try 
                {

                Desktop.getDesktop().browse(new URI("https://www.lacity.org/"));

                } 
                catch (URISyntaxException ex) 
                {

                 System.out.println(ex);

                }
                catch(IOException ex){

                System.out.println(e);

        }

            }  
        }); 
        add(lbl_Destinos);
        
        lbl_Destinos=new JLabel("Paris");
        lbl_Destinos.setBounds(600,180,100,30);
        lbl_Destinos.setFont(new java.awt.Font("Sitka Subheading", 3, 13));
        lbl_Destinos.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {  
        try 
                {

                Desktop.getDesktop().browse(new URI("http://www.paris.fr/"));

                } 
                catch (URISyntaxException ex) 
                {

                 System.out.println(ex);

                }
                catch(IOException ex){

                System.out.println(e);

        }

            }  
        }); 
        add(lbl_Destinos);
        
        lbl_Destinos=new JLabel("Seul");
        lbl_Destinos.setBounds(600,200,100,30);
        lbl_Destinos.setFont(new java.awt.Font("Sitka Subheading", 3, 13));
        lbl_Destinos.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {  
        try 
                {

                Desktop.getDesktop().browse(new URI("http://world.seoul.go.kr/"));

                } 
                catch (URISyntaxException ex) 
                {

                 System.out.println(ex);

                }
                catch(IOException ex){

                System.out.println(e);

        }

            }  
        }); 
        add(lbl_Destinos);
        
        lbl_Destinos=new JLabel("Londres");
        lbl_Destinos.setBounds(600,220,100,30);
        lbl_Destinos.setFont(new java.awt.Font("Sitka Subheading", 3, 13));
        lbl_Destinos.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {  
        try 
                {

                Desktop.getDesktop().browse(new URI("https://www.london.gov.uk/"));

                } 
                catch (URISyntaxException ex) 
                {

                 System.out.println(ex);

                }
                catch(IOException ex){

                System.out.println(e);

        }

            }  
        }); 
        add(lbl_Destinos);
        
        lbl_Destinos=new JLabel("Moscu");
        lbl_Destinos.setBounds(600,240,100,30);
        lbl_Destinos.setFont(new java.awt.Font("Sitka Subheading", 3, 13));
        lbl_Destinos.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {  
        try 
                {

                Desktop.getDesktop().browse(new URI("http://www.mos.ru/"));

                } 
                catch (URISyntaxException ex) 
                {

                 System.out.println(ex);

                }
                catch(IOException ex){

                System.out.println(e);

        }

            }  
        }); 
        add(lbl_Destinos);
        
        lbl_Destinos=new JLabel("Boston");
        lbl_Destinos.setBounds(600,260,100,30);
        lbl_Destinos.setFont(new java.awt.Font("Sitka Subheading", 3, 13));
        lbl_Destinos.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {  
        try 
                {

                Desktop.getDesktop().browse(new URI("http://www.cityofboston.gov/"));

                } 
                catch (URISyntaxException ex) 
                {

                 System.out.println(ex);

                }
                catch(IOException ex){

                System.out.println(e);

        }

            }  
        }); 
        add(lbl_Destinos);
        
        lbl_Destinos=new JLabel("Barcelona");
        lbl_Destinos.setBounds(600,280,100,30);
        lbl_Destinos.setFont(new java.awt.Font("Sitka Subheading", 3, 13));
        lbl_Destinos.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {  
        try 
                {

                Desktop.getDesktop().browse(new URI("https://www.barcelona.cat/es/"));

                } 
                catch (URISyntaxException ex) 
                {

                 System.out.println(ex);

                }
                catch(IOException ex){

                System.out.println(e);

        }

            }  
        }); 
        add(lbl_Destinos);
        
        lbl_Destinos=new JLabel("Bogota");
        lbl_Destinos.setBounds(600,300,100,30);
        lbl_Destinos.setFont(new java.awt.Font("Sitka Subheading", 3, 13));
        lbl_Destinos.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {  
        try 
                {

                Desktop.getDesktop().browse(new URI("http://www.bogota.gov.co/"));

                } 
                catch (URISyntaxException ex) 
                {

                 System.out.println(ex);

                }
                catch(IOException ex){

                System.out.println(e);

        }

            }  
        }); 
        add(lbl_Destinos);
        
    }
    
    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g); 
        
        //ORIGEN
        g.drawRoundRect(180,75,250,270,25,25); 
        
        //DESTINO
        g.drawRoundRect(580,75,250,270,25,25); 
    }
    
    public static void main(String[] args) 
    {
        JFrame frame=new JFrame();
        frame.setSize(900,600);
        
        
        frm_Viajes panel=new frm_Viajes();
        frame.add(panel);
        
        
        frame.setVisible(true);  
    }
    
    public void RegistroVuelo()
    {
        frm_Registro_vuelo rgv=new frm_Registro_vuelo();
        rgv.setVisible(true);
    }
}