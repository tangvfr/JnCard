package fr.tangv.pickdeckcard.model.board;

import fr.tangv.pickdeckcard.model.board.slot.JnBoardSlot;
import fr.tangv.pickdeckcard.model.card.JnCard;
import fr.tangv.pickdeckcard.model.game.settings.JnGameSettings;

public interface JnGamePlayer extends GamePlayer<JnCard, JnGameSettings, JnGamePlayer, JnGameBoard> {

    GameBoardPart<JnCard, JnBoardSlot> getPlayerBoard();
    boolean hasShield();
    int countHearths();
    void addShield(JnCard card);
    void addHeart(JnCard card);

}
