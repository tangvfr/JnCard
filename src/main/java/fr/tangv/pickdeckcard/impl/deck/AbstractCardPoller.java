package fr.tangv.pickdeckcard.impl.deck;

import fr.tangv.pickdeckcard.model.board.GameBoard;
import fr.tangv.pickdeckcard.model.board.GamePlayer;
import fr.tangv.pickdeckcard.model.deck.CardPoller;
import fr.tangv.pickdeckcard.model.exception.deck.EmptyDeckException;
import fr.tangv.pickdeckcard.model.game.settings.GameSettings;

public abstract class AbstractCardPoller<T, S extends GameSettings, P extends GamePlayer<T, S, P, B>, B extends GameBoard<T, S, P, B>>
        implements CardPoller<T, S, P, B> {

    @Override
    public void playerPollCard(P player) throws EmptyDeckException {
        T card = this.poll();
        if (card == null) throw new EmptyDeckException();

        player.distribute(card);
    }

    @Override
    public void playerPollCard(P player, int amount) throws EmptyDeckException {
        for (int i = 0; i < amount; i++) {
            this.playerPollCard(player);
        }
    }

}
