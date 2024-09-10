package fr.tangv.pickdeckcard.base.game.card;

public interface GameCard extends Card {
    CardOrientation getOrientation();
    void setOrientation(CardOrientation orientation);
}
