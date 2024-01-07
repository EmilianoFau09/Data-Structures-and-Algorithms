import java.util.ArrayList;
import java.util.List;

public class TElementoAB<T> implements IElementoAB<T> {

    private Comparable etiqueta;
    private TElementoAB<T> hijoIzq;
    private TElementoAB<T> hijoDer;
    private T datos;

    /**
     * @param unaEtiqueta
     * @param unosDatos
     */
    @SuppressWarnings("unchecked")
    public TElementoAB(Comparable unaEtiqueta, T unosDatos) {
        etiqueta = unaEtiqueta;
        datos = unosDatos;
    }

    public TElementoAB<T> getHijoIzq() {
        return hijoIzq;
    }

    public TElementoAB<T> getHijoDer() {
        return hijoDer;
    }

    /**
     * @param unElemento
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    // suponemos etiquetas como strings, si son ints es mejor sustituir el compareTo por una resta, sino no distinguira algunas cifras
    public boolean insertar(TElementoAB<T> unElemento) {
        if (etiqueta == unElemento.etiqueta){
            return false;
        }
        else if (unElemento.getEtiqueta().compareTo(etiqueta) < 0) {
            if (hijoIzq == null) {
                hijoIzq = unElemento;
                return true;
            } else {
                return getHijoIzq().insertar(unElemento);
            }
        }
        else {
            if (hijoDer == null) {
                hijoDer = unElemento;
                return true;
            } else {
                return getHijoDer().insertar(unElemento);
            }
        }
    }


    /**
     * @param unaEtiqueta
     * @return
     */
    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (unaEtiqueta.compareTo(etiqueta) == 0) {
            return this;
        } else if (unaEtiqueta.compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().buscar(unaEtiqueta);
            } else {
                return null;
            }
        } else if (unaEtiqueta.compareTo(etiqueta) > 0) {
            if (hijoDer != null) {
                return getHijoDer().buscar(unaEtiqueta);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }


    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    /**
     * @return
     */
    public String imprimir() {
        return (etiqueta.toString());
    }

    @Override
    public T getDatos() {
        return datos;
    }

    @Override
    public void setHijoIzq(TElementoAB<T> elemento) {
        this.hijoIzq = elemento;

    }

    @Override
    public void setHijoDer(TElementoAB<T> elemento) {
        this.hijoDer = elemento;
    }


    public int obtenerAltura() {
        int alturaIzq = 0;
        int alturaDer = 0;
        if (this == null) {
            return 0;
        }
        if (this.getHijoIzq() != null) {
            alturaIzq = this.getHijoIzq().obtenerAltura();
        }
        if (this.getHijoDer() != null) {
            alturaDer = this.getHijoDer().obtenerAltura();
        }

        return 1 + Math.max(alturaIzq, alturaDer);

    }

    public int obtenerTamaño() {
        int tamanoIzq = 0;
        int tamanoDer = 0;
        //para obtener el tamaño de un nodo, se debe tener el tamaño de sus hijos + 1
        //entonces se debe recorrer en post orden(hijoIzq, hijoDer, padre)

        if (this.getHijoIzq() != null) {
            tamanoIzq = this.getHijoIzq().obtenerTamaño();
        }

        if (this.getHijoDer() != null) {
            tamanoDer = this.getHijoDer().obtenerTamaño();
        }

        return tamanoIzq + tamanoDer + 1;
    }

    public int obtenerNivel(Comparable unaEtiqueta) {

        if (unaEtiqueta.equals(etiqueta)) {
            return 0;
        } else if (unaEtiqueta.compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return 1 + getHijoIzq().obtenerNivel(unaEtiqueta);
            } else {
                return 0;
            }
        } else if (hijoDer != null) {
            return 1 + getHijoDer().obtenerNivel(unaEtiqueta);
        } else {
            return 0;
        }

    }

    public int obtenerCantidadHojas() {
        //recorrer postorden
        int cantidad = 0;
        if (this.getHijoIzq() != null) {
            cantidad += this.getHijoIzq().obtenerCantidadHojas();
        }

        if (this.getHijoDer() != null) {
            cantidad += this.getHijoDer().obtenerCantidadHojas();
        }
        if (this.getHijoIzq() == null && this.getHijoDer() == null){
            cantidad = 1;
        }
        return cantidad;

    }

    @Override
    public TElementoAB eliminar(Comparable unaEtiqueta) {

        if (unaEtiqueta.compareTo(this.getEtiqueta()) < 0) {

            if (this.getHijoIzq() != null) {

                this.setHijoIzq(this.getHijoIzq().eliminar(unaEtiqueta));

            }
            return this;
        }
        if (unaEtiqueta.compareTo(this.getEtiqueta()) > 0) {

            if (this.getHijoDer() != null) {

                this.setHijoDer(this.getHijoDer().eliminar(unaEtiqueta));

            }
            return this;
        }

        return this.quitaElNodo();
    }

    private TElementoAB<T> quitaElNodo() {

        if (this.getHijoIzq() == null) {

            return this.getHijoDer();

        }

        if (this.getHijoDer() == null) {
            return this.getHijoIzq();
        }

        // es un nodo completo

        TElementoAB<T> hijo = this.getHijoIzq();
        TElementoAB<T> padre = this;

        while (hijo.getHijoDer() != null) {
            padre = hijo;
            hijo = hijo.getHijoDer();
        }

        if (padre != this) {
            padre.setHijoDer(hijo.getHijoIzq());
            hijo.setHijoIzq(hijoIzq);
        }

        hijo.setHijoDer(hijoDer);
        return hijo;

    }

    @Override
    public String preOrden() {
        // padre, hijoIzq y hijoDer
        StringBuilder sb = new StringBuilder("");

        sb.append(this.imprimir() + "-");
        if (this.getHijoIzq() != null) {
            sb.append(this.getHijoIzq().preOrden());
        }
        if (this.getHijoDer() != null) {
            sb.append(this.getHijoDer().preOrden());
        }
        return sb.toString();
    }

    @Override
    public String inOrden() {
        // hijoIzq, padre y hijoDer
        StringBuilder sb = new StringBuilder("");

        if (this.getHijoIzq() != null) {
            sb.append(this.getHijoIzq().inOrden());
        }
        sb.append(this.imprimir() + "-");
        if (this.getHijoDer() != null) {
            sb.append(this.getHijoDer().inOrden());
        }
        return sb.toString();
    }

    @Override
    public String postOrden() {
        // hijoIzq, hijoDer y padre
        StringBuilder sb = new StringBuilder("");

        if (this.getHijoIzq() != null) {
            sb.append(this.getHijoIzq().postOrden());
        }
        if (this.getHijoDer() != null) {
            sb.append(this.getHijoDer().postOrden());
        }
        sb.append(this.imprimir() + "-");
        return sb.toString();
    }

    public String imprimirElementos() {
        String datos = "";

        if (this.getHijoIzq() != null) {
            datos += this.getHijoIzq().imprimirElementos();
        }
        datos += this.datos.toString() + "\n";
        if (this.getHijoDer() != null) {
            datos += this.getHijoDer().imprimirElementos();
        }
        return datos;
    }
    public TElementoAB<T> obtenerMenorClave() {
        if (this.getHijoIzq() != null) {
            return this.getHijoIzq().obtenerMenorClave();
        }
        return this;
    }

    public TElementoAB<T> obtenerMayorClave() {
        if (this.getHijoDer() != null) {
            return this.getHijoDer().obtenerMayorClave();
        }
        return this;
    }

    public TElementoAB<T> obtenerClaveInmediatamenteAnterior(Comparable unaEtiqueta) {
        if (etiqueta == null) {
            return null;
        }
        if (unaEtiqueta.compareTo(etiqueta) == 0) {
            if (getHijoIzq() != null) {
                return getHijoIzq().obtenerMayorClave();
            } else {
                return null;
            }
        } else if (unaEtiqueta.compareTo(etiqueta) < 0) {
            if (getHijoIzq() != null) {
                return getHijoIzq().obtenerClaveInmediatamenteAnterior(unaEtiqueta);
            } else {
                return null;
            }
        } else {
            if (getHijoDer() != null) {
                TElementoAB<T> temp = getHijoDer().obtenerClaveInmediatamenteAnterior(unaEtiqueta);
                if (temp == null) {
                    return this;
                } else {
                    return temp;
                }
            } else {
                return this;
            }
        }
    }

    public int CantidadNodosEnNivel(int nivelBuscado) {
        int cantidadIzquierda = 0;
        int cantidadDerecha = 0;
        if (this == null) {
            return 0;
        }
        if (nivelBuscado == 0) {
            return 1;
        }
        if (this.getHijoIzq() != null) {
            cantidadIzquierda = this.getHijoIzq().CantidadNodosEnNivel(nivelBuscado - 1);
        }
        if (this.getHijoDer() != null) {
            cantidadDerecha = this.getHijoDer().CantidadNodosEnNivel(nivelBuscado - 1);
        }
        return cantidadIzquierda + cantidadDerecha;
    }

    public List<String> listarHojasConNivel(List<String> lista, int nivel) {
        if ((this.getHijoIzq() == null) && (this.getHijoDer() == null)) {
            lista.add("Hoja: " + this.getEtiqueta() + " - Nivel: " + nivel);
        } else {
            if (this.getHijoIzq() != null) {
                this.getHijoIzq().listarHojasConNivel(lista, nivel + 1);
            }
            if (this.getHijoDer() != null) {
                this.getHijoDer().listarHojasConNivel(lista, nivel + 1);
            }
        }
        return lista;
    }

    public boolean esArbolDeBusqueda() {
        if (this.getHijoIzq() != null) {
            if (this.getEtiqueta().compareTo(this.getHijoIzq().getEtiqueta()) <= 0){
                return false;
            }
            if (!this.getHijoIzq().esArbolDeBusqueda()) {
                return false;
            }
        }
        if (this.getHijoDer() != null) {
            if (this.getEtiqueta().compareTo(this.getHijoDer().getEtiqueta()) >= 0){
                return false;
            }
            if (!this.getHijoDer().esArbolDeBusqueda()) {
                return false;
            }
        }
        return true;
    }
    public void listar(ArrayList<T> unArrayList) {
        if (this.getDatos().toString() == "true"){ // un parametro para listar por ese
            unArrayList.add((T) this);
        }
        if (this.getHijoIzq() != null) {
            this.getHijoIzq().listar(unArrayList);
        }
        if (this.getHijoDer() != null) {
            this.getHijoDer().listar(unArrayList);
        }
    }

    /*public TArbolBBU armarIndiceCarrera(Comparable laCarrera) {
        if (raiz != null){
            TArbolBBU a = new TArbolBBU();
            raiz.indizar(a,laCarrera);
            return a;
        }else{
            return null;
        }
    }*/
    public TElementoAB inmediatamenteAnterior(Comparable clave){
        if (this == null){
            return null;
        }
        if (this.etiqueta == clave){
            TElementoAB nodoAnterior;
            if (this.hijoIzq != null){
                nodoAnterior = this.hijoIzq;
                while (nodoAnterior.hijoDer != null){
                    nodoAnterior = nodoAnterior.hijoDer;
                }
                return nodoAnterior;
            }else{
                return this;
            }
        }
        if (this.hijoIzq != null && clave.compareTo(this.etiqueta) < 0) {
            return this.hijoIzq.inmediatamenteAnterior(clave);
        }
        if (this.hijoDer != null && clave.compareTo(this.etiqueta) > 0) {
            return this.hijoDer.inmediatamenteAnterior(clave);
        }
        return null;
    }

    public int sumaMismoNivel(int nivel, int suma){
        if (nivel == 0){
            suma = suma + Integer.parseInt(this.etiqueta.toString());
        }
        if (nivel < 0){
            return suma;
        }
        if (this.hijoIzq != null){
            suma = this.hijoIzq.sumaMismoNivel(nivel-1,suma);
        }
        if (this.hijoDer != null){
            suma = this.hijoDer.sumaMismoNivel(nivel-1,suma);
        }
        return suma;
    }

    public int enQueNivelEstaUnNodo(Comparable unaEtiqueta, int contador) {
        if (unaEtiqueta.compareTo(etiqueta) == 0) {
            return contador;
        } else if (unaEtiqueta.compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().enQueNivelEstaUnNodo(unaEtiqueta, contador+1);
            } else {
                contador = -1;
            }
        } else if (unaEtiqueta.compareTo(etiqueta) > 0) {
            if (hijoDer != null) {
                return getHijoDer().enQueNivelEstaUnNodo(unaEtiqueta, contador+1);
            } else {
                contador = -1;
            }
        } else {
            contador = -1;
        }
        return contador;
    }



    public void obtenerNodosEnRango(Comparable rangoMin, Comparable rangoMax, List<TElementoAB> nodosEnRango) {
        TElementoAB nodoActual = this;
        if (nodoActual == null) {
            return;
        }
        if (nodoActual.getEtiqueta().compareTo(rangoMin) < 0) {
            nodoActual.getHijoDer().obtenerNodosEnRango(rangoMin, rangoMax, nodosEnRango);
        } else if (nodoActual.getEtiqueta().compareTo(rangoMax) > 0) {
            nodoActual.getHijoIzq().obtenerNodosEnRango(rangoMin, rangoMax, nodosEnRango);
        } else {
            nodosEnRango.add(nodoActual);
            nodoActual.getHijoIzq().obtenerNodosEnRango(rangoMin, rangoMax, nodosEnRango);
            nodoActual.getHijoDer().obtenerNodosEnRango(rangoMin, rangoMax, nodosEnRango);
        }
    }

    public boolean esIdentico(TElementoAB otroArbol){
        if (this == null && otroArbol == null){
            return true;
        }
        if (this == null || otroArbol == null){
            return false;
        }
        if (!this.equals(otroArbol)){
            return false;
        }
        return this.getHijoIzq().esIdentico(otroArbol.getHijoIzq()) && this.getHijoDer().esIdentico(otroArbol.getHijoDer());
    }


    public int menoresQue(Comparable unaclave) {
        int contador = 0;
        if (this.etiqueta == unaclave) {
            if (this.getHijoIzq() != null) {
                contador += this.getHijoIzq().menoresQue(unaclave);
            }
            if (this.getHijoDer() != null) {
                contador += this.getHijoDer().menoresQue(unaclave);
            }
        } else if (this.etiqueta.compareTo(unaclave) < 0) {
            contador += 1;
            if (this.getHijoIzq() != null) {
                contador += this.getHijoIzq().menoresQue(unaclave);
            }
            if (this.getHijoDer() != null) {
                contador += this.getHijoDer().menoresQue(unaclave);
            }
        } else {
            if (this.getHijoIzq() != null) {
                contador += this.getHijoIzq().menoresQue(unaclave);
            }
            if (this.getHijoDer() != null) {
                contador += this.getHijoDer().menoresQue(unaclave);
            }
        }
        return contador;
    }

    public String imprimirRango(Comparable inferior, Comparable superior) {
        String string = "";
        if (this.getEtiqueta().compareTo(inferior) >= 0 || this.getEtiqueta().compareTo(superior) <= 0){
            string += (this.getEtiqueta()+"");
        }
        if (this.getHijoIzq() != null){
            string += this.getHijoIzq().imprimirRango(inferior,superior);
        }
        if (this.getHijoDer() != null){
            string += this.getHijoDer().imprimirRango(inferior,superior);
        }
        return string;
    }
}
