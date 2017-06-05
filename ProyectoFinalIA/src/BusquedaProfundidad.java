
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
public class BusquedaProfundidad {

    private ArrayList visitados;
    private ArrayList pilaNodos;
    private ArrayList caminos;

    public BusquedaProfundidad() {
        this.visitados = new ArrayList();
        this.caminos = new ArrayList();
        this.pilaNodos = new ArrayList();

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

        this.pilaNodos.add(Integer.valueOf(ni));

        while (this.pilaNodos.size() != 0) {

            int i = Integer.parseInt(this.pilaNodos.remove(0).toString());
            this.visitados.add(Integer.valueOf(i));
            if (i == nf) {
                x = "Encontrado";

                break;

            } else {

                for (int j = grafo.length - 1; j >= 0; j--) {
                    if (grafo[i][j] == 1 && this.verificarVisitado(j) == false) {
                        this.pilaNodos.add(0, Integer.valueOf(j));
                    }
                }
            }
        }

        return x;

    }

    public void imprimirCaminos() {
        System.out.println("---------");

        for (int k = 0; k < this.visitados.size(); k++) {
            System.out.println(Integer.parseInt(this.visitados.get(k).toString()));

        }

    }

}
