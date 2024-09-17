package fr.tangv.pickdeckcard.model.action;

import fr.tangv.pickdeckcard.model.board.BoardSlot;
import fr.tangv.pickdeckcard.model.board.GamePlayer;
import fr.tangv.pickdeckcard.model.card.JnCard;
import fr.tangv.pickdeckcard.model.game.GameSettings;

import java.util.Set;

public interface ActionSupplier<T extends JnCard, S extends GameSettings> {

    Action<T> create(ActionType type, GamePlayer<T, S> player, Set<T> cards, BoardSlot<T> target);

}
