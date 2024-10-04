package fr.tangv.pickdeckcard.impl.deck;

import fr.tangv.pickdeckcard.model.board.GameBoard;
import fr.tangv.pickdeckcard.model.board.GamePlayer;
import fr.tangv.pickdeckcard.model.deck.Deck;
import fr.tangv.pickdeckcard.model.deck.DeckBox;
import fr.tangv.pickdeckcard.model.game.settings.GameSettings;

import java.util.NoSuchElementException;

/**
 * Pioche normale avec défausse associée
 * @param <T>
 * @param <S>
 */
public class IDeckBox<T, S extends GameSettings, P extends GamePlayer<T, S, P, B>, B extends GameBoard<T, S, P, B>>
        extends AbstractCardPoller<T, S, P, B> implements DeckBox<T, S, P, B> {

    private Deck<T> deck;
    private Deck<T> dump;

    @Override
    public void initialize(Deck<T> deck, Deck<T> dump) {
        this.deck = deck;
        this.dump = dump;
    }

    @Override
    public Deck<T> getDump() {
        return this.dump;
    }

    @Override
    public Deck<T> getDeck() {
        return this.deck;
    }

    @Override
    public void remix() {
        this.dump.transfertTo(this.deck);
        this.deck.mix();
    }

    @Override
    public T remove() {
        try {
            return this.deck.remove();
        } catch (NoSuchElementException e) {
            this.remix();
            return this.deck.remove();
        }
    }

    @Override
    public T poll() {
        T card = this.deck.poll();

        if (card == null) {
            this.remix();
            return this.deck.poll();
        }
        return card;
    }

    @Override
    public void dump(T card) {
        this.dump.add(card);
    }

}
