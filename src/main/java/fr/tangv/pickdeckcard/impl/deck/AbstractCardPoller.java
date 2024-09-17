package fr.tangv.pickdeckcard.impl.deck;

import fr.tangv.pickdeckcard.model.board.GamePlayer;
import fr.tangv.pickdeckcard.model.deck.CardPoller;
import fr.tangv.pickdeckcard.model.deck.exception.EmptyDeckException;
import fr.tangv.pickdeckcard.model.game.GameSettings;

public abstract class AbstractCardPoller<T, S extends GameSettings> implements CardPoller<T, S> {

    @Override
    public void playerPollCard(GamePlayer<T, S> player) throws EmptyDeckException {
        T card = this.poll();
        if (card == null) throw new EmptyDeckException();

        player.distribute(card);
    }

    @Override
    public void playerPollCard(GamePlayer<T, S> player, int amount) throws EmptyDeckException {
        for (int i = 0; i < amount; i++) {
            this.playerPollCard(player);
        }
    }

}
