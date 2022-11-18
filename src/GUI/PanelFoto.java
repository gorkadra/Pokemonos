package GUI;

import javax.swing.*;

public class PanelFoto extends JPanel {

    public PanelFoto(String path){
        JLabel labelFoto = imageIcon(path);
        this.add(labelFoto);
    }
    public JLabel imageIcon(String path){
        ImageIcon foto = new ImageIcon(path,"Foto del pokemon");
        return new JLabel(foto, JLabel.CENTER);
    }

}
