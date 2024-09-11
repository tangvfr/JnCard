package fr.tangv.pickdeckcard.model.card.excpetion;

/**
 * Permet de signaler que les données pour faire références a une carte sont invalides
 */
public class InvalidDataCardException extends RuntimeException {
    public InvalidDataCardException(String message) {
        super(message);
    }
}
