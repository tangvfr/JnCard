package fr.tangv.pickdeckcard.model.event.exception;

public class NotFoundListenerException extends RuntimeException {
    public NotFoundListenerException(String message) {
        super(message);
    }
}
