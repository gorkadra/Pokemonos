package vista;

import javax.swing.*;
import java.awt.*;

public class PanelChat extends JPanel {

    public PanelChat(String mov, float mult, String pkmIa){
        this.setLayout(new BorderLayout());
        String efectividad;
        if (mult <= 0.5) {
            efectividad = " es poco eficaz ";
        } else if (mult==1.0) {
            efectividad = " es neutral ";
        } else if (mult>=1.0 && mult<=2.0){
            efectividad = " es eficaz ";
        }
        else if (mult>2.0){
            efectividad = " es muy eficaz ";
        }else {
            efectividad = "desconocida";
        }
        String frase;
        frase = mov + efectividad + " contra " + pkmIa;
        JLabel texto = new JLabel(frase);
        this.add(texto,BorderLayout.CENTER);
    }
    public PanelChat(String mov){
        this.setLayout(new BorderLayout());

        String frase;
        frase = mov;
        JLabel texto = new JLabel(frase);
        this.add(texto,BorderLayout.CENTER);
    }
}
