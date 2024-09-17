package fr.tangv.pickdeckcard.model.board;

public interface JnGamePlayer<T> extends GamePlayer<T> {

    boolean hasShield();
    int countHearths();
    void addShield(T card);
    void addHeart(T card);

}
