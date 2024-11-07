package fr.tangv.pickdeckcard.impl.card.factory;

import fr.tangv.pickdeckcard.model.card.CardSymbol;
import fr.tangv.pickdeckcard.model.card.CardValue;
import fr.tangv.pickdeckcard.model.card.ClassicCard;
import fr.tangv.pickdeckcard.model.card.ClassicCardFactory;
import fr.tangv.pickdeckcard.api.model.exception.card.InvalidDataCardException;

public abstract class BaseClassicCardFactory<T extends ClassicCard> implements ClassicCardFactory<T> {

    @Override
    public T create(CardValue value, CardSymbol symbol) {
        this.check(value, symbol);
        return this.createCard(value, symbol);
    }

    protected void check(CardValue value, CardSymbol symbol) {
        if (value == null) {
            throw new InvalidDataCardException("Value card cannot be null");
        }

        if (symbol == null) {
            throw new InvalidDataCardException("Symbol card cannot be null");
        }
    }

    protected abstract T createCard(CardValue value, CardSymbol symbol);

}
