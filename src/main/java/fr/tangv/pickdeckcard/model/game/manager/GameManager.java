package fr.tangv.pickdeckcard.model.game.manager;

import fr.tangv.pickdeckcard.model.game.Game;
import fr.tangv.pickdeckcard.model.util.Updateable;

import java.util.Collection;

public interface GameManager<T extends Game> extends Updateable {

    boolean contains(T game);
    void add(T game) throws GameAlreadyExistException;
    void remove(T game) throws GameNotFoundException;
    T remove(String gameId) throws GameNotFoundException;
    T get(String gameId) throws GameNotFoundException;
    void stop(T game) throws GameNotFoundException;
    T stop(String gameId) throws GameNotFoundException;
    void stopAll();
    int count();
    Collection<T> getGames();

}
