package pokemon;

public abstract class Jokalaria {

	//atributuak
	protected String izena;
	protected int puntuazioa;
	protected ListaPokemon lista;
	
	//eraikitzailea
	public Jokalaria(String pIzena, int pPuntuazioa){
		this.izena = pIzena;
		this.puntuazioa = pPuntuazioa;
	}
	
	//metodoak
	
	public abstract void gehituPokemon(Pokemon pPokemon);
	
	public abstract void gehituPuntuazioa(String pIzena);
}
