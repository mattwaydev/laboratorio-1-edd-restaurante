/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Samuel Ramirez
 */
public class Factura {

    private int idFactura;
    private int idPedido;
    private String fechaHora;
    private double subtotal;
    private double propina;
    private double total;

    public Factura(int idFactura, int idPedido, String fechaHora, double subtotal, double propina, double total) {
        this.idFactura = idFactura;
        this.idPedido = idPedido;
        this.fechaHora = fechaHora;
        this.subtotal = subtotal;
        this.propina = propina;
        this.total = total;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getPropina() {
        return propina;
    }

    public void setPropina(double propina) {
        this.propina = propina;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return idFactura + "," + idPedido + "," + fechaHora + ","
                + subtotal + "," + propina + "," + total;
    }
}
