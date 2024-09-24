package fr.tangv.pickdeckcard.model.event.exception;

public class AlreadyRegisterListenerException extends RuntimeException {
    public AlreadyRegisterListenerException(String message) {
        super(message);
    }
}
