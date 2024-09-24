package fr.tangv.pickdeckcard.impl.event;

import fr.tangv.pickdeckcard.model.event.Event;
import fr.tangv.pickdeckcard.model.event.EventExecutor;
import fr.tangv.pickdeckcard.model.event.Listener;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.lang.reflect.Method;

@RequiredArgsConstructor
public class EventExecutorAdapter implements EventExecutor {

    private final Listener listener;
    private final Method method;

    @SneakyThrows
    @Override
    public void fire(Event event) {
        this.method.invoke(this.listener, event);
    }

}
