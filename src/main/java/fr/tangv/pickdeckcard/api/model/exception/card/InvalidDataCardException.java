package fr.tangv.pickdeckcard.api.model.exception.card;

/**
 * Permet de signaler que les données pour faire références a une carte sont invalides
 */
public class InvalidDataCardException extends RuntimeException {
    public InvalidDataCardException(String message) {
        super(message);
    }
}
