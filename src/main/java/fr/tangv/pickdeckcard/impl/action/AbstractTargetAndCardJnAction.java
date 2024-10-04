package fr.tangv.pickdeckcard.impl.action;

import fr.tangv.pickdeckcard.model.action.JnGameActionType;
import fr.tangv.pickdeckcard.model.board.JnGamePlayer;
import fr.tangv.pickdeckcard.model.board.slot.BoardSlot;
import fr.tangv.pickdeckcard.model.board.GamePlayer;
import fr.tangv.pickdeckcard.model.board.slot.JnBoardSlot;
import fr.tangv.pickdeckcard.model.card.JnCard;
import fr.tangv.pickdeckcard.model.game.JnGame;
import fr.tangv.pickdeckcard.model.game.settings.GameSettings;

import java.util.List;
import java.util.Set;

public abstract class AbstractTargetAndCardJnAction extends AbstractCardJnAction {

    private JnBoardSlot target;

    public AbstractTargetAndCardJnAction(JnGame game, JnGameActionType type, JnGamePlayer executor, List<JnCard> cards, JnBoardSlot target) {
        super(game, type, executor, cards);
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
