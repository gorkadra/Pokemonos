package pokemon;

import java.util.ArrayList;

public abstract class ListaPokemon {

	//atributuak
	private ArrayList<Pokemon> lista;
	
	//eraikitzailea;
	public ListaPokemon(){
		this.lista = new ArrayList<Pokemon>();
	}
	
	//metodoak
	public void gehituPokemon (Pokemon pPokemon){
		this.lista.add(pPokemon);
	}
	
	public int getTamaina(){
		return this.lista.size();
	}
}
