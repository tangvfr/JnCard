package fr.tangv.pickdeckcard.model.board;

import fr.tangv.pickdeckcard.model.board.slot.BoardSlot;
import fr.tangv.pickdeckcard.model.board.slot.SlotType;

import java.util.List;
import java.util.function.Predicate;

public interface GameBoardPart<T, B extends BoardSlot<T>> {

    List<B> getSlots(SlotType type);
    int sizeSlots(SlotType type);
    B appendSlot(SlotType type);
    B appendSlot(SlotType type, T card);
    B getSlot(SlotType type, int index);
    B removeSlot(SlotType type, int index);
    boolean removeSlot(SlotType type, B slot);
    boolean removeSlot(SlotType type, T mainCard);
    boolean removeSlotsIf(SlotType type, Predicate<B> predicate);
    boolean removeAllSlots(SlotType type);
    void removeAllSlots();

}
