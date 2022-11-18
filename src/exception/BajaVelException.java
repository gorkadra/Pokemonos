package exception;

public class BajaVelException extends Throwable {

    public BajaVelException() {
        super();
    }
    //gainontzeko metodoak
    public void imprimirMensaje() {
        System.out.println("-----------------------------------------");
        System.out.println("El indice de velocidad del pokemon ha bajado en exceso");
        System.out.println("-----------------------------------------");
    }

}
