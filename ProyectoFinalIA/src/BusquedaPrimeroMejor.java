
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
public class BusquedaPrimeroMejor {

    private ArrayList visitados;
    private ArrayList adyacentes;
    private ArrayList pilaNodos;

    public BusquedaPrimeroMejor() {
        this.visitados = new ArrayList();
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

    public String buscar(int[][] grafo, int ni, int nf, ArrayList heuristica) {
        String x = "No encontrado";

        this.pilaNodos.add(Integer.valueOf(ni));

        while (this.pilaNodos.size() != 0) {

            int i = Integer.parseInt(this.pilaNodos.remove(0).toString());
            System.out.println("Adyacentes del nodo:" + i);
            this.visitados.add(Integer.valueOf(i));
            if (i == nf) {
                x = "Encontrado";

                break;

            } else {

                int j;
                this.adyacentes = new java.util.ArrayList();
                for (j = grafo.length - 1; j >= 0; j--) {

                    if (grafo[i][j] == 1) {
                        System.out.println("," + j);
                        this.adyacentes.add(Integer.valueOf(j));

                    }

                }

                if (this.adyacentes.isEmpty() == true) {
                    System.out.println("No tiene adyacentes: " + j);

                } else {
                    this.pilaNodos.add(Integer.valueOf(this.selecionarMenor(heuristica)));
                }
                this.adyacentes = null;

            }
        }

        return x;

    }

    public int selecionarMenor(ArrayList heuristica) {

        int ad = Integer.parseInt(this.adyacentes.get(0).toString());
        int posmenor = ad;
        int menor = Integer.parseInt(heuristica.get(ad).toString());

        for (int i = 1; i < this.adyacentes.size(); i++) {

            int ad1 = Integer.parseInt(this.adyacentes.get(i).toString());
            int menor1 = Integer.parseInt(heuristica.get(ad1).toString());

            if (menor1 < menor) {
                menor = menor1;
                posmenor = ad1;

            }
        }

        System.out.println(posmenor + ", " + menor);
        //System.out.println("entro");

        return posmenor;
    }

    public void imprimirCaminos() {
        System.out.println("---------");

        for (int k = 0; k < this.visitados.size(); k++) {
            System.out.println(Integer.parseInt(this.visitados.get(k).toString()));

        }

    }

}
