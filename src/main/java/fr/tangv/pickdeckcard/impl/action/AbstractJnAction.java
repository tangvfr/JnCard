package fr.tangv.pickdeckcard.impl.action;

import fr.tangv.pickdeckcard.model.action.JnGameActionNoCard;
import fr.tangv.pickdeckcard.model.board.JnGamePlayer;
import fr.tangv.pickdeckcard.model.board.slot.JnBoardSlot;
import fr.tangv.pickdeckcard.model.card.JnCard;
import fr.tangv.pickdeckcard.model.game.JnGame;
import lombok.Getter;

import java.util.List;

@Getter
public abstract class AbstractJnAction implements JnGameActionNoCard {

    private static final String NOT_IMPLEMENTED = "It isn't implemented !";
    private JnGame game;
    private JnGamePlayer executor;

    /**
     * Permet de créer la base d'une action
     * @param game la partie
     * @param executor joueur qui a lancé l'action
     * @throws IllegalArgumentException si le type ou lanceur est nulle
     */
    public AbstractJnAction(JnGame game, JnGamePlayer executor) {
        if (game == null || executor == null)
            throw new IllegalArgumentException("Game or executor can't be null");

        this.game = game;
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