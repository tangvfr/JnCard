package fr.tangv.pickdeckcard.impl.card.factory;

import fr.tangv.pickdeckcard.impl.card.IJnCard;
import fr.tangv.pickdeckcard.model.card.CardSymbol;
import fr.tangv.pickdeckcard.model.card.CardValue;
import fr.tangv.pickdeckcard.model.card.ClassicCard;
import fr.tangv.pickdeckcard.model.card.JnCard;

public class IJnCardFactory extends BaseClassicCardFactory<JnCard> {

    @Override
    protected JnCard createCard(CardValue value, CardSymbol symbol) {
        return new IJnCard(value, symbol);
    }

}
