package fr.tangv.pickdeckcard.impl.deck;

import fr.tangv.pickdeckcard.impl.card.ICard;
import fr.tangv.pickdeckcard.model.card.Card;
import fr.tangv.pickdeckcard.model.card.CardSymbol;
import fr.tangv.pickdeckcard.model.card.CardType;
import fr.tangv.pickdeckcard.model.card.CardValue;
import fr.tangv.pickdeckcard.model.deck.Deck;

import java.util.Arrays;

public class DeckFactory {

    public static final CardSymbol[] HEARTH_SYMBOLS = {CardSymbol.HEART, CardSymbol.DIAMOND};
    public static final CardSymbol[] ATTACK_SYMBOLS = {CardSymbol.CLUB, CardSymbol.SPADE};
    public static final CardValue[] FACE_VALUES = filterType(CardType.FACE);
    public static final CardValue[] NUMBER_VALUES = filterType(CardType.NUMBER);

    private static CardValue[] filterType(CardType type) {
        return Arrays.stream(CardValue.values())
                .filter((value) -> value.getType() == type)
                .toArray(CardValue[]::new);
    }

    public static void appendCards(Deck<Card> deck, CardSymbol[] symbols, CardValue[] values) {
        for (CardSymbol symbol : symbols) {
            for (CardValue value : values) {
                deck.add(ICard.createCard(value, symbol));
            }
        }
    }

    public static Deck<Card> createEmptyDeck() {
        return new IDeck<>();
    }

    public static Deck<Card> createDeck(CardSymbol[] symbols, CardValue[] values) {
        Deck<Card> deck = DeckFactory.createEmptyDeck();
        DeckFactory.appendCards(deck, symbols, values);
        return deck;
    }

    public static Deck<Card> createCompletedDeck() {
        return createDeck(CardSymbol.values(), CardValue.values());
    }

    /**
     * (10 sur le dessus du packer)
     * @return le tat des cartes de nombres rouges
     */
    public static Deck<Card> createHearthDeck() {
        return createDeck(HEARTH_SYMBOLS, NUMBER_VALUES);
    }

    public static Deck<Card> createAttackDeck() {
        //ajout des nombres noirs
        Deck<Card> deck = createDeck(ATTACK_SYMBOLS, NUMBER_VALUES);
        //ajout de toutes les têtes
        DeckFactory.appendCards(deck, CardSymbol.values(), FACE_VALUES);
        return deck;
    }

}
