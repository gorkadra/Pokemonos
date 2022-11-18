package pokemon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


public class ListaEntrenadores {
    //atributos
    private static ListaEntrenadores listaEntrenadores = null;
    private EntrenadorPropio personaje = null;
    private ArrayList<Entrenador> lista;
    // constructor
    private void ListaEntrenadores() {
        this.lista = new ArrayList<Entrenador>();
    }
    public static ListaEntrenadores getMiListaEntrenadores() {
        if(listaEntrenadores == null) {
            listaEntrenadores = new ListaEntrenadores();
        }
        return listaEntrenadores;
    }
    //resto de metodos
    public ArrayList<Entrenador> getLista() {
        return this.lista;
    }
    public void setPersonaje(EntrenadorPropio pPerson) {
        this.personaje = pPerson;
    }
    public void resetear() {
        this.lista.clear();
    }
    private void pelear() {
        boolean primeraVez = true;//para que no cambie nuestro pokemon todo el rato
        Iterator<Entrenador> itrEntrenador = this.getIterador();
        boolean vaBien = true;//para saber si se han debilitado los pokemon
        boolean tienePokemonRival = true;
        Iterator<Pokemon> miEquipo = personaje.getMiListaPokemon().getIterador(); //para coger los pokemon de nuestro equipo
        Pokemon miPoke = null;
        int i = 2;
        int ronda = 1;
        while(itrEntrenador.hasNext() && vaBien) {
            tienePokemonRival = true;
            Entrenador actual = itrEntrenador.next(); //para coger individualmente cada entrenador
            Iterator<Pokemon> actualEquipo = actual.getMiListaPokemon().getIterador(); //para coger el equipo del entrenador actual
            Pokemon actualPoke = null;
            System.out.println("|                                                    |");
            System.out.println("|Se está jugando la ronda: "+ ronda + "            |");
            System.out.println("|                                                    |");
            System.out.println("Tu rival tiene "+ actual.getMiListaPokemon().listaLongitud()+" pokemon");
            while( vaBien && tienePokemonRival) {
                if(primeraVez || actualPoke == null) {
                    if (primeraVez) {
                        actualPoke = actualEquipo.next();
                        miPoke = miEquipo.next();
                        primeraVez = false;
                    }
                    else { //para cuando pases de ronda no de null
                        actualPoke = actualEquipo.next();
                    }
                }
                if(vaBien) {
                    if(actualPoke.getVeloc() > miPoke.getVeloc()) {
                        System.out.println("Rival primero");
                        Movimiento haUsado = actual.usarMovi(actualPoke);
                        turnoAtaque(actualPoke,miPoke,haUsado);
                        if(miPoke.getVida()>0) { //para saber si tiene vida ese pokémon
                            System.out.println("Vida nueva del pokémon:"+miPoke.getVida());
                            miPoke.imprimirMovi();
                            Movimiento yoUso = personaje.usarMovi(miPoke);
                            turnoAtaque(miPoke,actualPoke,yoUso);
                            System.out.println(miPoke.getNombre()+" ha usado "+haUsado.getDescripcion());
                            if(actualPoke.getVida() <= 0){
                                if(actualEquipo.hasNext()) {
                                    actualPoke = actualEquipo.next(); //pokemon del contrario
                                }
                                else {
                                    System.out.println("el entrenador actual se ha quedado sin pokémon");
                                    ronda = ronda + 1;
                                    tienePokemonRival = false;
                                }
                            }
                        }
                        else {
                            if(miEquipo.hasNext()) { //si se debilita un pokemon, que entre otro
                                System.out.println("Tu pokemon:"+ i);
                                miPoke = miEquipo.next(); //pokemon del rival
                                i = i + 1;
                            }
                            else {
                                vaBien = false;
                            }
                        }
                    }
                    else {
                        System.out.println("Tu primero");
                        miPoke.imprimirMovi();
                        Movimiento yoUso = personaje.usarMovi(miPoke);
                        turnoAtaque(miPoke,actualPoke,yoUso);
                        System.out.println(miPoke.getNombre()+" ha usado"+yoUso.getDescripcion());
                        if(actualPoke.getVida()>0) {//para saber si el pokemon tiene vida
                            System.out.println("Vida del pokemon rival:"+actualPoke.getVida());
                            Movimiento haUsado = actual.usarMovi(actualPoke);
                            turnoAtaque(miPoke,miPoke,haUsado);
                            System.out.println(actualPoke.getNombre()+" ha usado " +haUsado.getDescripcion());
                            if(miPoke.getVida() <= 0) {
                                if(miEquipo.hasNext()) { //si se debilita un pokemon que entre el siguiente
                                    System.out.println("Mi pokemon:"+ i);
                                    miPoke = miEquipo.next(); //pokemon actual del contrario
                                    i = i + 1;
                                }
                                else {
                                    vaBien = false;
                                }
                            }
                        }
                        else {
                            if(actualEquipo.hasNext()) {
                                actualPoke = actualEquipo.next(); // pokemon actual del rival
                            }
                            else {
                                System.out.println("el entrenador actual no tiene pokemon");
                                personaje.setDinero(actual.getDinero());
                                System.out.println("dinero:"+ personaje.getDinero());
                                ronda = ronda + 1;
                                tienePokemonRival = false;
                            }
                        }
                    }
                }
                cls();
            }
            if((ronda==5|| ronda==10||ronda==15)&& vaBien) {
                if(personaje.getDinero()>=15) {
                    System.out.println("quieres comprar algo?");
                    System.out.println("si -> b");
                    String decision = Teclado.getMiTeclado().leerString();
                    if(decision.equals("b")){
                        Movimiento pMovi = Tienda.getMiTienda().comprarMovimiento(); //hay que crear tienda
                        if(pMovi != null) {
                            miPoke.imprimirMovi();
                            System.out.println("que movimiento quieres comprar?");
                            int opcion = Teclado.getMiTeclado().leerEntero();
                            miPoke.getMiLista().cambiarMovi(pMovi, opcion);
                        }
                    }
                }
                else {
                    System.out.println("No tienes dinero!!");
                }
            }
            if(ronda==10) {  //para recuperar PS de los pokemon en la ronda 10
                int a = 0;
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("Se han recuperado los pokemon, vas a usar de nuevo el primer pokemon!!");
                System.out.println("---------------------------------------------------------------------------------------");
                while(a<=2) {
                    this.personaje.getMiListaPokemon().getMiLista().get(a).RecuperarVida(this.personaje.getMiListaPokemon().getMiLista().get(a).getVidaMax());
                    a++;
                }
                miEquipo = personaje.getMiListaPokemon().getIterador();
                miPoke = miEquipo.next();
            }
        }
        this.resetear();
        personaje = null;
    }
    private void turnoAtaque(Pokemon p1,Pokemon p2,Movimiento haUsado) {
        if(haUsado instanceof MovimientoStat) {
            float booster = ((MovimientoStat) haUsado).getBooster();
            String estadistica = ((MovimientoStat) haUsado).getEstadistica();
            if(estadistica.equals("Ataque")) {
                if(((MovimientoStat) haUsado).getPropio()) {
                    p1.setAtaque(booster);
                }
                else {
                    p2.setAtaque(booster);
                }
            }
            else if (estadistica.equals("Defensa")) {
                if(((MovimientoStat) haUsado).getPropio()) {
                    p1.setDefensa(booster);
                }
                else {
                    p2.setDefensa(booster);
                }
            }
            else if (estadistica.equals("Velocidad")) {
                if(((MovimientoStat) haUsado).getPropio()) {
                    p1.setVeloc(booster);
                }
                else {
                    p2.setVeloc(booster);
                }
            }
            else {
                p1.setVida(booster);
            }
        }
        else if(haUsado instanceof MovimientoAtaque) {
            float ataque = ((MovimientoAtaque) haUsado).getPotencia();
            int tipoAtaque = ((MovimientoAtaque) haUsado).getTipo()[0];
            float eficiencia = TablaTipos.getMiTablaTipos().calcularEfectividad(p1.getTipo()[0], p2.getTipo()[0]);
            float mismoTipo =(float) 1.0;
            if (((MovimientoAtaque) haUsado).getCat() == true){
                if(Arrays.asList(p1.getTipo()).contains(tipoAtaque)) {
                    mismoTipo = (float) 1.5;
                    p2.atacar(ataque,eficiencia,p1.getAtaque(),p2.getDefensa(),mismoTipo);
                }
                else {
                    p2.atacar(ataque,eficiencia,p1.getAtaque(),p2.getDefensa(),mismoTipo);
                }
            }
            else{
                if(Arrays.asList(p1.getTipo()).contains(tipoAtaque)) {
                    mismoTipo = (float) 1.5;
                    p2.atacar(ataque,eficiencia,p1.getAtaqueSp(),p2.getDefensaSp(),mismoTipo);
                }
                else {
                    p2.atacar(ataque,eficiencia,p1.getAtaqueSp(),p2.getDefensaSp(),mismoTipo);
                }
            }

        }
    }
    private void crearEntrenadores() {
        int cuantosPokemon  = 0;
        String pNombre = "PAKO";
        int pDinero = 5; //con la tienda
        for(int i=1;i<=20;i++) {
            if(i%5 == 0) { //de las rondas 5-10-15-20 rondetako entrenatzaileei 3 pokemon esleitzeko
                cuantosPokemon = 3;
            }
            else {
                cuantosPokemon = 1;
            }
            EntrenadorBot actual = new EntrenadorBot(pNombre,pDinero);
            actual.crearEquipo(cuantosPokemon);
            lista.add(actual);
        }
    }

    private void crearPersonaje() { // para crear el equipo del personaje
        int cuantosPokemon = 3;
        if(personaje == null) {
            personaje =  new EntrenadorPropio(" ",10);
            personaje.crearEquipo(cuantosPokemon);
        }
    }

    private Iterator<Entrenador> getIterador() {
        return this.lista.iterator();
    }

}
