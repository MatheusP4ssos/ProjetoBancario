package MatheusP4ssos.com.github.ProjetoBancario.exception;

import org.hibernate.ObjectNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<String> handleArithmeticException(ArithmeticException e) {
        String errorMessage = "Foi feita uma operação matematica irregular";
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrityViolationException(
            DataIntegrityViolationException e) {
        String errorMessage = "Descrição: " + e.getLocalizedMessage();
        return new ResponseEntity<>(errorMessage, HttpStatus.PRECONDITION_FAILED);
    }

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<String> handlerObjNotFoundException(ObjectNotFoundException e) {
        String errorMessage = "Objeto não encontrado!";
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

}