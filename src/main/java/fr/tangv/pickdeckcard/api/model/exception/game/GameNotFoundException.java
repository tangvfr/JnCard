package fr.tangv.pickdeckcard.api.model.exception.game;

public class GameNotFoundException extends Exception {
    public GameNotFoundException(String message) {
        super(message);
    }
}
