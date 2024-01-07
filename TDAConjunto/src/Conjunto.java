public class Conjunto<T> implements IConjunto{
    private Nodo<T> primero;
    private Nodo<T> ultimo;
    private int cantidadElementos;
    public Conjunto() {
        primero = null;
        cantidadElementos = 0;
    }

    @Override
    public Nodo obtenerPrimerNodo() {
        return primero;
    }


    @Override
    public void insertar(Nodo nodo) {
        if (esVacia()) {
            cantidadElementos++;
            primero = nodo;
            ultimo = nodo;
        } else {
            if (buscar(nodo.getEtiqueta()) == null){
                cantidadElementos++;
                ultimo.setSiguiente(nodo);
                ultimo = nodo;
            }else {
                System.out.println("No se pudo insertar el elemento " + nodo.getEtiqueta() + " ya que esta repetido\n");
            }
        }
    }
    public void insertar(Comparable etiqueta, Object dato){
        insertar(new Nodo(etiqueta,dato));
    }

    @Override
    public Nodo buscar(Comparable clave) {
        if (esVacia()) {
            return null;
        }
        Nodo<T> aux = primero;
        while (aux != null) {
            if (aux.getEtiqueta().equals(clave)) {
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
        if (esVacia()) {
            return null;
        } else {
            Nodo<T> aux = primero;
            while (aux != null) {
                T dato = aux.getDato();
                str += "Dato: " + dato.toString() + "\n";
                aux = aux.getSiguiente();
            }
        }
        return str;
    }

    @Override
    public String imprimir(String separador) {
        String str = "";
        if (esVacia()) {
            return null;
        } else {
            Nodo<T> aux = primero;
            while (aux != null) {
                T dato = aux.getDato();
                str += dato.toString() + separador;
                aux = aux.getSiguiente();
            }
        }
        return str;
    }

    @Override
    public int cantElementos() {
        return cantidadElementos;
    }

    @Override
    public boolean esVacia() {
        return primero == null;
    }

    @Override
    public void setPrimero(Nodo unNodo) {

    }
    @Override
    public IConjunto union(IConjunto otroConjunto) {
        Conjunto<T> conjuntoAux = new Conjunto<>();
        Nodo<T> aux = primero;
        while (aux != null) {
            conjuntoAux.insertar(new Nodo<T>(aux.getEtiqueta(), aux.getDato()));
            aux = aux.getSiguiente();
        }

        Nodo<T> aux1 = otroConjunto.obtenerPrimerNodo();
        while (aux1 != null) {
            if (buscar(aux1.getEtiqueta()) == null) {
                conjuntoAux.insertar(new Nodo<T>(aux1.getEtiqueta(), aux1.getDato()));
            }
            aux1 = aux1.getSiguiente();
        }
        return conjuntoAux;
    }

    @Override
    public IConjunto interseccion(IConjunto otroConjunto) {
        Conjunto<T> conjuntoAux = new Conjunto<>();

        Nodo<T> aux1 = otroConjunto.obtenerPrimerNodo();
        while (aux1 != null) {
            if (buscar(aux1.getEtiqueta()) != null) {
                conjuntoAux.insertar(new Nodo<T>(aux1.getEtiqueta(), aux1.getDato()));
            }
            aux1 = aux1.getSiguiente();
        }
        return conjuntoAux;
    }

    public IConjunto diferenciaSimetrica(IConjunto otroConjunto ){
        Conjunto<T> conjunto3 = new Conjunto();
        Nodo<T> aux = primero;
        Nodo<T> aux2 = otroConjunto.obtenerPrimerNodo();
        while (aux != null){
            if (otroConjunto.buscar(aux.getEtiqueta()) == null){
                conjunto3.insertar(new Nodo(aux.getEtiqueta(),aux.getDato()));
            }
            aux = aux.getSiguiente();
        }
        while (aux2 != null){
            if (buscar(aux2.getEtiqueta()) == null){
                conjunto3.insertar(new Nodo(aux2.getEtiqueta(),aux2.getDato()));
            }
            aux2 = aux2.getSiguiente();
        }
        return conjunto3;
    }

    public IConjunto complemento(IConjunto otroConjunto ){
        Conjunto<T> conjunto3 = new Conjunto();
        Nodo<T> aux = otroConjunto.obtenerPrimerNodo();
        while (aux != null){
            if (buscar(aux.getEtiqueta()) == null){
                conjunto3.insertar(new Nodo(aux.getEtiqueta(),aux.getDato()));
            }
            aux = aux.getSiguiente();
        }
        return conjunto3;
    }
}
