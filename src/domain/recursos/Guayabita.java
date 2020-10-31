package domain.recursos;
import java.util.List;

public class Guayabita {
    public Jugador jugadores;
    public List<Jugador> jugadoresList;
    int pote;
    int jug = 0;

    public int getPote() {
        return pote;
    }

    public void setPote(int pote) {
        this.pote = pote;
    }

    public void PoteInicial(int cantidadjugadores){
        pote = 500 * cantidadjugadores;
    }

    public int TirarDado(){
        int num;
        num = (int) Math.floor(Math.random()*6+1);
        return num;
    }

    public boolean hayJugadores(){

        jugadoresList.forEach(jugador -> {
            if(jugador.getDinero()!=0){
                jug+=1;
            }
        });
        if(jug==1){
            return true;
        }else {return false;}
    }

    public void Tablero() {
        jugadoresList.forEach(jugadores -> {
            System.out.println(jugadores.getNombre());
            System.out.println(jugadores.getDinero());
        });
        System.out.println("pote: "+ pote);
    }

}
