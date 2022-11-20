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
            String reglas = "                                      --- REGLAS ---\n" +
                    "1. Al pulsar jugar, se te asginarán 4 pokemon aleatoriamente\n" +
                    "2. En cada turno podrás elegir uno de tus 4 movimientos disponibles\n" +
                    "3. Después de ti el enemigo hará lo mismo en tu contra\n" +
                    "4. El combate acabará cuando uno de los dos se quede sin Pokemon";
            JOptionPane.showMessageDialog(null, reglas);

        }else if(log.getJugar().equals(e.getSource())){
            if(log.getTxtNom().getText().equals("")){
                JOptionPane.showMessageDialog(null, "Indica tu nombre porfavor :)");
                log.getTxtNom().setText("");
                log.getTxtNom().requestFocus();
            }else{
                entrenador.setNombre(log.getTxtNom().getText());
            }
        }else if(log.getSalir().equals(e.getSource())){
            System.exit(0);
        }


    }

}
