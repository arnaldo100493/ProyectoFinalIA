
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

public class BusquedaAmplitud {

    private ArrayList visitados;
    private ArrayList caminos;
    private ArrayList colaNodos;
    
    public BusquedaAmplitud() {
        this.visitados = new ArrayList();
        this.caminos = new ArrayList();
        this.colaNodos = new ArrayList();
    }

    public boolean verificarVisitado(int x) {
        boolean b = false;

        for (int k = 0; k < this.visitados.size(); k++) {

            if (Integer.parseInt(String.valueOf(this.visitados.get(k))) == x) {
                b = true;
                break;
            }
        }

        return b;
    }

    public String buscar(int[][] grafo, int ni, int nf) {
        String x = "No encontrado";

        this.visitados.add(Integer.valueOf(ni));
        this.caminos.add(Integer.valueOf(ni));
        this.colaNodos.add(Integer.valueOf(ni));

        while (this.colaNodos.size() != 0) {

            int i = Integer.parseInt(this.colaNodos.remove(0).toString());

            if (i == nf) {
                x = "Encontrado";
                System.out.println("Encontrado");
            } else {

                for (int j = 0; j < grafo.length; j++) {

                    if (grafo[i][j] == 1 && this.verificarVisitado(j) == false) {
                        this.colaNodos.add(Integer.valueOf(j));
                        this.visitados.add(Integer.valueOf(j));
                        this.caminos.add(Integer.valueOf(j));
                    }
                }
            }

        }

        return x;

    }

    public void imprimirCaminos() {

        for (int k = 0; k < this.caminos.size(); k++) {
            System.out.println(Integer.parseInt(this.caminos.get(k).toString()));
        }

    }

}
