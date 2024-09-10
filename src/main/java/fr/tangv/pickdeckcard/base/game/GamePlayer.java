package fr.tangv.pickdeckcard.base.game;

import fr.tangv.pickdeckcard.base.game.card.GameCard;

import java.util.List;

public interface GamePlayer {

    GameBoard getBoard();
    Player getPlayer();
    List<GameCard> getHand();
    List<GameCard> getHearths();
    List<GameCard> getShields();
    boolean isDeath();
    boolean hasShield();

}
