package fr.tangv.pickdeckcard.impl.card.converter;

import fr.tangv.pickdeckcard.model.card.CardSymbol;
import fr.tangv.pickdeckcard.model.card.CardValue;
import fr.tangv.pickdeckcard.model.card.ClassicCard;
import fr.tangv.pickdeckcard.model.card.ClassicCardFactory;
import fr.tangv.pickdeckcard.api.model.exception.card.InvalidDataCardException;
import fr.tangv.pickdeckcard.api.model.exception.card.ParseCardException;

public abstract class ClassicCardConverter {

    public static final int CODE_LENGTH = 2;
    public static final int CARD_VALUE_INDEX_CODE = 0;
    public static final int CARD_SYMBOL_INDEX_CODE = 1;

    public static String toCode(ClassicCard card) {
        return Character.toString(card.getValue().getCode()) + card.getSymbol().getCode();
    }

    public static <T extends ClassicCard> T parseCode(ClassicCardFactory<T> factory, String code) throws ParseCardException, InvalidDataCardException {
        if (code.length() != ClassicCardConverter.CODE_LENGTH) {
            throw new ParseCardException("Length of code must be 2");
        }

        return factory.create(
            CardValue.of(code.charAt(CARD_VALUE_INDEX_CODE)),
            CardSymbol.of(code.charAt(CARD_SYMBOL_INDEX_CODE))
        );
    }

}
