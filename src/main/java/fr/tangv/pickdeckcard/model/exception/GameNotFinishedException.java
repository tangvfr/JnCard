package fr.tangv.pickdeckcard.model.exception;

public class GameNotFinishedException extends GameStatementException {
    public GameNotFinishedException(String message) {
        super(message);
    }
}
