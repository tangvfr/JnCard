package fr.tangv.pickdeckcard.model.board;

import fr.tangv.pickdeckcard.model.card.Card;

import java.util.List;

public interface BoardSlot<T extends Card> {

    List<T> getAll();
    T getMain();
    T pop();
    void offer(T card);

    boolean isEmpty();
    boolean isBoosted();
    void setBoosted(boolean boosted);
    int calcDurability();
    boolean isBroken();

}
