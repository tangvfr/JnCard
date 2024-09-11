package fr.tangv.pickdeckcard.impl.board;

import fr.tangv.pickdeckcard.model.board.GameBoard;
import fr.tangv.pickdeckcard.model.board.GamePlayer;
import fr.tangv.pickdeckcard.model.card.Card;
import fr.tangv.pickdeckcard.model.exception.GameNotStartedException;
import fr.tangv.pickdeckcard.model.exception.GameNotStartingException;
import fr.tangv.pickdeckcard.model.exception.GameStatementException;
import fr.tangv.pickdeckcard.model.game.Game;
import fr.tangv.pickdeckcard.model.game.GameStatement;
import fr.tangv.pickdeckcard.model.player.Player;

public abstract class AbstractGameBoard<T extends Card> implements GameBoard<T> {

    private static final double RANDOM_50 = 0.5;

    private final Game<T> game;
    private GamePlayer<T> player1;
    private GamePlayer<T> player2;
    private GamePlayer<T> currentPlayer;

    public AbstractGameBoard(Game<T> game) {
        this.game = game;
    }

    @Override
    public Game<T> getGame() {
        return this.game;
    }

    @Override
    public <T extends GameStatementException> void throwIfStatement(GameStatement statement, Class<T> exception, String msg) throws T {
        this.game.throwIfStatement(statement, exception, msg);
    }

    @Override
    public <T extends GameStatementException> void throwIfNotStatement(GameStatement statement, Class<T> exception, String msg) throws T {
        this.game.throwIfNotStatement(statement, exception, msg);
    }

    @Override
    public GamePlayer<T> getPlayer1() {
        return this.player1;
    }

    @Override
    public GamePlayer<T> getPlayer2() {
        return this.player2;
    }

    @Override
    public GamePlayer<T> getTurnPlayer() throws GameNotStartedException {
        throwIfNotStatement(GameStatement.STARTED, GameNotStartedException.class);
        return this.currentPlayer;
    }

    @Override
    public void switchPlayerTurn() throws GameNotStartedException {
        throwIfNotStatement(GameStatement.STARTED, GameNotStartedException.class);

        this.currentPlayer = this.currentPlayer.getEnemy();
        this.getTurnActionCounter().reset();
    }

    @Override
    public void initPlayers(Player player1, Player player2) throws GameNotStartingException {
        throwIfNotStatement(GameStatement.STARTING, GameNotStartingException.class);

        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public void calcFirstPlayerTurn() throws GameNotStartingException {
        throwIfNotStatement(GameStatement.STARTED, GameNotStartingException.class);
        int playerHearts1 = this.getPlayer1().countHearths();
        int playerHearts2 = this.getPlayer2().countHearths();

        if (playerHearts1 == playerHearts2) {//random choice
            this.currentPlayer = Math.random() < RANDOM_50 ? this.player1 : this.player2;
        } else if (playerHearts1 < playerHearts2) {//lesser hearts choice
            this.currentPlayer = this.player1;
        } else {//(playerHearts2 < playerHearts1) {//lesser hearts choice
            this.currentPlayer = this.player2;
        }
    }

    @Override
    void giveCards() throws GameNotStartingException {
        throwIfNotStatement(GameStatement.STARTING, GameNotStartingException.class);

        throw new RuntimeException("Not yet implemented");
    }

}
