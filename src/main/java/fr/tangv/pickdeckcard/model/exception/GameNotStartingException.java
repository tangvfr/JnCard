package fr.tangv.pickdeckcard.model.exception;

public class GameNotStartingException extends GameStatementException {
    public GameNotStartingException(String message) {
        super(message);
    }
}
