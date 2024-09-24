package fr.tangv.pickdeckcard.impl.event;


import fr.tangv.pickdeckcard.model.event.Event;
import lombok.Data;

/**
 * Évènement pour effectuer les tests
 */
@Data
public class TestEvent implements Event {

    private String text;

}
