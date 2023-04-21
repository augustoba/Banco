package Entities;

public abstract class Banco {
    final String nombre = "Rio";

    private String direccion;

    private String provincia;

    private Integer cp;

    private String pais;

    public Banco() {
    }

    public Banco(String direccion, String provincia, Integer cp, String pais) {
        this.direccion = direccion;
        this.provincia = provincia;
        this.cp = cp;
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Integer getCp() {
        return cp;
    }

    public void setCp(Integer cp) {
        this.cp = cp;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "\n"+
                "Banco{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", provincia='" + provincia + '\'' +
                ", cp=" + cp +
                ", pais='" + pais + '\'' +
                '}';
    }
}
