package fr.tangv.pickdeckcard.model.event;

public interface EventManager {

    void register(Listener listener);
    void unregister(Listener listener);
    void fire(Event event);

}
