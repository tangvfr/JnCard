package fr.tangv.pickdeckcard.impl.deck;

import fr.tangv.pickdeckcard.model.deck.Deck;
import fr.tangv.pickdeckcard.model.deck.DeckBox;
import fr.tangv.pickdeckcard.model.card.JnCard;
import fr.tangv.pickdeckcard.model.game.GameSettings;

import javax.smartcardio.Card;
import java.util.NoSuchElementException;
import java.util.Objects;

public class PollerDeckBox<T, S extends GameSettings> extends IDeckBox<T, S> {

    private final DeckBox<T, S> polled;
    private final int pollNumber;

    private PollerDeckBox(DeckBox<T, S> polled, int pollNumber) {
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

    public static <T, S extends GameSettings> PollerDeckBox<T, S> create(DeckBox<T, S> polled, int pollNumber) {
        Objects.requireNonNull(polled, "polled cannot be null");
        if (pollNumber <= 0) {
            throw new IllegalArgumentException("pollNumber must be greater than 0");
        }

        return new PollerDeckBox<>(polled, pollNumber);
    }

}
