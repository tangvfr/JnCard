package fr.tangv.pickdeckcard.model.board;

import fr.tangv.pickdeckcard.model.card.Card;
import fr.tangv.pickdeckcard.model.player.Player;

import java.util.List;

public interface GamePlayer<T extends Card> {

    GameBoard<T> getBoard();
    GamePlayer<T> getEnemy();
    Player getPlayer();
    List<T> getHand();
    List<BoardSlot<T>> getHearths();
    List<BoardSlot<T>> getShields();
    boolean isDeath();
    boolean hasShield();
    int countHearths();

}
