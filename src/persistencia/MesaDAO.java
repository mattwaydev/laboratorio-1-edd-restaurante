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
}
