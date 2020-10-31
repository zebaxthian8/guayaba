package Desafio2.domain;

public class Vendedor extends Directo{
    private long ventasDelMes;

    public Vendedor(String nombre, long salario, long ventasDelMes) {
        super(nombre, salario);
        this.ventasDelMes = ventasDelMes;
    }

    public long calcularComision(){
        if(getSalario() < 1000000){
            return (long) (this.ventasDelMes * 0.04);
        }else{
            return (long) (this.ventasDelMes * 0.035);
        }
    }

    @Override
    public long calcularSalario() {
        return ((getSalario() - calcularPension() - calcularSalud()) + calcularComision());
    }

    public long getVentasDelMes() {
        return ventasDelMes;
    }

    public void setVentasDelMes(long ventasDelMes) {
        this.ventasDelMes = ventasDelMes;
    }
}
