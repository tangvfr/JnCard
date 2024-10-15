package fr.tangv.pickdeckcard.impl.game;

import fr.tangv.pickdeckcard.model.event.Event;
import fr.tangv.pickdeckcard.model.event.EventManager;
import fr.tangv.pickdeckcard.model.game.EventGame;

/**
 * Représente la base d'une partie de jeu avec une gestion d'évènement
 */
public abstract class BaseEventGame extends BaseGame implements EventGame {

    public abstract EventManager getInstanceOfEventManager();

    @Override
    public <T extends Event> void fire(T event) {
        this.getInstanceOfEventManager().fire(event);
    }

}
