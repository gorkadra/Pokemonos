package vista;

import controlador.LogginControl;

import javax.swing.*;
import java.awt.*;

public class Loggin extends JFrame{

    private JFrame start;
    private JTextField txtNom;
    private JButton reglas, jugar, salir;

    public Loggin(){
        start = new JFrame();
        start.setSize(500,300);
        start.setLayout(new GridLayout(3,1));

        JPanel bienvenido = new JPanel();
        bienvenido.setLayout(new FlowLayout());
        bienvenido.add(new JLabel("Hola, bienvenidx a Pokemonos!!"));

        JPanel username = new JPanel();
        username.setLayout(new GridLayout(3,3));
        JLabel nom = new JLabel("Usuario: ");
        username.add(nom,0,0);
        txtNom = new JTextField();
        username.add(txtNom,0,1);

        JPanel botones = new JPanel();
        botones.setLayout(new FlowLayout());
        reglas = new JButton("Reglas");
        //reglas.addActionListener(new GUI_Inicio());
        jugar = new JButton("Jugar");
        //jugar.addActionListener(new GUI_Inicio());
        salir = new JButton("Salir");
        //salir.addActionListener(new GUI_Inicio());
        botones.add(reglas);
        botones.add(jugar);
        botones.add(salir);

        start.add(bienvenido);
        start.add(username);
        start.add(botones);
        start.setVisible(true);

    }
    public void cerrar(){
        start.dispose();
    }

    public JTextField getTxtNom() {
        return txtNom;
    }

    public JButton getReglas() {
        return reglas;
    }

    public JButton getJugar() {
        return jugar;
    }

    public JButton getSalir() {
        return salir;
    }

    public void setTxtNom(JTextField txtNom) {
        this.txtNom = txtNom;
    }

    public void setController(LogginControl lgc){
        reglas.addActionListener(lgc);
        jugar.addActionListener(lgc);
        salir.addActionListener(lgc);
    }

}
