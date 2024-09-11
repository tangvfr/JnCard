package fr.tangv.pickdeckcard.model.deck;

import fr.tangv.pickdeckcard.model.board.GamePlayer;
import fr.tangv.pickdeckcard.model.card.Card;

/**
 * Représente une pioche accompagnée de ça défausse
 * @param <T> le type de carte utilisé
 */
public interface DeckBox<T extends Card> {

    void initialize(Deck<T> deck, Deck<T> dump);
    Deck<T> getDump();
    Deck<T> getDeck();
    void remix();
    T remove();
    T poll();
    void dump(T card);

}
