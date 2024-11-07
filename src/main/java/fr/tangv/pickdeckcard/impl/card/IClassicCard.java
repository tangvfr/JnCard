package fr.tangv.pickdeckcard.impl.card;

import fr.tangv.pickdeckcard.model.card.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class IClassicCard implements ClassicCard {

    private final CardValue value;
    private final CardSymbol symbol;

    public IClassicCard(CardValue value, CardSymbol symbol) {
        this.value = value;
        this.symbol = symbol;
    }

    @Override
    public CardType getType() {
        return this.value.getType();
    }

    @Override
    public CardColor getColor() {
        return this.symbol.getColor();
    }

    @Override
    public boolean isValue(CardValue value) {
        return this.value == value;
    }

    @Override
    public boolean isType(CardType type) {
        return this.getType() == type;
    }

    @Override
    public boolean isSymbol(CardSymbol symbol) {
        return this.symbol == symbol;
    }

    @Override
    public boolean isColor(CardColor color) {
        return this.getColor() == color;
    }

}
