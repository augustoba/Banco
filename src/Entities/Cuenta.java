package Entities;

import java.time.LocalDate;
import java.util.List;

public class Cuenta {
    private Integer  idCuenta;
    private Integer sucursal;
    private Boolean cajaAhorro;
    private  Boolean cuentaCorriente;
    private Cliente cliente;
    private Double saldo;
    LocalDate fechaAlta;
    private List<Transferencia>transferencias;
    static  Integer contador = 0;


    public Cuenta() {
        contador++;
        this.idCuenta =contador;
        this.cajaAhorro = false;
        this.cuentaCorriente = false;
        this.saldo = 0.0;
    }

    public Cuenta(Boolean cajaAhorro, Boolean cuentaCorriente, Double saldo) {
        contador++;
        this.cajaAhorro = cajaAhorro;
        this.cuentaCorriente = cuentaCorriente;
        this.saldo = saldo;
        this.idCuenta = contador;
        }

    public Integer getIdCuenta() {
        return idCuenta;
    }



    public Boolean getCajaAhorro() {
        return cajaAhorro;
    }

    public void setCajaAhorro(Boolean cajaAhorro) {
        this.cajaAhorro = cajaAhorro;
    }

    public Boolean getCuentaCorriente() {
        return cuentaCorriente;
    }

    public void setCuentaCorriente(Boolean cuentaCorriente) {
        this.cuentaCorriente = cuentaCorriente;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }


    public List<Transferencia> getTransferencias() {
        return transferencias;
    }

    public void setTransferencias(List<Transferencia> transferencias) {
        this.transferencias = transferencias;
    }

    public Integer getSucursal() {
        return sucursal;
    }

    public void setSucursal(Integer sucursal) {
        this.sucursal = sucursal;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "idCuenta=" + idCuenta +
                ", cajaAhorro=" + cajaAhorro +
                ", cuentaCorriente=" + cuentaCorriente +
                ", saldo=" + saldo +
                '}';
    }
}
