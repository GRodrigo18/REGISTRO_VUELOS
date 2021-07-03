package VISTA;
import java.awt.Desktop;
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
public class frm_Viajes extends JFrame
{
    
    JButton Btn_Salir,Btn_Registro;
    JLabel lbl_Origen,lbl_Destinos,lbl_Lima,lbl_Amazonas,lbl_Ancash,lbl_Apurimac,
            lbl_Arequipa,lbl_Ayacucho,lbl_Cajamarca,lbl_Callao,lbl_Huancavelica,
            lbl_Tokio,lbl_NewYork,lbl_LosAngeles,lbl_Paris,lbl_Seul,lbl_Londres,
            lbl_Moscu,lbl_Boston,lbl_Barcelona,lbl_Bogota,lblperu;
    JPanel jpanel1,jpanel2;
    
    public frm_Viajes()
    {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    private void initComponents() 
    {   
        setSize(650,500);
        setLayout(null); 
        getContentPane().setLayout(null);
        this.getContentPane().setBackground(new java.awt.Color(58, 83, 155));
         
       //BOTONES
        Btn_Registro=new JButton("Registro");
        Btn_Registro.setBounds(50,400,155,35);
        Btn_Registro.setIcon(new ImageIcon("src\\IMAGENES\\registro.png"));
        Btn_Registro.setFont(new java.awt.Font("Roboto Light", 3, 20));
        Btn_Registro.setBackground(new java.awt.Color(102, 153, 255));
        Btn_Registro.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                registrovuelo();
            }
        });
        add(Btn_Registro);
        
        Btn_Salir=new JButton("Salir");
        Btn_Salir.setBounds(350,400,150,35);
        Btn_Salir.setIcon(new ImageIcon("src\\IMAGENES\\puertasalida.png"));
        Btn_Salir.setFont(new java.awt.Font("Roboto Light", 3, 20));
        Btn_Salir.setBackground(new java.awt.Color(102, 153, 255));
        Btn_Salir.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                dispose();
            }
        });
        add(Btn_Salir);
        
        
        //LABELS
        
        lbl_Origen=new JLabel("Origenes disponibles");
        lbl_Origen.setBounds(50,50,300,35);
        lbl_Origen.setForeground(new java.awt.Color(102, 153, 255));
        lbl_Origen.setFont(new java.awt.Font("Sitka Subheading", 3, 25));
        add(lbl_Origen);
        
        lblperu=new JLabel();
        lblperu.setBounds(150,40,300,300);
        lblperu.setIcon(new ImageIcon("src\\IMAGENES\\peru.png"));
        lblperu.setFont(new java.awt.Font("Roboto Light", 3, 20));
        lblperu.setBackground(new java.awt.Color(102, 153, 255));
        add(lblperu);
        
        lbl_Lima=new JLabel("Lima");
        lbl_Lima.setBounds(50,80,100,30);
        lbl_Lima.setFont(new java.awt.Font("Sitka Subheading", 3, 15));
        lbl_Lima.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_Lima.addMouseListener(new MouseAdapter()  
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
        add(lbl_Lima);
        
        lbl_Amazonas=new JLabel("Amazonas");
        lbl_Amazonas.setBounds(50,110,100,30);
        lbl_Amazonas.setFont(new java.awt.Font("Sitka Subheading", 3, 15));
        lbl_Amazonas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_Amazonas.addMouseListener(new MouseAdapter()  
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
        add(lbl_Amazonas);
        
        lbl_Ancash=new JLabel("Ancash");
        lbl_Ancash.setBounds(50,140,100,30);
        lbl_Ancash.setFont(new java.awt.Font("Sitka Subheading", 3, 15));
        lbl_Ancash.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_Ancash.addMouseListener(new MouseAdapter()  
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
        add(lbl_Ancash);
        
        lbl_Apurimac=new JLabel("Apurimac");
        lbl_Apurimac.setBounds(50,170,100,30);
        lbl_Apurimac.setFont(new java.awt.Font("Sitka Subheading", 3, 15));
        lbl_Apurimac.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_Apurimac.addMouseListener(new MouseAdapter()  
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
        add(lbl_Apurimac);
        
        lbl_Arequipa=new JLabel("Arequipa");
        lbl_Arequipa.setBounds(50,200,100,30);
        lbl_Arequipa.setFont(new java.awt.Font("Sitka Subheading", 3, 15));
        lbl_Arequipa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_Arequipa.addMouseListener(new MouseAdapter()  
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
        add(lbl_Arequipa);
        
        lbl_Ayacucho=new JLabel("Ayacucho");
        lbl_Ayacucho.setBounds(50,230,100,30);
        lbl_Ayacucho.setFont(new java.awt.Font("Sitka Subheading", 3, 15));
        lbl_Ayacucho.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_Ayacucho.addMouseListener(new MouseAdapter()  
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
        add(lbl_Ayacucho);
        
        lbl_Cajamarca=new JLabel("Cajamarca");
        lbl_Cajamarca.setBounds(50,260,100,30);
        lbl_Cajamarca.setFont(new java.awt.Font("Sitka Subheading", 3, 15));
        lbl_Cajamarca.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_Cajamarca.addMouseListener(new MouseAdapter()  
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
        add(lbl_Cajamarca);
        
        lbl_Callao=new JLabel("Callao");
        lbl_Callao.setBounds(50,290,100,30);
        lbl_Callao.setFont(new java.awt.Font("Sitka Subheading", 3, 15));
        lbl_Callao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_Callao.addMouseListener(new MouseAdapter()  
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
        add(lbl_Callao);
        
        lbl_Huancavelica=new JLabel("Huancavelica");
        lbl_Huancavelica.setBounds(50,320,100,30);
        lbl_Huancavelica.setFont(new java.awt.Font("Sitka Subheading", 3, 15));
        lbl_Huancavelica.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_Huancavelica.addMouseListener(new MouseAdapter()  
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
        add(lbl_Huancavelica);
        
        
        
        //DESTINOS
             
        
        lbl_Destinos=new JLabel("Destinos disponibles");
        lbl_Destinos.setBounds(350,50,300,35);
        lbl_Destinos.setForeground(new java.awt.Color(102, 153, 255));
        lbl_Destinos.setFont(new java.awt.Font("Sitka Subheading", 3, 25));  
        add(lbl_Destinos);
        
        lbl_Tokio=new JLabel("Tokio");
        lbl_Tokio.setBounds(350,80,100,30);
        lbl_Tokio.setIcon(new ImageIcon("src\\IMAGENES\\japon.png"));
        lbl_Tokio.setFont(new java.awt.Font("Sitka Subheading", 3, 15));
        lbl_Tokio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_Tokio.addMouseListener(new MouseAdapter()  
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
        add(lbl_Tokio);
     
        lbl_NewYork=new JLabel("New York");
        lbl_NewYork.setBounds(350,110,100,30);
        lbl_NewYork.setIcon(new ImageIcon("src\\IMAGENES\\estados-unidos.png"));
        lbl_NewYork.setFont(new java.awt.Font("Sitka Subheading", 3, 15));
        lbl_NewYork.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_NewYork.addMouseListener(new MouseAdapter()  
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
        add(lbl_NewYork);
        
        lbl_LosAngeles=new JLabel("Los Angeles");
        lbl_LosAngeles.setBounds(350,140,120,30);
        lbl_LosAngeles.setIcon(new ImageIcon("src\\IMAGENES\\estados-unidos.png"));
        lbl_LosAngeles.setFont(new java.awt.Font("Sitka Subheading", 3, 15));
        lbl_LosAngeles.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_LosAngeles.addMouseListener(new MouseAdapter()  
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
        add(lbl_LosAngeles);
        
        lbl_Paris=new JLabel("Paris");
        lbl_Paris.setBounds(350,170,100,30);
        lbl_Paris.setIcon(new ImageIcon("src\\IMAGENES\\francia.png"));
        lbl_Paris.setFont(new java.awt.Font("Sitka Subheading", 3, 15));
        lbl_Paris.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_Paris.addMouseListener(new MouseAdapter()  
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
        add(lbl_Paris);
        
        lbl_Seul=new JLabel("Seul");
        lbl_Seul.setBounds(350,200,100,30);
        lbl_Seul.setIcon(new ImageIcon("src\\IMAGENES\\corea-del-sur.png"));
        lbl_Seul.setFont(new java.awt.Font("Sitka Subheading", 3, 15));
        lbl_Seul.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_Seul.addMouseListener(new MouseAdapter()  
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
        add(lbl_Seul);
        
        lbl_Londres=new JLabel("Londres");
        lbl_Londres.setBounds(350,230,100,30);
        lbl_Londres.setIcon(new ImageIcon("src\\IMAGENES\\inglaterra.png"));
        lbl_Londres.setFont(new java.awt.Font("Sitka Subheading", 3, 15));
        lbl_Londres.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_Londres.addMouseListener(new MouseAdapter()  
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
        add(lbl_Londres);
        
        lbl_Moscu=new JLabel("Moscu");
        lbl_Moscu.setBounds(350,260,100,30);
        lbl_Moscu.setIcon(new ImageIcon("src\\IMAGENES\\rusia.png"));
        lbl_Moscu.setFont(new java.awt.Font("Sitka Subheading", 3, 15));
        lbl_Moscu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_Moscu.addMouseListener(new MouseAdapter()  
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
        add(lbl_Moscu);
        
        lbl_Boston=new JLabel("Boston");
        lbl_Boston.setBounds(350,290,100,30);
        lbl_Boston.setIcon(new ImageIcon("src\\IMAGENES\\estados-unidos.png"));
        lbl_Boston.setFont(new java.awt.Font("Sitka Subheading", 3, 15));
        lbl_Boston.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_Boston.addMouseListener(new MouseAdapter()  
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
        add(lbl_Boston);
        
        lbl_Barcelona=new JLabel("Barcelona");
        lbl_Barcelona.setBounds(350,320,100,30);
        lbl_Barcelona.setIcon(new ImageIcon("src\\IMAGENES\\espana.png"));
        lbl_Barcelona.setFont(new java.awt.Font("Sitka Subheading", 3, 15));
        lbl_Barcelona.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_Barcelona.addMouseListener(new MouseAdapter()  
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
        add(lbl_Barcelona);
        
        lbl_Bogota=new JLabel("Bogota");
        lbl_Bogota.setBounds(350,350,100,30);
        lbl_Bogota.setIcon(new ImageIcon("src\\IMAGENES\\colombia.png"));
        lbl_Bogota.setFont(new java.awt.Font("Sitka Subheading", 3, 15));
        lbl_Bogota.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_Bogota.addMouseListener(new MouseAdapter()  
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
        add(lbl_Bogota);
        
        jpanel1=new JPanel();
        jpanel1.setBackground(new java.awt.Color(228, 241, 254));
        jpanel1.setBounds(340, 50, 270, 325);
        add(jpanel1);
        
        jpanel2=new JPanel();
        jpanel2.setBackground(new java.awt.Color(228, 241, 254));
        jpanel2.setBounds(40, 50, 270, 300);
        add(jpanel2);
    }
    
    
    public static void main(String[] args) 
    {
      frm_Viajes v=new frm_Viajes();
        v.setVisible(true); 
    }
    public void registrovuelo()
    {
        frm_Registro_vuelo rgv=new frm_Registro_vuelo();
        rgv.setVisible(true); 
    }
     
}