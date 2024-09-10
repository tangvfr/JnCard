package fr.tangv.pickdeckcard.base.game.card.converter;

import fr.tangv.pickdeckcard.base.game.card.Card;
import fr.tangv.pickdeckcard.base.game.card.CardSymbol;
import fr.tangv.pickdeckcard.base.game.card.CardValue;
import fr.tangv.pickdeckcard.base.game.card.ICard;
import fr.tangv.pickdeckcard.base.game.exception.InvalidDataCardException;
import fr.tangv.pickdeckcard.base.game.exception.ParseCardException;

public abstract class CardConverter {

    public static final int CODE_LENGTH = 2;
    public static final int CARD_VALUE_INDEX_CODE = 0;
    public static final int CARD_SYMBOL_INDEX_CODE = 1;

    public static String toCode(Card card) {
        return Character.toString(card.getValue().getCode()) + card.getSymbol().getCode();
    }

    public static Card toCard(String code) throws ParseCardException, InvalidDataCardException {
        if (code.length() != CardConverter.CODE_LENGTH) {
            throw new ParseCardException("Length of code must be 2");
        }

        return ICard.createCard(
            CardValue.of(code.charAt(CARD_VALUE_INDEX_CODE)),
            CardSymbol.of(code.charAt(CARD_SYMBOL_INDEX_CODE))
        );
    }

}
