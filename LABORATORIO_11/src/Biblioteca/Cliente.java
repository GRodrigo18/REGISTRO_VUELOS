package Biblioteca;

public class Cliente {
    private String Codigo;
    private String Apellidos;
    private String Nombres;
    
    public Cliente(Object[] Registro)
    {
        this.Codigo = Registro[0].toString();
        this.Apellidos = Registro[1].toString();
        this.Nombres = Registro[2].toString();
    }
    
    public Object[] getRegistro()
    {
        Object[] Registro = {Codigo,Apellidos,Nombres};
        return Registro;
    }
    
    public String getNomCompleto() {return Apellidos + " " + Nombres;};
    
    public String getCodigo() {return Codigo;}
    public void setCodigo(String Codigo) {this.Codigo = Codigo;}
    
    public String getApellidos() {return Apellidos;}
    public void setApellidos(String Apellidos) {this.Apellidos = Apellidos;}
    
    public String getNombres() {return Nombres;}
    public void setNombres(String Nombres) {this.Nombres = Nombres;} 
}
