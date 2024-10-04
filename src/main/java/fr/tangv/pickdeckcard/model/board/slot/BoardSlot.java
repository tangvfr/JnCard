package fr.tangv.pickdeckcard.model.board.slot;

public interface BoardSlot<T> {

    T getMain();
    T defineMain(T card);
    boolean isEmpty();
    SlotType getSlotType();

}
