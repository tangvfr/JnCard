package fr.tangv.pickdeckcard.impl.board;

import fr.tangv.pickdeckcard.model.board.JnGameBoard;
import fr.tangv.pickdeckcard.model.board.JnGamePlayer;
import fr.tangv.pickdeckcard.model.board.slot.JnBoardSlot;
import fr.tangv.pickdeckcard.model.board.slot.SlotType;
import fr.tangv.pickdeckcard.model.card.JnCard;
import fr.tangv.pickdeckcard.model.game.settings.JnGameSettings;
import lombok.Getter;

import java.util.Objects;

public class IJnGamePlayer extends BaseGamePlayer<JnCard, JnGameSettings, JnGamePlayer, JnGameBoard> implements JnGamePlayer {

    @Getter
    private IGameBoardPart<JnCard, JnBoardSlot> playerBoard;

    @Override
    public boolean hasShield() {
        return !this.playerBoard.getSlots(SlotType.SHIELD).isEmpty();
    }

    @Override
    public int countHearths() {
        return this.playerBoard.getSlots(SlotType.HEARTH).stream()
                .mapToInt(JnBoardSlot::calcDurability)
                .sum();
    }

    @Override
    public void addShield(JnCard card) {
        Objects.requireNonNull(card);
        this.playerBoard.appendSlot(SlotType.SHIELD, card);
    }

    @Override
    public void addHeart(JnCard card) {
        Objects.requireNonNull(card);
        this.playerBoard.appendSlot(SlotType.HEARTH, card);
    }

    @Override
    public void distribute(JnCard card) {
        Objects.requireNonNull(card);
        if (card.isHearth()) {
            this.addHeart(card);
        } else {
            this.addHand(card);
        }
    }

    @Override
    public boolean isDeath() {
        return this.playerBoard.getSlots(SlotType.HEARTH).isEmpty();
    }

}
