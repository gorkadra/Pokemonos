package vista;

import javax.swing.*;
import java.awt.*;

public class PanelVida extends JPanel {

    public PanelVida(String nomPokemon, String[] tipos, int ptVida, int vidTot){
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel nomPkm = new JLabel(nomPokemon);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(nomPkm,gbc);

        JLabel hueco = new JLabel(" ");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        this.add(hueco,gbc);

        JLabel tiposPkm = new JLabel("(" + tipos[0] + "," + tipos[1] + ")");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 0;
        this.add(tiposPkm,gbc);

        JLabel colVida = new JLabel(" ");
        if (ptVida <= vidTot/10){
            colVida.setBackground(Color.red);
        } else if (ptVida <= (vidTot/10)*5){
            colVida.setBackground(Color.yellow);
        } else{
            colVida.setBackground(Color.green);
        }
        colVida.setOpaque(true);
        gbc.gridwidth = 3;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(colVida,gbc);

        String act = Integer.toString(ptVida);
        String tot = Integer.toString(vidTot);

        JLabel vida = new JLabel( act + "/" + tot);
        gbc.gridx = 1;
        gbc.gridy = 2;
        this.add(vida,gbc);
    }
}
