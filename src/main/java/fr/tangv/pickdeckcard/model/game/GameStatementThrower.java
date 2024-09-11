package fr.tangv.pickdeckcard.model.game;

import fr.tangv.pickdeckcard.model.exception.GameStatementException;

public interface GameStatementThrower {

    <T extends GameStatementException> void throwIfStatement(GameStatement statement, Class<T> exception, String msg) throws T;
    <T extends GameStatementException> void throwIfNotStatement(GameStatement statement, Class<T> exception, String msg) throws T;
    default <T extends GameStatementException> void throwIfStatement(GameStatement statement, Class<T> exception) throws T {
        throwIfStatement(statement, exception, "");
    }
    default <T extends GameStatementException> void throwIfNotStatement(GameStatement statement, Class<T> exception) throws T {
        throwIfNotStatement(statement, exception, "");
    }

}
