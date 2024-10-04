package fr.tangv.pickdeckcard.model.game;

import fr.tangv.pickdeckcard.model.util.Stoppable;
import fr.tangv.pickdeckcard.model.util.Updateable;

public interface GameManager<T extends Game> extends Updateable, Stoppable {

    void add(T game);
    void stop(T game);
    T stop(String gameId);
    T get(String gameId);
    T create();

}
