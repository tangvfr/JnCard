package fr.tangv.pickdeckcard.impl.card.converter;

import fr.tangv.pickdeckcard.impl.card.ICard;
import fr.tangv.pickdeckcard.model.card.CardSymbol;
import fr.tangv.pickdeckcard.model.card.CardValue;
import fr.tangv.pickdeckcard.model.card.JnCard;
import fr.tangv.pickdeckcard.model.card.excpetion.InvalidDataCardException;
import fr.tangv.pickdeckcard.model.card.excpetion.ParseCardException;

public abstract class CardConverter {

    public static final int CODE_LENGTH = 2;
    public static final int CARD_VALUE_INDEX_CODE = 0;
    public static final int CARD_SYMBOL_INDEX_CODE = 1;

    public static String toCode(JnCard card) {
        return Character.toString(card.getValue().getCode()) + card.getSymbol().getCode();
    }

    public static JnCard parseCode(String code) throws ParseCardException, InvalidDataCardException {
        if (code.length() != CardConverter.CODE_LENGTH) {
            throw new ParseCardException("Length of code must be 2");
        }

        return ICard.create(
            CardValue.of(code.charAt(CARD_VALUE_INDEX_CODE)),
            CardSymbol.of(code.charAt(CARD_SYMBOL_INDEX_CODE))
        );
    }

}
