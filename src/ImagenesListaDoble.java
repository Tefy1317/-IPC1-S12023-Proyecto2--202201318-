import proyecto2.EstructuraDeDatos;
public class ImagenesListaDoble  extends EstructuraDeDatos {
    Nodo inicio;
    Nodo fin;
    int tamano;
    @Override
    public void add(Object e) {
        Nodo nuevonodo = new Nodo(e);
        if(fin==null){
            inicio = nuevonodo;
        }else{
            nuevonodo.setAnterior(fin);
            fin.setSiguiente(nuevonodo);
        }
        fin = nuevonodo;
        tamano++;
    }

    @Override
    public Object peek() {
        return inicio;
    }

    @Override
    public Object find(Object e) {
        Nodo actual = inicio;
        while(actual != null){
            if (comparar(actual.getDato(), e)) {
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
        if (ind < 0 || ind >= tamano) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        Nodo actual = inicio;
        for (int i = 0; i < ind; i++) {
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
        Nodo actual = inicio;
        while (actual != null) {

            if (comparar(actual.getDato(), e)) {
                if (actual == inicio) {
                    if(inicio.getSiguiente() != null){
                        inicio.getSiguiente().setAnterior(null);
                        inicio = inicio.getSiguiente();
                    }
                    else{
                        fin = null;
                    }
                } else if (actual == fin) {
                    fin = fin.getAnterior();
                    fin.setSiguiente(null);
                } else {
                    actual.getAnterior().setSiguiente(actual.getSiguiente());
                    actual.getSiguiente().setAnterior(actual.getAnterior());
                }
                tamano--;
                break;
            }
            actual = actual.getSiguiente();
        }
    }

    public boolean comparar(Object objeto1, Object objeto2){
        return objeto1.equals(objeto2);
    }
}


