package domain.app;
import domain.recursos.Guayabita;
import domain.recursos.Jugador;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class guayabaApp {
    public static final int JUGAR = 0;
    public static final int INSTRUCCIONES = 1;

    public static void main(String[] args) {
        Guayabita game = new Guayabita();
        game.jugadoresList = new ArrayList<>();
        int poteTempo = 0;
        int apuesta = 0;
        Icon guayaIcon = new ImageIcon(guayabaApp.class.getResource("guayab.jpg"));
        int opcionElegida = JOptionPane.showOptionDialog(null, "Bienvenido a guayabita \n que quieres hacer?", "Guayabita", 0,
                0, guayaIcon, Arrays.asList("Jugar", "Intrucciones").toArray(), "Jugar");

        switch (opcionElegida) {
            case JUGAR: {
                int cantidadJugadores = Integer.parseInt(JOptionPane.showInputDialog(null, "cantidad de jugadores"));
                for(int i = 0; i<cantidadJugadores; i++){
                    String nombreJugador = JOptionPane.showInputDialog(null, "Ingrese el nombre del jugador" + (i+1));
                    int dineroJugador = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dinero del jugador" + (i+1)));
                    Jugador newJugador = new Jugador(nombreJugador, dineroJugador - 500);
                    game.jugadoresList.addAll(Arrays.asList(newJugador));
                }
                game.PoteInicial(cantidadJugadores);
                do{
                    for(int i=0; i < cantidadJugadores; i++){
                        if(game.jugadoresList.get(i).getDinero() != 0){
                            String nombre= game.jugadoresList.get(i).getNombre();
                            int dinero= game.jugadoresList.get(i).getDinero();
                            int jugarConfirm = JOptionPane.showConfirmDialog(null, nombre+", el pote actual es de : " + game.getPote()+" \n Tirar dado?", "Guayabita", 0,
                                    0, null);
                            if(jugarConfirm == 0){
                                int dado1 = game.TirarDado();
                                Icon iconDado1 = new ImageIcon(guayabaApp.class.getResource("dado"+dado1+".jpg"));
                                if(dado1 != 1 && dado1 != 6){
                                    jugarConfirm = JOptionPane.showConfirmDialog(null, nombre+", Arriesgas a apostar?","Guayabita", 0,
                                            0, iconDado1);
                                    if(jugarConfirm == 0){
                                        int apuestaJugador = 0;
                                        do{
                                            apuestaJugador = Integer.parseInt(JOptionPane.showInputDialog(null, nombre+", cuanto desea apostar? \n su dinero es "+dinero+ "\n (el pote esta en "+ game.getPote()+")"));
                                        }while(apuestaJugador>game.getPote())
                                            ;
                                        int dado2 = game.TirarDado();
                                        Icon iconDado2 = new ImageIcon(guayabaApp.class.getResource("dado"+dado2+".jpg"));
                                        if (dado2>dado1){
                                            JOptionPane.showMessageDialog(null," has ganado", "Guayabita",0, iconDado2);
                                            apuesta = game.jugadoresList.get(i).getDinero()+ apuestaJugador;
                                            game.jugadoresList.get(i).setDinero(apuesta);
                                            poteTempo = game.getPote() - apuestaJugador;
                                            game.setPote(poteTempo);
                                            if(game.getPote()==0){
                                                break;
                                            }
                                        }else {
                                            JOptionPane.showMessageDialog(null," has perdido", "Guayabita",0, iconDado2);
                                            apuesta = game.jugadoresList.get(i).getDinero()-apuestaJugador;
                                            game.jugadoresList.get(i).setDinero(apuesta);
                                            poteTempo = game.getPote()+apuestaJugador;
                                            game.setPote(poteTempo);
                                        }

                                    }
                                }else{
                                    JOptionPane.showConfirmDialog(null,"cede turno", "Guayabita", 0, 0, iconDado1);
                                }
                            }


                        }
                    }
                }while(game.getPote()!=0 || game.hayJugadores()!=false );
                String tablaFinal = "";
                for(int i = 0; i < cantidadJugadores; i++){
                    tablaFinal += "\nNombre: " + game.jugadoresList.get(i).getNombre() + "     Dinero: " + game.jugadoresList.get(i).getDinero();
                }

                JOptionPane.showMessageDialog(null,"Tabla de jugadores: " + tablaFinal + "\n Pote: " + game.getPote(), "Guayabita",0, guayaIcon);
                break;
            }
            case INSTRUCCIONES: {
                String instru = "Instrucciones:" +
                        "\nEl juego al iniciar tienes que ingresar la cantidad de jugadores, sus nombres y la cantidad de dineron"
                        +"\n va por turnos y consiste en que cada jugador lanza un dado para hacer una apuesta, si saca 1 0 6, cede el turno"
                        +"\n, al sacar un nuveo el jugador puede decicir si apostar o no. No puede apostar mas de lo que hay en pote "
                        + "\n y debera tirar el dado otra vez intentando sacar un numero mayor a la inicial para ganar la apuesta."
                        +"\n El juego termina cuando no hayan jugadores con dinero o el pote sea 0.";
                JOptionPane.showMessageDialog(null,instru, "Guayabita",0, guayaIcon);

                break;
            }
        }
    }
}
