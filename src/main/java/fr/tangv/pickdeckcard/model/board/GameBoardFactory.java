package fr.tangv.pickdeckcard.model.board;

import fr.tangv.pickdeckcard.model.game.settings.GameSettings;

public interface GameBoardFactory<T, S extends GameSettings, P extends GamePlayer<T, S, P, B>, B extends GameBoard<T, S, P, B>> {

    B createBoard();

}
