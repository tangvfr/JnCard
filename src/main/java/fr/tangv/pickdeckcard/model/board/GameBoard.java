package fr.tangv.pickdeckcard.model.board;

import fr.tangv.pickdeckcard.model.card.Card;
import fr.tangv.pickdeckcard.model.deck.DeckBox;
import fr.tangv.pickdeckcard.model.exception.GameNotStartedException;
import fr.tangv.pickdeckcard.model.exception.GameNotStartingException;
import fr.tangv.pickdeckcard.model.game.Game;
import fr.tangv.pickdeckcard.model.game.GameStatementThrower;
import fr.tangv.pickdeckcard.model.player.Player;

public interface GameBoard<T extends Card> extends GameStatementThrower {

    Game<T> getGame();
    GamePlayer<T> getPlayer1();
    GamePlayer<T> getPlayer2();

    //players
    GamePlayer<T> getTurnPlayer() throws GameNotStartedException;
    void switchPlayerTurn() throws GameNotStartedException;

    //starting
    void initPlayers(Player player1, Player player2) throws GameNotStartingException;
    void initDecks() throws GameNotStartingException;
    void giveCards() throws GameNotStartingException;
    void calcFirstPlayerTurn() throws GameNotStartingException;

    //deck
    DeckBox<T> getMainDeckBox();
    DeckBox<T> getHearthDeckBox();

    //action
    ActionCounter getTurnActionCounter();
    ActionCounter getPlayedActionCounter();

}
