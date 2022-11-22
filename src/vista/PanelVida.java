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

        String[] tiposStr = new String[2];
        int i =0;
        while (i<tipos.length){
            int pNum = Integer.parseInt(tipos[i]);
            String res="";
            if(pNum==0) {
                res = "fuego";
            }
            if(pNum==1) {
                res = "agua";
            }
            if(pNum==2) {
                res = "planta";
            }
            if(pNum==3) {
                res = "normal";
            }
            if(pNum==4) {
                res = "fantasma";
            }
            if (pNum==5){
                res = "hielo";
            }
            if (pNum==6){
                res = "lucha";
            }
            if (pNum==7){
                res = "tierra";
            }
            tiposStr[i]=res;
            i++;
        }

        JLabel tiposPkm = new JLabel("(" + tiposStr[0] + "," + tiposStr[1] + ")");
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
    public void update(String nomPokemon, String[] tipos, int ptVida, int vidTot){
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

    @Override
    public void updateUI() {
        super.updateUI();
    }
}
