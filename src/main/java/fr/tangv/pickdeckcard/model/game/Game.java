package fr.tangv.pickdeckcard.model.game;

import fr.tangv.pickdeckcard.model.board.GameBoard;
import fr.tangv.pickdeckcard.model.board.GamePlayer;
import fr.tangv.pickdeckcard.model.card.Card;
import fr.tangv.pickdeckcard.model.exception.GameNotFinishedException;
import fr.tangv.pickdeckcard.model.exception.GameNotStartedException;
import fr.tangv.pickdeckcard.model.exception.GameNotStartingException;
import fr.tangv.pickdeckcard.model.exception.GameStartingException;
import fr.tangv.pickdeckcard.model.player.Observer;
import fr.tangv.pickdeckcard.model.player.Player;

import java.util.Collection;

public interface Game<T extends Card> extends GameStatementThrower {

    String getId();
    Player getPlayer1();
    Player getPlayer2();
    Collection<Observer> getObservers();
    GameCooldown getCooldown();
    GameSettings getSettings();
    GameBoard<T> getBoard() throws GameStartingException;
    GamePlayer<T> getWinner() throws GameNotFinishedException;
    GameStatement getStatement();
    GameStatement isStatement(GameStatement statement);
    void start() throws GameNotStartingException;
    void finish(GamePlayer<T> winner) throws GameNotStartedException;

}
