package pokemon;

public class Aurkaria extends Jokalaria{

	//atributuak
	private int puntuazioAkum = 0;
	
	//eraikitzailea 
	public Aurkaria(String pIzena, int pPuntuazioa){
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
	


}
