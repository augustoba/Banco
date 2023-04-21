package Entities;

import java.time.LocalDate;


public class Transferencia {
   private Integer idTransferencia;
    private Double monto;
    private LocalDate fechaTransferenc;
    private String detalle;
    private static int contador = 0;

    public Transferencia() {
        contador ++;
        this.idTransferencia = contador;
        this.fechaTransferenc = LocalDate.now();

    }

    public Transferencia(Integer idTransferencia, Double monto, LocalDate fechaTransferenc, String detalle) {
        contador++;
        this.idTransferencia = contador;
        this.monto = monto;
        this.fechaTransferenc = LocalDate.now();
        this.detalle = detalle;
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

    public LocalDate getFechaTransferenc() {
        return fechaTransferenc;
    }

    public void setFechaTransferenc(LocalDate fechaTransferenc) {
        this.fechaTransferenc = fechaTransferenc;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    @Override
    public String toString() {
        return  detalle ;
    }
}
