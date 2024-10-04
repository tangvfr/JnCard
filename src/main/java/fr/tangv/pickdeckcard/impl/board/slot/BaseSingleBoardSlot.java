package fr.tangv.pickdeckcard.impl.board.slot;

import fr.tangv.pickdeckcard.model.board.slot.BoardSlot;
import fr.tangv.pickdeckcard.model.board.slot.SlotType;

public class BaseSingleBoardSlot<T> extends BaseBoardSlot<T> implements BoardSlot<T> {

    private T card;

    public BaseSingleBoardSlot(SlotType slotType) {
        super(slotType);
    }

    @Override
    public T defineMain(T card) {
        T old = this.card;
        this.card = card;
        return old;
    }

    @Override
    public T getMain() {
        return this.card;
    }

    @Override
    public boolean isEmpty() {
        return this.card == null;
    }

}
