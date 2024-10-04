package fr.tangv.pickdeckcard.impl.deck;

import fr.tangv.pickdeckcard.model.board.GameBoard;
import fr.tangv.pickdeckcard.model.board.GamePlayer;
import fr.tangv.pickdeckcard.model.deck.Deck;
import fr.tangv.pickdeckcard.model.deck.DeckBox;
import fr.tangv.pickdeckcard.model.game.settings.GameSettings;

import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Pioche normale avec défausse associée, qui pioche automatiquement dans une autre pioche x carte en cas de remix
 * @param <T>
 * @param <S>
 */
public class PollerDeckBox<T, S extends GameSettings, P extends GamePlayer<T, S, P, B>, B extends GameBoard<T, S, P, B>>
        extends IDeckBox<T, S, P, B> {

    private final DeckBox<T, S, P, B> polled;
    private final int pollNumber;

    private PollerDeckBox(DeckBox<T, S, P, B> polled, int pollNumber) {
        this.polled = polled;
        this.pollNumber = pollNumber;
    }

    /**
     * Permet d'ajouter à la pioche les cartes d'une autre pioche
     */
    private void pollCards() {
        Deck<T> deck = this.getDeck();
        try {
            for (int i = 0; i < this.pollNumber; i++) {
                deck.add(this.polled.remove());
            }
        } catch (NoSuchElementException ignored) {}
    }

    @Override
    public void remix() {
        Deck<T> deck = this.getDeck();
        this.getDump().transfertTo(deck);
        this.pollCards();
        deck.mix();
    }

    public static <T, S extends GameSettings, P extends GamePlayer<T, S, P, B>, B extends GameBoard<T, S, P, B>>
    PollerDeckBox<T, S, P, B> create(DeckBox<T, S, P, B> polled, int pollNumber) {
        Objects.requireNonNull(polled, "polled cannot be null");
        if (pollNumber <= 0) {
            throw new IllegalArgumentException("pollNumber must be greater than 0");
        }

        return new PollerDeckBox<>(polled, pollNumber);
    }

}
