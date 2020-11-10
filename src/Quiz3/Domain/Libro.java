package Quiz3.Domain;

public class Libro extends Recurso implements Prestable{


    public Libro(boolean prestado, String nombre) {
        super(prestado, nombre);
    }

    @Override
    public void prestar() {
        this.setPrestado(true);
    }

    @Override
    public void devolver() {
        this.setPrestado(false);
    }

    @Override
    public String toString() {
        return "Libro {" +
                "Nombre = " + this.getNombre() +
                '}';
    }
}
