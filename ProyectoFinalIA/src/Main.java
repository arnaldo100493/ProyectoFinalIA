
import com.heuristica.control.Grafo;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author FABAME
 */
public class Main {

    public Main() {

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[][] matriz = {{0, 1, 0, 0, 0},
        {1, 0, 1, 0, 1},
        {0, 1, 0, 1, 1},
        {0, 0, 1, 1, 0},
        {0, 1, 1, 0, 0}};

        ArrayList heuristica = new ArrayList();
        heuristica.add(0, Integer.valueOf(5));
        heuristica.add(1, Integer.valueOf(4));
        heuristica.add(2, Integer.valueOf(3));
        heuristica.add(3, Integer.valueOf(3));
        heuristica.add(4, Integer.valueOf(2));

        Grafo grafo = new Grafo();

        System.out.println("Busqueda por Amplitud: " + grafo.busquedaPorAmplitud(matriz, 0, 4));
        grafo.imprimirCaminosPorAmplitud();

        System.out.println("");

        System.out.println("Busqueda por Profundidad: " + grafo.busquedaPorProfundidad(matriz, 0, 4));
        grafo.imprimirCaminosPorProfundidad();

        System.out.println("");

        System.out.println("Busqueda por Primero el mejor: " + grafo.busquedaPorPrimeroMejor(matriz, 0, 4, heuristica));

    }

}
