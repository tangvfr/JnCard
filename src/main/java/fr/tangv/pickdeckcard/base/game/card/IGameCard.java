package fr.tangv.pickdeckcard.base.game.card;

import fr.tangv.pickdeckcard.base.game.exception.InvalidDataCardException;

public class IGameCard extends ICard implements GameCard {

    private CardOrientation orientation;

    protected IGameCard(CardValue value, CardSymbol symbol, CardOrientation orientation) {
        super(value, symbol);
        this.orientation = orientation;
    }

    @Override
    public CardOrientation getOrientation() {
        return this.orientation;
    }

    @Override
    public void setOrientation(CardOrientation orientation) {
        this.orientation = orientation;
    }

    /**
     * Permet de créer une carte
     * @param value la valeur de la carte
     * @param symbol le symbole de la carte
     * @param orientation l'orientation de la carte
     * @return la carte crée
     * @throws InvalidDataCardException si le symbole ou la valeur est nulle
     */
    public static GameCard createGameCard(CardValue value, CardSymbol symbol, CardOrientation orientation) throws InvalidDataCardException {
        if (value == null) {
            throw new InvalidDataCardException("Value card cannot be null");
        }

        if (symbol == null) {
            throw new InvalidDataCardException("Symbol card cannot be null");
        }

        if (orientation == null) {
            throw new InvalidDataCardException("Orientation card cannot be null");
        }

        return new IGameCard(value, symbol, orientation);
    }

    /**
     * Permet de créer une carte, avec l'orientation par default (verticale)
     * @param value la valeur de la carte
     * @param symbol le symbole de la carte
     * @return la carte crée
     * @throws InvalidDataCardException si le symbole ou la valeur est nulle
     */
    public static GameCard createGameCard(CardValue value, CardSymbol symbol) throws InvalidDataCardException {
        return IGameCard.createGameCard(value, symbol, CardOrientation.DEFAULT_ORIENTATION);
    }

}
