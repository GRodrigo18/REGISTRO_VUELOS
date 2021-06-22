 
package Modelo;
 
public class Cliente 
{
   private String Apellidos;
   private String Nombres;
   private String Telefono;
   
   public Cliente(Object[] Registro)
   {
       this.Apellidos=Registro[0].toString();
       this.Nombres=Registro[1].toString();
       this.Telefono=Registro[2].toString();
   }
   
   public Object[] getRegistro()
   {
       Object[]Registro={Apellidos, Nombres, Telefono};
       return Registro;
   }
   
   public String getNombreCompleto() 
   {
       return Apellidos + " " + Nombres;
   }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }
   
   
   
}

