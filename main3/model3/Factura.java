package main3.model3;

import java.util.ArrayList;

public class Factura {
    private String fechaFactura;
    private long numeroFactura;
    private String cliente;
    private ArrayList<DetalleFactura> detallesFactura;
    private double totalCalculadoFactura;

    // Constructor
    public Factura(String fechaFactura, long numeroFactura, String cliente) {
        this.fechaFactura = fechaFactura;
        this.numeroFactura = numeroFactura;
        this.cliente = cliente;
        this.detallesFactura = new ArrayList<>();
        this.totalCalculadoFactura = 0;
    }

    // Métod para agregar un detalle a la factura
    public void agregarDetalle(DetalleFactura detalle) {
        this.detallesFactura.add(detalle);
    }

    // Metod para calcular el total de la factura
    public void calcularMontoTotal() {
        this.totalCalculadoFactura = 0;
        for (DetalleFactura detalle : detallesFactura) {
            this.totalCalculadoFactura += detalle.getSubtotal();
        }
    }

    // Getters y setters
    public String getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(String fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public long getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(long numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getTotalCalculadoFactura() {
        return totalCalculadoFactura;
    }

    public ArrayList<DetalleFactura> getDetallesFactura() {
        return detallesFactura;
    }
}
