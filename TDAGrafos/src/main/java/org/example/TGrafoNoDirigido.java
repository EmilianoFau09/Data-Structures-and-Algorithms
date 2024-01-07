package org.example;

import java.util.*;

public class TGrafoNoDirigido extends TGrafoDirigido implements IGrafoNoDirigido {

    protected TAristas lasAristas = new TAristas();

    /**
     *
     * @param vertices
     * @param aristas
     */
    public TGrafoNoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        super(vertices, aristas);
        lasAristas.insertarAmbosSentidos(aristas);

    }

    @Override
    public boolean insertarArista(TArista arista) {
        boolean tempbool = false;
        TArista arInv = new TArista(arista.getEtiquetaDestino(), arista.getEtiquetaOrigen(), arista.getCosto());
        tempbool = (super.insertarArista(arista) && super.insertarArista(arInv));
        return tempbool;
    }

    public TAristas getLasAristas() {
        return lasAristas;
    }

    @Override
    public TGrafoNoDirigido Prim() {
        LinkedList<TArista> aristas = Prim2();
        Collection<TVertice> v = getVertices().values();
        TGrafoNoDirigido gnd = new TGrafoNoDirigido(v,aristas);
        return gnd;
    }

    public LinkedList<TArista> Prim2(){
        Set<TVertice> V = new HashSet<>(this.getVertices().values());
        LinkedList<TArista> T = new LinkedList<>();
        Set<TVertice> U = new HashSet<>();
        for (TVertice v : getVertices().values()){
            U.add(v);
            break;
        }
        while (U.size() != V.size()){
            double menor = Double.MAX_VALUE;
            TArista aristaMenorCosto = null;
            LinkedList<TArista> todasLasAristas = this.getAristas();
            for (TArista a : todasLasAristas){
                Set<TVertice> diferencia = new HashSet<>(V);
                diferencia.removeAll(U);
                TVertice verticeOrigen = buscarVertice(a.etiquetaOrigen);
                TVertice verticeDestino = buscarVertice(a.etiquetaDestino);
                if (U.contains(verticeOrigen) && diferencia.contains(verticeDestino) && a.getCosto() < menor && !T.contains(a)){
                    menor = a.getCosto();
                    aristaMenorCosto = a;
                }
            }
            T.add(aristaMenorCosto);
            TVertice ver = buscarVertice(aristaMenorCosto.etiquetaDestino);
            U.add(ver);
        }
        return T;
    }

    @Override
    public TGrafoNoDirigido Kruskal() {
        LinkedList<TArista> aristas = Kruskal2();
        Collection<TVertice> v = getVertices().values();
        TGrafoNoDirigido gnd = new TGrafoNoDirigido(v,aristas);
        return gnd;
    }

    public LinkedList<TArista> Kruskal2(){
        Set<TVertice> V = new HashSet<>(this.getVertices().values());
        LinkedList<TArista> T = new LinkedList<>();
        Set<TVertice> U = new HashSet<>();

        // Agregar un vértice inicial arbitrario a U
        TVertice primerVertice = getVertices().values().iterator().next();
        U.add(primerVertice);

        while (U.size() != V.size()) {
            double menor = Double.MAX_VALUE;
            TArista aristaMenorCosto = null;
            LinkedList<TArista> todasLasAristas = this.getAristas();

            for (TArista a : todasLasAristas) {
                // Comprobar si la arista conecta un vértice en U y otro en V-U
                TVertice verticeOrigen = buscarVertice(a.etiquetaOrigen);
                TVertice verticeDestino = buscarVertice(a.etiquetaDestino);

                boolean conectaUV = U.contains(verticeOrigen) && !U.contains(verticeDestino);
                boolean conectaVU = U.contains(verticeDestino) && !U.contains(verticeOrigen);

                if ((conectaUV || conectaVU) && a.getCosto() < menor && !T.contains(a)) {
                    menor = a.getCosto();
                    aristaMenorCosto = a;
                }
            }

            if (aristaMenorCosto != null) {
                T.add(aristaMenorCosto);
                TVertice ver = buscarVertice(aristaMenorCosto.etiquetaDestino);
                U.add(ver);
            }
        }

        return T;
    }

    public TGrafoNoDirigido Kruskal3() {
        TGrafoNoDirigido AAM = new TGrafoNoDirigido(getVertices().values(),new TAristas());
        var aristasDesordenadas = lasAristas;
        aristasDesordenadas.sort((TArista a1, TArista a2) -> {
            if (a1.costo < a2.costo){
                return -1;
            } else if(a1.costo > a2.costo){
                return 1;
            } else{
                return 0;
            }
        });;
        TAristas aristasOrdenadas = new TAristas();
        aristasOrdenadas.addAll(aristasDesordenadas);
        int aristasAgregadas = 0;

        while (aristasAgregadas != getVertices().size() - 1){
            TArista aristaMin = aristasOrdenadas.removeFirst();
            TVertice verticeOrigen = AAM.getVertices().get(aristaMin.getEtiquetaOrigen());
            TVertice verticeDestino = AAM.getVertices().get(aristaMin.getEtiquetaDestino());
            if (!AAM.estanConectados(verticeOrigen.getEtiqueta(), verticeDestino.getEtiqueta())){
                AAM.insertarArista(aristaMin);
                AAM.getLasAristas().add(aristaMin);
                AAM.getLasAristas().add(aristaMin.aristaInversa());
                aristasAgregadas++;
            }
        }
        return AAM;
    }

    private boolean estanConectados(Comparable etiqueta, Comparable etiqueta1) {
        TVertice v = buscarVertice(etiqueta);
        if (v.buscarAdyacencia(etiqueta1) != null){
            return true;
        }
        return false;
    }

    public TGrafoNoDirigido Prim3() {
        Collection<Comparable> V = new ArrayList<>();
        Collection<Comparable> U = new ArrayList<>();
        Collection<TArista> AristasAAM = new ArrayList<>();
        double costoPrim = 0;

        for (TVertice vertice : this.getVertices().values()) {
            V.add(vertice.getEtiqueta());
        }

        U.add(V.iterator().next());
        V.remove(V.iterator().next());

        while (V.size() != 0) {
            TArista tempArista = this.lasAristas.buscarMin(U, V);
            AristasAAM.add(tempArista);
            V.remove(tempArista.getEtiquetaDestino());
            U.add(tempArista.getEtiquetaDestino());
            costoPrim = costoPrim + tempArista.getCosto();
        }

        Collection<TVertice> VerticesSeleccionados = new ArrayList<>();

        for (Comparable vertice : U) {
            VerticesSeleccionados.add(new TVertice(vertice));
        }

        return new TGrafoNoDirigido(VerticesSeleccionados, AristasAAM);
    }

    public TCamino buscarCamino(Comparable vOrigen, Comparable vDestino) {
        if (vOrigen != null && vDestino != null) {
            TGrafoNoDirigido a = this.Prim();
            desvisitarVertices();
            TVertice v = this.getVertices().get(vOrigen);
            TCamino camino = new TCamino(v);
            a.getVertices().values().iterator().next().buscarCamino(vDestino, camino);
            return camino;
        }
        return null;
    }

    @Override
    public Collection<TVertice> bea(Comparable etiquetaOrigen) {
        desvisitarVertices();
        Collection<TVertice> resultado = new ArrayList(this.getVertices().size());
        TVertice origen = this.buscarVertice(etiquetaOrigen);
        origen.bea(resultado);
        return resultado;
    }

    public Collection<TVertice> bea(TVertice verticeOrigen) {
        desvisitarVertices();
        Collection<TVertice> resultado = new ArrayList(this.getVertices().size());
        verticeOrigen.bea(resultado);
        return resultado;
    }

    public Collection<TVertice> bea() {
        desvisitarVertices();
        Collection<TVertice> resultado = new ArrayList(this.getVertices().size());
        Iterator var2 = this.getVertices().values().iterator();

        while(var2.hasNext()) {
            TVertice vertice = (TVertice)var2.next();
            if (!vertice.getVisitado()) {
                Collection<TVertice> v = new ArrayList(this.getVertices().size());
                vertice.bea(v);
                resultado.addAll(v);
            }
        }

        return resultado;
    }

    public LinkedList<TVertice> ptoArt(){
        desvisitarVertices();
        LinkedList<TVertice> puntos = new LinkedList<>();
        int[] cont = new int[1];
        for (TVertice v : getVertices().values()){
            if (!v.getVisitado()){
                v.ptoArt(puntos,cont);
            }
        }
        LinkedList<TVertice> sinRepetidos = new LinkedList<>();
        for (TVertice v : puntos){
            if (!sinRepetidos.contains(v)){
                sinRepetidos.add(v);
            }
        }
        return sinRepetidos;
    }
    public int numBacon(Comparable verticeAComparar, Comparable otroVertice) {
        desvisitarVertices();
        TVertice v = buscarVertice(verticeAComparar);
        if (v != null){
            return v.numBacon(otroVertice.toString());
        }
        return -1;
    }

    public boolean conectados(Comparable origen, Comparable destino){
        desvisitarVertices();
        TVertice ver = buscarVertice(origen);
        LinkedList<TVertice> vertices = new LinkedList<>();
        if (ver != null){
            ver.bpf(vertices);
            for (TVertice vert : vertices){
                if (vert.getEtiqueta().equals(destino)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean conectados2(Comparable origen, Comparable destino) {
        desvisitarVertices();
        TVertice ver = buscarVertice(origen);
        if (ver != null) {
            return ver.conectadoA(destino);
        }
        return false;
    }

    public LinkedList<TVertice> vertPorNivel(Comparable verticeAComparar) {
        desvisitarVertices();
        TVertice v = buscarVertice(verticeAComparar);
        if (v != null){
            return v.verticesPorNivel();
        }
        return null;
    }

    public int obtenerNivelDeVertice(TVertice origen, TVertice destino) {
        if (!this.getVertices().containsKey(origen.getEtiqueta())) {
            return -1;
        }
        desvisitarVertices();
        TVertice v = this.getVertices().get(origen.getEtiqueta());
        return v.obtenerNivelDeVertice(destino.getEtiqueta());

    }
    public LinkedList<TVertice> obtenerVerticesANivel(TVertice origen, int nivel) {
        LinkedList<TVertice> verts = new LinkedList<>();
        origen.obtenerVerticesANivel(verts, nivel);
        return verts;
    }
    public Map<Integer, LinkedList<TVertice>> listarHastaNivel (int nivel, TVertice inicio){
        Map<Integer, LinkedList<TVertice>> mapa = new HashMap<>();

        for (int i=0; i <= nivel; i++){
            System.out.println("--------------------"+i+"--------------------");
            desvisitarVertices();
            LinkedList<TVertice> lista = this.obtenerVerticesANivel(inicio, i);
            for( TVertice a : lista){
                System.out.println(a.getEtiqueta());
            }
            mapa.put(i, lista);
        }

        return mapa;
    }
}
