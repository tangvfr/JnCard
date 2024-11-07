package fr.tangv.pickdeckcard.impl.action;

import fr.tangv.pickdeckcard.model.board.JnGamePlayer;
import fr.tangv.pickdeckcard.model.card.JnCard;
import fr.tangv.pickdeckcard.model.game.JnGame;

import java.util.List;

public abstract class AbstractCardJnAction extends AbstractJnAction {

    private final List<JnCard> cards;

    public AbstractCardJnAction(JnGame game, JnGamePlayer executor, List<JnCard> cards) {
        super(game, executor);
        if (cards == null)
            throw new IllegalArgumentException("cards can't be null");

        this.cards = List.copyOf(cards);
    }

    @Override
    public List<JnCard> getCards() {
        return this.cards;
    }

    @Override
    public boolean hasCard() {
        return !this.cards.isEmpty();
    }

}
