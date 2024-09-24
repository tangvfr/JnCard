package fr.tangv.pickdeckcard.impl.event;

import fr.tangv.pickdeckcard.model.event.EventExecutor;
import fr.tangv.pickdeckcard.model.event.EventPriority;
import fr.tangv.pickdeckcard.model.event.Listener;
import lombok.Data;

@Data
public class EventManagerObserver implements Comparable<EventManagerObserver> {

    private final Listener listener;
    private final EventPriority priority;
    private final EventExecutor executor;

    @Override
    public int compareTo(EventManagerObserver iEventManagerObserver) {
        return this.priority.compareTo(iEventManagerObserver.priority);
    }

}
