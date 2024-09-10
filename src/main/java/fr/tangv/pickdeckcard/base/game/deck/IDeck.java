package fr.tangv.pickdeckcard.base.game.deck;

import fr.tangv.pickdeckcard.base.game.card.Card;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Random;

public class IDeck<T extends Card> implements Deck<T> {

    private Queue<T> cards;

    @Override
    public void mixed() {
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
    public T pick() {
        return this.cards.poll();
    }

    @Override
    public void insert(T card) {
        this.cards.add(card);
    }

    @Override
    public int size() {
        return this.cards.size();
    }

    @Override
    public boolean isEmpty() {
        return this.cards.isEmpty();
    }

}
