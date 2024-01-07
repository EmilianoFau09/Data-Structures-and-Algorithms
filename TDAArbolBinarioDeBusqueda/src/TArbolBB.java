import java.util.ArrayList;
import java.util.List;

public class TArbolBB<T> implements IArbolBB<T> {

    private TElementoAB<T> raiz;

    /**
     * Separador utilizado entre elemento y elemento al imprimir la lista
     */
    public static final String SEPARADOR_ELEMENTOS_IMPRESOS = "-";

    public TArbolBB() {
        raiz = null;
    }

    /**
     * @param unElemento
     * @return
     */

    public boolean insertar(TElementoAB<T> unElemento) {
        if (esVacio()) {
            raiz = unElemento;
            return true;
        } else {
            return raiz.insertar(unElemento);
        }
    }

    /**
     * @param unaEtiqueta
     * @return
     */
    @SuppressWarnings("unchecked")

    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (esVacio()) {
            return null;
        } else {
            return raiz.buscar(unaEtiqueta);
        }
    }


    @Override
    public String preOrden() {
        if (esVacio()) {
            return null;
        } else {
            return raiz.preOrden();
        }
    }

    /**
     * @return recorrida en inorden del arbol, null en caso de ser vacío
     */
    public String inOrden() {
        if (esVacio()) {
            return null;
        } else {
            return raiz.inOrden();
        }
    }

    @Override
    public String postOrden() {
        if (esVacio()) {
            return null;
        } else {
            return raiz.postOrden();
        }
    }

    /**
     * @return recorrida en preOrden del arbol, null en caso de ser vacío
     */
    /**
     * @return
     */
    public boolean esVacio() {
        return (raiz == null);
    }

    /**
     * @return True si habían elementos en el árbol, false en caso contrario
     */
    public boolean vaciar() {
        if (!esVacio()) {
            raiz = null;
            return true;
        }
        return false;
    }


    public int obtenerAltura() {
        if (raiz == null) {
            return -1;
        }
        return raiz.obtenerAltura() - 1;
    }

    public int obtenerTamanio() {
        if (raiz == null) {
            return 0;
        }
        return raiz.obtenerTamaño();
    }

    public int obtenerNivel(Comparable unaEtiqueta) {

        if (raiz == null) {
            return 0;
        }
        return raiz.obtenerNivel(unaEtiqueta);

    }

    public int obtenerCantidadHojas() {
        if (raiz == null) {
            return 0;
        }

        return raiz.obtenerCantidadHojas();

    }

    @Override
    public void eliminar(Comparable unaEtiqueta) {
        if (!esVacio()) {
            this.raiz = this.raiz.eliminar(unaEtiqueta);
        }
    }
    public String imprimir() {
        return raiz.imprimirElementos();
    }
    public TElementoAB<T> obtenerMenorClave() {
        if (raiz == null) {
            return null;
        }
        return raiz.obtenerMenorClave();
    }
    public TElementoAB<T> obtenerMayorClave() {
        if (raiz == null) {
            return null;
        }
        return raiz.obtenerMayorClave();
    }
    public TElementoAB<T> obtenerClaveInmediatamenteAnterior(Comparable unaEtiqueta) {
        if (raiz == null) {
            return null;
        }
        return raiz.obtenerClaveInmediatamenteAnterior(unaEtiqueta);
    }
    public int nodosEnNivel(int nivelBuscado) {
        if (raiz == null) {
            return 0;
        }
        return raiz.CantidadNodosEnNivel(nivelBuscado);
    }
    public List<String> listarHojasConNivel() {
        if (raiz == null) {
            return null;
        }
        List<String> lista = new ArrayList<>();
        int nivel = 0;
        return raiz.listarHojasConNivel(lista,nivel);
    }
    public boolean esArbolDeBusqueda() {
        if (raiz == null) {
            return false;
        }
        return raiz.esArbolDeBusqueda();
    }
    public ArrayList<T> listar() {
        if (raiz != null){
            ArrayList<T> array = new ArrayList<>();
            raiz.listar(array);
            return array;
        }else{
            return null;
        }
    }
    /* Arma un arbol a partir de un parametro
    public void indizar(TArbolBB indice, Comparable laCarrera) {
        Alumno alumno = (Alumno) this.getDatos();
        if (alumno.getCarrera().equals(laCarrera)){
            indice.insertar(new TNodoAlumnoAB(alumno.getApellido(),alumno));
        }
        if (this.getHijoIzq() != null) {
            this.getHijoIzq().indizar(indice,laCarrera);
        }
        if (this.getHijoDer() != null) {
            this.getHijoDer().indizar(indice,laCarrera);
        }
    }*/
    public TElementoAB inmediatamenteAnterior(Comparable clave){
        if (raiz != null){
            return raiz.inmediatamenteAnterior(clave);
        }else{
            return null;
        }
    }
    public int sumaMismoNivel(int nivel){
        if (raiz != null){
            int suma = 0;
            return raiz.sumaMismoNivel(nivel,suma);
        }else{
            return 0;
        }
    }

    public int enQueNivelEstaUnNodo(Comparable etiqueta){
        if (!esVacio()){
            int contador = 0;
            return raiz.enQueNivelEstaUnNodo(etiqueta,contador);
        }
        return -1;
    }

    public List<TElementoAB> obtenerNodosEnRango(Comparable rangoMin, Comparable rangoMax) {
        List<TElementoAB> nodosEnRango = new ArrayList<>();
        if (raiz != null){
            raiz.obtenerNodosEnRango(rangoMin, rangoMax, nodosEnRango);
            return nodosEnRango;
        }
        return null;
    }

    public boolean esIdentico(TArbolBB otroArbol){
        if (raiz == null){
            return false;
        }else {
            return raiz.esIdentico(otroArbol.raiz);
        }
    }

    public int menoresQue (Comparable unaclave){
        if (raiz != null){
            return raiz.menoresQue(unaclave);
        }
        return -1;
    }

    public String imprimirRango (Comparable inferior,Comparable superior){
        if (raiz != null){
            return raiz.imprimirRango(inferior,superior);
        }else {
            return null;
        }
    }
}
