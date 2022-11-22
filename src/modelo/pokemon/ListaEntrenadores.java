package modelo.pokemon;

import java.util.*;


public class ListaEntrenadores extends Observable {
    //atributos
    private static ListaEntrenadores listaEntrenadores = null;
    private EntrenadorPropio personaje = null;
    private EntrenadorBot rival = null;
    private boolean primeraVez = true;
    private Pokemon miPoke = null;
    private Pokemon actualPoke = null;
    // constructor
    private void ListaEntrenadores() {

    }
    public static ListaEntrenadores getMiListaEntrenadores() {
        if(listaEntrenadores == null) {
            listaEntrenadores = new ListaEntrenadores();
        }
        return listaEntrenadores;
    }
    //resto de metodos

    public void setPersonaje(EntrenadorPropio pPerson) {
        this.personaje = pPerson;
    }
    public void resetear() {
        this.rival = null;
    }

    public void pelearConNum(int ataque) {

        boolean vaBien = true;//para saber si se han debilitado los model.pokemon
        boolean tienePokemonRival = true;
        //Propio
        Iterator<Pokemon> miEquipo = personaje.getMiListaPokemon().getIterador(); //para coger los pokemon de nuestro equipo
        tienePokemonRival = true;
        //Rival
        Iterator<Pokemon> enmigoEquipo = rival.getMiListaPokemon().getIterador(); //para coger el equipo del entrenador actual


        System.out.println("Tu rival tiene "+ rival.getMiListaPokemon().listaLongitud()+" pokemon");
        if(primeraVez || actualPoke == null) {
            if (primeraVez) {
                actualPoke = enmigoEquipo.next();
                miPoke = miEquipo.next();
                primeraVez = false;
            }
            else { //para cuando pases de ronda no de null
                actualPoke = enmigoEquipo.next();
            }
        }
        if(vaBien && tienePokemonRival) {
            if(actualPoke.getVeloc() > miPoke.getVeloc()) {
                System.out.println("Rival primero");
                Movimiento haUsado = rival.usarMovi(actualPoke);
                turnoAtaque(actualPoke,miPoke,haUsado);
                if(miPoke.getVida()>0) { //para saber si tiene vida ese pokémon
                    Movimiento yoUso = personaje.usarMoviNum(miPoke, ataque);
                    turnoAtaque(miPoke,actualPoke,yoUso);
                    if(actualPoke.getVida() <= 0){
                        rival.setPokRes(rival.getPokRes()-1);
                        if(rival.getPokRes()!=0) {
                            actualPoke = enmigoEquipo.next(); //model.pokemon del contrario
                            rival.setCambio(true);
                            setChanged();
                            notifyObservers(Notificaciones.pokemonCambiado);
                        }
                        else {
                            System.out.println("el entrenador actual se ha quedado sin pokémon");
                            setChanged();
                            notifyObservers(Notificaciones.pierdeRival);
                            tienePokemonRival = false;
                        }
                    }else{
                        setChanged();
                        notifyObservers(Notificaciones.turnoHecho);
                    }
                }
                else {
                    personaje.setPokRes(personaje.getPokRes()-1);
                    if(personaje.getPokRes()!=0) { //si se debilita un model.pokemon, que entre otro
                        System.out.println("Tu pokemon:");
                        miPoke = miEquipo.next(); //pokemon del rival
                        personaje.setCambio(true);

                        setChanged();
                        notifyObservers(Notificaciones.pokemonCambiado);
                    }
                    else {
                        vaBien = false;
                        setChanged();
                        notifyObservers(Notificaciones.pierdePropio);
                    }
                }

            }
            else {
                System.out.println("Tu primero");
                Movimiento yoUso = personaje.usarMoviNum(miPoke,ataque);
                turnoAtaque(miPoke,actualPoke,yoUso);
                if(actualPoke.getVida()>0) {//para saber si el model.pokemon tiene vida
                    Movimiento haUsado = rival.usarMovi(actualPoke);
                    turnoAtaque(miPoke,miPoke,haUsado);
                    if(miPoke.getVida() <= 0) {
                        personaje.setPokRes(personaje.getPokRes()-1);
                        if(personaje.getPokRes()!=0) { //si se debilita un .pokemon que entre el siguiente
                            System.out.println(personaje.getPokRes());
                            System.out.println("Mi pokemon:");
                            miPoke = miEquipo.next(); //pokemon actual del contrario
                            personaje.setCambio(true);


                            setChanged();
                            notifyObservers(Notificaciones.pokemonCambiado);
                        }
                        else {
                            vaBien = false;
                            setChanged();
                            notifyObservers(Notificaciones.pierdePropio);
                        }
                    }else{
                        setChanged();
                        notifyObservers(Notificaciones.turnoHecho);
                    }

                }
                else {
                    rival.setPokRes(rival.getPokRes()-1);
                    if(rival.getPokRes()!=0) {
                        actualPoke = enmigoEquipo.next(); //pokemon actual del rival
                        rival.setCambio(true);

                        setChanged();
                        notifyObservers(Notificaciones.pokemonCambiado);
                    }
                    else {
                        System.out.println("el entrenador rival no tiene pokemon");
                        setChanged();
                        notifyObservers(Notificaciones.pierdeRival);
                        personaje.setDinero(rival.getDinero());
                        System.out.println("dinero:"+ personaje.getDinero());

                        tienePokemonRival = false;
                    }
                }
            }
        }

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
            if (personaje.getMiListaPokemon().getMiLista().contains(p1)){
                personaje.setUsado(haUsado.getDescripcion(),((MovimientoStat) haUsado).getBooster());
            }

        }
        else if(haUsado instanceof MovimientoAtaque) {
            float ataque = ((MovimientoAtaque) haUsado).getPotencia();
            int tipoAtaque = ((MovimientoAtaque) haUsado).getTipo();
            float eficiencia = TablaTipos.getMiTablaTipos().calcularEfectividad(tipoAtaque, p2.getTipo()[0], p2.getTipo()[0]);
            System.out.println(eficiencia);
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
            if (personaje.getMiListaPokemon().getMiLista().contains(p1)){
                personaje.setUsado(haUsado.getDescripcion(), ((MovimientoAtaque) haUsado).getPotencia());
            }

        }
    }
    public void crearEntrenador() {
        int cuantosPokemon  = 3;
        String pNombre = "PAKO";
        int pDinero = 5; //con la tienda
        EntrenadorBot actual = new EntrenadorBot(pNombre,pDinero);
        actual.crearEquipo(cuantosPokemon);
        rival = actual;

        setChanged();
        notifyObservers(Notificaciones.pokemonCambiado);

    }

    private void crearPersonaje() { // para crear el equipo del personaje
        int cuantosPokemon = 3;
        if(personaje == null) {
            personaje =  EntrenadorPropio.getEntrenadorPropio();
            personaje.crearEquipo(cuantosPokemon);
        }
    }



    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
    }

    public EntrenadorPropio getPersonaje() {
        return personaje;
    }

    public EntrenadorBot getRival() {
        return rival;
    }

    public void setRival(EntrenadorBot rival) {
        this.rival = rival;
    }
}
