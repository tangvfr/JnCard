package fr.tangv.pickdeckcard.api.model.exception.action;

public class TurnActionException extends ForbidenActionException {
    public TurnActionException(String message) {
        super(message);
    }
}
