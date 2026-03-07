/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import modelo.DetallePedido;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Samuel Ramirez
 */
public class DetallePedidoDAO {

    private static final String ARCHIVO = "data/DetallePedido.txt";

    public ArrayList<DetallePedido> cargarDetalles() {
        ArrayList<DetallePedido> lista = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(ARCHIVO));
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] d = linea.split(",");
                lista.add(new DetallePedido(
                        Integer.parseInt(d[0]), Integer.parseInt(d[1]),
                        Integer.parseInt(d[2]), d[3],
                        Integer.parseInt(d[4]), Double.parseDouble(d[5])
                ));
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error cargando Detalles: " + e.getMessage());
        }
        return lista;
    }
    
    public void guardarDetalles(ArrayList<DetallePedido> lista) {
        try{
            PrintWriter pw = new PrintWriter(new FileWriter(ARCHIVO));
            for (DetallePedido d : lista) pw.println(d.toString());
            pw.close();
        }catch(Exception e){
            System.out.println("Error guardando Detalles: " + e.getMessage());
        }
    }
    
    public int generarNuevoId() {
        ArrayList<DetallePedido> lista = cargarDetalles();
        return lista.isEmpty() ? 1 : lista.get(lista.size() - 1).getIdDetalle() + 1;
    }
    
    public void agregarDetalle(DetallePedido d) {
        ArrayList<DetallePedido> lista = cargarDetalles();
        lista.add(d);
        guardarDetalles(lista);
    }
    
    public ArrayList<DetallePedido> obtenerPorPedido(int idPedido) {
        ArrayList<DetallePedido> resultado = new ArrayList<>();
        for (DetallePedido d : cargarDetalles())
            if(d.getIdPedido() == idPedido) resultado.add(d);
        return resultado;
    }
    
    public void eliminarPorPedido(int idPedido) {
        ArrayList<DetallePedido> lista = cargarDetalles();
        lista.removeIf(d -> d.getIdPedido() == idPedido);
        guardarDetalles(lista);
    }
}
