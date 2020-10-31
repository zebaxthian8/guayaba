package Desafio2.domain;
import java.util.List;

public class Nomina {

    public Empleado empleados;
    public List<Empleado> empleadosList;

    public void calcularNomina(){
        empleadosList.forEach(empleado -> {
            System.out.println("Nombre: " + empleado.getNombre() + "  Salario: " + empleado.calcularSalario());
        });
    }

    public void listarDirectos(){
        empleadosList.forEach(empleado -> {
            if (empleado instanceof Directo) {
                System.out.println(empleado.getNombre());
            }
        });
    }

    public void listarFreelancers(){
        empleadosList.forEach(empleado -> {
            if (empleado instanceof Freelance) {
                System.out.println(empleado.getNombre());
            }
        });
    }

    public void listarPromotores(){
        empleadosList.forEach(empleado -> {
            if (empleado instanceof Promotor) {
                System.out.println(empleado.getNombre());
            }
        });
    }

}
