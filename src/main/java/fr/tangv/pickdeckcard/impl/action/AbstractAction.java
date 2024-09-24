package fr.tangv.pickdeckcard.impl.action;

import fr.tangv.pickdeckcard.model.action.GameAction;
import fr.tangv.pickdeckcard.model.action.GameActionType;
import fr.tangv.pickdeckcard.model.board.BoardSlot;
import fr.tangv.pickdeckcard.model.board.GamePlayer;
import fr.tangv.pickdeckcard.model.game.GameSettings;
import lombok.Getter;

import java.util.Set;

@Getter
public abstract class AbstractAction<T, S extends GameSettings> implements GameAction<T, S> {

    private static final String FORBIDEN_METHOD = "Forbidden method";
    private GameActionType type;
    private GamePlayer<T, S> executor;

    /**
     * Permet de créer la base d'une action
     * @param type le type de l'action
     * @param executor joueur qui a lancé l'action
     * @throws IllegalArgumentException si le type ou lanceur est nulle
     */
    public AbstractAction(GameActionType type, GamePlayer<T, S> executor) {
        if (type == null || executor == null)
            throw new IllegalArgumentException("Type or executor can't be null");

        this.type = type;
        this.executor = executor;
    }

    public Set<T> getCards() {
        throw new RuntimeException(FORBIDEN_METHOD);
    }

    @Override
    public boolean hasCard() {
        return false;
    }

    @Override
    public BoardSlot<T> getTarget() {
        throw new RuntimeException(FORBIDEN_METHOD);
    }

    @Override
    public boolean hasTarget() {
        return false;
    }

}
