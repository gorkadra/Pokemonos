package vista;

import controlador.LogginControl;
import controlador.PartidaControl;
import modelo.pokemon.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        //Coger pokemon actual del campo de batalla y pasar su jpeg a PanelFoto
        pokemonIA = new PanelFoto("src/vista/PkmImg/Abomasnow.jpeg");

        //Mirar que boton se ha pulsado, calcular la efectividad contra el pokemon enemigo y decir el pokemon enemigo
        //Boton pulsado + Calcular efectividad vs pokemon enemigo + nombre pokemon enemigo
        float mult = 1.0F;
        PanelChat chat = new PanelChat("Lanzallamas",mult,"Kyogre");

        //Coger pokemon actual del campo de batalla y pasar su jpeg a PanelFoto
        pokemonJgd = new PanelFoto("src/vista/PkmImg/Abomasnow.jpeg");

        // ---------------------------------------------------------
        JPanel movs = new JPanel();
        movs.setLayout(new GridLayout(2,2));
        // Cargar lista de movimientos de nuestro pokemon actual
        String[] movis = new String[4];
        movis[0] = "Lanzallamas";
        movis[1] = "Nitrocarga";
        movis[2] = "Avalancha";
        movis[3] = "Tajo aereo";
        // Lista de los tipos de esos movimientos
        String[] tiposMvs = new String[4];
        tiposMvs[0] = "Fuego";
        tiposMvs[1] = "Fuego";
        tiposMvs[2] = "Roca";
        tiposMvs[3] = "Volador";
        String mov1 = movis[0] + " (" + tiposMvs[0] + ")";
        String mov2 = movis[1] + " (" + tiposMvs[1] + ")";
        String mov3 = movis[2] + " (" + tiposMvs[2] + ")";
        String mov4 = movis[3] + " (" + tiposMvs[3] + ")";

        bt1 = new JButton(mov1);
        bt2 = new JButton(mov2);
        bt3 = new JButton(mov3);
        bt4 = new JButton(mov4);

        movs.add(bt1);
        movs.add(bt2);
        movs.add(bt3);
        movs.add(bt4);

        //-----------------------------------------------------------


        String nomPkmJ = "Paco"; // Nombre del pokemon actual
        String[] tiposPkmJ = new String[2]; // Tipo(s) del pokemon en cuestion
        tiposPkmJ[0] = "Agua";
        tiposPkmJ[1] = "Tierra";
        // Vida actual y vida total del pokemon
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
        JOptionPane.showMessageDialog(null, "pako");
        ListaEntrenadores lisEnt= ListaEntrenadores.getMiListaEntrenadores();
        EntrenadorPropio yo = (EntrenadorPropio)lisEnt.getLista().get(0);
        String nomPkmJ = yo.getNombre();
        setPokemonJgd(nomPkmJ);
        Pokemon pok = yo.getMiListaPokemon().getMiLista().get(0);
        String[] tiposPkmJ = new String[2];
        int[] tipInt = pok.getTipo();
        int tip1 = tipInt[0];
        int tip2 = tipInt[1];
        tiposPkmJ[0] = Integer.toString(tip1);
        tiposPkmJ[1] = Integer.toString(tip2);
        int ptVidaJ = (int)pok.getVida();
        int vidTotJ = (int)pok.getVidaMax();

        EntrenadorBot riv = (EntrenadorBot) lisEnt.getLista().get(1);
        String nomPkmR = riv.getNombre();
        setPokemonIA(nomPkmR);
        Pokemon pokR = riv.getMiListaPokemon().getMiLista().get(0);
        String[] tiposPkmR = new String[2];
        int[] tipIntR = pokR.getTipo();
        tip1 = tipIntR[0];
        tip2 = tipIntR[1];
        tiposPkmR[0] = Integer.toString(tip1);
        tiposPkmR[1] = Integer.toString(tip2);
        int ptVidaR = (int)pok.getVida();
        int vidTotR = (int)pok.getVidaMax();

        frame.add(new PanelVida(nomPkmR,tiposPkmR,ptVidaR,vidTotR), 0);
        frame.add(new PanelVida(nomPkmJ,tiposPkmJ,ptVidaJ,vidTotJ), 8);
        SwingUtilities.updateComponentTreeUI(frame);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(arg.equals(Notificaciones.pokemonCambiado)){
            cambiado();
        }
        if(arg.equals(Notificaciones.turnoHecho)){
            ListaEntrenadores lisEnt= ListaEntrenadores.getMiListaEntrenadores();
            EntrenadorPropio yo = (EntrenadorPropio)lisEnt.getLista().get(0);
            String nomPkmJ = yo.getNombre();
            Pokemon pok = yo.getMiListaPokemon().getMiLista().get(0);
            String[] tiposPkmJ = new String[2];
            int[] tipInt = pok.getTipo();
            int tip1 = tipInt[0];
            int tip2 = tipInt[1];
            tiposPkmJ[0] = Integer.toString(tip1);
            tiposPkmJ[1] = Integer.toString(tip2);
            int ptVidaJ = (int)pok.getVida();
            int vidTotJ = (int)pok.getVidaMax();

            EntrenadorBot riv = (EntrenadorBot) lisEnt.getLista().get(1);
            String nomPkmR = riv.getNombre();
            Pokemon pokR = riv.getMiListaPokemon().getMiLista().get(0);
            String[] tiposPkmR = new String[2];
            int[] tipIntR = pokR.getTipo();
            tip1 = tipIntR[0];
            tip2 = tipIntR[1];
            tiposPkmR[0] = Integer.toString(tip1);
            tiposPkmR[1] = Integer.toString(tip2);
            int ptVidaR = (int)pok.getVida();
            int vidTotR = (int)pok.getVidaMax();
            
            frame.add(new PanelVida(nomPkmR,tiposPkmR,ptVidaR,vidTotR), 0);
            frame.add(new PanelVida(nomPkmJ,tiposPkmJ,ptVidaJ,vidTotJ), 8);
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
