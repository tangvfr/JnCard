package fr.tangv.pickdeckcard.model.util;

public interface Counter {

    boolean isEmpty();
    int get();
    void set(int number);
    void reset();
    void decrease();
    void decrease(int number);
    void increase();
    void increase(int number);

}
