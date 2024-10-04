package fr.tangv.pickdeckcard.model.game;

import fr.tangv.pickdeckcard.model.util.Cyclable;

/**
 * Représente un jeu
 */
public interface Game extends Cyclable {

    String getId();
    GameStatement getStatement();
    GameStatement isStatement(GameStatement statement);

}
