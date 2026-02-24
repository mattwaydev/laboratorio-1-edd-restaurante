/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;
import persistencia.PlatoDAO;
import modelo.Plato;
import java.util.ArrayList;
import modelo.Mesa;
import persistencia.MesaDAO;
/**
 *
 * @author Matt
 */
public class Main {
    
    public static void main(String[] args) {

        PlatoDAO dao = new PlatoDAO();
        ArrayList<Plato> platos = dao.cargarPlatos();

        for (Plato p : platos) {
            System.out.println(p);
        }
        
        //mesas lista
        MesaDAO daoMesa = new MesaDAO();
        ArrayList<Mesa> mesas = daoMesa.cargarMesas();
        
        System.out.println("\n-----Lista Mesas-----");
        for (Mesa m : mesas) {
            System.out.println(m);
        }
        
    }
    
}
