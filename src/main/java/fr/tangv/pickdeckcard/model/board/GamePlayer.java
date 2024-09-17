package fr.tangv.pickdeckcard.model.board;

import fr.tangv.pickdeckcard.model.game.GameSettings;
import fr.tangv.pickdeckcard.model.player.Player;

import java.util.List;

public interface GamePlayer<T, S extends GameSettings> {

    GameBoard<T, S> getBoard();
    GamePlayer<T, S> getEnemy();
    Player getPlayer();
    List<T> getHand();
    List<BoardSlot<T>> getSlots(SlotType type);
    void distribute(T card);
    boolean isDeath();
    void addHand(T card);
    boolean isAFK();

}
