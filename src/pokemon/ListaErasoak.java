package pokemon;

import java.util.ArrayList;

public abstract class ListaErasoak {

	private ArrayList<Erasoa> lista;
	
	//eraikitzailea
	public ListaErasoak(){
		this.lista = new ArrayList<Erasoa>();
	}
	
	//metodoak
	public int getTamaina(){
		return this.lista.size();
	}
	
	public void gehituErasoak(){
		
	}
}
