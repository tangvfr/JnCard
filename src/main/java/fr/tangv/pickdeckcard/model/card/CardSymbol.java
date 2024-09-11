package fr.tangv.pickdeckcard.model.card;

import fr.tangv.pickdeckcard.model.card.excpetion.ParseCardException;

public enum CardSymbol {

    CLUB(CardColor.BLACK, 'C'),
    HEART(CardColor.RED, 'H'),
    SPADE(CardColor.BLACK, 'S'),
    DIAMOND(CardColor.RED, 'D');

    CardSymbol(CardColor color, char code) {
        this.color = color;
        this.code = code;
    }

    private final CardColor color;
    private final char code;

    /**
     * Permet de récupérer la couleur lié au symbole (Rouge ou Noir)
     * @return la couleur lié au symbole
     */
    public CardColor getColor() {
        return this.color;
    }

    /**
     * Permet de récupérer le code lié au symbole
     * @return le code lié au symbole
     */
    public char getCode() {
        return this.code;
    }

    /**
     * Permet d'obtenir le symbole de carte pour un caractère, s'il n'existe pas une exception est levé
     * @param symbol un caractère
     * @return le symbole de carte qui corespond au caractère
     * @throws ParseCardException si le caractère corespond à aucun symbole de carte
     */
    public static CardSymbol of(char symbol) throws ParseCardException {
        for (CardSymbol cardSymbol : CardSymbol.values()) {
            if (cardSymbol.getCode() == symbol)
                return cardSymbol;
        }
        throw new ParseCardException("Invalid card symbol: " + symbol);
    }

}
