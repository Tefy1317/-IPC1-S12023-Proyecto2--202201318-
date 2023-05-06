import proyecto2.EstructuraDeDatos;
public class UsuariosListaSimple extends EstructuraDeDatos {
    private Nodo cabeza;
    private int tamano;

    public UsuariosListaSimple(){
        cabeza = null;
        tamano = 0;
    }
    @Override
    public void add(Object dato) {
        Nodo nuevoNodo = new Nodo(dato);
        nuevoNodo.setSiguiente(cabeza);
        cabeza = nuevoNodo;
        tamano++;
    }

    @Override
    public Object peek() {
        return cabeza;
    }

    @Override
    public Object find(Object e) {
        Nodo actual = cabeza;
        while(actual != null){
            if(comparar(actual.getDato(),e)){
                return actual;
            }
           actual = actual.getSiguiente();
        }
        return null;
    }

    @Override
    public Object getNext() {
        return null;
    }

    @Override
    public int getSize() {
        return tamano;
    }

    @Override
    public Object get(int ind) {
        if(ind<0 || ind >= tamano){
            throw new IndexOutOfBoundsException("El índice no está en rango");
        }
        Nodo actual = cabeza;
        for(int i = 0; i< ind; i++){
            actual = actual.getSiguiente();
        }
        return actual.getDato();
    }

    @Override
    public Object pop() {
        return null;
    }

    @Override
    public void delete(Object e) {
        if(cabeza == null){
            return;
        }
        Usuario usuario = (Usuario) e;
        if(((Usuario) cabeza.getDato()).getNombre().equals(usuario.getNombre())){
            cabeza = cabeza.getSiguiente();
            tamano--;
            return;
        }
        Nodo actual = cabeza;
        while(actual.getSiguiente() != null && !comparar(actual.getSiguiente().getDato(), e)){
            actual = actual.getSiguiente();
        }
        if(actual.getSiguiente() != null){
            actual.setSiguiente(actual.getSiguiente().getSiguiente());
            tamano--;
        }
    }
    public boolean comparar(Object objeto1, Object objeto2){
        Usuario usuario1 = (Usuario) objeto1;
        Usuario usuario2 = (Usuario) objeto2;
        return usuario1.getNombre().equals(usuario2.getNombre());
    }

}

