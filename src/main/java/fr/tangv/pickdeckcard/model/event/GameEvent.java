package fr.tangv.pickdeckcard.model.event;

import fr.tangv.pickdeckcard.model.game.Game;

public interface GameEvent<T extends Game> extends Event {

    T getGame();

}
