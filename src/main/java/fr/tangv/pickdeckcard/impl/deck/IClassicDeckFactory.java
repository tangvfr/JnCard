package fr.tangv.pickdeckcard.impl.deck;

import fr.tangv.pickdeckcard.model.card.*;
import fr.tangv.pickdeckcard.model.deck.ClassicDeckFactory;
import fr.tangv.pickdeckcard.model.deck.Deck;

public class IClassicDeckFactory<T extends ClassicCard> implements ClassicDeckFactory<T> {

    private final ClassicCardFactory<T> cardFactory;

    public IClassicDeckFactory(ClassicCardFactory<T> cardFactory) {
        this.cardFactory = cardFactory;
    }

    protected void appendCards(Deck<T> deck, CardSymbol[] symbols, CardValue[] values) {
        for (CardSymbol symbol : symbols) {
            for (CardValue value : values) {
                deck.add(this.cardFactory.create(value, symbol));
            }
        }
    }

    protected Deck<T> createDeck(CardSymbol[] symbols, CardValue[] values) {
        Deck<T> deck = this.createEmpty();
        this.appendCards(deck, symbols, values);
        return deck;
    }

    public Deck<T> createEmpty() {
        return new IDeck<>();
    }

    public Deck<T> createCompleted() {
        return this.createDeck(CardSymbol.values(), CardValue.values());
    }

}
