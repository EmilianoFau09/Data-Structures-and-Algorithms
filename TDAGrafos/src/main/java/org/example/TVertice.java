package org.example;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


public class TVertice<T> implements IVertice {

    private Comparable etiqueta;
    private LinkedList<TAdyacencia> adyacentes;
    private boolean visitado;
    private T datos;
    private int bp_num;

    private int bajo_num = -1;

    private int v;

    private int visitadoIndex; //Variable para almacenar el indice de visita

    public void setVisitadoIndex(int visitadoIndex) {
        this.visitadoIndex = visitadoIndex;
    }

    public int getVisitadoIndex() {
        return this.visitadoIndex;
    }

    public Comparable getEtiqueta() {
        return etiqueta;
    }

    public LinkedList<TAdyacencia> getAdyacentes() {
        return adyacentes;
    }

    public T getDatos() {
        return datos;
    }

    public TVertice(Comparable unaEtiqueta) {
        this.etiqueta = unaEtiqueta;
        adyacentes = new LinkedList();
        visitado = false;
    }

    public void setVisitado(boolean valor) {
        this.visitado = valor;
    }

    public boolean getVisitado() {
        return this.visitado;
    }

    public int getBajo_num() {
        return bajo_num;
    }

    public int getBp_num() {
        return bp_num;
    }

    public int getV() {
        return v;
    }

    public void setBp_num(int bp_num) {
        this.bp_num = bp_num;
    }

    public void setV(int v) {
        this.v = v;
    }

    public void setBajo_num(int bajo_num) {
        this.bajo_num = bajo_num;
    }

    @Override
    public TAdyacencia buscarAdyacencia(TVertice verticeDestino) {
        if (verticeDestino != null) {
            return buscarAdyacencia(verticeDestino.getEtiqueta());
        }
        return null;
    }

    @Override
    public Double obtenerCostoAdyacencia(TVertice verticeDestino) {
        TAdyacencia ady = buscarAdyacencia(verticeDestino);
        if (ady != null) {
            return ady.getCosto();
        }
        return Double.MAX_VALUE;
    }

    @Override
    public boolean insertarAdyacencia(Double costo, TVertice verticeDestino) {
        if (buscarAdyacencia(verticeDestino) == null) {
            TAdyacencia ady = new TAdyacencia(costo, verticeDestino);
            return adyacentes.add(ady);
        }
        return false;
    }

    @Override
    public boolean eliminarAdyacencia(Comparable nomVerticeDestino) {
        TAdyacencia ady = buscarAdyacencia(nomVerticeDestino);
        if (ady != null) {
            adyacentes.remove(ady);
            return true;
        }
        return false;
    }

    @Override
    public TVertice primerAdyacente() {
        if (this.adyacentes.getFirst() != null) {
            return this.adyacentes.getFirst().getDestino();
        }
        return null;
    }


    @Override
    public TAdyacencia buscarAdyacencia(Comparable etiquetaDestino) {
        for (TAdyacencia adyacencia : adyacentes) {
            if (adyacencia.getDestino().getEtiqueta().compareTo(etiquetaDestino) == 0) {
                return adyacencia;
            }
        }
        return null;
    }

    public int obtenerGrado() {
        return getAdyacentes().size();
    }

    @Override
    public TCaminos todosLosCaminos(Comparable etVertDest, TCamino caminoPrevio, TCaminos todosLosCaminos) {
        this.setVisitado(true);
        for (TAdyacencia adyacencia : this.getAdyacentes()) {
            TVertice destino = adyacencia.getDestino();
            if (!destino.getVisitado()) {
                if (destino.getEtiqueta().compareTo(etVertDest) == 0) {
                    TCamino copia = caminoPrevio.copiar();
                    copia.agregarAdyacencia(adyacencia);
                    todosLosCaminos.getCaminos().add(copia);
                } else {
                    caminoPrevio.agregarAdyacencia(adyacencia);
                    destino.todosLosCaminos(etVertDest, caminoPrevio, todosLosCaminos);
                }
            }
        }
        this.setVisitado(false);
        return todosLosCaminos;
    }
  
    @Override
    public void bpf(Collection<TVertice> visitados) {
        setVisitado(true);
        visitados.add(this);
        for (TAdyacencia adyacente : adyacentes) {
            TVertice vertAdy = adyacente.getDestino();
            if (!vertAdy.getVisitado()) {
                vertAdy.bpf(visitados);
            }
        }
    }

    @Override
    public void bea(Collection<TVertice> visitados) {
        Queue<TVertice> cola = new LinkedList<>();
        this.setVisitado(true);
        cola.offer(this);
        visitados.add(this);
        while (!cola.isEmpty()){
            TVertice x = cola.remove();
            LinkedList<TAdyacencia> ady = x.getAdyacentes();
            for (TAdyacencia y : ady){
                TVertice vertAdy = y.getDestino();
                if (!vertAdy.getVisitado()){
                    vertAdy.setVisitado(true);
                    cola.offer(vertAdy);
                    visitados.add(vertAdy);
                }
            }
        }
    }

    @Override
    public TVertice siguienteAdyacente(TVertice w) {
        boolean encontramosW = false;
        for (TAdyacencia ad : getAdyacentes()) {
            TVertice vertice = ad.getDestino();
            if (encontramosW) {
                return vertice;
            }
            if (vertice.getEtiqueta().compareTo(w.getEtiqueta()) == 0) {
                encontramosW = true;
            }
        }
        return null;
    }

    @Override
    public boolean tieneCiclo(LinkedList<Comparable> camino) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int numBajo;
    public int numBp;
    public void ptoArt(LinkedList<TVertice> puntos, int[] cont) {
        this.visitado = true;
        cont[0]++;
        this.numBp = cont[0];
        this.numBajo = cont[0];
        int numHijos = 0;
        LinkedList<TVertice> hijos = new LinkedList<>();

        for (TAdyacencia adyacencia : this.getAdyacentes()) {
            TVertice adyacente = adyacencia.getDestino();

            if (!adyacente.visitado) {
                numHijos++;
                adyacente.ptoArt(puntos, cont);
                hijos.add(adyacente);
                this.numBajo = Math.min(this.numBajo, adyacente.numBajo);

                if (this.numBp <= adyacente.numBajo) {
                    puntos.add(this);
                }
            } else {
                this.numBajo = Math.min(this.numBajo, adyacente.numBp);
            }
        }

        if (numHijos > 1 && this.numBp == 1) {
            puntos.add(this);
        }
    }

    public int numBacon (String destino){
        Queue<TVertice> cola = new LinkedList<>();
        this.setVisitado(true);
        cola.offer(this);
        setBacon(0);
        while (!cola.isEmpty()) {
            TVertice x = cola.remove();
            LinkedList<TAdyacencia> ady = x.getAdyacentes();
            for (TAdyacencia y : ady){
                TVertice vertAdy = y.getDestino();
                if (!vertAdy.getVisitado()){
                    vertAdy.setVisitado(true);
                    vertAdy.setBacon(x.getBacon()+1);
                    if (vertAdy.getEtiqueta().equals(destino)){
                        return vertAdy.getBacon();
                    }
                    cola.offer(vertAdy);
                }
            }
        }
        return -1;
    }

    public LinkedList<TVertice> verticesPorNivel (){
        LinkedList<TVertice> listaVerticesOrdenadosNivel = new LinkedList<>();
        listaVerticesOrdenadosNivel.add(this);
        Queue<TVertice> cola = new LinkedList<>();
        this.setVisitado(true);
        cola.offer(this);
        setBacon(0);
        while (!cola.isEmpty()){
            TVertice x = cola.remove();
            LinkedList<TAdyacencia> ady = x.getAdyacentes();
            for (TAdyacencia y : ady){
                TVertice vertAdy = y.getDestino();
                if (!vertAdy.getVisitado()){
                    vertAdy.setVisitado(true);
                    vertAdy.setBacon(x.getBacon()+1);
                    listaVerticesOrdenadosNivel.add(vertAdy); // agrega vertices por nivel a la lista
                    cola.offer(vertAdy);
                }
            }
        }
        return listaVerticesOrdenadosNivel;
    }

    public void obtenerVerticesANivel(LinkedList<TVertice> verts, int nivel) {
        this.visitado = true;
        this.bp_num = 0;
        LinkedList<TVertice> cola = new LinkedList<>();
        cola.addLast(this);
        while (!cola.isEmpty()) {
            TVertice x = cola.getLast();
            cola.removeLast();
            if (x.getBp_num() == nivel) {
                verts.add(x);
                continue;
            }
            for (Object ad : x.getAdyacentes()) {
                TAdyacencia ady = (TAdyacencia) ad;
                TVertice y = ady.getDestino();
                if (!y.getVisitado()) {
                    y.setVisitado(true);
                    cola.addFirst(y);
                    y.setBp_num(x.getBp_num() + 1);
                }
            }

        }

    }

    public void ordenarBp(int[] nivel, LinkedList<TVertice> verticesOrdenadosPorBp) {
        this.setVisitado(true);
        nivel[0]++;
        this.bp_num = nivel[0];
        verticesOrdenadosPorBp.add(this);
        boolean b = true;
        for (TAdyacencia ady : adyacentes) {
            if (!ady.getDestino().getVisitado()) {
                ady.getDestino().ordenarBp(nivel, verticesOrdenadosPorBp);
            }
            verticesOrdenadosPorBp.add(new TVertice("Centinela"));
        }
    }

    public void ordenParcial(LinkedList<TVertice> verticesOrdenados) {
        this.setVisitado(true);
        LinkedList<TAdyacencia> ady = this.getAdyacentes();

        for (TAdyacencia adyacencia : ady) {
            TVertice adyacente = adyacencia.getDestino();
            if (!adyacente.getVisitado()) {
                adyacente.ordenParcial(verticesOrdenados);
            }
        }
        verticesOrdenados.addFirst(this);
    }

    public void buscarCamino(Comparable vDestino, TCamino camino) {
        this.visitado = true;
        LinkedList<TVertice> cola = new LinkedList<>();
        cola.addFirst(this);
        while (!cola.isEmpty()) {
            TVertice x = cola.getLast();
            cola.removeLast();
            for (Object ad : x.getAdyacentes()) {
                TAdyacencia ady = (TAdyacencia) ad;
                TVertice y = ady.getDestino();
                if (!y.getVisitado()) {
                    if (y.getEtiqueta().compareTo(vDestino) == 0) {
                        camino.agregarAdyacencia(ady);
                        cola.clear();
                        break;
                    }
                    y.setVisitado(true);
                    cola.addFirst(y);
                    camino.agregarAdyacencia(ady);
                }
            }
        }
    }

    public void calcularBajo(LinkedList<TVertice> puntosArticulacion) {
        int i = 123;
        int j = -1;
        for (TAdyacencia ady : this.getAdyacentes()) {
            // Revisamos que haya una arista de retroceso.
            if (ady.getDestino().getVisitado() && ady.getDestino().getBp_num() < this.bp_num) {
                i = ady.getDestino().getBp_num();
            } else if (!ady.getDestino().getVisitado()) {
                j = ady.getDestino().getBajo_num();
                if (j >= this.bp_num) {
                    puntosArticulacion.add(this);
                }
            }
            if (j > 0) {
                int minTemp = Integer.min(i, j);
                bajo_num = Integer.min(minTemp, this.bp_num);
            } else {
                bajo_num = Integer.min(i, this.bp_num);
            }
        }
    }

    public void clasificacionTopologica(LinkedList<TVertice> listaOrdenada) {
        this.setVisitado(true);

        for (TAdyacencia adyacencia : adyacentes) {
            TVertice verticeDestino = adyacencia.getDestino();
            if (!verticeDestino.getVisitado()) {
                verticeDestino.clasificacionTopologica(listaOrdenada);
            }
        }
        listaOrdenada.addFirst(this);
    }

    public int obtenerNivelDeVertice(Comparable destino) {
        this.visitado = true;
        this.bp_num = 0;
        LinkedList<TVertice> cola = new LinkedList<>();
        cola.addLast(this);
        while (!cola.isEmpty()) {
            TVertice x = cola.getLast();
            cola.removeLast();
            if (x.getEtiqueta() == destino) {
                return x.bp_num;
            }
            for (Object ad : x.getAdyacentes()) {
                TAdyacencia ady = (TAdyacencia) ad;
                TVertice y = ady.getDestino();
                if (!y.getVisitado()) {
                    y.setVisitado(true);
                    cola.addFirst(y);
                    y.setBp_num(x.getBp_num() + 1);
                }
            }
        }
        return -1;
    }
    public boolean tienePrecedesoresNoVisitados(Map<Comparable, Boolean> visitados) {
        for (TAdyacencia adyacencia : adyacentes) {
            TVertice origen = adyacencia.getDestino();
            if (!visitados.get(origen.getEtiqueta())) {
                return true;
            }
        }
        return false;
    }

    private int numBacon;
    public int getBacon() {
        return numBacon;
    }
    public void setBacon(int newBacon) {
        numBacon = newBacon;
    }

    public boolean conectadoA(Comparable etiquetaDestino) {
        if (this.getEtiqueta().equals(etiquetaDestino)) {
            return true;
        }
        this.setVisitado(true);
        for (TAdyacencia ady : adyacentes) {
            if (!ady.getDestino().getVisitado()) {
                if (ady.getDestino().conectadoA(etiquetaDestino)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void contieneCiclos(LinkedList<TVertice> visitados, int[] contador) {
        this.setVisitado(true);
        for(TAdyacencia ady : getAdyacentes()) {
            TVertice vertice = ady.getDestino();
            if(visitados.contains(vertice)) {
                contador[0]++;
            } else {
                visitados.add(vertice);
                vertice.getAdyacentes();
            }
        }
    }

    public void clasificarArcos(LinkedList<TArista> arcosArbol, LinkedList<TArista> arcosRetroceso, LinkedList<TArista> arcosAvance, LinkedList<TArista> arcosCruzados) {
        //Reiniciar el estadod e visitado de todas las aristas
        for (TAdyacencia a : this.getAdyacentes()) {
            a.getDestino().setVisitado(false);
        }

        // Clasificar aristas segun su tipo
        for (TAdyacencia adyacencia : this.getAdyacentes()) {
            TVertice ady = adyacencia.getDestino();
            TArista arista = new TArista(this.getEtiqueta(), ady.getEtiqueta(), adyacencia.getCosto());

            if (!adyacencia.getDestino().getVisitado()) {
                //Arcos de arbol
                arcosArbol.add(arista);
            } else {
                if (this.getVisitadoIndex() == ady.getVisitadoIndex()) {
                    //Arcos cruzados
                    arcosCruzados.add(arista);
                } else if (this.getVisitadoIndex() < ady.getVisitadoIndex()) {
                    //Arcos de avance
                    arcosAvance.add(arista);
                } else {
                    //Arcos de retroceso
                    arcosRetroceso.add(arista);
                }
            }
        }
    }

    public void conexionTotal(Collection<TVertice> visitados) {

        if (!this.getVisitado()) {
            visitado = true;
            visitados.add(this);
            for (TAdyacencia ady : this.adyacentes) {
                ady.getDestino().conexionTotal(visitados);
            }
        }
    }
}
