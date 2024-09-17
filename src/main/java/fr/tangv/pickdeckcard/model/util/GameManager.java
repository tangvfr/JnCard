package fr.tangv.pickdeckcard.model.util;

import fr.tangv.pickdeckcard.model.game.Game;

public interface GameManager<T extends Game> extends Updateable, Stoppable {

    void add(T game);
    void stop(T game);
    T stop(String gameId);
    T get(String gameId);
    T create();

}
