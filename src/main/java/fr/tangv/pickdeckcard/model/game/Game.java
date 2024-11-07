package fr.tangv.pickdeckcard.model.game;

import fr.tangv.pickdeckcard.model.util.Cyclable;

/**
 * Représente un jeu
 */
public interface Game extends Cyclable, GameStatementThrower {

    String getId();
    GameStatement getStatement();
    void setStatement(GameStatement statement);
    boolean isStatement(GameStatement statement);

}
