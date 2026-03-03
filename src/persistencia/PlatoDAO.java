/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;
import modelo.Plato;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.PrintWriter;
/**
 *
 * @author Matt
 */
public class PlatoDAO {
    
     private static final String ARCHIVO = "data/Platos.txt";
    
    public ArrayList<Plato> cargarPlatos() {

        ArrayList<Plato> lista = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(ARCHIVO));
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
    
    public void guardarPlatos(ArrayList<Plato> lista) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(ARCHIVO));
            for (Plato p : lista) {
                pw.println(p.getIdPlato() + "," + p.getNombre() + "," +
                        p.getCategoria() + "," + p.getPrecio() + "," +
                        (p.isDisponible() ? "SI" : "NO"));
            }
            pw.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public int generarNuevoId() {
        ArrayList<Plato> lista = cargarPlatos();
        return lista.isEmpty() ? 1 : lista.get(lista.size() - 1).getIdPlato() + 1;
    }

    public void agregarPlato(Plato p) {
        ArrayList<Plato> lista = cargarPlatos();
        lista.add(p);
        guardarPlatos(lista);
    }

    public Plato buscarPlatoPorId(int id) {
        for (Plato p : cargarPlatos()) {
            if (p.getIdPlato() == id) return p;
        }
        return null;
    }

    public void editarPlato(Plato editado) {
        ArrayList<Plato> lista = cargarPlatos();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getIdPlato() == editado.getIdPlato()) {
                lista.set(i, editado);
                break;
            }
        }
        guardarPlatos(lista);
    }

    public void eliminarPlato(int id) {
        ArrayList<Plato> lista = cargarPlatos();
        lista.removeIf(p -> p.getIdPlato() == id);
        guardarPlatos(lista);
    }

    public void cambiarDisponibilidad(int id) {
        ArrayList<Plato> lista = cargarPlatos();
        for (Plato p : lista) {
            if (p.getIdPlato() == id) {
                p.setDisponible(!p.isDisponible());
                break;
            }
        }
        guardarPlatos(lista);
    }
}

    

