package controlador;

import modelo.pokemon.EntrenadorPropio;
import vista.Loggin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class LogginControl implements ActionListener {

    private EntrenadorPropio entrenador;
    private Loggin log;

    public LogginControl(EntrenadorPropio entr, Loggin logP){
        entrenador = entr;
        log = logP;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(log.getReglas().equals(e.getSource())){
            JOptionPane.showMessageDialog(null, "La única regla es divertirse rey :D");

        }else if(log.getJugar().equals(e.getSource())){
            System.out.println("pilla el boton jugar");
            System.out.println(log.getTxtNom().getText());
            if(log.getTxtNom().getText().equals("")){
                JOptionPane.showMessageDialog(null, "Te has olvidado de decir quien eres");
                log.getTxtNom().setText("");
                log.getTxtNom().requestFocus();
            }else{
                entrenador.setNombre(log.getTxtNom().getText());
            }
        }else if(log.getSalir().equals(e.getSource())){
            System.out.println("pilla el boton salir");
            //Hacer que se cierre la ventana
            System.exit(0);
        }


    }

}
