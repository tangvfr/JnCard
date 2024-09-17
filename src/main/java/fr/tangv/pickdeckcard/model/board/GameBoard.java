package fr.tangv.pickdeckcard.model.board;

import fr.tangv.pickdeckcard.model.deck.DeckBox;
import fr.tangv.pickdeckcard.model.game.CardGame;
import fr.tangv.pickdeckcard.model.game.GameSettings;
import fr.tangv.pickdeckcard.model.game.exception.GameStatementException;
import fr.tangv.pickdeckcard.model.util.Updateable;
import fr.tangv.pickdeckcard.model.util.countdown.Countdown;

public interface GameBoard<T, S extends GameSettings> extends Updateable {

    CardGame<T, S> getGame();
    void setGame(CardGame<T, S> game);
    GamePlayer<T, S> getPlayer1();
    void setPlayer1(GamePlayer<T, S> player);
    GamePlayer<T, S> getPlayer2();
    void setPlayer2(GamePlayer<T, S> player);

    //players
    Countdown getTurnCountdown();
    GamePlayer<T, S> getTurnPlayer() throws GameStatementException;
    void switchPlayerTurn() throws GameStatementException;

    //deck
    DeckBox<T, S> getMainDeckBox();
    void setMainDeckBox(DeckBox<T, S> aDeck);
    DeckBox<T, S> getHearthDeckBox();
    void setHearthDeckBox(DeckBox<T, S> aDeck);

    //action
    ActionCounter getTurnActionCounter();
    ActionCounter getPlayedActionCounter();

}
