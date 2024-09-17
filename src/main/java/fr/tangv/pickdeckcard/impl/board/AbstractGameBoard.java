package fr.tangv.pickdeckcard.impl.board;

import fr.tangv.pickdeckcard.model.board.GameBoard;
import fr.tangv.pickdeckcard.model.board.GamePlayer;
import fr.tangv.pickdeckcard.model.game.CardGame;
import fr.tangv.pickdeckcard.model.game.GameSettings;
import fr.tangv.pickdeckcard.model.game.GameStatement;
import fr.tangv.pickdeckcard.model.game.exception.GameStatementException;
import lombok.Getter;
import lombok.Setter;

public abstract class AbstractGameBoard<T, S extends GameSettings> implements GameBoard<T, S> {

    private @Getter @Setter CardGame<T, S> game;
    private GamePlayer<T, S> currentPlayer;

    public AbstractGameBoard(CardGame<T, S> game) {
        this.game = game;
    }

    @Override
    public GamePlayer<T, S> getTurnPlayer() throws GameStatementException {
        this.game.throwIfNotStatement(GameStatement.STARTED);
        return this.currentPlayer;
    }

    @Override
    public void switchPlayerTurn() throws GameStatementException {
        this.game.throwIfNotStatement(GameStatement.STARTED);

        this.currentPlayer = this.currentPlayer.getEnemy();
        this.getTurnActionCounter().reset();
    }

}
