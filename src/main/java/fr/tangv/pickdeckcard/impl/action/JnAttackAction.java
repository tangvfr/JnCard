package fr.tangv.pickdeckcard.impl.action;

import fr.tangv.pickdeckcard.model.action.GameActionType;
import fr.tangv.pickdeckcard.model.board.BoardSlot;
import fr.tangv.pickdeckcard.model.board.GamePlayer;
import fr.tangv.pickdeckcard.model.card.CardColor;
import fr.tangv.pickdeckcard.model.card.CardType;
import fr.tangv.pickdeckcard.model.card.JnCard;
import fr.tangv.pickdeckcard.model.game.JnGameSettings;

import java.util.Set;

public class JnAttackAction extends AbstractTargetAndCardAction<JnCard, JnGameSettings> {

    private final int damage;

    /**
     * Permet de créer une action de type attaque simple
     * @param executor le joueur qui a lancé l'attaque
     * @param card la carte liée à l'attaque
     * @throws IllegalArgumentException si la carte n'est pas noir ou n'est pas de type nombre
     */
    public JnAttackAction(GamePlayer<JnCard, JnGameSettings> executor, JnCard card, BoardSlot<JnCard> slot) {
        super(GameActionType.ATTACK, executor, Set.of(card), slot);
        if (!card.isColor(CardColor.BLACK) || !card.isType(CardType.NUMBER))
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
