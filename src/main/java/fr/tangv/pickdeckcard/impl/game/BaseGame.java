package fr.tangv.pickdeckcard.impl.game;

import fr.tangv.pickdeckcard.model.game.Game;
import fr.tangv.pickdeckcard.model.game.GameStatement;
import fr.tangv.pickdeckcard.model.exception.game.GameStatementException;

import java.util.UUID;

/**
 * Représente la base d'une partie de jeu
 */
public abstract class BaseGame implements Game {

    private static final String MUST_BE = "Statement must be ";
    private static final String MUST_NOT_BE = "Statement mustn't be ";

    String id;
    GameStatement statement;

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public GameStatement getStatement() {
        return statement;
    }

    @Override
    public boolean isStatement(GameStatement statement) {
        return this.statement == statement;
    }

    @Override
    public void setStatement(GameStatement statement) {
        this.statement = statement;
    }

    @Override
    public void init() {
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public void throwIfStatement(GameStatement statement) throws GameStatementException {
        if (this.isStatement(statement)) {
            throw new GameStatementException(MUST_NOT_BE + statement.name());
        }
    }

    @Override
    public void throwIfNotStatement(GameStatement statement) throws GameStatementException {
        if (this.isStatement(statement)) {
            throw new GameStatementException(MUST_BE + statement.name());
        }
    }

    @Override
    public boolean equals(Object game) {
        if (!(game instanceof Game)) return false;
        if (this.id == null) return false;

        String gid = ((Game) game).getId();
        if (gid == null) return false;

        return this.id.equals(gid);
    }

}
