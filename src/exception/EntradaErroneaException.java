package exception;

public class EntradaErroneaException  extends Throwable {
    public EntradaErroneaException() {
        super();}
    public void imprimirMsj() {
        System.out.println("Selección invalida, pruebe otra vez.");
    }
}
