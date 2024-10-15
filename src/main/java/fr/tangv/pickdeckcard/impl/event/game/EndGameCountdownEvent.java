package fr.tangv.pickdeckcard.impl.event.game;

import fr.tangv.pickdeckcard.model.game.Game;

public class EndGameCountdownEvent<T extends Game> extends AbstractGameEvent<T> {

    public EndGameCountdownEvent(T game) {
        super(game);
    }

}
