package exception;

public class DemasiadaVelException extends Throwable {

    public DemasiadaVelException() {
        super();
    }
    //gainontzeko metodoak
    public void imprimirMensaje() {
        System.out.println("-----------------------------------------");
        System.out.println("El indice de velocidad del pokemon ha subido en exceso");
        System.out.println("-----------------------------------------");
    }

}
