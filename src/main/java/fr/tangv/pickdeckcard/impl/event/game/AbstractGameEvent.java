package fr.tangv.pickdeckcard.impl.event.game;

import fr.tangv.pickdeckcard.model.event.GameEvent;
import fr.tangv.pickdeckcard.model.game.Game;
import lombok.Getter;
import lombok.NonNull;

@Getter
public abstract class AbstractGameEvent<T extends Game> implements GameEvent<T> {

    private final T game;

    public AbstractGameEvent(@NonNull T game) {
        this.game = game;
    }

}
