package fr.tangv.pickdeckcard.impl.board;

import fr.tangv.pickdeckcard.model.board.ActionCounter;

public class IActionCounter implements ActionCounter {

    private final int defaultValue;
    private int counter;

    public IActionCounter(int defaultValue) {
        if (defaultValue < 0) {
            throw new IllegalArgumentException("Default value cannot be negative");
        }

        this.defaultValue = defaultValue;
        this.counter = defaultValue;
    }

    @Override
    public boolean isEmpty() {
        return this.counter == 0;
    }

    @Override
    public int getNumber() {
        return this.counter;
    }

    @Override
    public void reset() {
        this.counter = this.defaultValue;
    }

    @Override
    public void decrease() {
        if (this.counter == 0) {
            throw new RuntimeException("Counter cannot be negative");
        }

        this.counter--;
    }

    @Override
    public void increase() {
        this.counter++;
    }

    @Override
    public void increase(int number) {
        this.counter += number;
    }

}
