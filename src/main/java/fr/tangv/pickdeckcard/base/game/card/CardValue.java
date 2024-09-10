package fr.tangv.pickdeckcard.base.game.card;

import fr.tangv.pickdeckcard.base.game.exception.ParseCardException;

public enum CardValue {

    ONE(1, '1', CardType.NUMBER),
    TWO(2, '2', CardType.NUMBER),
    THREE(3, '3', CardType.NUMBER),
    FOUR(4, '4', CardType.NUMBER),
    FIVE(5, '5', CardType.NUMBER),
    SIX(6, '6', CardType.NUMBER),
    SEVEN(7, '7', CardType.NUMBER),
    EIGHT(8, '8', CardType.NUMBER),
    NINE(9, '9', CardType.NUMBER),
    TEN(10, 'T', CardType.NUMBER),
    JACK(11, 'J', CardType.FACE),
    QUEEN(12, 'Q', CardType.FACE),
    KING(13, 'K', CardType.FACE);

    private final int value;
    private final char code;
    private final CardType type;

    private CardValue(int value, char code, CardType type) {
        this.value = value;
        this.code = code;
        this.type = type;
    }

    /**
     * Permet d'obtenir la valeur de la carte en numérique
     * @return la valeur de la carte en numérique
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Permet d'obtenir le type de carte que c'est
     * @return le type de carte (nombre ou tête)
     */
    public CardType getType() {
        return this.type;
    }

    /**
     * Permet de récupérer le code lié au valeur de la carte
     * @return le code lié au valeur de la carte
     */
    public char getCode() {
        return this.code;
    }

    /**
     * Permet d'obtenir la valeur de carte pour un caractère, s'il n'existe pas une exception est levé
     * @param value un caractère
     * @return la valeur de carte qui corespond au caractère
     * @throws ParseCardException si le caractère corespond à aucune valeur de carte
     */
    public static CardValue of(char value) throws ParseCardException {
        for (CardValue cardValue : CardValue.values()) {
            if (cardValue.getCode() == value)
                return cardValue;
        }
        throw new ParseCardException("Invalid card value: " + value);
    }

}
