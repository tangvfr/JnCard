package fr.tangv.pickdeckcard.impl.event.game;

import fr.tangv.pickdeckcard.model.game.Game;
import lombok.Getter;

public class GameStopEvent<T extends Game> extends AbstractGameEvent<T> {

    private @Getter boolean forced;

    public GameStopEvent(T game, boolean forced) {
        super(game);
        this.forced = forced;
    }

}
