package fr.tangv.pickdeckcard.model.card;

import fr.tangv.pickdeckcard.api.model.exception.card.ParseCardException;

import java.util.Arrays;
import java.util.Objects;

public enum CardValue {

    ONE((byte) 1, '1', CardType.NUMBER),
    TWO((byte) 2, '2', CardType.NUMBER),
    THREE((byte) 3, '3', CardType.NUMBER),
    FOUR((byte) 4, '4', CardType.NUMBER),
    FIVE((byte) 5, '5', CardType.NUMBER),
    SIX((byte) 6, '6', CardType.NUMBER),
    SEVEN((byte) 7, '7', CardType.NUMBER),
    EIGHT((byte) 8, '8', CardType.NUMBER),
    NINE((byte) 9, '9', CardType.NUMBER),
    TEN((byte) 10, 'T', CardType.NUMBER),
    JACK((byte) 11, 'J', CardType.FACE),
    QUEEN((byte) 12, 'Q', CardType.FACE),
    KING((byte) 13, 'K', CardType.FACE);

    private final byte value;
    private final char code;
    private final CardType type;

    private CardValue(byte value, char code, CardType type) {
        this.value = value;
        this.code = code;
        this.type = type;
    }

    /**
     * Permet d'obtenir la valeur de la carte en numérique
     * @return la valeur de la carte en numérique
     */
    public byte getValue() {
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
     * Permet de récupérer le code lié à la valeur de la carte
     * @return le code lié à la valeur de la carte
     */
    public char getCode() {
        return this.code;
    }

    /**
     * Permet d'obtenir la valeur de carte pour un caractère, s'il n'existe pas une exception est levé
     * @param value un caractère
     * @return la valeur de carte qui correspond au caractère
     * @throws ParseCardException si le caractère correspond à aucune valeur de carte
     */
    public static CardValue of(char value) throws ParseCardException {
        for (CardValue cardValue : CardValue.values()) {
            if (cardValue.getCode() == value)
                return cardValue;
        }
        throw new ParseCardException("Invalid card value: " + value);
    }

    /**
     * Permet d'obtenir les valeurs de carte d'un certain type
     * @param type type de cartes
     * @return les valeurs de carte du type donné
     * @throws NullPointerException si type est null
     */
    public static CardValue[] valuesOfType(CardType type) {
        Objects.requireNonNull(type);
        return Arrays.stream(CardValue.values())
                .filter((value) -> value.getType() == type)
                .toArray(CardValue[]::new);
    }

}
