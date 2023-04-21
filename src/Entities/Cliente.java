package Entities;

public class Cliente {

   private String dni;
   private String nombre;
   private String apellido;
   private String direccion;
   private Boolean alta;
   private Cuenta cuenta;

    public Cliente() {

    }

    public Cliente(String dni, String nombre, String apellido, String direccion, Boolean alta, Cuenta cuenta) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.alta = alta;
        this.cuenta = cuenta;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }



    @Override
    public String toString() {
        return "\n"+
                "Cliente{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", direccion='" + direccion + '\'' +
                ", alta=" + alta +
                ", cuenta=" + cuenta +
                '}';
    }
}
