package fr.tangv.pickdeckcard.model.event;

import lombok.SneakyThrows;

/**
 * Permet de déclencher un évènement
 */
@FunctionalInterface
public interface EventExecutor {

    void fire(Event event);

}
