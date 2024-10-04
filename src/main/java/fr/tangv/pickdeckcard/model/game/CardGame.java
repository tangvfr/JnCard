package fr.tangv.pickdeckcard.model.game;

import fr.tangv.pickdeckcard.model.board.GameBoard;
import fr.tangv.pickdeckcard.model.board.GamePlayer;
import fr.tangv.pickdeckcard.model.game.exception.GameStatementException;
import fr.tangv.pickdeckcard.model.game.settings.GameSettings;
import fr.tangv.pickdeckcard.model.player.Player;
import fr.tangv.pickdeckcard.model.util.countdown.Countdown;

import java.util.Collection;

/**
 * Représente un jeu de carte
 * @param <T> le type de carte
 * @param <S> les paramètres de jeu utilisé
 * @param <P> le type de joueur
 * @param <B> le type de plateau utilisé
 */
public interface CardGame<T, S extends GameSettings, P extends GamePlayer<T, S, P, B>, B extends GameBoard<T, S, P, B>>
        extends EventGame, GameStatementThrower {

    Player getPlayer1();
    Player getPlayer2();
    Collection<Player> getObservers();
    S getSettings();
    Countdown getGameCountdown();
    B getBoard() throws GameStatementException;
    P getWinner() throws GameStatementException;
    void start() throws GameStatementException;
    void setWinner(P winner) throws GameStatementException;

}
