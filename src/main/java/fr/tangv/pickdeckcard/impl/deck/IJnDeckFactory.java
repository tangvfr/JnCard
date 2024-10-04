package fr.tangv.pickdeckcard.impl.deck;

import fr.tangv.pickdeckcard.model.card.*;
import fr.tangv.pickdeckcard.model.deck.Deck;
import fr.tangv.pickdeckcard.model.deck.JnDeckFactory;

public class IJnDeckFactory<T extends ClassicCard> extends IClassicDeckFactory<T> implements JnDeckFactory<T> {

    private static final CardSymbol[] HEARTH_SYMBOLS = {CardSymbol.HEART, CardSymbol.DIAMOND};
    private static final CardSymbol[] ATTACK_SYMBOLS = {CardSymbol.CLUB, CardSymbol.SPADE};
    private static final CardValue[] FACE_VALUES = CardValue.valuesOfType(CardType.FACE);
    private static final CardValue[] NUMBER_VALUES = CardValue.valuesOfType(CardType.NUMBER);

    public IJnDeckFactory(ClassicCardFactory<T> cardFactory) {
        super(cardFactory);
    }

    public Deck<T> createHearth() {
        return this.createDeck(HEARTH_SYMBOLS, NUMBER_VALUES);
    }

    public Deck<T> createAttack() {
        //ajout des nombres noirs
        Deck<T> deck = this.createDeck(ATTACK_SYMBOLS, NUMBER_VALUES);
        //ajout de toutes les têtes
        this.appendCards(deck, CardSymbol.values(), FACE_VALUES);
        return deck;
    }

}
