package fr.tangv.pickdeckcard.base.game.deck;

import fr.tangv.pickdeckcard.base.game.card.Card;

public interface Deck<T extends Card> {

    void mixed();
    T pick();
    void insert(T card);
    int size();
    boolean isEmpty();

}
