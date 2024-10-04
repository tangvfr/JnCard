package fr.tangv.pickdeckcard.model.game;

import fr.tangv.pickdeckcard.model.event.EventExecutor;
import fr.tangv.pickdeckcard.model.game.settings.GameSettings;

/**
 * Représente un jeu avec des évènements
 */
public interface EventGame extends Game, EventExecutor {}
