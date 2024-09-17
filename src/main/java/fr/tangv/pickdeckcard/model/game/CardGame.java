package fr.tangv.pickdeckcard.model.game;

import fr.tangv.pickdeckcard.model.board.GameBoard;
import fr.tangv.pickdeckcard.model.board.GamePlayer;
import fr.tangv.pickdeckcard.model.game.exception.GameStatementException;
import fr.tangv.pickdeckcard.model.player.Player;
import fr.tangv.pickdeckcard.model.util.countdown.Countdown;

import java.util.Collection;

/**
 * Représente un jeu de carte
 * @param <T> le type de carte
 * @param <S> les paramètres de jeu utilisé
 */
public interface CardGame<T, S extends GameSettings> extends Game, GameStatementThrower {

    Player getPlayer1();
    Player getPlayer2();
    Collection<Player> getObservers();
    S getSettings();
    Countdown getGameCountdown();
    GameBoard<T, S> getBoard() throws GameStatementException;
    GamePlayer<T, S> getWinner() throws GameStatementException;
    void start() throws GameStatementException;
    void setWinner(GamePlayer<T, S> winner) throws GameStatementException;

}
