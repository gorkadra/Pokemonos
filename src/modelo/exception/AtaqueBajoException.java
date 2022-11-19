package modelo.exception;

public class AtaqueBajoException extends Throwable {

    public AtaqueBajoException() {
        super();
    }
    //gainontzeko metodoak
    public void imprimirMensaje() {
        System.out.println("-----------------------------------------");
        System.out.println("El indice de ataque del model.pokemon ha bajado en exceso");
        System.out.println("-----------------------------------------");
    }

}
