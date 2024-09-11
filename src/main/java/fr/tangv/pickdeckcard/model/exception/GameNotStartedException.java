package fr.tangv.pickdeckcard.model.exception;

public class GameNotStartedException extends GameStatementException {
    public GameNotStartedException(String message) {
        super(message);
    }
}
