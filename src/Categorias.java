public class Categorias {
    String nombre;
    ImagenesListaDoble imagenes;

    public Categorias(String nombre) {
        this.nombre = nombre;
        this.imagenes = new ImagenesListaDoble();

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setImagenes(ImagenesListaDoble imagenes) {
        this.imagenes = imagenes;
    }

    public ImagenesListaDoble getImagenes() {
        return imagenes;
    }
    @Override
    public String toString() {
        return " " +nombre;
    }
}
