package iniciador;

import controlador.PartidaControl;
import modelo.pokemon.EntrenadorPropio;
import modelo.pokemon.ListaEntrenadores;
import modelo.txt.Lector;
import vista.Partida;

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
        System.out.println(yo.getNombre());
        yo.getMiListaPokemon().imprimirPokemon();

        lisEnt.setPersonaje(yo);
        lisEnt.crearEntrenador();

        //vista
        Partida parti = new Partida();

        //controlador
        PartidaControl parCon = new PartidaControl(parti,lisEnt);
        parti.setController(parCon);

        //Observers a la lista de entrenadores
        lisEnt.addObserver(parCon);
        lisEnt.addObserver(parti);



    }

    @Override
    public void update(Observable o, Object arg) {
        iniciar();
    }
}
