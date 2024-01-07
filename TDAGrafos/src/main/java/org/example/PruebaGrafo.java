package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class PruebaGrafo {

    public static void main(String[] args) {
        /*TGrafoNoDirigido gnd = (TGrafoNoDirigido) UtilGrafos.cargarGrafo(
                "src/main/java/org/example/vert2.txt",
                "src/main/java/org/example/pA.txt",
                false, TGrafoNoDirigido.class);

        Collection<TVertice> v = gnd.bea();
        for (TVertice vertice : v){
            System.out.println(vertice.getEtiqueta());
        }

        System.out.println("Punto articulacion: ");
        LinkedList<TVertice> pA = gnd.ptoArt();
        for (TVertice vertice : pA){
            System.out.println(vertice.getEtiqueta());
        }

        System.out.println(gnd.numBacon("A","C"));
        System.out.println(gnd.conectados("A","B"));
        System.out.println(gnd.conectados2("A","H"));

        System.out.println(gnd.gradoVertice("A"));

        Collection<TVertice> v2 = gnd.vertPorNivel("A");
        for (TVertice vertice : v2){
            System.out.println(vertice.getEtiqueta() + " " + vertice.getBacon());
        }*/

        TVertice v1 = new TVertice("Calculo1");
        TVertice v2 = new TVertice("Calculo2");
        TVertice v3 = new TVertice("Inicio");
        TVertice v4 = new TVertice("Graduacion");
        TVertice v5 = new TVertice("TeoComputacion");
        TVertice v6 = new TVertice("Yoga");

        TArista a1 = new TArista("Calculo1", "Calculo2", 1);
        TArista a2 = new TArista("Inicio", "Calculo1", 1);
        TArista a3 = new TArista("Calculo2", "TeoComputacion", 1);
        TArista a4 = new TArista("TeoComputacion", "Yoga", 2);
        TArista a5 = new TArista("Yoga", "Graduacion", 1);
        TArista a6 = new TArista("TeoComputacion", "Graduacion", 1);

        Collection<TVertice> vertices = new ArrayList<>();
        Collection<TArista> aristas = new ArrayList<>();

        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        vertices.add(v4);
        vertices.add(v5);
        vertices.add(v6);
        aristas.add(a1);
        aristas.add(a2);
        aristas.add(a3);
        aristas.add(a4);
        aristas.add(a5);
        aristas.add(a6);

        TGrafoDirigido gd = new TGrafoDirigido(vertices, aristas);

        LinkedList<Comparable> camino = gd.caminoConMenosSaltos("Inicio", "Graduacion");
        for (Comparable c:camino) {
            System.out.println(c);
        }
        System.out.println(gd.conectaConTodos("A"));
    }
}
