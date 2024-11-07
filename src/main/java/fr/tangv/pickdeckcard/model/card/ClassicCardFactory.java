package fr.tangv.pickdeckcard.model.card;

import fr.tangv.pickdeckcard.api.model.exception.card.InvalidDataCardException;

public interface ClassicCardFactory<T extends ClassicCard> {

    /**
     * Permet de créer une carte qui a une valeur et symbole
     * @param value la valeur de la carte
     * @param symbol le symbole de la carte
     * @return la carte crée
     * @throws InvalidDataCardException si le symbole ou la valeur est nulle
     */
    T create(CardValue value, CardSymbol symbol);

}
