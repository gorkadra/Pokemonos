package iniciador;

import modelo.pokemon.EntrenadorPropio;
import modelo.pokemon.ListaEntrenadores;
import modelo.txt.Lector;

import java.util.Observable;
import java.util.Observer;

public class AJugar implements Observer {

    private static AJugar jogoBonito;

    private AJugar(){}

    public static AJugar getAJugar(){
        if (jogoBonito==null){
            jogoBonito= new AJugar();
        }
        return jogoBonito;
    }

    public void iniciar(){
        //Cargar los datos del juego
        Lector miLector = new Lector();
        miLector.leerTipos();
        miLector.leerPokemons();
        miLector.leerAtaques();

        //modelo
        ListaEntrenadores lisEnt = ListaEntrenadores.getMiListaEntrenadores();
        EntrenadorPropio yo = EntrenadorPropio.getEntrenadorPropio();
        yo.crearEquipo(3);
        lisEnt.setPersonaje(yo);

        //vista

        //controlador
    }

    @Override
    public void update(Observable o, Object arg) {
        iniciar();
    }
}
