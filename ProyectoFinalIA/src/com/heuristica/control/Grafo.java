package com.heuristica.control;


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
public class Grafo {

    private ArrayList visitados;
    private ArrayList caminos;
    private ArrayList pilaNodos;
    private ArrayList colaNodos;
    private ArrayList adyacentes;

    public Grafo() {
        this.visitados = new ArrayList();
        this.caminos = new ArrayList();
        this.pilaNodos = new ArrayList();
        this.colaNodos = new ArrayList();
        this.adyacentes = new ArrayList();
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

    public String busquedaPorAmplitud(int[][] grafo, int nodoInicial, int nodoFinal) {
        String mensaje = "El nodo solicitado no fue encontrado";

        this.visitados.add(Integer.valueOf(nodoInicial));
        this.caminos.add(Integer.valueOf(nodoInicial));
        this.colaNodos.add(Integer.valueOf(nodoInicial));

        while (this.colaNodos.size() != 0) {

            int i = Integer.parseInt(this.colaNodos.remove(0).toString());

            if (i == nodoFinal) {
                mensaje = "Nodo encontrado";
                System.out.println("Nodo encontrado");
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

        return mensaje;

    }

    public String busquedaPorProfundidad(int[][] grafo, int nodoInicial, int nodoFinal) {
        String mensaje = "El nodo solicitado no fue encontrado";

        this.pilaNodos.add(Integer.valueOf(nodoInicial));

        while (this.pilaNodos.size() != 0) {

            int i = Integer.parseInt(this.pilaNodos.remove(0).toString());
            this.visitados.add(Integer.valueOf(i));
            if (i == nodoFinal) {
                mensaje = "Nodo encontrado";

                break;

            } else {

                for (int j = grafo.length - 1; j >= 0; j--) {
                    if (grafo[i][j] == 1 && this.verificarVisitado(j) == false) {
                        this.pilaNodos.add(0, java.lang.Integer.valueOf(j));
                    }
                }
            }
        }

        return mensaje;

    }

    public String busquedaPorPrimeroMejor(int[][] grafo, int nodoInicial, int nodoFinal, ArrayList heuristica) {
        String mensaje = "El nodo solicitado no fue encontrado";

        this.pilaNodos.add(java.lang.Integer.valueOf(nodoInicial));

        while (this.pilaNodos.size() != 0) {

            int i = Integer.parseInt(this.pilaNodos.remove(0).toString());
            System.out.println("Adyacentes del nodo:" + i);
            this.visitados.add(java.lang.Integer.valueOf(i));
            if (i == nodoFinal) {
                mensaje = "Nodo encontrado";

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
                    System.out.println("no tiene adyacentes: " + j);

                } else {
                    this.pilaNodos.add(Integer.valueOf(this.selecionarmenor(heuristica)));
                }
                this.adyacentes = null;

            }
        }

        return mensaje;

    }

    public int selecionarmenor(ArrayList heuristica) {

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
    
    public void imprimirCaminosPorAmplitud()
	{
		
		
		for(int k=0; k<this.caminos.size();k++)
		{
		  System.out.println(java.lang.Integer.parseInt(this.caminos.get(k).toString()));
		 
		}
		
		
	}
    
    public void imprimirCaminosPorProfundidad()
		{
			System.out.println("---------");
			
			for(int k=0; k<this.visitados.size();k++)
			{
			  System.out.println(java.lang.Integer.parseInt(this.visitados.get(k).toString()));
			 
			}
			
			
		}

}
