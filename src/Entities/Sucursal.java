package Entities;

import java.util.ArrayList;
import java.util.List;

public class Sucursal extends Banco{
    final String nombre = "Rio";
    private Integer numeroSuc;
    private String direccion;
    private List<Cliente> clientes = new ArrayList<>();

    static int contador=0;


    public Sucursal() {
         contador++;
        this.numeroSuc=contador;
    }

    public Sucursal(String direccion, String provincia, Integer cp, String pais, Integer numeroSuc, List<Cliente> clientes) {
        super(direccion, provincia, cp, pais);
        contador++;
        this.numeroSuc=contador;
        this.clientes = clientes;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getNumeroSuc() {
        return numeroSuc;
    }

    public void setNumeroSuc(Integer numeroSuc) {
        this.numeroSuc = numeroSuc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public String toString() {
        return "\n"+
                "Sucursal{" +
                "nombre='" + nombre + '\'' +
                ", numeroSuc=" + numeroSuc +
                ", direccion='" + direccion + '\'' +
                ", clientes=" + clientes +
                '}';
    }
}