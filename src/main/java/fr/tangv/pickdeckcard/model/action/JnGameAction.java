package fr.tangv.pickdeckcard.model.action;

import fr.tangv.pickdeckcard.model.board.JnGamePlayer;
import fr.tangv.pickdeckcard.model.board.slot.JnBoardSlot;
import fr.tangv.pickdeckcard.model.card.JnCard;
import fr.tangv.pickdeckcard.model.game.JnGame;

import java.util.List;

public interface JnGameAction extends Action {

    JnGameActionType getType();
    JnGame getGame();
    JnGamePlayer getExecutor();
    List<JnCard> getCards();
    JnBoardSlot getTarget();
    boolean hasCard();
    boolean hasTarget();

}
