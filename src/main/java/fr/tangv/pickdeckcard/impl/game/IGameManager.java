package fr.tangv.pickdeckcard.impl.game;

import fr.tangv.pickdeckcard.model.game.Game;
import fr.tangv.pickdeckcard.model.game.GameStatement;
import fr.tangv.pickdeckcard.model.game.manager.GameAlreadyExistException;
import fr.tangv.pickdeckcard.model.game.manager.GameManager;
import fr.tangv.pickdeckcard.model.game.manager.GameNotFoundException;
import lombok.NonNull;

import java.util.*;

public class IGameManager<T extends Game> implements GameManager<T> {

    private static final boolean FORCED_STOP = true;

    Map<String, T> games = new TreeMap<>();

    @Override
    public boolean contains(@NonNull T game) {
        return games.containsKey(game.getId());
    }

    private void testGameNotFound(T game) throws GameNotFoundException {
        if (game == null)
            throw new GameNotFoundException();
    }

    @Override
    public void add(@NonNull T game) throws GameAlreadyExistException {
        if (contains(game))
            throw new GameAlreadyExistException();

        games.put(game.getId(), game);
    }

    @Override
    public void remove(@NonNull T game) throws GameNotFoundException {
        remove(game.getId());
    }

    @Override
    public T remove(@NonNull String gameId) throws GameNotFoundException {
        T game = games.remove(gameId);
        testGameNotFound(game);
        return game;
    }

    @Override
    public T get(@NonNull String gameId) throws GameNotFoundException {
        T game = games.get(gameId);
        testGameNotFound(game);
        return game;
    }

    @Override
    public void stop(@NonNull T game) throws GameNotFoundException {
        stop(game.getId());
    }

    @Override
    public T stop(@NonNull String gameId) throws GameNotFoundException {
        T game = remove(gameId);
        game.stop(FORCED_STOP);
        return game;
    }

    @Override
    public int count() {
        return games.size();
    }

    @Override
    public Collection<T> getGames() {
        return List.copyOf(games.values());
    }

    @Override
    public void stopAll() {
        Iterator<T> it = this.games.values().iterator();
        T game;

        while (it.hasNext()) {
            game = it.next();
            it.remove();
            game.stop(FORCED_STOP);
        }
    }

    @Override
    public void update() {
        Iterator<T> it = this.games.values().iterator();
        T game;

        while (it.hasNext()) {
            game = it.next();
            if (game.isStatement(GameStatement.FINISHED)) {
                it.remove();
            } else {
                game.update();
            }
        }
    }

}
