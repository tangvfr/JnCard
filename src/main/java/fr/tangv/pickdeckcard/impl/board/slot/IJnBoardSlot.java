package fr.tangv.pickdeckcard.impl.board.slot;

import fr.tangv.pickdeckcard.model.board.slot.JnBoardSlot;
import fr.tangv.pickdeckcard.model.board.slot.SlotType;
import fr.tangv.pickdeckcard.model.card.JnCard;
import lombok.Getter;
import lombok.Setter;

import java.util.Iterator;

public class IJnBoardSlot extends BaseMultipleBoardSlot<JnCard> implements JnBoardSlot {

    @Getter @Setter
    private boolean isBoosted = false;
    private byte shield = 0;

    public IJnBoardSlot(SlotType slotType) {
        super(slotType);
    }

    @Override
    public boolean isShield() {
        return this.getSlotType() == SlotType.SHIELD;
    }

    @Override
    public void setShield(byte shield) {
        if (shield <= 0) {
            throw new IllegalArgumentException("shield can't be negative or zero");
        }
        this.shield = shield;
    }

    @Override
    public int calcDurability() {
        int durability = this.isShield() ? this.shield : this.getMain().getValue().getValue();
        Iterator<JnCard> list = this.getAll().listIterator(1);//on saute la main
        JnCard card;

        while (list.hasNext() && durability > 0) {
            card = list.next();
            durability -= card.getValue().getValue();
        }

        if (durability < 0) {
            durability = 0;
        }

        return durability;
    }

    @Override
    public boolean isBroken() {
        return this.calcDurability() == 0;
    }

}
