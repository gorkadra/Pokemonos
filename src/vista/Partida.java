package vista;

import controlador.LogginControl;
import controlador.PartidaControl;
import modelo.pokemon.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;


public class Partida implements Observer {

    private JButton bt1,bt2,bt3,bt4;
    private PanelFoto pokemonIA, pokemonJgd;
    private JFrame frame;

    public Partida() {

        // ------------------ Pantalla de partida -----------------

        frame = new JFrame();

        frame.setSize(1100,700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3,3));

        JPanel relleno1 = new JPanel();
        JPanel relleno2 = new JPanel();
        JPanel relleno3 = new JPanel();
        ListaEntrenadores lisEnt = ListaEntrenadores.getMiListaEntrenadores();
        EntrenadorPropio yo = lisEnt.getPersonaje();
        EntrenadorBot riv = lisEnt.getRival();

        //Coger pokemon actual del campo de batalla y pasar su jpeg a PanelFoto
        String nombrePok = riv.getMiListaPokemon().getMiLista().get(0).getNombre();
        String path = "src/vista/PkmImg/" +nombrePok+".jpeg";
        System.out.println(path);
        pokemonIA = new PanelFoto(path);

        //Mirar que boton se ha pulsado, calcular la efectividad contra el pokemon enemigo y decir el pokemon enemigo
        //Boton pulsado + Calcular efectividad vs pokemon enemigo + nombre pokemon enemigo
        float mult = 1.0F;
        PanelChat chat = new PanelChat(yo.getMiListaPokemon().getMiLista().get(0).getMiLista().getMiLista().get(1).getDescripcion(),mult,nombrePok);

        //Coger pokemon actual del campo de batalla y pasar su jpeg a PanelFoto
        String nombrePokYo = yo.getMiListaPokemon().getMiLista().get(0).getNombre();
        String pathYo = "src/vista/PkmImg/" +nombrePokYo+".jpeg";
        pokemonJgd = new PanelFoto(pathYo);

        // ---------------------------------------------------------
        JPanel movs = new JPanel();
        movs.setLayout(new GridLayout(2,2));
        // Cargar lista de movimientos de nuestro pokemon actual
        String[] movis = new String[4];
        movis = yo.getMiListaPokemon().getMiLista().get(0).getMiLista().desMovStr();

        bt1 = new JButton(movis[0]);
        bt2 = new JButton(movis[1]);
        bt3 = new JButton(movis[2]);
        bt4 = new JButton(movis[3]);


        movs.add(bt1);
        movs.add(bt2);
        movs.add(bt3);
        movs.add(bt4);

        //-----------------------------------------------------------


        Pokemon pok = yo.getMiListaPokemon().getMiLista().get(3-yo.getPokRes());
        String[] tiposPkmJ = new String[2];
        int[] tipInt = pok.getTipo();
        int tip1 = tipInt[0];
        int tip2 = tipInt[1];
        tiposPkmJ[0] = Integer.toString(tip1);
        tiposPkmJ[1] = Integer.toString(tip2);
        int ptVidaJ = (int)pok.getVida();
        int vidTotJ = (int)pok.getVidaMax();

        Pokemon pokR = riv.getMiListaPokemon().getMiLista().get(3-riv.getPokRes());
        String[] tiposPkmR = new String[2];
        String nomPkmR = riv.getNombre();
        int[] tipIntR = pokR.getTipo();
        tip1 = tipIntR[0];
        tip2 = tipIntR[1];
        tiposPkmR[0] = Integer.toString(tip1);
        tiposPkmR[1] = Integer.toString(tip2);
        int ptVidaR = (int)pokR.getVida();
        int vidTotR = (int)pokR.getVidaMax();

        frame.add(new PanelVida(pokR.getNombre(),tiposPkmR,ptVidaR,vidTotR));
        frame.add(relleno1);
        frame.add(pokemonIA);
        frame.add(relleno2);
        frame.add(chat);
        frame.add(relleno3);
        frame.add(pokemonJgd);
        frame.add(movs);
        frame.add(new PanelVida(pok.getNombre(),tiposPkmJ,ptVidaJ,vidTotJ));


        frame.setVisible(true);
    }

    public void setController(PartidaControl ptc){
        bt1.addActionListener(ptc);
        bt2.addActionListener(ptc);
        bt3.addActionListener(ptc);
        bt4.addActionListener(ptc);
    }

    public JButton getBt1() {
        return bt1;
    }

    public JButton getBt2() {
        return bt2;
    }

    public JButton getBt3() {
        return bt3;
    }

    public JButton getBt4() {
        return bt4;
    }

    public void setPokemonIA(String nombrePok) {
        String path = "src/vista/PkmImg";
        path.concat(nombrePok);
        path.concat(".jpeg");
        this.pokemonIA.imageIcon(path);
    }

    public void setPokemonJgd(String nombrePok) {
        String path = "src/vista/PkmImg";
        path.concat(nombrePok);
        path.concat(".jpeg");
        this.pokemonJgd.imageIcon(path);
    }

    public void cambiado(){
        frame.dispose();
        frame = new JFrame();
        frame.setSize(1100,700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3,3));

        JPanel relleno1 = new JPanel();
        JPanel relleno2 = new JPanel();
        JPanel relleno3 = new JPanel();
        ListaEntrenadores lisEnt = ListaEntrenadores.getMiListaEntrenadores();
        EntrenadorPropio yo = lisEnt.getPersonaje();
        EntrenadorBot riv = lisEnt.getRival();

        //Coger pokemon actual del campo de batalla y pasar su jpeg a PanelFoto
        String nombrePok = riv.getMiListaPokemon().getMiLista().get(0).getNombre();
        String path = "src/vista/PkmImg/" +nombrePok+".jpeg";
        System.out.println(path);
        pokemonIA = new PanelFoto(path);

        //Mirar que boton se ha pulsado, calcular la efectividad contra el pokemon enemigo y decir el pokemon enemigo
        //Boton pulsado + Calcular efectividad vs pokemon enemigo + nombre pokemon enemigo
        float mult = 1.0F;
        PanelChat chat = new PanelChat(yo.getMiListaPokemon().getMiLista().get(0).getMiLista().getMiLista().get(1).getDescripcion(),mult,nombrePok);

        //Coger pokemon actual del campo de batalla y pasar su jpeg a PanelFoto
        String nombrePokYo = yo.getMiListaPokemon().getMiLista().get(0).getNombre();
        String pathYo = "src/vista/PkmImg/" +nombrePokYo+".jpeg";
        pokemonJgd = new PanelFoto(pathYo);

        // ---------------------------------------------------------
        JPanel movs = new JPanel();
        movs.setLayout(new GridLayout(2,2));
        // Cargar lista de movimientos de nuestro pokemon actual
        String[] movis = new String[4];
        movis = yo.getMiListaPokemon().getMiLista().get(0).getMiLista().desMovStr();

        bt1.setText(movis[0]);
        bt2.setText(movis[1]);
        bt3.setText(movis[2]);
        bt4.setText(movis[3]);

        movs.add(bt1);
        movs.add(bt2);
        movs.add(bt3);
        movs.add(bt4);

        //-----------------------------------------------------------


        Pokemon pok = yo.getMiListaPokemon().getMiLista().get(3-yo.getPokRes());
        String[] tiposPkmJ = new String[2];
        int[] tipInt = pok.getTipo();
        int tip1 = tipInt[0];
        int tip2 = tipInt[1];
        tiposPkmJ[0] = Integer.toString(tip1);
        tiposPkmJ[1] = Integer.toString(tip2);
        int ptVidaJ = (int)pok.getVida();
        int vidTotJ = (int)pok.getVidaMax();

        Pokemon pokR = riv.getMiListaPokemon().getMiLista().get(3-riv.getPokRes());
        String[] tiposPkmR = new String[2];
        String nomPkmR = riv.getNombre();
        int[] tipIntR = pokR.getTipo();
        tip1 = tipIntR[0];
        tip2 = tipIntR[1];
        tiposPkmR[0] = Integer.toString(tip1);
        tiposPkmR[1] = Integer.toString(tip2);
        int ptVidaR = (int)pokR.getVida();
        int vidTotR = (int)pokR.getVidaMax();

        frame.add(new PanelVida(pokR.getNombre(),tiposPkmR,ptVidaR,vidTotR));
        frame.add(relleno1);
        frame.add(pokemonIA);
        frame.add(relleno2);
        frame.add(chat);
        frame.add(relleno3);
        frame.add(pokemonJgd);
        frame.add(movs);
        frame.add(new PanelVida(pok.getNombre(),tiposPkmJ,ptVidaJ,vidTotJ));


        frame.setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(arg.equals(Notificaciones.pokemonCambiado)){
            cambiado();
        }
        if(arg.equals(Notificaciones.turnoHecho)){
            cambiado();
        }
        if(arg.equals(Notificaciones.pierdePropio)){
            //pantalla de que has perdido
            JFrame lose = new JFrame();
            lose.setSize(350,150);
            lose.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            lose.setLayout(new BorderLayout());
            JPanel lost = new JPanel();
            lost.setLayout(new BorderLayout());
            JLabel mensaje = new JLabel("Has perdido la partida :(");
            lost.add(mensaje,BorderLayout.CENTER);
            lose.add(lost,BorderLayout.CENTER);
            lose.setVisible(true);
        }
        if(arg.equals(Notificaciones.pierdeRival)){
            //pantalla de que ha perdido el rival
            JFrame win = new JFrame();
            win.setSize(350,150);
            win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            win.setLayout(new BorderLayout());
            JPanel won = new JPanel();
            won.setLayout(new BorderLayout());
            JLabel mensaje = new JLabel("Has ganado la partida!! :)");
            won.add(mensaje,BorderLayout.CENTER);
            win.add(won,BorderLayout.CENTER);
            win.setVisible(true);
        }
    }
}
