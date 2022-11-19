package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI_Inicio implements ActionListener {

    public static void main(String[] args){
        JFrame start = new JFrame();
        start.setSize(500,300);
        start.setLayout(new GridLayout(3,1));

        JPanel bienvenido = new JPanel();
        bienvenido.setLayout(new FlowLayout());
        bienvenido.add(new JLabel("Hola, bienvenidx a Pokemonos!!"));

        JPanel username = new JPanel();
        username.setLayout(new GridLayout(3,3));
        JLabel nom = new JLabel("Usuario: ");
        username.add(nom,0,0);
        JTextField txtNom = new JTextField();
        username.add(txtNom,0,1);

        JPanel botones = new JPanel();
        botones.setLayout(new FlowLayout());
        JButton reglas = new JButton("Reglas");
        reglas.addActionListener(new GUI_Inicio());
        JButton jugar = new JButton("Jugar");
        jugar.addActionListener(new GUI_Inicio());
        JButton salir = new JButton("Salir");
        salir.addActionListener(new GUI_Inicio());
        botones.add(reglas);
        botones.add(jugar);
        botones.add(salir);

        start.add(bienvenido);
        start.add(username);
        start.add(botones);
        start.setVisible(true);

        // ------------------ OTRA PANTALLA -----------------

        JFrame frame = new JFrame();

        frame.setSize(1100,700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3,3));

        JPanel relleno1 = new JPanel();
        JPanel relleno2 = new JPanel();
        JPanel relleno3 = new JPanel();

        /*
        JPanel vidaIA = new JPanel();
        vidaIA.setLayout(new GridBagLayout());
         */

        PanelFoto pokemonIA = new PanelFoto("C:/Users/olaba/Desktop/Bulbas.jpeg");

        float mult = 1.0F;
        PanelChat chat = new PanelChat("Lanzallamas",mult,"Kyogre");

        PanelFoto pokemonJgd = new PanelFoto("C:/Users/olaba/Desktop/Charm.jpeg");

        // ---------------------------------------------------------
        JPanel movs = new JPanel();
        movs.setLayout(new GridLayout(2,2));
        String[] movis = new String[4];
        movis[0] = "Lanzallamas";
        movis[1] = "Nitrocarga";
        movis[2] = "Avalancha";
        movis[3] = "Tajo aereo";
        String[] tiposMvs = new String[4];
        tiposMvs[0] = "Fuego";
        tiposMvs[1] = "Fuego";
        tiposMvs[2] = "Roca";
        tiposMvs[3] = "Volador";
        String mov1 = movis[0] + " (" + tiposMvs[0] + ")";
        String mov2 = movis[1] + " (" + tiposMvs[1] + ")";
        String mov3 = movis[2] + " (" + tiposMvs[2] + ")";
        String mov4 = movis[3] + " (" + tiposMvs[3] + ")";

        JButton bt1 = new JButton(mov1);
        bt1.addActionListener(new GUI_Inicio());
        JButton bt2 = new JButton(mov2);
        bt2.addActionListener(new GUI_Inicio());
        JButton bt3 = new JButton(mov3);
        bt3.addActionListener(new GUI_Inicio());
        JButton bt4 = new JButton(mov4);
        bt4.addActionListener(new GUI_Inicio());

        movs.add(bt1);
        movs.add(bt2);
        movs.add(bt3);
        movs.add(bt4);
        //-----------------------------------------------------------

        /*
        JPanel vidaJgd = new JPanel();
        vidaJgd.setLayout(new GridBagLayout());
        */
        String nomPkmJ = "Paco";
        String[] tiposPkmJ = new String[2];
        tiposPkmJ[0] = "Agua";
        tiposPkmJ[1] = "Tierra";
        int ptVidaJ = 51;
        int vidTotJ = 100;

        frame.add(new PanelVida(nomPkmJ,tiposPkmJ,ptVidaJ,vidTotJ));
        frame.add(relleno1);
        frame.add(pokemonIA);
        frame.add(relleno2);
        frame.add(chat);
        frame.add(relleno3);
        frame.add(pokemonJgd);
        frame.add(movs);
        frame.add(new PanelVida(nomPkmJ,tiposPkmJ,ptVidaJ,vidTotJ));


        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Reglas")){
            System.out.println("1"); //Printear reglas
        } else if (e.getActionCommand().equals("Jugar")) {
            System.out.println("2"); //Checkear nombre
            // If textBox llena -> sigue // Sino pedir nombre de nuevo
        } else {
            System.out.println("3"); //Salir
            System.exit(0);
        }
    }
}
