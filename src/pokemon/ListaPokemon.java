package pokemon;
import java.util.ArrayList;
import java.util.Iterator;

public class ListaPokemon {
	//atributos
	private ArrayList<Pokemon> lista;
	//constructor
	public ListaPokemon() {
		this.lista = new ArrayList<Pokemon>();
	}
	//resto de métodos
	public ArrayList<Pokemon> getMiLista(){
		return this.lista;
	}
	public int listaLongitud() {
		return this.lista.size();
	}
	public void addPokemon(Pokemon pPoke) {
		this.lista.add(pPoke);
	}

	public void removePokemon(Pokemon pPoke) {
		this.lista.remove(pPoke);
	}

	public Pokemon buscarPokemonId(int pokemonId) {
		Pokemon res = null;
		boolean enc = false;
		Iterator<Pokemon> itr = this.getIterador();
		while(itr.hasNext() &&!enc){
			res = itr.next();
			if(res.mismoId(pokemonId)) {
				enc = true;
			}
		}
		return res;
	}

	public Pokemon crearPokemon(int pokemonId) {
		Pokemon deseado = this.buscarPokemonId(pokemonId); //aleatorioki erabakitako pokemon-a pokedex osoan bilatzean, bariable horretan gordetzeko
		deseado.asignarMovim(); // aurkitu dugun pokemon-ari mugimenduak esleitzeko
		return deseado;
	}

	public Iterator<Pokemon> getIterador() {
		return lista.iterator();
	}

	public void imprimirPokemon() {
		Iterator<Pokemon> itr = this.getIterador();
		while(itr.hasNext()) {
			Pokemon mom = itr.next();
			System.out.println("Pokemonaren izena: " + mom.getNombre());
			System.out.println(mom.getMiLista().listaLongi());
			mom.getMiLista().imprimirMovi();
		}
	}
	public void reset() {
		this.lista.clear();
	}
}