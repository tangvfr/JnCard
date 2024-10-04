package fr.tangv.pickdeckcard.impl.board.slot;

import fr.tangv.pickdeckcard.model.board.slot.BoardSlotFactory;
import fr.tangv.pickdeckcard.model.board.slot.JnBoardSlot;
import fr.tangv.pickdeckcard.model.board.slot.SlotType;
import fr.tangv.pickdeckcard.model.card.JnCard;

public class IJnBoardSlotFactory implements BoardSlotFactory<JnCard, JnBoardSlot> {

    @Override
    public JnBoardSlot create(SlotType type) {
        return new IJnBoardSlot(type);
    }

}
