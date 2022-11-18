package exception;

public class DemasiadaVidaException extends Throwable {

    public DemasiadaVidaException() {
        super();
    }
    //gainontzeko metodoak
    public void imprimirMensaje() {
        System.out.println("-----------------------------------------");
        System.out.println("El pokemon ha recuperado vida en exceso");
        System.out.println("-----------------------------------------");
    }

}
