package fr.tangv.pickdeckcard.impl.event;

import fr.tangv.pickdeckcard.model.event.Event;
import fr.tangv.pickdeckcard.model.game.Game;
import lombok.Getter;

public class AbstractGameEvent implements Event {

    @Getter
    private Game game;

}
