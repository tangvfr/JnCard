package fr.tangv.pickdeckcard.impl.board.slot;

import fr.tangv.pickdeckcard.model.board.slot.MultipleBoardSlot;
import fr.tangv.pickdeckcard.model.board.slot.SlotType;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class BaseMultipleBoardSlot<T> extends BaseBoardSlot<T> implements MultipleBoardSlot<T> {

    private static final int DEFAULT_CARD_NUMBER_IN_SLOT = 2;

    private final Deque<T> cards = new ArrayDeque<>(DEFAULT_CARD_NUMBER_IN_SLOT);

    public BaseMultipleBoardSlot(SlotType slotType) {
        super(slotType);
    }

    @Override
    public T getMain() {
        return this.cards.peekFirst();
    }

    @Override
    public T defineMain(T card) {
        this.cards.addFirst(card);
        return null;
    }

    @Override
    public List<T> getAll() {
        return List.copyOf(this.cards);
    }

    @Override
    public T poll() {
        return this.cards.pollLast();
    }

    @Override
    public void offer(T card) {
        this.cards.offerLast(card);
    }

    @Override
    public int size() {
        return this.cards.size();
    }

    @Override
    public boolean isEmpty() {
        return this.cards.isEmpty();
    }

}
