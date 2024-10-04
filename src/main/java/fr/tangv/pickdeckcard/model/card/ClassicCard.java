package fr.tangv.pickdeckcard.model.card;

public interface ClassicCard {

    /**
     * Permet de récupérer la valeur de la carte qui est entre 1 et 13 (1 à 10 pour 1 à 10, 11 pour Valet, 12 pour Dame, 13 pour Roi)
     * @return la valeur de la carte
     */
    CardValue getValue();
    /**
     * Permet de savoir si le type de carte (tête ou nombre)
     * @returnle type de carte
     */
    CardType getType();
    /**
     * Permet de d'obtenir le symbole de la carte
     * @return le symbole de la carte
     */
    CardSymbol getSymbol();
    /**
     * Permet de d'obtenir la couleur de la carte
     * @return la couleur de la carte
     */
    CardColor getColor();

    boolean isValue(CardValue value);
    boolean isType(CardType type);
    boolean isSymbol(CardSymbol symbol);
    boolean isColor(CardColor color);

}
