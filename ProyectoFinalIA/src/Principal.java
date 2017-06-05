
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author FABAME
 */
public class Principal {

    public Principal() {

    }

    public static void main(String[] args) {

        int[][] grafo = {
            // 0, 1, 2, 3, 4 ,5, 6, 7, 8
            {0, 1, 0, 1, 1, 0, 1, 0, 0},//0
            {0, 0, 1, 0, 0, 0, 0, 0, 0},//1
            {0, 0, 0, 0, 0, 0, 0, 0, 1},//2
            {0, 0, 1, 0, 1, 0, 1, 0, 0},//3
            {0, 0, 0, 0, 0, 1, 0, 0, 0},//4
            {0, 0, 0, 0, 0, 0, 0, 0, 1},//5
            {0, 0, 0, 0, 0, 0, 0, 1, 1},//6
            {0, 0, 0, 0, 0, 0, 0, 0, 0},//7
            {0, 0, 0, 0, 0, 0, 0, 0, 0},//8
        };

        ArrayList heuristica = new ArrayList();
        heuristica.add(0, Integer.valueOf(5));
        heuristica.add(1, Integer.valueOf(4));
        heuristica.add(2, Integer.valueOf(3));
        heuristica.add(3, Integer.valueOf(3));
        heuristica.add(4, Integer.valueOf(2));
        heuristica.add(5, Integer.valueOf(2));
        heuristica.add(6, Integer.valueOf(3));
        heuristica.add(7, Integer.valueOf(2));
        heuristica.add(8, Integer.valueOf(0));

        int op;
        do {
            Scanner dato = new Scanner(System.in);
            System.out.println("Digite opcion");
            op = dato.nextInt();

            switch (op) {

                case 1:
                    System.out.println("Busqueda en profundidad");
                    BusquedaProfundidad bp = new BusquedaProfundidad();
                    System.out.println(bp.buscar(grafo, 0, 8));
                    bp.imprimirCaminos();
                    break;

                case 2:
                    System.out.println("Busqueda en Amplitud");
                    BusquedaAmplitud ba = new BusquedaAmplitud();
                    System.out.println(ba.buscar(grafo, 0, 8));
                    ba.imprimirCaminos();
                    break;

                case 3:
                    System.out.println("Busqueda en Primero el mejor");
                    BusquedaPrimeroMejor bpm = new BusquedaPrimeroMejor();
                    System.out.println(bpm.buscar(grafo, 0, 8, heuristica));
                    break;

            }

        } while (op <= 3);

    }

}
