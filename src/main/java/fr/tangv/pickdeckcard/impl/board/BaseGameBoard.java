package fr.tangv.pickdeckcard.impl.board;

import fr.tangv.pickdeckcard.impl.event.game.player.GamePlayerAFKEvent;
import fr.tangv.pickdeckcard.impl.event.game.player.GamePlayerEndTurnEvent;
import fr.tangv.pickdeckcard.impl.util.CountdownFactory;
import fr.tangv.pickdeckcard.impl.util.ICounter;
import fr.tangv.pickdeckcard.model.board.GameBoard;
import fr.tangv.pickdeckcard.model.util.Counter;
import fr.tangv.pickdeckcard.model.board.GamePlayer;
import fr.tangv.pickdeckcard.model.game.CardGame;
import fr.tangv.pickdeckcard.model.game.settings.GameSettings;
import fr.tangv.pickdeckcard.model.util.Countdown;
import lombok.Getter;
import lombok.Setter;


public abstract class BaseGameBoard<T, S extends GameSettings, P extends GamePlayer<T, S, P, B>, B extends GameBoard<T, S, P, B>>
        implements GameBoard<T, S, P, B> {

    private static final int DEFAULT_ACTION_BY_TURN = 1;

    private @Getter @Setter CardGame<T, S, P, B> game;
    private @Getter @Setter P player1;
    private @Getter @Setter P player2;
    private @Getter @Setter Countdown turnCountdown;
    private @Getter Counter turnActionCounter;
    private @Getter Counter playedActionCounter;
    private P currentPlayer;

    @Override
    public void init() {
        this.turnCountdown = CountdownFactory.createSuitable(this.getGame().getSettings().getTurnDuration());
        this.turnActionCounter = new ICounter(DEFAULT_ACTION_BY_TURN);
        this.playedActionCounter = new ICounter(0);
    }

    @Override
    public P getTurnPlayer() {
        //this.getGame().throwIfNotStatement(GameStatement.STARTED);
        return this.currentPlayer;
    }

    @Override
    public void switchPlayerTurn() {
        //this.getGame().throwIfNotStatement(GameStatement.STARTED);
        this.currentPlayer = this.currentPlayer.getEnemy();
        this.getTurnActionCounter().reset();
    }

    private void testAfk(P player) {
        switch (player.isAfk()) {
            case PUNISH:
                fireAfkEvent(player, true);
                break;
            case ALERT:
                fireAfkEvent(player, false);
                break;
            //case NO:
            default:
                break;
        }
    }

    private void testEndTurn() {
        this.turnCountdown.update();
        if (this.turnCountdown.isFinish()) {
            fireEndTurnEvent(this.currentPlayer, true);
        }
    }

    public void fireAfkEvent(P player, boolean punish) {
        this.getGame().fire(new GamePlayerAFKEvent<>(this.getGame(), player, punish));
    }

    public void fireEndTurnEvent(P player, boolean endTime) {
        this.getGame().fire(new GamePlayerEndTurnEvent<>(this.getGame(), player, endTime));
    }

    @Override
    public void update() {
        testAfk(this.player1);
        testAfk(this.player2);
        testEndTurn();
    }

}
