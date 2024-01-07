package org.example;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author jechague
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int comparaciones1 = 0;
        int comparaciones2 = 0;
        HashMap hash = new HashMap(22);

        String datos[] = ManejadorArchivosGenerico.leerArchivo("src/main/java/org/example/claves_insertar.txt");
        for (int i = 0; i < datos.length; i++) {
            comparaciones1 += hash.insert(datos[i],datos[i]);
        }

        datos = ManejadorArchivosGenerico.leerArchivo("src/main/java/org/example/claves_buscar.txt");
        for (int i = 0; i < datos.length; i++) {
            comparaciones2 += hash.searchIterations(datos[i]);
        }

        System.out.println("Comparacion 1: " + comparaciones1);
        System.out.println("Comparacion 2: " + comparaciones2);

        System.out.println(hash.claves());
        System.out.println(hash.valores());
        System.out.println(hash.elementos());

        System.out.println(hash.isEmpty());
    }

}
