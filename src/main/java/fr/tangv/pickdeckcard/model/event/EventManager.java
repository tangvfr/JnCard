package fr.tangv.pickdeckcard.model.event;

/**
 * Permet la gestion d'observateur
 */
public interface EventManager extends EventExecutor {

    void register(Listener listener);
    void unregister(Listener listener);
    boolean isRegistered(Listener listener);

}
