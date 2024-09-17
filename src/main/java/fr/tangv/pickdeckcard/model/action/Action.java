package fr.tangv.pickdeckcard.model.action;

import fr.tangv.pickdeckcard.model.board.BoardSlot;
import fr.tangv.pickdeckcard.model.board.GamePlayer;
import fr.tangv.pickdeckcard.model.card.JnCard;
import fr.tangv.pickdeckcard.model.game.GameSettings;

import java.util.Set;

public interface Action<T, S extends GameSettings> {

    ActionType getType();
    GamePlayer<T, S> getExecutor();
    Set<T> getCards();
    BoardSlot<T> getTarget();
    boolean hasCard();
    boolean hasTarget();
    boolean isAvaible();
    void execute();

}
