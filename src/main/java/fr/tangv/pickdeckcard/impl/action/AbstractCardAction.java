package fr.tangv.pickdeckcard.impl.action;

import fr.tangv.pickdeckcard.model.action.ActionType;
import fr.tangv.pickdeckcard.model.board.GamePlayer;
import fr.tangv.pickdeckcard.model.card.JnCard;
import fr.tangv.pickdeckcard.model.game.GameSettings;

import java.util.Set;

public abstract class AbstractCardAction<T, S extends GameSettings> extends AbstractAction<T, S> {

    private final Set<T> cards;

    public AbstractCardAction(ActionType type, GamePlayer<T, S> executor, Set<T> cards) {
        super(type, executor);
        if (cards == null)
            throw new IllegalArgumentException("cards can't be null");

        this.cards = Set.copyOf(cards);
    }

    @Override
    public Set<T> getCards() {
        return this.cards;
    }

    @Override
    public boolean hasCard() {
        return !this.cards.isEmpty();
    }

}
