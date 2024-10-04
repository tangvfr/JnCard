package fr.tangv.pickdeckcard.model.game;

import fr.tangv.pickdeckcard.model.board.JnGameBoard;
import fr.tangv.pickdeckcard.model.board.JnGamePlayer;
import fr.tangv.pickdeckcard.model.card.JnCard;
import fr.tangv.pickdeckcard.model.game.settings.JnGameSettings;

public interface JnGame extends CardGame<JnCard, JnGameSettings, JnGamePlayer, JnGameBoard> { }
