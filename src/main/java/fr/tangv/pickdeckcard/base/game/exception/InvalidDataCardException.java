package fr.tangv.pickdeckcard.base.game.exception;

/**
 * Permet de signaler que les données pour faire références a une carte sont invalides
 */
public class InvalidDataCardException extends Exception {
    public InvalidDataCardException(String message) {
        super(message);
    }
}
