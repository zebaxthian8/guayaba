package Quiz3.Domain;

public class Revista extends Recurso implements Prestable {

    public Revista(boolean prestado, String nombre) {
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
        return "Revista {" +
                "Nombre = " + this.getNombre() +
                '}';
    }
}
