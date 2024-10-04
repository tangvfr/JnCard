package fr.tangv.pickdeckcard.model.event;

import fr.tangv.pickdeckcard.impl.event.manager.IEventManager;
import lombok.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EventManagerTest {

    @Data class TestEvent1 implements Event {int value = 0;}
    @Data class TestEvent2 implements Event {String text = "";}
    class TestListenner1 implements Listener {
        @EventAnnotation(event = TestEvent1.class)
        void event1(TestEvent1 event) {
            event.value += 10;
        }
        @EventAnnotation(event = TestEvent2.class)
        void event2(TestEvent2 event) {
            event.text = "fired";
        }
    }
    class TestListenner2 implements Listener {
        @EventAnnotation(event = TestEvent1.class)
        void event1(TestEvent1 event) {
            event.value += 5;
        }
    }
    class TestListennerPH implements Listener {
        @EventAnnotation(event = TestEvent1.class, priority = EventPriority.HIGH)
        void event1(TestEvent1 event) {
            event.value *= 5;
        }
    }
    class TestListennerPL implements Listener {
        @EventAnnotation(event = TestEvent1.class, priority = EventPriority.LOW)
        void event1(TestEvent1 event) {
            event.value *= 5;
        }
    }

    EventManager eventManager;

    @BeforeEach
    public void setUp() {
        eventManager = new IEventManager();
    }

    @Test
    void registerOK() {
        //init
        TestListenner1 l1 = new TestListenner1();
        TestListenner2 l2 = new TestListenner2();
        //before register
        Assertions.assertFalse(eventManager.isRegistered(l1));
        Assertions.assertFalse(eventManager.isRegistered(l2));
        //register
        Assertions.assertDoesNotThrow(() -> eventManager.register(l1));
        //after register
        Assertions.assertTrue(eventManager.isRegistered(l1));
        Assertions.assertFalse(eventManager.isRegistered(l2));
    }

    @Test
    void unregister() {
        //init
        TestListenner1 l1 = new TestListenner1();
        TestListenner2 l2 = new TestListenner2();
        Assertions.assertDoesNotThrow(() -> {
            eventManager.register(l1);
            eventManager.register(l2);
        });
        //before unregister
        Assertions.assertTrue(eventManager.isRegistered(l1));
        Assertions.assertTrue(eventManager.isRegistered(l2));
        //unregister
        Assertions.assertDoesNotThrow(() -> eventManager.unregister(l1));
        //after unregister
        Assertions.assertFalse(eventManager.isRegistered(l1));
        Assertions.assertTrue(eventManager.isRegistered(l2));
    }

    @Test
    void isRegistered() {
        TestListenner1 l1 = new TestListenner1();
        Assertions.assertFalse(eventManager.isRegistered(l1));
        Assertions.assertDoesNotThrow(() -> eventManager.register(l1));
        Assertions.assertTrue(eventManager.isRegistered(l1));
    }

    @Test
    void fire() {

    }

}