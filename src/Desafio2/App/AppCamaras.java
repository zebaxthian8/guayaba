package Desafio2.App;

import Desafio2.domain.*;

import java.util.ArrayList;
import java.util.Arrays;

public class AppCamaras {
    public static void main(String[] args) {
        Nomina nomina = new Nomina();
        nomina.empleadosList = new ArrayList<>();
        Empleado juan = new Directo("Juan", 4840000);
        Empleado julian = new Vendedor("Julián", 2050000, 45510000);
        Empleado johanna = new Freelance("Johanna", 71000, 89);
        Empleado carolina = new Vendedor("Carolina", 980000, 35989000);
        Empleado pedro = new Promotor("Pedro", 1200, 300, 62);
        Empleado david = new Directo("David", 3975000);
        Empleado gustavo = new Freelance("Gustavo", 42500, 65);

        nomina.empleadosList.addAll(Arrays.asList(juan, julian, johanna, carolina, pedro, david, gustavo));
        System.out.println("Nomina de la empresa; ");
        nomina.calcularNomina();
    }
}
