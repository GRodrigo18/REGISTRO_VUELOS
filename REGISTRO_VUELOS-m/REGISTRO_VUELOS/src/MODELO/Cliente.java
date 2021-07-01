 
package MODELO;
public class Cliente 
{
     public String Tipodocu,numdocu,pasaporte,nombres,apellidos,sexo,origen,destino;
     public String fechasalida,fecharetorno;
     
   public Cliente(Object[] Registro)
   {
       this.Tipodocu=Registro[0].toString();
       this.numdocu=Registro[1].toString();
       this.pasaporte=Registro[2].toString();
       this.nombres=Registro[3].toString();
       this.apellidos=Registro[4].toString();
       this.sexo=Registro[5].toString();
       this.origen=Registro[6].toString();
       this.destino=Registro[7].toString();
       this.fechasalida=Registro[8].toString();
       this.fecharetorno=Registro[9].toString();
   }
   public Object[] getRegistro()
   {
       Object[]Registro={Tipodocu,numdocu,pasaporte,nombres,apellidos,sexo,
                            origen,destino,fechasalida,fecharetorno};
       return Registro;
   }
   public String getNombreCompleto() 
   {
       return apellidos + " " + nombres;
   }

    public String getTipodocu() {
        return Tipodocu;
    }

    public void setTipodocu(String Tipodocu) {
        this.Tipodocu = Tipodocu;
    }

    public String getNumdocu() {
        return numdocu;
    }

    public void setNumdocu(String numdocu) {
        this.numdocu = numdocu;
    }

    public String getPasaporte() {
        return pasaporte;
    }

    public void setPasaporte(String pasaporte) {
        this.pasaporte = pasaporte;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getFechsali() {
        return fechasalida;
    }

    public void setFechsali(String fechsali) {
        this.fechasalida = fechsali;
    }

    public String getFechretor() {
        return fecharetorno;
    }

    public void setFechretor(String fechretor) {
        this.fecharetorno = fechretor;
    }   
 
}
