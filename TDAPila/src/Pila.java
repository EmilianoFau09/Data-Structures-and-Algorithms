import java.lang.reflect.Array;
import java.util.ArrayList;

public class Pila<T> extends Lista<T>{

    public Nodo pop() {
        if (esVacia()) {
            return null;
        }
        if (getPrimero().getSiguiente() == null) {
            Nodo<T> valor = getPrimero();
            setPrimero(null);
            setUltimo(null);
            return valor;
        }
        Nodo<T> actual = getPrimero();
        while (actual.getSiguiente().getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
        Nodo<T> valor = actual.getSiguiente();
        actual.setSiguiente(null);
        setUltimo(actual);
        return valor;
    }

    public void push(Nodo nodo){
        insertar(nodo);
    }

    public boolean isEmpty(){
        return esVacia();
    }

    public Nodo peek(){
        if (esVacia()) {
            return null;
        }
        if (getPrimero().getSiguiente() == null) {
            Nodo valor = getPrimero();
            return valor;
        }
        Nodo<T> actual = getPrimero();
        while (actual.getSiguiente().getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
        Nodo valor = actual.getSiguiente();
        return valor;
    }
    public int size(){
        return cantElementos();
    }
    public void clear(){
        setPrimero(null);
    }
    public int search(Comparable etiqueta){
        int contador = 0;
        boolean b = false;
        Nodo<T> actual = getPrimero();
        while (actual != null) {
            if (buscar(etiqueta) != null){
                b = true;
            }
            if (b){
                contador++;
            }
            actual = actual.getSiguiente();
        }
        return contador;
    }

    public ArrayList toArray(){
        ArrayList a = new ArrayList(size());
        Nodo<T> actual = getPrimero();
        while (actual != null) {
            a.add(actual);
            actual = actual.getSiguiente();
        }
        return a;
    }
}
