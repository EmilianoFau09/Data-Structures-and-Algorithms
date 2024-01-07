public class Main {
    public static void main(String[] args) {
        Lista l = new Lista<>();

        l.insertar(new Nodo<>(1,1));
        l.insertar(new Nodo<>(2,2));
        l.insertar(new Nodo<>(3,3));
        l.insertar(new Nodo<>(4,4));

        System.out.println(l.imprimir());

        l.invertirLista();

        System.out.println(l.imprimir());
    }
}