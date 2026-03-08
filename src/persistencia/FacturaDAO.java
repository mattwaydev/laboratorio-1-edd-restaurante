/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import modelo.Factura;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Samuel Ramirez
 */
public class FacturaDAO {

    private static final String ARCHIVO = "data/Facturas.txt";

    public ArrayList<Factura> cargarFacturas() {
        ArrayList<Factura> lista = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(ARCHIVO));
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) {
                    continue;
                }
                String[] f = linea.split(",");
                lista.add(new Factura(
                        Integer.parseInt(f[0]),
                        Integer.parseInt(f[1]),
                        f[2],
                        Double.parseDouble(f[3]),
                        Double.parseDouble(f[4]),
                        Double.parseDouble(f[5])
                ));
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error cargando facturas: " + e.getMessage());
        }
        return lista;
    }

    public void guardarFacturas(ArrayList<Factura> lista) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(ARCHIVO));
            for (Factura f : lista) {
                pw.println(f.toString());
            }
            pw.close();
        } catch (Exception e) {
            System.out.println("Error guardando facturas: " + e.getMessage());
        }
    }

    public int generarNuevoId() {
        ArrayList<Factura> lista = cargarFacturas();
        return lista.isEmpty() ? 1 : lista.get(lista.size() - 1).getIdFactura() + 1;
    }

    public void agregarFactura(Factura f) {
        ArrayList<Factura> lista = cargarFacturas();
        lista.add(f);
        guardarFacturas(lista);
    }

    public Factura buscarPorIdPedido(int idPedido) {
        for (Factura f : cargarFacturas()) {
            if (f.getIdPedido() == idPedido) {
                return f;
            }
        }
        return null;
    }
}

