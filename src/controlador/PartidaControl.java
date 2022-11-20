package controlador;

import modelo.pokemon.ListaEntrenadores;
import vista.Partida;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PartidaControl implements ActionListener {

    private Partida juego;
    private ListaEntrenadores lisEnt;

    public PartidaControl(Partida pJuego, ListaEntrenadores pLisEnt){
        juego = pJuego;
        lisEnt = pLisEnt;
    }

    public void actionPerformed(ActionEvent e) {

        if(juego.){
            JOptionPane.showMessageDialog(null, "La única regla es divertirse rey :D");

        }else if(juego.){
            System.out.println("pilla el boton jugar");
            //System.out.println(log.getTxtNom().getText());
            if(juego.){
                JOptionPane.showMessageDialog(null, "Te has olvidado de decir quien eres");

            }else{
                //lisEnt.
            }
        }else if(juego.){
            System.out.println("pilla el boton salir");
            //Hacer que se cierre la ventana
            System.exit(0);
        }


    }

}
