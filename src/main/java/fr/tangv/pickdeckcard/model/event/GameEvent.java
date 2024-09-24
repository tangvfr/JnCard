package fr.tangv.pickdeckcard.model.event;

import fr.tangv.pickdeckcard.model.game.Game;

public interface GameEvent extends Event {

    Game getGame();

}
