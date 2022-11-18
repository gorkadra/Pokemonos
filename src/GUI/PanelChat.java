package GUI;

import javax.swing.*;
import java.awt.*;

public class PanelChat extends JPanel {

    public PanelChat(String mov, float mult, String pkmIa){
        this.setLayout(new BorderLayout());
        String efectividad;
        if (mult == 0.5) {
            efectividad = " es (poco eficaz) ";
        } else if (mult==1.0) {
            efectividad = " es (neutral) ";
        } else {
            efectividad = " es (muy eficaz) ";
        }
        String frase;
        frase = mov + efectividad + " contra " + pkmIa;
        JLabel texto = new JLabel(frase);
        this.add(texto,BorderLayout.CENTER);
    }
}
