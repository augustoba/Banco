package Entities;

import java.time.LocalDate;
import java.util.Date;

public class Transferencia {
    Integer idTransferencia;
    Double monto;
    LocalDate fechaTransferenc;


    public Transferencia() {
    fechaTransferenc = LocalDate.now();


    }

    public Integer getIdTransferencia() {
        return idTransferencia;
    }

    public void setIdTransferencia(Integer idTransferencia) {
        this.idTransferencia = idTransferencia;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }



    @Override
    public String toString() {
        return "Transferencia{" +
                "idTransferencia=" + idTransferencia +
                ", monto=" + monto +
                '}';
    }
}
