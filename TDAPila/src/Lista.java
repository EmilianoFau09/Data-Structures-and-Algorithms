public class Lista<T> implements ILista<T> {

    private Nodo<T> primero;
    private Nodo<T> ultimo;

    public Lista() {
        primero = null;
    }

    @Override
    public void insertar(Nodo<T> nodo) {
        if (esVacia()){
            primero = nodo;
        }else{
            Nodo<T> aux = primero;
            while (aux.getSiguiente() != null){
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nodo);
        }
        ultimo = nodo;
    }

    @Override
    public void insertar(Comparable etiqueta, T dato) {
        insertar(new Nodo<>(etiqueta,dato));
    }

    @Override
    public Nodo<T> buscar(Comparable clave) {
        if (esVacia()){
            return null;
        }
        Nodo<T> aux = primero;
        while (aux != null){
            if (aux.getEtiqueta().equals(clave)){
                return aux;
            }
            aux = aux.getSiguiente();
        }
        return null;
    }

    @Override
    public boolean eliminar(Comparable clave) {
        if (esVacia()) {
            return false;
        }
        Nodo aux = primero;
        Nodo ant = null;
        while (aux != null) {
            if (aux.getEtiqueta().equals(clave)) {
                if (ant == null) {
                    primero = aux.getSiguiente();
                } else {
                    ant.setSiguiente(aux.getSiguiente());
                }
                return true;
            }
            ant = aux;
            aux = aux.getSiguiente();
        }
        return false;
    }

    @Override
    public String imprimir() {
        String str = "";
        if (esVacia()){
            return null;
        }else{
            Nodo<T> aux = primero;
            while (aux != null){
                T dato = aux.getDato();
                str += dato.toString() + "\n";
                aux = aux.getSiguiente();
            }
        }
        return str;
    }

    @Override
    public String imprimir(String separador) {
        String str = "";
        if (esVacia()){
            return null;
        }else{
            Nodo<T> aux = primero;
            while (aux != null){
                T dato = aux.getDato();
                str += dato.toString() + separador;
                aux = aux.getSiguiente();
            }
        }
        return str;
    }

    @Override
    public int cantElementos() {
        int i = 0;
        if (esVacia()){
            return 0;
        }else{
            Nodo<T> aux = primero;
            while (aux != null){
                i++;
                aux = aux.getSiguiente();
            }
        }
        return i;
    }

    @Override
    public boolean esVacia() {
        return primero==null;
    }

    @Override
    public void setPrimero(Nodo<T> unNodo) {
        this.primero = unNodo;
    }

    public Nodo<T> getPrimero() {
        return primero;
    }

    public Nodo<T> getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodo<T> ultimo) {
        this.ultimo = ultimo;
    }
}
