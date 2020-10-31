package Desafio2.domain;

public abstract class Empleado {
    private String nombre;


    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    public abstract long calcularSalario();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
