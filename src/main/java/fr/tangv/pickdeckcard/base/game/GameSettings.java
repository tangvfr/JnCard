package fr.tangv.pickdeckcard.base.game;

public interface GameSettings {

    int getStartingNumberHearthCard();
    int getStartingNumberAttackCard();
    int getNumberHearthInMainDeck();
    boolean boostedOneInHearthDeck();
    boolean blackOneCardCanBeShield();
    int shieldDurability();
    boolean allowedSumAttack();
    int sumAttackMax();

}
