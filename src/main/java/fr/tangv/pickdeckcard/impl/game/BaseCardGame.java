package fr.tangv.pickdeckcard.impl.game;

import fr.tangv.pickdeckcard.impl.event.game.EndGameCountdownEvent;
import fr.tangv.pickdeckcard.impl.util.CountdownFactory;
import fr.tangv.pickdeckcard.model.action.Action;
import fr.tangv.pickdeckcard.api.model.exception.action.ForbidenActionException;
import fr.tangv.pickdeckcard.model.board.GameBoard;
import fr.tangv.pickdeckcard.model.board.GamePlayer;
import fr.tangv.pickdeckcard.model.game.CardGame;
import fr.tangv.pickdeckcard.model.game.GameStatement;
import fr.tangv.pickdeckcard.model.exception.game.GameStatementException;
import fr.tangv.pickdeckcard.model.game.GameType;
import fr.tangv.pickdeckcard.model.game.settings.GameSettings;
import fr.tangv.pickdeckcard.model.player.ConnectedPlayer;
import fr.tangv.pickdeckcard.model.util.Countdown;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Représente la base d'une partie de jeu de carte avec une gestion d'évènement
 * @param <T> le type de carte
 * @param <S> les paramètres de jeu utilisé
 * @param <P> le type de joueur
 * @param <B> le type de plateau utilisé
 */
public abstract class BaseCardGame<T, S extends GameSettings, P extends GamePlayer<T, S, P, B>, B extends GameBoard<T, S, P, B>>
        extends BaseEventGame implements CardGame<T, S, P, B> {

    @Getter @Setter GameType gameType;
    //init in init()
    @Getter Countdown gameCountdown;
    Collection<ConnectedPlayer> observers = new LinkedList<>();
    //init before finish()
    P winner = null;

    //init before init()
    @Getter @Setter ConnectedPlayer player1 = null;
    @Getter @Setter ConnectedPlayer player2 = null;
    @Getter @Setter S settings = null;
    B board = null;

    @Override
    public void init() {
        super.init();
        this.gameCountdown = CountdownFactory.createSuitable(this.settings.getGameDuration());
    }

    @Override
    public Collection<ConnectedPlayer> getObservers() {
        return List.copyOf(this.observers);
    }

    @Override
    public boolean removeObserver(ConnectedPlayer player) {
        return this.observers.remove(player);
    }

    @Override
    public void addObserver(ConnectedPlayer player) {
        this.observers.add(player);
    }

    @Override
    public B getBoard() throws GameStatementException {
        throwIfNotStatement(GameStatement.STARTED);
        return this.board;
    }

    @Override
    public P getWinner() throws GameStatementException {
        throwIfNotStatement(GameStatement.FINISHED);
        return this.winner;
    }

    @Override
    public void setWinner(P winner) throws GameStatementException {
        throwIfNotStatement(GameStatement.STARTED);
        this.winner = winner;
    }

    @Override
    public void play(Action aAction) throws GameStatementException, ForbidenActionException {
        throwIfNotStatement(GameStatement.STARTED);
        if (!aAction.isAvaible()) {
            throw new ForbidenActionException(aAction.getClass().getSimpleName());
        }
        aAction.execute();
    }

    @Override
    public void update() {
        this.gameCountdown.update();
        if (this.gameCountdown.isFinish()) {
            this.fire(new EndGameCountdownEvent<>(this));
        }
    }

}
