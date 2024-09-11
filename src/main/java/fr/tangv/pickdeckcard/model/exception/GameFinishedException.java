package fr.tangv.pickdeckcard.model.exception;

public class GameFinishedException extends GameStatementException {
    public GameFinishedException(String message) {
        super(message);
    }
}
