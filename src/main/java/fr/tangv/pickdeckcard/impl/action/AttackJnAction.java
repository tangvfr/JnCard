package fr.tangv.pickdeckcard.impl.action;

import fr.tangv.pickdeckcard.model.board.JnGamePlayer;
import fr.tangv.pickdeckcard.model.board.slot.JnBoardSlot;
import fr.tangv.pickdeckcard.model.card.JnCard;
import fr.tangv.pickdeckcard.model.game.JnGame;

import java.util.List;

public class AttackJnAction extends AbstractTargetAndCardJnAction {

    private final int damage;

    /**
     * Permet de créer une action de type attaque simple
     * @param executor le joueur qui a lancé l'attaque
     * @param card la carte liée à l'attaque
     * @throws IllegalArgumentException si la carte n'est pas noir ou n'est pas de type nombre
     */
    public AttackJnAction(JnGame game, JnGamePlayer executor, JnCard card, JnBoardSlot slot) {
        super(game, executor, List.of(card), slot);
        if (!card.isAttack())
            throw new IllegalArgumentException("Card must be BLACK and NUMBER");

        this.damage = card.getValue().getValue();
    }

    public int getDamage() {
        return this.damage;
    }

    @Override
    public boolean isAvaible() {
        //return this.exe;
        return true;
    }

    @Override
    public void execute() {

    }
}
