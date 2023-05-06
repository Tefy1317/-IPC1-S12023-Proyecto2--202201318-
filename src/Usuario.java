import java.util.ArrayList;

public class Usuario {
    private String Nombre;
    private String categorias;

    private ArrayList<Categorias> Categorias;

    public Usuario(String nombre) {
        Nombre = nombre;
    }

    public String getNombre() {
        return Nombre;
    }

    @Override
    public String toString() {
        return " " +Nombre;
    }

    public String getCategorias() {
        return categorias;
    }

    public void setCategorias(String categorias) {
        this.categorias = categorias;
    }
}

