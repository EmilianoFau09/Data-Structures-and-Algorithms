
/**
 *
 * @author ernesto
 * @param <T>
 */
public interface IConjunto extends ILista{

    
    public IConjunto union (IConjunto otroConjunto);

    public IConjunto interseccion (IConjunto otroConjunto);

    <T> Nodo<T> obtenerPrimerNodo();
}
