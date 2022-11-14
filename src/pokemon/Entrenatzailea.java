package pokemon;

public class Entrenatzailea extends Jokalaria{

	//atributuak
	private int puntuazioAkum = 0;
	
	//eraikitzailea 
	public Entrenatzailea(String pIzena, int pPuntuazioa){
		super(pIzena,pPuntuazioa);
	}
	
	//metodoak
	public void gehituPuntuazioa(String pIzena){
		
		if (super.izena == pIzena){
			super.puntuazioa = this.puntuazioAkum + 1;
		}
	}
	
	public void imprimatuta (String pIzena){
	System.out.println("Izena: "+pIzena+" Puntuak: "+this.puntuazioAkum+"");
	}
	
	public void gehituPokemon (Pokemon pPokemon){
		if(super.lista.getTamaina()==0){
			super.lista.gehituPokemon(pPokemon);
	}
	}
}
