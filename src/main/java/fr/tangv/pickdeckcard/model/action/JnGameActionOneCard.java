package fr.tangv.pickdeckcard.model.action;

import fr.tangv.pickdeckcard.model.card.JnCard;

public interface JnGameActionOneCard extends JnGameActionNoCard {

    JnCard getCard();

}
