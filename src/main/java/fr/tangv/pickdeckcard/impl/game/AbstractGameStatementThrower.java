package fr.tangv.pickdeckcard.impl.game;

import fr.tangv.pickdeckcard.model.game.GameStatement;
import fr.tangv.pickdeckcard.model.game.GameStatementThrower;
import fr.tangv.pickdeckcard.model.game.exception.GameStatementException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public abstract class AbstractGameStatementThrower implements GameStatementThrower {

    private static final String CANT_BE = "Statement of the game can't be ";
    private static final String MUST_BE = "Statement of the game must be ";

    @Override
    public void throwIfStatement(GameStatement statement) throws GameStatementException {
        if (statement == this.getStatement())
            throw new GameStatementException(CANT_BE + statement.name());
    }

    @Override
    public void throwIfNotStatement(GameStatement statement) throws GameStatementException {
        if (statement != this.getStatement())
            throw new GameStatementException(MUST_BE + statement.name());
    }

}
