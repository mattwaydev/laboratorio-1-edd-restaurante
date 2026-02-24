/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;
import modelo.Plato;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
/**
 *
 * @author Matt
 */
public class PlatoDAO {
    
    public ArrayList<Plato> cargarPlatos() {

        ArrayList<Plato> lista = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("data/Platos.txt"));
            String linea;

            while ((linea = br.readLine()) != null) {

                String[] partes = linea.split(",");

                int id = Integer.parseInt(partes[0]);
                String nombre = partes[1];
                String categoria = partes[2];
                double precio = Double.parseDouble(partes[3]);
                boolean disponible = partes[4].equals("SI");

                Plato p = new Plato(id, nombre, categoria, precio, disponible);
                lista.add(p);
            }

            br.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return lista;
    }
}
    

