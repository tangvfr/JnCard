package fr.tangv.pickdeckcard.model.deck;

import fr.tangv.pickdeckcard.model.game.GameSettings;

/**
 * Représente une pioche accompagnée de ça défausse
 * @param <T> le type de carte utilisé
 */
public interface DeckBox<T, S extends GameSettings> extends CardPoller<T, S> {

    void initialize(Deck<T> deck, Deck<T> dump);
    Deck<T> getDump();
    Deck<T> getDeck();
    void remix();
    T remove();
    T poll();
    void dump(T card);

}
