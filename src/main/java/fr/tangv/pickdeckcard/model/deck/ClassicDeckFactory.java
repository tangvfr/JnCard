package fr.tangv.pickdeckcard.model.deck;

public interface ClassicDeckFactory<T> {

    Deck<T> createEmpty();
    Deck<T> createCompleted();

}
