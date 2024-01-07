package org.example;

import java.util.Random;

public class TClasificador {

    public static final int METODO_CLASIFICACION_INSERCION = 1;
    public static final int METODO_CLASIFICACION_SHELL = 2;
    public static final int METODO_CLASIFICACION_BURBUJA = 3;
    public static final int METODO_CLASIFICACION_QUICKSORT = 4;
    public static final int METODO_CLASIFICACION_SELECCIONDIRECTA = 5;
    public static final int METODO_CLASIFICACION_HEAPSORT = 6;
    public static final int METODO_CLASIFICACION_CUENTASPORDISTRIBUCION = 7;
    public static final int METODO_CLASIFICACION_BINSORT = 8;

    /**
     * Punto de entrada al clasificador
     *
     * @param metodoClasificacion
     * @param orden
     * @param tamanioVector
     * @return Un vector del tam. solicitado, ordenado por el algoritmo
     * solicitado
     */
    public int[] clasificar(int[] datosParaClasificar, int metodoClasificacion) {
        switch (metodoClasificacion) {
            case METODO_CLASIFICACION_INSERCION:
                return ordenarPorInsercion(datosParaClasificar);
            case METODO_CLASIFICACION_SHELL:
                return ordenarPorShell(datosParaClasificar);
            case METODO_CLASIFICACION_BURBUJA:
                return ordenarPorBurbuja(datosParaClasificar);
            case METODO_CLASIFICACION_QUICKSORT:
                return ordenarPorQuicksort(datosParaClasificar);
            case METODO_CLASIFICACION_SELECCIONDIRECTA:
                return seleccionDirecta(datosParaClasificar);
            case METODO_CLASIFICACION_HEAPSORT:
                return heapSort(datosParaClasificar);
            case METODO_CLASIFICACION_CUENTASPORDISTRIBUCION:
                return cuentaPorDistribucion(datosParaClasificar);
            case METODO_CLASIFICACION_BINSORT:N:
                return binSort(datosParaClasificar);
            default:
                System.err.println("Este codigo no deberia haberse ejecutado");
                break;
        }
        return datosParaClasificar;
    }

    private void intercambiar(int[] vector, int pos1, int pos2) {
        int temp = vector[pos2];
        vector[pos2] = vector[pos1];
        vector[pos1] = temp;
    }

    /**
     * @param datosParaClasificar
     * @return
     */
    private int[] ordenarPorShell(int[] datosParaClasificar) {
        int j, inc;
        int[] incrementos = new int[]{3223, 358, 51, 10, 3, 1};
        int aux;
        if (datosParaClasificar != null) {
            for (int posIncrementoActual = 0; posIncrementoActual < incrementos.length; posIncrementoActual++) {
                inc = incrementos[posIncrementoActual];
                for (int i = inc; i < datosParaClasificar.length; i++) {
                    j = i - inc;
                    aux = datosParaClasificar[i];
                    while (j >= 0) {
                        //&& aux < datosParaClasificar[j]
                        if (datosParaClasificar[j] > datosParaClasificar[j + inc]) {
                            intercambiar(datosParaClasificar, j, j + inc);
                        }
                        j = j - inc;
                    }

                }
            }
        }
        return datosParaClasificar;
    }

    /**
     * @param datosParaClasificar
     * @return
     */
    protected int[] ordenarPorInsercion(int[] datosParaClasificar) {
        if (datosParaClasificar != null) {
            for (int i = 1; i < datosParaClasificar.length; i++) {
                int j = i - 1;
                int aux = datosParaClasificar[i];

                while ((j >= 0) && (aux < datosParaClasificar[j])) {
                    intercambiar(datosParaClasificar, j, j + 1);
                    j--;
                }
                datosParaClasificar[j + 1] = aux;
            }
            return datosParaClasificar;
        }
        return null;
    }

    private int[] ordenarPorBurbuja(int[] datosParaClasificar) {
        if (datosParaClasificar != null) {
            int n = datosParaClasificar.length - 1;
            for (int i = 0; i <= n; i++) {
                for (int j = n; j >= (i + 1); j--) {
                    if (datosParaClasificar[j] < datosParaClasificar[j - 1]) {
                        intercambiar(datosParaClasificar, j - 1, j);
                    }
                }
            }
            return datosParaClasificar;
        }
        return null;
    }

    private int[] ordenarPorQuicksort(int[] datosParaClasificar) {
        int i = 0;
        int j = datosParaClasificar.length - 1;
        return ordenarPorQuicksort(datosParaClasificar, i, j);
    }

    private int[] ordenarPorQuicksort(int[] V, int i, int j) {
        if (i < j) { // Verificar que i sea menor que j para evitar bucle infinito
            int indicePivote = encuentraPivote(V, i, j);
            int pivote = V[indicePivote];
            int k = particion(i, j, pivote, V);
            ordenarPorQuicksort(V, i, k - 1);
            ordenarPorQuicksort(V, k, j);
        }
        return V;
    }

    public int encuentraPivote(int[] V, int i, int j) {
        int posicion = (i + j) / 2; // Calcular la posición del pivote correctamente
        if (posicion >= i && posicion <= j) {
            return posicion;
        } else if (i >= posicion && i <= j) {
            return i;
        } else {
            return j;
        }
    }

    public int particion(int i, int j, int pivote, int[] V) {
        int L = i;
        int R = j;
        while (L <= R) { // Utilizar un bucle while en lugar de do-while
            while (V[L] < pivote) {
                L++;
            }
            while (V[R] > pivote) { // Cambiar ">=" a ">" para evitar intercambiar el pivote repetidamente
                R--;
            }
            if (L <= R) {
                intercambiar(V, L, R);
                L++;
                R--;
            }
        }
        return L;
    }

    private int[] seleccionDirecta(int[] datosParaClasificar) {
        for (int i = 0; i < datosParaClasificar.length - 1; i++) {
            int indiceMenor = i;
            int claveMenor = datosParaClasificar[i];
            for (int j = i + 1; j < datosParaClasificar.length; j++) {  // Se corrige el índice del bucle interno
                if (datosParaClasificar[j] < claveMenor) {
                    indiceMenor = j;
                    claveMenor = datosParaClasificar[j];
                }
            }
            intercambiar(datosParaClasificar, i, indiceMenor);
        }
        return datosParaClasificar;
    }

    private int[] heapSort(int[] datosParaClasificar) {
        int largo = datosParaClasificar.length;
        // Construir el heap (montículo)
        for (int i = largo / 2 - 1; i >= 0; i--)
            heapify(datosParaClasificar, largo, i);

        // Extraer elementos del heap uno por uno
        for (int i = largo - 1; i > 0; i--) {
            // Mover la raíz actual al final
            int temp = datosParaClasificar[0];
            datosParaClasificar[0] = datosParaClasificar[i];
            datosParaClasificar[i] = temp;

            // Llamar a heapify en el subárbol reducido
            heapify(datosParaClasificar, i, 0);
        }
        return datosParaClasificar;
    }
    private void heapify(int[] arr, int n, int raiz) {
        int largest = raiz; // Inicializar el nodo raíz como el más grande
        int left = 2 * raiz + 1; // Índice del hijo izquierdo
        int right = 2 * raiz + 2; // Índice del hijo derecho

        // Si el hijo izquierdo es más grande que la raíz
        if (left < n && arr[left] > arr[largest])
            largest = left;

        // Si el hijo derecho es más grande que la raíz
        if (right < n && arr[right] > arr[largest])
            largest = right;

        // Si el nodo más grande no es la raíz, intercambiar y hacer heapify en el subárbol afectado
        if (largest != raiz) {
            intercambiar(arr,largest,raiz);
            heapify(arr, n, largest);
        }
    }

    private int[] cuentaPorDistribucion(int[] datosParaClasificar){
        int[] S = new int[datosParaClasificar.length];
        int u = 0;
        int v = datosParaClasificar.length; // Valor maximo, no cuando no son del 0 al v seguidos
        int N = datosParaClasificar.length;
        int[] Cuenta = new int[v + 1];
        // Inicializar el arreglo Cuenta
        for (int i = u; i <= v; i++) {
            Cuenta[i] = 0;
        }
        // Contar las ocurrencias de cada elemento en R
        for (int j = 0; j < N; j++) {
            Cuenta[datosParaClasificar[j]]++;
        }
        // Calcular la suma acumulativa en Cuenta
        for (int i = u + 1; i <= v; i++) {
            Cuenta[i] = Cuenta[i] + Cuenta[i - 1];
        }
        // Construir el arreglo ordenado S
        for (int j = N - 1; j >= 0; j--) {
            int i = Cuenta[datosParaClasificar[j]];
            S[i - 1] = datosParaClasificar[j];
            Cuenta[datosParaClasificar[j]] = i - 1;
        }
        return S;
    }

    private int[] binSort (int[] datosParaClasificar){
        int maxVal = datosParaClasificar.length;
        int[] bins = new int[maxVal + 1]; // Arreglo de "bins" vacíos

        // Colocar elementos en los "bins"
        for (int i = 0; i < datosParaClasificar.length; i++) {
            bins[datosParaClasificar[i]]++;
        }

        int index = 0;
        // Recorrer los "bins" y colocar los elementos en el arreglo original en orden
        for (int i = 0; i < bins.length; i++) {
            while (bins[i] > 0) {
                datosParaClasificar[index++] = i;
                bins[i]--;
            }
        }
        return datosParaClasificar;
    }
    public boolean estaOrdenado(int[] arreglo) {

        int tamanio = arreglo.length;
        if (tamanio > 1) {
            //verifica hasta el penultimo
            for (int i = 0; i < tamanio - 1; i++) {
                if (arreglo[i + 1] < arreglo[i]) {
                    return false;
                }
            }
            //verifica con el ultimo, y el penultimo
            if (arreglo[tamanio - 1] < arreglo[tamanio - 2]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {

        //GeneradorDatosGenericos.TAMANIO_MAX = 10;
        /*int datos[] = new int[]{5, 2, 4, 1, 3, 8, 9, 15, 13};
        int datosSinOrdenar[] = {5, 2, 4, 1, 3, 8, 9, 15, 13};
        int datosPruebaEstaOrdenado[] = {15, 13};

        TClasificador clasif = new TClasificador();
        System.out.println("Insercion directa:");
        int[] insercion = clasif.clasificar(datos,
                TClasificador.METODO_CLASIFICACION_INSERCION);
        for (int i = 0; i < insercion.length; i++) {
            System.out.print(insercion[i] + " ");
        }

        System.out.println("");
        System.out.println("Shell:");
        datos = new int[]{5, 2, 4, 1, 3, 8, 9, 15, 13};
        int[] shellsort = clasif.clasificar(datos,
                TClasificador.METODO_CLASIFICACION_SHELL);
        for (int i = 0; i < shellsort.length; i++) {
            System.out.print(shellsort[i] + " ");
        }

        System.out.println("");
        System.out.println("Burbuja:");
        datos = new int[]{5, 2, 4, 1, 3, 8, 9, 15, 13};
        int[] burbuja = clasif.clasificar(datos,
                TClasificador.METODO_CLASIFICACION_BURBUJA);
        for (int i = 0; i < burbuja.length; i++) {
            System.out.print(burbuja[i] + " ");
        }

        System.out.println("");
        System.out.println("Insercion: " + clasif.estaOrdenado(insercion));
        System.out.println("Shellsort: " + clasif.estaOrdenado(shellsort));
        System.out.println("Burbuja: " + clasif.estaOrdenado(burbuja));

        System.out.println("");
        System.out.println("Quicksort:");
        datos = new int[]{5, 2, 4, 1, 3, 8, 9, 15, 13};
        int[] quicksort = clasif.clasificar(datos,
                TClasificador.METODO_CLASIFICACION_QUICKSORT);
        for (int i = 0; i < quicksort.length; i++) {
            System.out.print(quicksort[i] + " ");
        }*/

        TClasificador clasif = new TClasificador();

        GeneradorDatosGenericos gdg1 = new GeneradorDatosGenericos(300);
        int[] vectorAleatorio = gdg1.generarDatosAleatorios();
        int[] vectorAscendente = gdg1.generarDatosAscendentes();
        int[] vectorDescendente = gdg1.generarDatosDescendentes();

        GeneradorDatosGenericos gdg2 = new GeneradorDatosGenericos(1000);
        int[] vectorAleatorio2 = gdg2.generarDatosAleatorios();
        int[] vectorAscendente2 = gdg2.generarDatosAscendentes();
        int[] vectorDescendente2 = gdg2.generarDatosDescendentes();

        GeneradorDatosGenericos gdg3 = new GeneradorDatosGenericos(3000);
        int[] vectorAleatorio3 = gdg3.generarDatosAleatorios();
        int[] vectorAscendente3 = gdg3.generarDatosAscendentes();
        int[] vectorDescendente3 = gdg3.generarDatosDescendentes();

        int[] resAleatorio = clasif.clasificar(vectorAleatorio,
                METODO_CLASIFICACION_BINSORT);
        for (int i = 0; i < resAleatorio.length; i++) {
            System.out.print(resAleatorio[i] + " ");
        }
        /*System.out.println("");
        int[] resAscendente = clasif.clasificar(vectorAscendente,
                METODO_CLASIFICACION_INSERCION);
        for (int i = 0; i < resAscendente.length; i++) {
            System.out.print(resAscendente[i] + " ");
        }
        System.out.println("");
        int[] resDescendente = clasif.clasificar(vectorDescendente,
                METODO_CLASIFICACION_INSERCION);
        for (int i = 0; i < resDescendente.length; i++) {
            System.out.print(resDescendente[i] + " ");
        }
        */
        int m = METODO_CLASIFICACION_HEAPSORT;
        String nombre = "heapsort";
        System.out.println("");
        System.out.println("Vector aleatorio, 300 valores, " + nombre);
        metodoClasificacionConTiempo(300,vectorAleatorio,m);
        System.out.println("");
        System.out.println("Vector ascendente, 300 valores, " + nombre);
        metodoClasificacionConTiempo(300,vectorAscendente,m);
        System.out.println("");
        System.out.println("Vector descendente, 300 valores, " + nombre);
        metodoClasificacionConTiempo(300,vectorDescendente,m);
        System.out.println("");
        System.out.println("Vector aleatorio, 1000 valores, " + nombre);
        metodoClasificacionConTiempo(1000,vectorAleatorio2,m);
        System.out.println("");
        System.out.println("Vector ascendente, 1000 valores, " + nombre);
        metodoClasificacionConTiempo(1000,vectorAscendente2,m);
        System.out.println("");
        System.out.println("Vector descendente, 1000 valores, " + nombre);
        metodoClasificacionConTiempo(1000,vectorDescendente2,m);
        System.out.println("");
        System.out.println("Vector aleatorio, 3000 valores, " + nombre);
        metodoClasificacionConTiempo(3000,vectorAleatorio3,m);
        System.out.println("");
        System.out.println("Vector ascendente, 3000 valores, " + nombre);
        metodoClasificacionConTiempo(3000,vectorAscendente3,m);
        System.out.println("");
        System.out.println("Vector descendente, 3000 valores, " + nombre);
        metodoClasificacionConTiempo(3000,vectorDescendente3,m);


    }

    public static void metodoClasificacionConTiempo(int cantDatos, int[] vector, int metodoClasificacion){
        TClasificador clasif2 = new TClasificador();
        int T = cantDatos; // Tamaño del vector
        long tiemporesolucion = 1000000000; // Tiempo de resolución en nanosegundos

        int[] vectorOriginal = vector;
        long t1 = System.nanoTime();
        long total = 0;
        int cantLLamadas = 0;

        while (total < tiemporesolucion) {
            cantLLamadas++;
            int[] datosCopia = new int[T];
            for (int i = 0; i < T; i++){
                datosCopia[i] = vectorOriginal[i];
            }
            clasif2.clasificar(datosCopia, metodoClasificacion); // EJECUTA EL MÉTODO
            long t2 = System.nanoTime();
            total = t2 - t1;
        }

        long TiempoMedioAlgoritmo = total / cantLLamadas;
        System.out.println("Tiempo medio del algoritmo: " + TiempoMedioAlgoritmo + " nanosegundos");
    }
}
