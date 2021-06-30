package MODELO;
public class ClienteM 
{
    private String Apellidos;
    private String Nombres;
    private String DNI;
    private String Equipaje;
    private String Precio;
    
    public ClienteM(Object[] Registro)
    {
        this.Apellidos=Registro[0].toString();
        this.Nombres=Registro[1].toString();
        this.DNI=Registro[2].toString();
        this.Equipaje=Registro[3].toString();
        this.Precio=Registro[4].toString();
    }
   
    public Object[] getRegistro()
    {
        Object[] Registro={Apellidos,Nombres,DNI,Equipaje,Precio};
        return Registro;
    }
    
    public String getNomCompleto()
    {
        return Apellidos+"  "+Nombres;
    }
    
    public String getApellidos()
    {
        return Apellidos;
    }
    
    public void setApellidos(String Apellidos)
    {
        this.Apellidos=Apellidos;
    }
    
    public String getNombres()
    {
        return Nombres;
    }
    
    public void setNombres(String Nombres)
    {
        this.Nombres=Nombres;
    }

    public String getDNI() 
    {
        return DNI;
    }

    public void setDNI(String DNI) 
    {
        this.DNI = DNI;
    }
    
    public String getEquipaje() 
    {
        return Equipaje;
    }

    public void setEquipaje(String Equipaje) 
    {
        this.Equipaje = Equipaje;
    }
    
    public String getPrecio() 
    {
        return Precio;
    }

    public void setPrecio(String Precio) 
    {
        this.Precio = Precio;
    }
}