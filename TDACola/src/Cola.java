public class Cola extends Lista{
    public Nodo dequeue() {
        if (esVacia()) {
            return null;
        }
        Nodo valor = getPrimero();
        setPrimero(valor.getSiguiente());
        return valor;
    }
    public void enqueue(Nodo nodo){
        insertar(nodo);
    }

    public Nodo peek() {
        if (esVacia()) {
            return null;
        }
        Nodo valor = getPrimero();
        return valor;
    }
    public boolean isEmpty(){
        return esVacia();
    }
    public int size(){
        return cantElementos();
    }
}


/* 
ponerEnCola(elemento T)
Comienzo
Si esta llena entonces
	imprimir la cola esta llena
Sino
	cola[fin] = elemento
	fin = (fin + 1) modulo tamaño;
FinSi
Fin

quitarDeCola()
Inicio
Si la cola esta vacia entonces
	imprimir la cola esta vacia
Sino 
	elemento = cola[frente]
	frente = (frente + 1) modulo tamaño
FinSi
Devolver elemento
Fin
*/ 