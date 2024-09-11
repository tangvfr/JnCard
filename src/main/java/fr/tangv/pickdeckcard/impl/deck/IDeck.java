package fr.tangv.pickdeckcard.impl.deck;

import fr.tangv.pickdeckcard.model.card.Card;
import fr.tangv.pickdeckcard.model.deck.Deck;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Random;

public class IDeck<T extends Card> implements Deck<T> {

    private Deque<T> cards;

    @Override
    public void mix() {
        //liste >= 1
        if (!cards.isEmpty()) {
            //preparing
            ArrayList<T> cardList = new ArrayList<>(cards);
            this.cards.clear();
            Random random = new Random();
            int len = cardList.size();

            //mixing
            while (len > 1) {
                cards.offer(cardList.remove(random.nextInt(len)));
                len--;
            }

            //liste = 1
            cards.offer(cardList.remove(0));
        }
        //liste vide
    }

    @Override
    public T poll() {
        return this.cards.pollFirst();
    }

    @Override
    public T remove() {
        return this.cards.removeFirst();
    }

    @Override
    public void add(T card) {
        this.cards.addFirst(card);
    }

    @Override
    public int size() {
        return this.cards.size();
    }

    @Override
    public boolean isEmpty() {
        return this.cards.isEmpty();
    }

    @Override
    public void transfertTo(Deck<T> deck) {
        T card = this.cards.pollFirst();
        while (card != null) {
            deck.add(card);
            card = this.cards.pollFirst();
        }
    }

}
