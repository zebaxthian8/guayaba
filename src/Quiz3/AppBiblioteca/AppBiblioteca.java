package Quiz3.AppBiblioteca;

import Quiz3.Domain.*;

public class AppBiblioteca {
    public static void main(String[] args) {
        Biblioteca comuna = new Biblioteca();
        Libro tigres = new Libro(false, "Tigres");
        Revista avon = new Revista(false, "Avon");
        Comic marvel = new Comic(false, "Hombre Araña");
        Tesis graduacion = new Tesis(false, "FInalice la carrera");
        Diccionario ingles = new Diccionario(false, "Diccionario de ingles");

        comuna.addRecurso(tigres);
        comuna.addRecurso(avon);
        comuna.addRecurso(marvel);
        comuna.addRecurso(graduacion);
        comuna.addRecurso(ingles);

        comuna.prestarRecurso(ingles);
        comuna.prestarRecurso(tigres);
        comuna.prestarRecurso(avon);
        comuna.prestarRecurso(marvel);

        comuna.devolverRecurso(avon);

        comuna.listarPrestados();
    }
}
