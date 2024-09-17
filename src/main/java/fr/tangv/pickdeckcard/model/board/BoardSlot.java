package fr.tangv.pickdeckcard.model.board;

import java.util.List;

public interface BoardSlot<T> {

    List<T> getAll();
    T getMain();
    T pop();
    void offer(T card);

    boolean isEmpty();
    boolean isBoosted();
    void setBoosted(boolean boosted);
    int calcDurability();
    boolean isBroken();
    SlotType getSlotType();

}
