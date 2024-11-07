package fr.tangv.pickdeckcard.impl.card;

import fr.tangv.pickdeckcard.model.card.*;

public class IJnCard extends IClassicCard implements JnCard {

    public IJnCard(CardValue value, CardSymbol symbol) {
        super(value, symbol);
    }

    @Override
    public boolean isAttack() {
        return this.isColor(CardColor.BLACK) && this.isType(CardType.NUMBER);
    }

    @Override
    public boolean isHearth() {
        return this.isColor(CardColor.RED) && this.isType(CardType.NUMBER);
    }

}
