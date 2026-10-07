package linkedlist;

public class ListaEnlazada <T> implements IList<T>, Iterable<T>{
protected NodoSimple inicio;
protected int nElementos;

    private class NodoSimple <T>{
        private T dato;
        private NodoSimple<T> sig;
        
        public NodoSimple (T dato){
            this.dato = dato;
        }
    }
public ListaEnlazada(){
    inicio = null; 
    nElementos = 0;
}
 private NodoSimple<T> getNodo(int index) {
        NodoSimple<T> nodo = inicio;
        for (int i = 0; i < index; i++) {
            nodo = nodo.sig;
        }
        return nodo;
    }

    @Override
    public void append(T elemento) throws ListExcepciom {
   NodoSimple<T> nodoNuevo = new NodoSimple<>(elemento);
   NodoSimple<T> nodo = inicio;
   
   if (nodo == null){
       inicio = nodoNuevo;
       
   }else{
       while (nodo.sig != null){
           nodo = nodo.sig;
       }
       nodo.sig = nodoNuevo;
   }
   nElementos++;
    }

    @Override
    public void insert(T elemento, int index) throws ListExcepciom {
     if (index < 0 || index > nElementos) {
            throw new ListExcepciom("Indice fuera de limites");
        }
        NodoSimple<T> nodoNuevo = new NodoSimple<>(elemento);
        if (index == 0) {
            nodoNuevo.sig = inicio;
            inicio = nodoNuevo;
        } else {
            NodoSimple<T> anterior = getNodo(index - 1);
            nodoNuevo.sig = anterior.sig;
            anterior.sig = nodoNuevo;
        }
        nElementos++;
    }

    @Override
    public T remove(int index) throws ListExcepciom {
            if (empty()) {
            throw new ListExcepciom("Lista vacia");
        }
        if (index < 0 || index >= nElementos) {
            throw new ListExcepciom("Indice fuera de limites");
        }
        T dato;
        if (index == 0) {
            dato = (T) inicio.dato;
            inicio = inicio.sig;
        } else {
            NodoSimple<T> anterior = getNodo(index - 1);
            NodoSimple<T> aEliminar = anterior.sig;
            dato = aEliminar.dato;
            anterior.sig = aEliminar.sig;
        }
        nElementos--;
        return dato;
    }

    @Override
    public boolean removeObj(T elemento) throws ListExcepciom {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int indexOf(T elemento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public T get(int index) throws ListExcepciom {
        if (empty()){
            throw new ListExcepciom("Lista vacia");
        }
        if (index < 0 || index >= nElementos){
            throw new ListExcepciom("Indice fuera de limites");
        }
        return getNodo(index).dato;
    }

    @Override
    public void set(T elemento, int index) throws ListExcepciom {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void clear() {
        inicio = null;
        nElementos = 0;
    }

    @Override
    public boolean empty() {
    return nElementos == 0;
    }

    @Override
    public int size() {
    return nElementos;  
    } 

    @Override
public String toString() {
    StringBuilder sb = new StringBuilder("[");
    NodoSimple<T> nodo = inicio;
    while (nodo != null) {
        sb.append(nodo.dato);
        if (nodo.sig != null) {
            sb.append(", ");
        }
        nodo = nodo.sig;
    }
    sb.append("]");
    return sb.toString();
}
    

    @Override
    public java.util.Iterator<T> Iterator() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public java.util.Iterator<T> iterator() {
    return new java.util.Iterator<T>() {
        private NodoSimple<T> actual = inicio;

        @Override
        public boolean hasNext() {
            return actual != null;
        }

        @Override
        public T next() {
            T dato = actual.dato;
            actual = actual.sig;
            return dato;
        }


 };
            }
}