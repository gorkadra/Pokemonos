package pokemon;

public abstract class Entrenador {
    //atributos
    private ListaPokemon listaPokemon;
    private String nombre;
    private int dinero;
    //constructor
    public Entrenador(String pNombre,int pDinero) {
        this.nombre = pNombre;
        this.dinero = pDinero;
        this.listaPokemon = new ListaPokemon();
    }
    //metodos
    public ListaPokemon getMiListaPokemon() {
        return this.listaPokemon;
    }
    public String getNombre() {
        return this.nombre;
    }
    public int getDinero() {
        return this.dinero;
    }
    public void setDinero(int pDinero) {
        this.dinero=this.dinero+pDinero;
    }
    protected void setNombre(String pNombre){
        this.nombre=pNombre;
    }
    public void crearEquipo(int numPoke) {
        int[] numLista = new int[4];
        int loop = 0;
        boolean esta = false;
        int i = 1;
        while(i<=numPoke) {
            int numAleatorio = (int) (Math.random()*Pokedex.getMiPokedex().listaLongitud());
            while (loop <= 3 && !esta) {
                if(numLista[loop]== numAleatorio) {
                    esta = true;
                }
                loop = loop + 1;
            }
            if(!esta) {
                numLista[i] = numAleatorio;
                Pokemon mom = Pokedex.getMiPokedex().crearPokemon(numAleatorio);
                Pokemon copia = new Pokemon(mom.getNombre(),mom.getId(), mom.getVida(), mom.getAtaque(), mom.getVeloc(), mom.getDefensa(), mom.getTipo(), mom.getAtaqueSp(), mom.getDefensaSp());
                copia.setVidaMax(mom.getVida());
                copia.setListaMovi(mom.getMiLista());
                listaPokemon.addPokemon(copia);
                i = i + 1;
            }
            else {
                esta = false;
            }
            loop = 0;
        }
    }
    public abstract Movimiento usarMovimiento(Pokemon pPoke);
}