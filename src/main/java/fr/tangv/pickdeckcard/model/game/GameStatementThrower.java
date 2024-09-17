package fr.tangv.pickdeckcard.model.game;

import fr.tangv.pickdeckcard.model.game.exception.GameStatementException;

public interface GameStatementThrower {

    GameStatement getStatement();
    void throwIfStatement(GameStatement statement) throws GameStatementException;
    void throwIfNotStatement(GameStatement statement) throws GameStatementException;

}
