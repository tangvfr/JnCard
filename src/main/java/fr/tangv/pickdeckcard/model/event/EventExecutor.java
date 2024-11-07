package fr.tangv.pickdeckcard.model.event;

/**
 * Permet de déclencher un évènement
 */
@FunctionalInterface
public interface EventExecutor {

    <T extends Event> void fire(T event);

}
