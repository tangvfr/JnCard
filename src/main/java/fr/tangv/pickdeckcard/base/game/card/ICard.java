package fr.tangv.pickdeckcard.base.game.card;

import fr.tangv.pickdeckcard.base.game.exception.InvalidDataCardException;

public class ICard implements Card {

    private final CardValue value;
    private final CardSymbol symbol;

    protected ICard(CardValue value, CardSymbol symbol) {
        this.value = value;
        this.symbol = symbol;
    }

    @Override
    public CardValue getValue() {
        return this.value;
    }

    @Override
    public CardType getType() {
        return null;
    }

    @Override
    public CardSymbol getSymbol() {
        return this.symbol;
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

    /**
     * Permet de créer une carte
     * @param value la valeur de la carte
     * @param symbol le symbole de la carte
     * @return la carte crée
     * @throws InvalidDataCardException si le symbole ou la valeur est nulle
     */
    public static Card createCard(CardValue value, CardSymbol symbol) throws InvalidDataCardException {
        if (value == null) {
            throw new InvalidDataCardException("Value card cannot be null");
        }

        if (symbol == null) {
            throw new InvalidDataCardException("Symbol card cannot be null");
        }

        return new ICard(value, symbol);
    }

}
