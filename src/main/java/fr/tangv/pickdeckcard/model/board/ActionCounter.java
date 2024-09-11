package fr.tangv.pickdeckcard.model.board;

public interface ActionCounter {

    boolean isEmpty();
    int getNumber();
    void reset();
    void decrease();
    void increase();
    void increase(int number);

}
