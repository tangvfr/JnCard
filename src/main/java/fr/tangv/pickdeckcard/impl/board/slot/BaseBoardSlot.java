package fr.tangv.pickdeckcard.impl.board.slot;

import fr.tangv.pickdeckcard.model.board.slot.BoardSlot;
import fr.tangv.pickdeckcard.model.board.slot.SlotType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class BaseBoardSlot<T> implements BoardSlot<T> {

    private final SlotType slotType;

}
