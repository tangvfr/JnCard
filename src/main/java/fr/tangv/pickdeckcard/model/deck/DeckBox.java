package fr.tangv.pickdeckcard.model.deck;

import fr.tangv.pickdeckcard.model.board.GameBoard;
import fr.tangv.pickdeckcard.model.board.GamePlayer;
import fr.tangv.pickdeckcard.model.game.settings.GameSettings;

/**
 * Représente une pioche accompagnée de ça défausse
 * @param <T> le type de carte utilisé
 */
public interface DeckBox<T, S extends GameSettings, P extends GamePlayer<T, S, P, B>, B extends GameBoard<T, S, P, B>>
        extends CardPoller<T, S, P, B> {

    void initialize(Deck<T> deck, Deck<T> dump);
    Deck<T> getDump();
    Deck<T> getDeck();
    void remix();
    T remove();
    T poll();
    void dump(T card);

}
