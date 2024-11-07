package fr.tangv.pickdeckcard.model.action;

import fr.tangv.pickdeckcard.model.board.JnGamePlayer;
import fr.tangv.pickdeckcard.model.board.slot.JnBoardSlot;
import fr.tangv.pickdeckcard.model.game.JnGame;

public interface JnGameActionNoCard extends Action {

    JnGame getGame();
    JnGamePlayer getExecutor();
    JnBoardSlot getTarget();
    boolean hasCard();
    boolean hasTarget();

}
