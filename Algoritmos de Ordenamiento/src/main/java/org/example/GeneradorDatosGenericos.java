package org.example;

import java.util.Random;

public class GeneradorDatosGenericos {

    private int TAMANIO_MAX;

    public GeneradorDatosGenericos(int tamanio) {
        TAMANIO_MAX = tamanio;
    }

    public GeneradorDatosGenericos() {
        TAMANIO_MAX = 32000;
    }

    public int[] generarDatosAleatorios() {
        Random rnd = new Random();
        int[] datosGenerados = new int[TAMANIO_MAX];
        boolean[] datosUtilizados = new boolean[TAMANIO_MAX];
        for (int i = 0; i < datosGenerados.length; i++) {
            int j = rnd.nextInt(TAMANIO_MAX);
            while (datosUtilizados[j]) {
                j = (j + 1) % TAMANIO_MAX;
            }
            datosGenerados[j] = i;
            datosUtilizados[j] = true;
        }
        return datosGenerados;
        //orden n^2
    }

    public int[] generarDatosAscendentes() {
        int[] copiaAscendente = new int[TAMANIO_MAX];
        for (int i = 0; i < TAMANIO_MAX; i++) {
            copiaAscendente[i] = i;
        }
        return copiaAscendente;
        //orden n
    }

    public int[] generarDatosDescendentes() {
        int[] copiaDescendente = new int[TAMANIO_MAX];
        for (int i = 0; i < TAMANIO_MAX; i++) {
            copiaDescendente[i] = TAMANIO_MAX - i;
        }
        return copiaDescendente;
        //orden n
    }

}
