package fr.tangv.pickdeckcard.impl.action;

import fr.tangv.pickdeckcard.model.board.JnGamePlayer;
import fr.tangv.pickdeckcard.model.board.slot.JnBoardSlot;
import fr.tangv.pickdeckcard.model.card.JnCard;
import fr.tangv.pickdeckcard.model.game.JnGame;

import java.util.List;

public abstract class AbstractTargetAndCardJnAction extends AbstractCardJnAction {

    private JnBoardSlot target;

    public AbstractTargetAndCardJnAction(JnGame game, JnGamePlayer executor, List<JnCard> cards, JnBoardSlot target) {
        super(game, executor, cards);
        this.target = target;
    }

    @Override
    public JnBoardSlot getTarget() {
        return this.target;
    }

    @Override
    public boolean hasTarget() {
        return this.target != null;
    }

}
