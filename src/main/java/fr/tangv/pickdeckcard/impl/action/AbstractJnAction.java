package fr.tangv.pickdeckcard.impl.action;

import fr.tangv.pickdeckcard.model.action.JnGameAction;
import fr.tangv.pickdeckcard.model.action.JnGameActionType;
import fr.tangv.pickdeckcard.model.board.JnGamePlayer;
import fr.tangv.pickdeckcard.model.board.slot.JnBoardSlot;
import fr.tangv.pickdeckcard.model.card.JnCard;
import fr.tangv.pickdeckcard.model.game.JnGame;
import lombok.Getter;

import java.util.List;

@Getter
public abstract class AbstractJnAction implements JnGameAction {

    private static final String NOT_IMPLEMENTED = "It isn't implemented !";
    private JnGame game;
    private JnGameActionType type;
    private JnGamePlayer executor;

    /**
     * Permet de créer la base d'une action
     * @param game la partie
     * @param type le type de l'action
     * @param executor joueur qui a lancé l'action
     * @throws IllegalArgumentException si le type ou lanceur est nulle
     */
    public AbstractJnAction(JnGame game, JnGameActionType type, JnGamePlayer executor) {
        if (game == null || type == null || executor == null)
            throw new IllegalArgumentException("Game or Type or executor can't be null");

        this.game = game;
        this.type = type;
        this.executor = executor;
    }

    public List<JnCard> getCards() {
        throw new RuntimeException(NOT_IMPLEMENTED);
    }

    @Override
    public boolean hasCard() {
        return false;
    }

    @Override
    public JnBoardSlot getTarget() {
        throw new RuntimeException(NOT_IMPLEMENTED);
    }

    @Override
    public boolean hasTarget() {
        return false;
    }

}