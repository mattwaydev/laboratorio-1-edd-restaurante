/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import modelo.Pedido;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Samuel Ramirez
 */
public class PedidoDAO {
    private static final String ARCHIVO = "data/Pedidos.txt";
    
    public ArrayList<Pedido> cargarPedidos() {
        ArrayList<Pedido> lista = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(ARCHIVO));
            String linea;
            while((linea = br.readLine()) != null){
                String[] p = linea.split(",");
                lista.add(new Pedido(Integer.parseInt(p[0]), Integer.parseInt(p[1]), p[2], p[3]));
            }
            br.close();
        }catch(Exception e){
            System.out.println("Error cargando pedidos: " + e.getMessage());
        }
        return lista;
    }
    
    public void guardarPedidos(ArrayList<Pedido> lista){
        try{
            PrintWriter pw = new PrintWriter(new FileWriter(ARCHIVO));
            for(Pedido p : lista) pw.println(p.toString());
            pw.close();
        }catch(Exception e){
            System.out.println("Error guardando Pedidos: " + e.getMessage());
        }
    }
    
    public int generarNuevoId() {
        ArrayList<Pedido> lista = cargarPedidos();
        return lista.isEmpty() ? 1 : lista.get(lista.size() - 1).getIdPedido() + 1;
    }
    
    public void agregarPedido(Pedido p) {
        ArrayList<Pedido> lista = cargarPedidos();
        lista.add(p);
        guardarPedidos(lista);
    }
    
    public Pedido buscarPorId(int id) {
        for(Pedido p : cargarPedidos())
            if(p.getIdPedido() == id) return p;
        return null;
    }
    
    public void actualizarEstado(int idPedido, String nuevoEstado) {
        ArrayList<Pedido> lista = cargarPedidos();
        for(Pedido p : lista)
            if(p.getIdPedido() == idPedido) {p.setEstado(nuevoEstado); break;}
        guardarPedidos(lista);
    }
}
