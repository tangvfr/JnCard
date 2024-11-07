package fr.tangv.pickdeckcard.model.action;

import fr.tangv.pickdeckcard.model.card.JnCard;

import java.util.List;

public interface JnGameActionCards extends JnGameActionNoCard {

    List<JnCard> getCards();

}
