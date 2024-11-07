package fr.tangv.pickdeckcard.model.exception.countdown;

public class CountdownException extends Exception {
    public CountdownException(String message) {
        super(message);
    }
    public CountdownException() {
        super();
    }
}
