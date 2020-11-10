package Quiz3.Domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Biblioteca {
    private List<Recurso> recursos;

    public Biblioteca() {
        this.recursos = new ArrayList<>();
    }

    public void addRecurso(Recurso ingresoRecurso) {
        boolean existe = recursos.stream().filter(v -> v.getNombre() == ingresoRecurso.getNombre()).findAny().isPresent();

        if (!existe) {
            this.recursos.add(ingresoRecurso);
        }
    }

    public boolean prestarRecurso(Recurso recursoPedido) {
        AtomicBoolean x = new AtomicBoolean(false);
        this.recursos.forEach(recursoAPrestar -> {
            if (recursoAPrestar instanceof Prestable && (recursoAPrestar.getNombre() == recursoPedido.getNombre()) && recursoAPrestar.isPrestado() == false) {
                ((Prestable) recursoAPrestar).prestar();
                x.set(true);
            }
        });

        if(x.get() == true){return true;}
        return false;
    }

    public boolean devolverRecurso(Recurso recursoDevolver) {
        AtomicBoolean x = new AtomicBoolean(false);
        this.recursos.forEach(recursoADevolver -> {
            if (recursoADevolver instanceof Prestable && (recursoADevolver.getNombre() == recursoDevolver.getNombre()) && recursoADevolver.isPrestado() == true) {
                ((Prestable) recursoADevolver).devolver();
                x.set(true);
            }
        });

        if(x.get() == true){return true;}
        return false;
    }

    public void listarPrestados(){
        this.recursos.forEach(recurso -> {
            if(recurso.isPrestado() == true){
                if(recurso instanceof Libro){
                    System.out.println("Nombre: " + recurso.getNombre() + " es un libro");
                }else if(recurso instanceof Revista){
                    System.out.println("Nombre: " + recurso.getNombre() + " es una revista");
                }else if(recurso instanceof Comic){
                    System.out.println("Nombre: " + recurso.getNombre() + " es un comic");
                }else if(recurso instanceof Tesis){
                    System.out.println("Nombre: " + recurso.getNombre() + " es una tesis");
                }else if(recurso instanceof Diccionario){
                    System.out.println("Nombre: " + recurso.getNombre() + " es un Diccionario");
                }
            }
        });
    }
}
