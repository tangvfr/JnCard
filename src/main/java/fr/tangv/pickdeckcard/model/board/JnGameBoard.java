package fr.tangv.pickdeckcard.model.board;

import fr.tangv.pickdeckcard.model.card.JnCard;
import fr.tangv.pickdeckcard.model.deck.DeckBox;
import fr.tangv.pickdeckcard.model.game.settings.JnGameSettings;

public interface JnGameBoard extends GameBoard<JnCard, JnGameSettings, JnGamePlayer, JnGameBoard> {

    DeckBox<JnCard, JnGameSettings, JnGamePlayer, JnGameBoard> getMainDeckBox();
    void setMainDeckBox(DeckBox<JnCard, JnGameSettings, JnGamePlayer, JnGameBoard> aDeck);
    DeckBox<JnCard, JnGameSettings, JnGamePlayer, JnGameBoard> getHearthDeckBox();
    void setHearthDeckBox(DeckBox<JnCard, JnGameSettings, JnGamePlayer, JnGameBoard> aDeck);

}
