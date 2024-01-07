package org.example;

import java.util.*;

public class TGrafoDirigido implements IGrafoDirigido {

    private final Map<Comparable, TVertice> vertices; //lista de vertices del grafo.-
    private final LinkedList<TArista> aristas;
    

    public TGrafoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        this.vertices = new HashMap<>();
        this.aristas = new LinkedList<TArista>();
        for (TVertice vertice : vertices) {
            insertarVertice(vertice.getEtiqueta());
        }
        for (TArista arista : aristas) {
            insertarArista(arista);
        }
    }

    /**
     * Metodo encargado de eliminar una arista dada por un origen y destino. En
     * caso de no existir la adyacencia, retorna falso. En caso de que las
     * etiquetas sean invalidas, retorna falso.
     *
     * @param nomVerticeOrigen
     * @param nomVerticeDestino
     * @return
     */
    @Override
    public boolean eliminarArista(Comparable nomVerticeOrigen, Comparable nomVerticeDestino) {
        if ((nomVerticeOrigen != null) && (nomVerticeDestino != null)) {
            TVertice vertOrigen = buscarVertice(nomVerticeOrigen);
            if (vertOrigen != null) {
                return vertOrigen.eliminarAdyacencia(nomVerticeDestino);
            }
        }
        return false;
    }

    /**
     * Metodo encargado de eliminar un vertice en el grafo. En caso de no
     * existir el v�rtice, retorna falso. En caso de que la etiqueta sea
     * inv�lida, retorna false.
     *
     * @param nombreVertice
     * @return
     */
    @Override
    public boolean eliminarVertice(Comparable nombreVertice) {
        if (nombreVertice != null) {
            getVertices().remove(nombreVertice);
            return getVertices().containsKey(nombreVertice);
        }
        return false;
    }

    /**
     * Metodo encargado de verificar la existencia de una arista. Las etiquetas
     * pasadas por par�metro deben ser v�lidas.
     *
     * @param etiquetaOrigen
     * @param etiquetaDestino
     * @return True si existe la adyacencia, false en caso contrario
     */
    @Override
    public boolean existeArista(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        TVertice vertOrigen = buscarVertice(etiquetaOrigen);
        TVertice vertDestino = buscarVertice(etiquetaDestino);
        if ((vertOrigen != null) && (vertDestino != null)) {
            return vertOrigen.buscarAdyacencia(vertDestino) != null;
        }
        return false;
    }

    /**
     * Metodo encargado de verificar la existencia de un vertice dentro del
     * grafo.-
     *
     * La etiqueta especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del v�rtice a buscar.-
     * @return True si existe el vertice con la etiqueta indicada, false en caso
     * contrario
     */
    @Override
    public boolean existeVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta) != null;
    }

    /**
     * Metodo encargado de verificar buscar un vertice dentro del grafo.-
     *
     * La etiqueta especificada como parametro debe ser valida.
     *
     * @param unaEtiqueta Etiqueta del v�rtice a buscar.-
     * @return El vertice encontrado. En caso de no existir, retorna nulo.
     */
    public TVertice buscarVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta);
    }

    /**
     * Matodo encargado de insertar una arista en el grafo (con un cierto
     * costo), dado su vertice origen y destino.- Para que la arista sea valida,
     * se deben cumplir los siguientes casos: 1) Las etiquetas pasadas por
     * parametros son v�lidas.- 2) Los vertices (origen y destino) existen
     * dentro del grafo.- 3) No es posible ingresar una arista ya existente
     * (miso origen y mismo destino, aunque el costo sea diferente).- 4) El
     * costo debe ser mayor que 0.
     *
     * @param arista
     * @return True si se pudo insertar la adyacencia, false en caso contrario
     */
    @Override
    public boolean insertarArista(TArista arista) {
        boolean tempbool = false;
        if ((arista.getEtiquetaOrigen() != null) && (arista.getEtiquetaDestino() != null)) {
            TVertice vertOrigen = buscarVertice(arista.getEtiquetaOrigen());
            TVertice vertDestino = buscarVertice(arista.getEtiquetaDestino());
            tempbool = (vertOrigen != null) && (vertDestino != null);
            if (tempbool) {
                getAristas().add(arista);
                return vertOrigen.insertarAdyacencia(arista.getCosto(), vertDestino);
            }

        }
        return false;
    }

    public LinkedList<TArista> getAristas() {
        return aristas;
    }

    /**
     * Metodo encargado de insertar un vertice en el grafo.
     *
     * No pueden ingresarse v�rtices con la misma etiqueta. La etiqueta
     * especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del v�rtice a ingresar.
     * @return True si se pudo insertar el vertice, false en caso contrario
     */
    public boolean insertarVertice(Comparable unaEtiqueta) {
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            TVertice vert = new TVertice(unaEtiqueta);
            getVertices().put(unaEtiqueta, vert);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }

    @Override
    public boolean insertarVertice(TVertice vertice) {
        Comparable unaEtiqueta = vertice.getEtiqueta();
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            getVertices().put(unaEtiqueta, vertice);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }


    public Object[] getEtiquetasOrdenado() {
        TreeMap<Comparable, TVertice> mapOrdenado = new TreeMap<>(this.getVertices());
        return mapOrdenado.keySet().toArray();
    }

    @Override
    public void desvisitarVertices() {
        for (TVertice vertice : this.vertices.values()) {
            vertice.setVisitado(false);
        }
    }

    /**
     * @return the vertices
     */
    @Override
    public Map<Comparable, TVertice> getVertices() {
        return vertices;
    }

    @Override
    public Comparable centroDelGrafo() {
        Comparable res = null;
        Double minExc = Double.MAX_VALUE;
        for (Comparable vert : vertices.keySet()){
            Double exc = obtenerExcentricidad(vert);
            if (exc < minExc && exc != -1){
                res = vert;
                minExc = exc;
            }
        }
        return res;
    }

    @Override
    public Double[][] floyd() {
        Double[][] res = UtilGrafos.obtenerMatrizCostos(this.vertices);
        int largo = res.length;
        for (int i = 0; i < largo; i++){
            for (int j = 0; j < largo; j++){
                for (int k = 0; k < largo; k++){
                    if(res[j][i] + res[i][k] < res[j][k]){
                        res[j][k] = res[j][i] + res[i][k];
                    }
                }
            }
        }
        return res;
    }

    public Double[][] floyd2() {
        Collection<TVertice> verticesCollection = this.vertices.values();
        ArrayList<TVertice> vertices = new ArrayList<>();
        for (TVertice i : verticesCollection) {
            vertices.add(i);
        }
        int n = getVertices().size();
        Double[][] A = new Double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = vertices.get(i).obtenerCostoAdyacencia(vertices.get(j));
            }
        }
        for (int i = 0; i < n; i++) {
            A[i][i] = (double) 0;
        }
        for (int k = 1; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (A[i][k] != Double.MAX_VALUE && i != k) {
                    for (int j = 0; j < n; j++) {
                        Double res = A[i][k] + A[k][j];
                        if (res < A[i][j]) {
                            A[i][j] = res;
                        }
                    }
                }
            }
        }
        return A;
    }

    public int[][] precedenciaDefloyd() {

        Double[][] A = UtilGrafos.obtenerMatrizCostos(vertices);
        int[][] P = new int[A.length][A.length];

        for (int i = 0; i < P.length; i++) {
            for (int j = 0; j < P.length; j++) {
                P[i][j] = 0;
            }
        }

        for (int k = 0; k < A.length; k++) {
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A.length; j++) {
                    if ((A[i][k] + A[k][j]) < A[i][j]) {
                        A[i][j] = A[i][k] + A[k][j];
                        P[i][j] = k;
                    }
                }
            }
        }

        return P;
    }

    @Override
    public Double obtenerExcentricidad(Comparable etiquetaVertice) {
        Double[][] aux = this.floyd();
        int index = 0;
        for (Comparable vert : vertices.keySet()){
            if(vert.equals(etiquetaVertice)){
                break;
            }
            index++;
        }

        Double valMax = 0.0;
        for(int i = 0; i < vertices.keySet().size(); i++){
            if (aux[i][index] != Double.MAX_VALUE && aux[i][index] > valMax){
                valMax = aux[i][index];
            }
        }
        if (valMax == 0){
            return -1.0;
        }else{
            return valMax;
        }
    }

    @Override
    public boolean[][] warshall() {
        Double[][] matrizCostos = UtilGrafos.obtenerMatrizCostos(getVertices());
        boolean[][] matrizWarshall = new boolean[matrizCostos.length][matrizCostos.length];
        for (int i = 0; i < matrizCostos.length; i++) {
            for (int j = 0; j < matrizCostos.length; j++) {
                matrizWarshall[i][j] = false;

                if (i != j && matrizCostos[i][j] < Integer.MAX_VALUE && matrizCostos[i][j] > 0) {
                    matrizWarshall[i][j] = true;
                }
            }
        }
        for (int k = 0; k < matrizWarshall.length; k++) {
            for (int i = 0; i < matrizWarshall.length; i++) {
                for (int j = 0; j < matrizWarshall.length; j++) {
                    if ((i != k) && (k != j) && (i != j)) {
                        if (!matrizWarshall[i][j]) {
                            matrizWarshall[i][j] = matrizWarshall[i][k] && matrizWarshall[k][j];
                        }
                    }
                }
            }
        }
        return matrizWarshall;
    }

    @Override
    public LinkedList<TVertice> bpf() {
        desvisitarVertices();
        LinkedList result = new LinkedList<TVertice>();
        if (vertices.isEmpty()){
            return null;
        } else{
            for (TVertice vert : this.vertices.values()){
                if (!vert.getVisitado()){
                    vert.bpf(result);
                }
            }
        }
        return result;
    }

    @Override
    public Collection<TVertice> bea() {
        desvisitarVertices();
        LinkedList<TVertice> list = new LinkedList<>();
        for (TVertice v : getVertices().values()){
            if (v != null){
                if (!v.getVisitado()){
                    v.bea(list);
                }
            }

        }
        return list;
    }

    public Collection<TVertice> bea(Comparable etiquetaOrigen) {
        TVertice v = buscarVertice(etiquetaOrigen);
        LinkedList<TVertice> list = new LinkedList<>();
        if (v != null){
            v.bea(list);
        }
        return list;
    }


    @Override
    public LinkedList<TVertice> bpf(Comparable etiquetaOrigen) {
        desvisitarVertices();
        LinkedList result = new LinkedList<TVertice>();
        TVertice nuevoOrigen = vertices.get(etiquetaOrigen);
        if (nuevoOrigen != null){
            nuevoOrigen.bpf(result);
        }
        return result;
    }


    @Override
    public LinkedList<TVertice> bpf(TVertice vertice) {
        desvisitarVertices();
        LinkedList result = new LinkedList<TVertice>();
        if (vertice != null){
            vertice.bpf(result);
        }
        return result;
    }


    public LinkedList<Comparable> caminoConMenosSaltos(Comparable origen, Comparable destino) {
        if (origen != null && destino != null) {
            TCaminos caminos = this.todosLosCaminos(origen, destino);

            int minSaltos = Integer.MAX_VALUE;
            TCamino caminoMenosSaltos = null;

            for (TCamino camino : caminos.getCaminos()){
                if (minSaltos > camino.getOtrosVertices().size()){
                    minSaltos = camino.getOtrosVertices().size();
                    caminoMenosSaltos = camino;
                }
            }

            LinkedList<Comparable> clavesCamino  = new LinkedList();
            if (caminoMenosSaltos != null){
                clavesCamino.add(origen);
                for(Comparable a : caminoMenosSaltos.getOtrosVertices()){
                    clavesCamino.add(a);
                }
                return clavesCamino;
            }

        }
        return null;
    }

    public int gradoVertice(Comparable etiquetaVertice) {
        TVertice v = buscarVertice(etiquetaVertice);
        return v.obtenerGrado();
    }
    @Override
    public TCaminos todosLosCaminos(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        desvisitarVertices();
        TCaminos todosLosCaminos = new TCaminos();
        TVertice v = buscarVertice(etiquetaOrigen);
        if (v != null) {
            TCamino caminoPrevio = new TCamino(v);
            v.todosLosCaminos(etiquetaDestino, caminoPrevio, todosLosCaminos);
            return todosLosCaminos;
        }
        return null;
    }

    public boolean conexionTotal(Comparable origen) {
        TVertice verticeOrigen = this.buscarVertice(origen);
        if (verticeOrigen == null) {
            System.out.println("El origen no existe.");
            return false;
        }
        desvisitarVertices();
        LinkedList<TVertice> visitados = new LinkedList();
        verticeOrigen.conexionTotal(visitados);
        if (visitados.size() == this.vertices.size()) {
            this.desvisitarVertices();
            return true;
        }
        this.desvisitarVertices();
        return false;
    }
    public boolean existeCamino(Comparable etiqueta1, Comparable etiqueta2) {
        Set<Comparable> etiquetas = vertices.keySet();
        Object[] v = etiquetas.toArray();
        int vertice1 = -1;
        int vertice2 = -1;

        for (int i = 0; i < v.length; i++) {
            if (v[i].equals(etiqueta1)) {
                vertice1 = i;
            } else if (v[i].equals(etiqueta2)) {
                vertice2 = i;
            } else if (vertice1 != -1 && vertice2 != -1) {
                break;
            }
        }
        return this.warshall()[vertice1][vertice2];
    }

    public TCamino obtenerCamino(Comparable etiqueta1, Comparable etiqueta2) {
        if (existeCamino(etiqueta1, etiqueta2)) {
            TCamino camino = new TCamino(buscarVertice(etiqueta1));
            int indice1 = -1;
            int indice2 = -1;
            Double[][] floyd = this.floyd();
            int[][] matrizP = precedenciaDefloyd();

            Set<Comparable> etiquetas = vertices.keySet();
            Object[] vertices = etiquetas.toArray();

            HashMap<Integer, Comparable> mapa = new HashMap<>();

            for (int i = 0; i < vertices.length; i++) {
                if (vertices[i].equals(etiqueta1)) {
                    indice1 = i;
                }
                if (vertices[i].equals(etiqueta2)) {
                    indice2 = i;
                }
                mapa.put(i, vertices[i].toString());
            }

            this.camino(camino, indice1, indice2, mapa, floyd, matrizP);
            return camino;
        } else {
            System.out.println("No existe un camino entre " + etiqueta1 + " y " + etiqueta2);
            return null;
        }
    }

    private void camino(TCamino c, int indice1, int indice2, HashMap<Integer, Comparable> mapa, Double[][] floyd2, int[][] matrizP) {

        if (matrizP[indice1][indice2] == 0) {
            TAdyacencia tAdyacencia = new TAdyacencia(floyd2[indice1][indice2], this.vertices.get(mapa.get(indice2)));
            c.agregarAdyacencia(tAdyacencia);
            return;
        } else {
            TAdyacencia tAdyacencia = new TAdyacencia(floyd2[indice1][indice2], this.vertices.get(mapa.get((matrizP[indice1][indice2]))));
            c.agregarAdyacencia(tAdyacencia);
            camino(c, matrizP[indice1][indice2], indice2, mapa, floyd2, matrizP);
        }
    }

    public void clasificarArcos(TVertice verticeOrigen, LinkedList<TArista> arcosArbol, LinkedList<TArista> arcosRetroceso, LinkedList<TArista> arcosAvance, LinkedList<TArista> arcosCruzados) {
        //Reiniciar el estado visitado de todos los vertices
        for (TVertice vertice : this.getVertices().values()) {
            vertice.setVisitado(false);
        }

        int visitadoIndex = 0; //Inicializar el indice de visita
        //Realizar el recorrido dfs desde el vertice origen
        clasificarArcosDFS(verticeOrigen, arcosArbol, arcosRetroceso, arcosAvance, arcosCruzados, visitadoIndex);
    }

    private void clasificarArcosDFS(TVertice vertice, LinkedList<TArista> arcosArbol, LinkedList<TArista> arcosRetroceso, LinkedList<TArista> arcosAvance, LinkedList<TArista> arcosCruzados, int visitadoIndex) {
        //Marcar el vertice como visitado y asignarle una indice de visita
        vertice.setVisitado(true);
        vertice.setVisitadoIndex(visitadoIndex);
        visitadoIndex++;

        //Recorrer todas las aristas del vertice
        LinkedList<TAdyacencia> ady = vertice.getAdyacentes();
        for (TAdyacencia adyacencia : ady) {
            TVertice adyacente = adyacencia.getDestino();
            TArista arista = new TArista(vertice.getEtiqueta(), adyacente.getEtiqueta(), adyacencia.getCosto());

            if (!adyacente.getVisitado()) {
                //Arcos de arbol
                arcosArbol.add(arista);
                clasificarArcosDFS(adyacente, arcosArbol, arcosRetroceso, arcosAvance, arcosCruzados, visitadoIndex);
            } else {
                // Posibles: arcos de retroceso, avance o cruzados
                if (vertice.getVisitadoIndex() == adyacente.getVisitadoIndex()) {
                    //Arcos cruzados
                    arcosCruzados.add(arista);
                } else if (vertice.getVisitadoIndex() < adyacente.getVisitadoIndex()) {
                    // Arcos de avance
                    arcosAvance.add(arista);
                } else {
                    //Arcos de retroceso
                    arcosRetroceso.add(arista);
                }
            }
        }
    }

    public List<List<TVertice>> generarOrdenacionesTopologicas() {
        List<List<TVertice>> ordenaciones = new ArrayList<>();
        List<TVertice> ordenacionActual = new ArrayList<>();
        Map<TVertice, Boolean> visitados = new HashMap<>();

        for (TVertice vertice : vertices.values()) {
            visitados.put(vertice, false);
        }

        generarOrdenacionesRecursivo(ordenaciones, ordenacionActual, visitados);

        return ordenaciones;
    }

    private void generarOrdenacionesRecursivo(List<List<TVertice>> ordenaciones, List<TVertice> ordenacionActual, Map<TVertice, Boolean> visitados) {
        boolean todosVisitados = true;

        for (TVertice vertice : vertices.values()) {
            if (!visitados.get(vertice) && !tienePredecesoresNoVisitados(vertice, visitados)) {
                visitados.put(vertice, true);
                ordenacionActual.add(vertice);

                generarOrdenacionesRecursivo(ordenaciones, ordenacionActual, visitados);

                visitados.put(vertice, false);
                ordenacionActual.remove(ordenacionActual.size()-1);

                todosVisitados = false;
            }
        }

        if (todosVisitados) {
            ordenaciones.add(new ArrayList<>(ordenacionActual));
        }
    }
    public LinkedList<TVertice> clasificacionTopologica() {
        LinkedList<TVertice> listaOrdenada = new LinkedList<>();

        for (TVertice vertice : vertices.values()) {
            if (!vertice.getVisitado()) {
                vertice.clasificacionTopologica(listaOrdenada);
            }
        }
        return listaOrdenada;
    }
    private boolean tienePredecesoresNoVisitados(TVertice vertice, Map<TVertice, Boolean> visitados) {
        for (TVertice predecesor : vertices.values()) {
            if (existeArista(predecesor.getEtiqueta(), vertice.getEtiqueta()) && !visitados.get(predecesor)) {
                return true;
            }
        }
        return false;
    }
    public LinkedList<TVertice> ordenParcial() {

        LinkedList<TVertice> verticesOrdenados = new LinkedList<>();
        for (TVertice vertice : vertices.values()) {
            vertice.setVisitado(false);
        }
        for (TVertice vertice : vertices.values()) {
            if (!vertice.getVisitado()) {
                vertice.ordenParcial(verticesOrdenados);
            }
        }
        return verticesOrdenados;
    }

    @Override
    public boolean tieneCiclo(TCamino camino) {
        return tieneCiclo(camino.getOrigen().getEtiqueta());
    }

    @Override
    public boolean tieneCiclo(Comparable etiquetaOrigen) {
        LinkedList<TVertice> visitados = new LinkedList<>();
        TVertice vertice = getVertices().get(etiquetaOrigen);
        int[] cont = new int[1];
        cont[0] = 0;

        vertice.contieneCiclos(visitados, cont);

        if (getVertices().size() == cont[0]) {
            return false;
        } else {
            return true;
        }
    }

    public boolean conectaConTodos(Comparable etiqueta) {
        Collection<TVertice> resultado = this.bea(etiqueta);

        if (resultado.size() == getVertices().size()) {
            return true;
        }
        return false;
    }
    @Override
    public boolean tieneCiclo() {
        return tieneCiclo((Comparable) getVertices().keySet().toArray()[0]);
    }
}
