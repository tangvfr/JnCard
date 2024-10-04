package fr.tangv.pickdeckcard.model.event;

/**
 * Permet la gestion d'observateur
 */
public interface EventManager extends EventExecutor {

    /**
     * Permet d'enregistrer un ensemble d'observateur
     * @param listener interface contenant des méthodes observatrices
     */
    void register(Listener listener);

    /**
     * Permet de retirer un ensemble d'observateur
     * @param listener interface contenant des méthodes observatrices
     */
    void unregister(Listener listener);

    /**
     * Permet de savoir si un ensemble d'observateur est déja présent
     * @return true s'il est déja présent sinon false
     */
    boolean isRegistered(Listener listener);

}
