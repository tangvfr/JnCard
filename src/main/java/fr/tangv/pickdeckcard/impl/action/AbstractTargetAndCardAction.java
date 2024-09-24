package fr.tangv.pickdeckcard.impl.action;

import fr.tangv.pickdeckcard.model.action.GameActionType;
import fr.tangv.pickdeckcard.model.board.BoardSlot;
import fr.tangv.pickdeckcard.model.board.GamePlayer;
import fr.tangv.pickdeckcard.model.game.GameSettings;

import java.util.Set;

public abstract class AbstractTargetAndCardAction<T, S extends GameSettings> extends AbstractCardAction<T, S> {

    private BoardSlot<T> target;

    public AbstractTargetAndCardAction(GameActionType type, GamePlayer<T, S> executor, Set<T> cards, BoardSlot<T> target) {
        super(type, executor, cards);
        this.target = target;
    }

    @Override
    public BoardSlot<T> getTarget() {
        return this.target;
    }

    @Override
    public boolean hasTarget() {
        return this.target != null;
    }

}
