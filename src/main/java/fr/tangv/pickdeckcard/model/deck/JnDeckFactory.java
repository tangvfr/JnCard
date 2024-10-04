package fr.tangv.pickdeckcard.model.deck;

public interface JnDeckFactory<T> extends ClassicDeckFactory<T> {

    /**
     * (10 sur le dessus du packer)
     * @return le tat des cartes de nombres rouges
     */
    Deck<T> createHearth();
    Deck<T> createAttack();

}
