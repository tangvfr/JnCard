package fr.tangv.pickdeckcard.base.game;

import fr.tangv.pickdeckcard.base.game.action.CardAction;
import fr.tangv.pickdeckcard.base.game.card.GameCard;
import fr.tangv.pickdeckcard.base.game.deck.Deck;
import fr.tangv.pickdeckcard.base.game.exception.game.GameNotStartedException;
import fr.tangv.pickdeckcard.base.game.exception.game.GameNotStartingException;

public interface GameBoard {

    Game getGame();

    //data
    Deck<GameCard> getHeartDump();
    Deck<GameCard> getAttackDump();
    Deck<GameCard> getHeartDeck();
    Deck<GameCard> getMainDeck();

    GamePlayer getPlayer1();
    GamePlayer getPlayer2();

    boolean noAction();
    int getNumberAction();
    void resetAction();
    void decreaseAction();
    void increaseAction();
    void increaseAction(int number);

    //players
    GamePlayer getTurnPlayer() throws GameNotStartedException;
    void switchsetPlayerTurn() throws GameNotStartedException;
    void playAction(GamePlayer player, CardAction action) throws GameNotStartedException;

    //starting
    void initPlayers(Player player1, Player player2) throws GameNotStartingException;
    void initDecks() throws GameNotStartingException;
    GamePlayer giveCards() throws GameNotStartingException;
    void setPlayerTurn(GamePlayer player) throws GameNotStartingException;

    //board action
    void remixHeartDeck() throws GameNotStartedException;
    void remixMainDeck() throws GameNotStartedException;
    void pickHearth(GamePlayer player) throws GameNotStartedException;
    void pickCard(GamePlayer player) throws GameNotStartedException;

}
