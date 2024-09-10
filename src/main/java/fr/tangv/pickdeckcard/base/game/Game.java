package fr.tangv.pickdeckcard.base.game;

import fr.tangv.pickdeckcard.base.game.exception.game.GameNotFinishedException;

public interface Game {

    Player getPlayer1();
    Player getPlayer2();
    GameSettings getSettings();
    GameBoard getBoard();
    GamePlayer getWinner() throws GameNotFinishedException;
    GameStatement getStatement();
    GameStatement isStatement(GameStatement statement);

}
