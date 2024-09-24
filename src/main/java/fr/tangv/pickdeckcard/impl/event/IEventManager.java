package fr.tangv.pickdeckcard.impl.event;

import fr.tangv.pickdeckcard.model.event.Event;
import fr.tangv.pickdeckcard.model.event.EventAnnotation;
import fr.tangv.pickdeckcard.model.event.EventManager;
import fr.tangv.pickdeckcard.model.event.Listener;
import fr.tangv.pickdeckcard.model.event.exception.AlreadyRegisterListenerException;
import fr.tangv.pickdeckcard.model.event.exception.NotFoundListenerException;

import java.lang.reflect.Method;
import java.util.*;

public class IEventManager implements EventManager {

    private static final Class<EventAnnotation> EVENT_ANNOTATION = EventAnnotation.class;

    private Set<Listener> registeredListeners = new HashSet<>();
    private Map<Class<? extends Event>, SortedSet<EventManagerObserver>> registeredObserver = new HashMap<>();

    @Override
    public void register(Listener listener) {
        //check up
        Objects.requireNonNull(listener);
        if (this.isRegistered(listener))
            throw new AlreadyRegisterListenerException(listener.getClass().getSimpleName());

        //register
        for (Method method : listener.getClass().getMethods()) {
            if (method.isAnnotationPresent(EVENT_ANNOTATION)) {
                this.appendObserver(listener, method);
            }
        }
        this.registeredListeners.add(listener);
    }

    private SortedSet<EventManagerObserver> getObserverSet(Class<? extends Event> eventClass) {
        return this.registeredObserver.computeIfAbsent(eventClass, k -> new TreeSet<>());
    }

    private void appendObserver(Listener listener, Method method) {
        EventAnnotation eventAnnotation = method.getAnnotation(EVENT_ANNOTATION);
        Class<? extends Event> eventClass = eventAnnotation.event();
        //on récupère la liste ou on la crée
        SortedSet<EventManagerObserver> observers = getObserverSet(eventClass);

        //ajout
        observers.add(new EventManagerObserver(
                    listener,
                    eventAnnotation.priority(),
                    new EventExecutorAdapter(listener, method)
                ));
    }

    @Override
    public void unregister(Listener listener) {
        Objects.requireNonNull(listener);
        if (!this.isRegistered(listener))
            throw new NotFoundListenerException(listener.getClass().getSimpleName());

        //removing
        this.registeredObserver.forEach((event, list) -> list.removeIf(ob -> ob.getListener().equals(listener)));
        this.registeredListeners.remove(listener);
    }

    @Override
    public boolean isRegistered(Listener listener) {
        return this.registeredListeners.contains(listener);
    }

    @Override
    public void fire(Event event) {
        Objects.requireNonNull(event);
        SortedSet<EventManagerObserver> observers = getObserverSet(event.getClass());
        //execution
        for (EventManagerObserver observer : observers) {
            observer.getExecutor().fire(event);
        }
    }

}
