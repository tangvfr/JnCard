package fr.tangv.pickdeckcard.base.game.action;

import fr.tangv.pickdeckcard.base.game.GameBoard;
import fr.tangv.pickdeckcard.base.game.GamePlayer;
import fr.tangv.pickdeckcard.base.game.card.Card;

import java.util.Collection;
import java.util.Set;

public interface CardAction {

    void execute(GamePlayer player, Card target);
    boolean isAvailable(GamePlayer player);
    Set<Card> getTargets(GamePlayer player);

}
