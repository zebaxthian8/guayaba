package Desafio2.domain;

public class Freelance extends Empleado{
    private long valorHora;
    private int horasTrabajadas;

    public Freelance(String nombre, long valorHoras, int horasTabajadas) {
        super(nombre);
        this.valorHora = valorHoras;
        this.horasTrabajadas = horasTabajadas;
    }

    @Override
    public long calcularSalario() {
        return this.valorHora * this.horasTrabajadas;
    }

    public long getValorHora() {
        return valorHora;
    }

    public void setValorHora(long valorHora) {
        this.valorHora = valorHora;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }
}
