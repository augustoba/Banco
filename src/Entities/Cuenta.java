package Entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cuenta {
    private String  idCuenta;
    private Integer sucursal;
    private Boolean cajaAhorro;
    private  Boolean cuentaCorriente;
    private Double saldo;
    LocalDate fechaAlta;
    private List<Transferencia>transferencias=new ArrayList<>();

    public Cuenta() {
    }

    public Cuenta(String idCuenta, Integer sucursal, Boolean cajaAhorro, Boolean cuentaCorriente,  Double saldo, LocalDate fechaAlta, List<Transferencia> transferencias) {
        this.idCuenta = idCuenta;
        this.sucursal = sucursal;
        this.cajaAhorro = cajaAhorro;
        this.cuentaCorriente = cuentaCorriente;

        this.saldo = saldo;
        this.fechaAlta = fechaAlta;
        this.transferencias = transferencias;
    }

    public String getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Integer getSucursal() {
        return sucursal;
    }

    public void setSucursal(Integer sucursal) {
        this.sucursal = sucursal;
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

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public List<Transferencia> getTransferencias() {
        return transferencias;
    }

    public void setTransferencias(List<Transferencia> transferencias) {
        this.transferencias = transferencias;
    }



    @Override
    public String toString() {
        return "\n"+
                "Cuenta{" +
                "idCuenta=" + idCuenta +
                ", sucursal=" + sucursal +
                ", cajaAhorro=" + cajaAhorro +
                ", cuentaCorriente=" + cuentaCorriente +
                ", saldo=" + saldo +
                ", fechaAlta=" + fechaAlta +
                ", transferencias=" + transferencias +
                '}';
    }
}
