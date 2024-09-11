package fr.tangv.pickdeckcard.model.action;

import fr.tangv.pickdeckcard.model.board.BoardSlot;
import fr.tangv.pickdeckcard.model.board.GamePlayer;
import fr.tangv.pickdeckcard.model.card.Card;

import java.util.Set;

public interface CardAction<T extends Card> {

    GamePlayer<T> getExecutor();
    Set<T> getCards();
    BoardSlot<T> getTarget();
    boolean isAvaible();
    void execute();

}
