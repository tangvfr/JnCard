package fr.tangv.pickdeckcard.impl.event.manager;

import fr.tangv.pickdeckcard.model.event.EventManager;

public class SingletonEventManager {

    public static final int JN_GAME_TYPE = 0;

    private static volatile EventManager instance;

    public static EventManager getInstance(int gameType) {
        synchronized (SingletonEventManager.class) {
            if (instance == null) {
                instance = new IEventManager();
            }

            return instance;
        }
    }

}
