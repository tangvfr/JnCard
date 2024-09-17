package fr.tangv.pickdeckcard.impl.deck;

import fr.tangv.pickdeckcard.impl.card.ICard;
import fr.tangv.pickdeckcard.model.card.JnCard;
import fr.tangv.pickdeckcard.model.card.CardSymbol;
import fr.tangv.pickdeckcard.model.card.CardType;
import fr.tangv.pickdeckcard.model.card.CardValue;
import fr.tangv.pickdeckcard.model.deck.Deck;

import java.util.Arrays;

public class JnDeckFactory {

    public static final CardSymbol[] HEARTH_SYMBOLS = {CardSymbol.HEART, CardSymbol.DIAMOND};
    public static final CardSymbol[] ATTACK_SYMBOLS = {CardSymbol.CLUB, CardSymbol.SPADE};
    public static final CardValue[] FACE_VALUES = filterType(CardType.FACE);
    public static final CardValue[] NUMBER_VALUES = filterType(CardType.NUMBER);

    private static CardValue[] filterType(CardType type) {
        return Arrays.stream(CardValue.values())
                .filter((value) -> value.getType() == type)
                .toArray(CardValue[]::new);
    }

    public static void appendCards(Deck<JnCard> deck, CardSymbol[] symbols, CardValue[] values) {
        for (CardSymbol symbol : symbols) {
            for (CardValue value : values) {
                deck.add(ICard.create(value, symbol));
            }
        }
    }

    public static Deck<JnCard> createEmptyDeck() {
        return new IDeck<>();
    }

    public static Deck<JnCard> createDeck(CardSymbol[] symbols, CardValue[] values) {
        Deck<JnCard> deck = JnDeckFactory.createEmptyDeck();
        JnDeckFactory.appendCards(deck, symbols, values);
        return deck;
    }

    public static Deck<JnCard> createCompletedDeck() {
        return createDeck(CardSymbol.values(), CardValue.values());
    }

    /**
     * (10 sur le dessus du packer)
     * @return le tat des cartes de nombres rouges
     */
    public static Deck<JnCard> createHearthDeck() {
        return createDeck(HEARTH_SYMBOLS, NUMBER_VALUES);
    }

    public static Deck<JnCard> createAttackDeck() {
        //ajout des nombres noirs
        Deck<JnCard> deck = createDeck(ATTACK_SYMBOLS, NUMBER_VALUES);
        //ajout de toutes les têtes
        JnDeckFactory.appendCards(deck, CardSymbol.values(), FACE_VALUES);
        return deck;
    }

}
