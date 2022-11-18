package pokemon;

public class Pokedex {
        //atributos
        private static Pokedex miPokedex = null;
        private ListaPokemon miListaPokemon;
        //constructor
        private Pokedex() {
            this.miListaPokemon = new ListaPokemon();
        }

        public static Pokedex getMiPokedex() {
            if(miPokedex == null) {
                miPokedex = new Pokedex();
            }
            return miPokedex;
        }
        //resto de metodos
        public ListaPokemon getMiLista() {
            return this.miListaPokemon;
        }
        public int listaLongitud() {
            return this.miListaPokemon.listaLongitud();
        }

        public Pokemon crearPokemon(int pokemonId) {
            return miListaPokemon.crearPokemon(pokemonId);
        }
        public void reset() {
            miListaPokemon.getMiLista().clear();
        }
    }

