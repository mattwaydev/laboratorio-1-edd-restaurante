/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import modelo.Mesa;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Samuel Ramirez
 */
public class MesaDAO {
    private final String fileName = "data/Mesas.txt"; 

    public ArrayList<Mesa> cargarMesas() {
        ArrayList<Mesa> lista = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String linea;

            while ((linea = br.readLine()) != null) {
                // separacion por comas
                String[] partes = linea.split(",");

                if (partes.length == 3) {
                    int id = Integer.parseInt(partes[0]);
                    int capacidad = Integer.parseInt(partes[1]);
                    String estado = partes[2];

                    // creamos objeto
                    Mesa m = new Mesa(id, capacidad, estado);
                    lista.add(m);
                }
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error en Mesa: " + e.getMessage());
        }

        return lista;
    }
    
    public void guardarTodas(ArrayList<Mesa> lista) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            for (Mesa m : lista) {
                bw.write(m.getIdMesa() + "," + m.getCapacidad() + "," + m.getEstado());
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }
    
    //boton añadir mesa
    public void agregarMesa(Mesa nueva) {
        ArrayList<Mesa> lista = cargarMesas();
        for(Mesa m : lista) {
            if (m.getIdMesa() == nueva.getIdMesa()) {
                System.out.println("Error, ID dulicado");
                return;
            }
        }
        lista.add(nueva);
        guardarTodas(lista);
    }
    
    //boton de editar mesa
    public void editarMesa(Mesa editada) {
        ArrayList<Mesa> lista = cargarMesas();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getIdMesa() == editada.getIdMesa()) {
                lista.set(i, editada);
                break;
            }
        }
        guardarTodas(lista);
    }
    
    //boton de eliminar mesa
    public void eliminarMesa(int idMesa) {
        ArrayList<Mesa> lista = cargarMesas();
        lista.removeIf(m -> m.getIdMesa() == idMesa);
        guardarTodas(lista);
    }
    
    //boton para cambiar estado
    public void cambiarEstado(int idMesa, String nuevoEstado) {
        ArrayList<Mesa> lista = cargarMesas();
        for (Mesa m : lista) {
            if(m.getIdMesa() == idMesa) {
                m.setEstado(nuevoEstado);
                break;
            }
        }
        guardarTodas(lista);
    }
}
