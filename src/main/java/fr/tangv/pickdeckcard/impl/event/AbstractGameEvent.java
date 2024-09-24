package fr.tangv.pickdeckcard.impl.event;

import fr.tangv.pickdeckcard.model.event.GameEvent;
import fr.tangv.pickdeckcard.model.game.Game;
import lombok.Getter;

public class AbstractGameEvent implements GameEvent {

    @Getter
    private Game game;

}
