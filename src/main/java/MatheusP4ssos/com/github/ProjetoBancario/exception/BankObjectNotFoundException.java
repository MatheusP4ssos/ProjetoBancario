package MatheusP4ssos.com.github.ProjetoBancario.exception;

public class BankObjectNotFoundException extends RuntimeException {
    public BankObjectNotFoundException(String message) {
        super(message);
    }

    public BankObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
