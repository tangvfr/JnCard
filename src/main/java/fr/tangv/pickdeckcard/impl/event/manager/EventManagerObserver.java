package fr.tangv.pickdeckcard.impl.event.manager;

import fr.tangv.pickdeckcard.model.event.Event;
import fr.tangv.pickdeckcard.model.event.EventExecutor;
import fr.tangv.pickdeckcard.model.event.EventPriority;
import fr.tangv.pickdeckcard.model.event.Listener;
import lombok.Data;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Représente une méthode avec une annotation EventAnnotation dans un Listener pour l'Event
 */
@Data
public class EventManagerObserver implements Comparable<EventManagerObserver>, EventExecutor {

    /**
     * Permet d'identifier d'où vient la méthode
     */
    private final Listener listener;
    private final EventPriority priority;
    /**
     * Méthode à executer
     */
    private final Method method;

    @Override
    public int compareTo(EventManagerObserver iEventManagerObserver) {
        return this.priority.compareTo(iEventManagerObserver.priority);
    }

    public <T extends Event> void fire(T event) {
        try {
            this.method.invoke(this.listener, event);
        } catch (InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}
