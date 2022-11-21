package controlador;

import modelo.pokemon.Entrenador;
import modelo.pokemon.ListaEntrenadores;
import modelo.pokemon.Notificaciones;
import vista.Partida;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

public class PartidaControl implements ActionListener, Observer {

    private Partida juego;
    private ListaEntrenadores lisEnt;

    public PartidaControl(Partida pJuego, ListaEntrenadores pLisEnt){
        juego = pJuego;
        lisEnt = pLisEnt;
    }

    public void actionPerformed(ActionEvent e) {

        if(juego.getBt1().equals(e.getSource())){
            lisEnt.pelearConNum(1);
            //juego.cambiado();
        }else if(juego.getBt2().equals(e.getSource())){
            lisEnt.pelearConNum(2);
            //juego.cambiado();

        }else if(juego.getBt3().equals(e.getSource())){
            lisEnt.pelearConNum(3);
            //juego.cambiado();

        }else if(juego.getBt4().equals(e.getSource())){
            lisEnt.pelearConNum(3);
            //juego.cambiado();

        }


    }

    @Override
    public void update(Observable o, Object arg) {
        if(arg.equals(Notificaciones.pokemonCambiado)){
            juego.setPokemonIA(lisEnt.getRival().getMiListaPokemon().getMiLista().get(1).getNombre());
            juego.setPokemonJgd(lisEnt.getPersonaje().getMiListaPokemon().getMiLista().get(0).getNombre());

        }
        if(arg.equals(Notificaciones.turnoHecho)){
            //pantalla de que has perdido
        }
        if(arg.equals(Notificaciones.pierdePropio)){
            //pantalla de que has perdido
        }
        if(arg.equals(Notificaciones.pierdeRival)){
            //pantalla de que ha perdido el rival
        }
    }
}
