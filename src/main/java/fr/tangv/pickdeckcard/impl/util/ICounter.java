package fr.tangv.pickdeckcard.impl.util;

import fr.tangv.pickdeckcard.model.util.Counter;

public class ICounter implements Counter {

    private final int defaultValue;
    private int counter;

    public ICounter(int defaultValue) {
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
    public int get() {
        return this.counter;
    }

    @Override
    public void set(int number) {
        this.counter = number;
    }

    @Override
    public void reset() {
        this.counter = this.defaultValue;
    }

    @Override
    public void decrease() {
        this.decrease(1);
    }

    @Override
    public void decrease(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number cannot be negative");
        }

        this.counter -= number;

        if (this.counter < 0) {
            this.counter = 0;
            throw new RuntimeException("Counter cannot be negative");
        }
    }

    @Override
    public void increase() {
        this.increase(1);
    }

    @Override
    public void increase(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number cannot be negative");
        }

        this.counter += number;
    }

}
