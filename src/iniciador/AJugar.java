package iniciador;

import java.util.Observable;
import java.util.Observer;

public class AJugar implements Observer {

    private static AJugar jogoBonito;

    private AJugar(){}

    public static AJugar getAJugar(){
        if (jogoBonito==null){
            jogoBonito= new AJugar();
        }
        return jogoBonito;
    }

    public void iniciar(){

    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
