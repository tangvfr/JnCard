package fr.tangv.pickdeckcard.model.board.slot;

public interface BoardSlotFactory<T, B extends BoardSlot<T>> {

    B create(SlotType type);

}
