package fr.tangv.pickdeckcard.impl.action;

import fr.tangv.pickdeckcard.model.action.JnGameActionType;
import fr.tangv.pickdeckcard.model.board.GamePlayer;
import fr.tangv.pickdeckcard.model.board.JnGamePlayer;
import fr.tangv.pickdeckcard.model.card.JnCard;
import fr.tangv.pickdeckcard.model.game.JnGame;
import fr.tangv.pickdeckcard.model.game.settings.GameSettings;

import java.util.List;
import java.util.Set;

public abstract class AbstractCardJnAction extends AbstractJnAction {

    private final List<JnCard> cards;

    public AbstractCardJnAction(JnGame game, JnGameActionType type, JnGamePlayer executor, List<JnCard> cards) {
        super(game, type, executor);
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
