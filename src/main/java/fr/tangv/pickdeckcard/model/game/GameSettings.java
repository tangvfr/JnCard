package fr.tangv.pickdeckcard.model.game;

public interface GameSettings {

    long getTimeToPlay();
    int getStartingNumberHearthCard();
    int getStartingNumberAttackCard();
    int getNumberHearthInMainDeck();
    boolean boostedOneInHearthDeck();
    boolean blackOneCardCanBeShield();
    int shieldDurability();
    boolean allowedSumAttack();
    int sumAttackMax();

}
