package fr.tangv.pickdeckcard.impl.card.factory;

import fr.tangv.pickdeckcard.impl.card.IClassicCard;
import fr.tangv.pickdeckcard.model.card.CardSymbol;
import fr.tangv.pickdeckcard.model.card.CardValue;
import fr.tangv.pickdeckcard.model.card.ClassicCard;

public class IClassicCardFactory extends BaseClassicCardFactory<ClassicCard> {

    @Override
    protected ClassicCard createCard(CardValue value, CardSymbol symbol) {
        return new IClassicCard(value, symbol);
    }

}
