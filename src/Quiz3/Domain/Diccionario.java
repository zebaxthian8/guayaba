package Quiz3.Domain;

public class Diccionario extends Recurso{
    public Diccionario(boolean prestado, String nombre) {
        super(prestado, nombre);
    }

    @Override
    public String toString() {
        return "Diccionario {" +
                "Nombre = " + this.getNombre() +
                '}';
    }
}
