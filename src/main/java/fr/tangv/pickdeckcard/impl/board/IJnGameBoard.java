package fr.tangv.pickdeckcard.impl.board;

import fr.tangv.pickdeckcard.model.board.JnGameBoard;
import fr.tangv.pickdeckcard.model.board.JnGamePlayer;
import fr.tangv.pickdeckcard.model.card.JnCard;
import fr.tangv.pickdeckcard.model.deck.DeckBox;
import fr.tangv.pickdeckcard.model.game.settings.JnGameSettings;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IJnGameBoard extends BaseGameBoard<JnCard, JnGameSettings, JnGamePlayer, JnGameBoard> implements JnGameBoard {

    private DeckBox<JnCard, JnGameSettings, JnGamePlayer, JnGameBoard> mainDeckBox;
    private DeckBox<JnCard, JnGameSettings, JnGamePlayer, JnGameBoard> hearthDeckBox;

}
