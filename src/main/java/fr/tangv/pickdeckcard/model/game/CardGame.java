package fr.tangv.pickdeckcard.model.game;

import fr.tangv.pickdeckcard.model.action.Action;
import fr.tangv.pickdeckcard.api.model.exception.action.ForbidenActionException;
import fr.tangv.pickdeckcard.model.board.GameBoard;
import fr.tangv.pickdeckcard.model.board.GamePlayer;
import fr.tangv.pickdeckcard.model.exception.game.GameStatementException;
import fr.tangv.pickdeckcard.model.game.settings.GameSettings;
import fr.tangv.pickdeckcard.model.player.Player;
import fr.tangv.pickdeckcard.model.util.Countdown;

import java.util.Collection;

/**
 * Représente un jeu de carte
 * @param <T> le type de carte
 * @param <S> les paramètres de jeu utilisé
 * @param <P> le type de joueur
 * @param <B> le type de plateau utilisé
 */
public interface CardGame<T, S extends GameSettings, P extends GamePlayer<T, S, P, B>, B extends GameBoard<T, S, P, B>>
        extends EventGame {

    Player getPlayer1();
    void setPlayer1(Player player);

    Player getPlayer2();
    void setPlayer2(Player player);

    Collection<Player> getObservers();
    void addObserver(Player player);
    boolean removeObserver(Player player);

    S getSettings();
    void setSettings(S settings);

    Countdown getGameCountdown();
    B getBoard() throws GameStatementException;
    P getWinner() throws GameStatementException;
    void setWinner(P winner) throws GameStatementException;
    void play(Action aAction) throws ForbidenActionException, GameStatementException;

}
