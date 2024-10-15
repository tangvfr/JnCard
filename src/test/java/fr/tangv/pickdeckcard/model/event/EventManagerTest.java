package fr.tangv.pickdeckcard.model.event;

import fr.tangv.pickdeckcard.impl.event.manager.IEventManager;
import lombok.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EventManagerTest {

    @Data class TestEventInt implements Event {int value = 0;}
    @Data class TestEventStr implements Event {String text = "no";}
    public class TestListenner1 implements Listener {
        @EventAnnotation(event = TestEventInt.class)
        public void event1(TestEventInt event) {
            event.value += 10;
        }
        @EventAnnotation(event = TestEventStr.class)
        public void event2(TestEventStr event) {
            event.text = "fired";
        }
    }
    public class TestListenner2 implements Listener {
        @EventAnnotation(event = TestEventInt.class)
        public void event1(TestEventInt event) {
            event.value += 5;
        }
    }
    public class TestListennerPH implements Listener {
        @EventAnnotation(event = TestEventInt.class, priority = EventPriority.HIGH)
        public void event1(TestEventInt event) {
            event.value *= 5;
        }
    }
    public class TestListennerPL implements Listener {
        @EventAnnotation(event = TestEventInt.class, priority = EventPriority.LOW)
        public void event1(TestEventInt event) {
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
        eventManager.register(new TestListenner1());
        TestEventStr event = new TestEventStr();
        //test
        Assertions.assertDoesNotThrow(() -> eventManager.fire(event));
        Assertions.assertEquals("fired", event.getText());
    }

    @Test
    void firePriorityLow() {
        eventManager.register(new TestListenner2());
        eventManager.register(new TestListennerPL());
        TestEventInt event = new TestEventInt();
        //test
        Assertions.assertDoesNotThrow(() -> eventManager.fire(event));
        Assertions.assertEquals(25, event.getValue());
    }

    @Test
    void firePriorityHigh() {
        eventManager.register(new TestListenner2());
        eventManager.register(new TestListennerPH());
        TestEventInt event = new TestEventInt();
        //test
        Assertions.assertDoesNotThrow(() -> eventManager.fire(event));
        Assertions.assertEquals(5, event.getValue());
    }

}