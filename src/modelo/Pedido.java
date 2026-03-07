/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Samuel Ramirez
 */
public class Pedido {
    private int idPedido;
    private int idMesa;
    private String fechaHora;
    private String estado;

    public Pedido(int idPedido, int idMesa, String fechaHora, String estado) {
        this.idPedido = idPedido;
        this.idMesa = idMesa;
        this.fechaHora = fechaHora;
        this.estado = estado;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return idPedido + "," + idMesa + "," + fechaHora + "," + estado;
    }
    
    
}
