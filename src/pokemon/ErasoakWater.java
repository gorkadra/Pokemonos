package pokemon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class ErasoakWater extends Erasoa {
	//atributuak
	private ArrayList<Erasoa> lista;
	private Random lag= new Random (System.nanoTime());
		
	//eraikitzailea;
	public ErasoakWater(String pIzena, int pErasoa, String pMota){
		super(pIzena,pErasoa,pMota);
		this.lista = new ArrayList<Erasoa>();
	}
		
	//metodoak
	private Iterator <Erasoa>getIteradorea() {
		return this.lista.iterator();
	}
		
	public void gehitu (Erasoa pMota){
		this.lista.add(pMota);
	}

	public Erasoa aukeratuerasoa (){
		int laguntzailea=lag.nextInt(6)+1;
		Iterator<Erasoa> itr= this.getIteradorea();
		int emaitza=0;
		Erasoa erasoa1=null;
		while (itr.hasNext() && emaitza!=laguntzailea){
			erasoa1=itr.next();
			emaitza=emaitza+1;			
		}
		return erasoa1;		
	}
}
