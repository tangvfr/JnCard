package fr.tangv.pickdeckcard.api.model.exception.player;

public class PlayerNotFoundException extends Exception {
    public PlayerNotFoundException(String message) {
        super(message);
    }
}
