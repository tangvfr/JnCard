package fr.tangv.pickdeckcard.model.board.slot;

import fr.tangv.pickdeckcard.model.card.JnCard;

public interface JnBoardSlot extends MultipleBoardSlot<JnCard> {

    boolean isShield();
    void setShield(byte shield);
    boolean isBoosted();
    void setBoosted(boolean isBoosted);
    int calcDurability();
    boolean isBroken();

}
