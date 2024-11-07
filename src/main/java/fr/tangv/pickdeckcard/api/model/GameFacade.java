package fr.tangv.pickdeckcard.api.model;

import fr.tangv.pickdeckcard.model.game.Game;
import fr.tangv.pickdeckcard.model.game.settings.GameSettings;
import fr.tangv.pickdeckcard.model.player.Player;

/**
 * Permet d'interagir avec le model de jeu de carte
 * @param <T> Type de partie géré
 * @param <S> Type de paramétrage pour les parties
 */
public interface GameFacade<T extends Game, S extends GameSettings> {

    /* gestion de parti */

    /**
     * Permet d'instancier une nouvelle partie
     * @param players les joueurs participant à la partie
     * @return la nouvel parti instancié
     */
    T createGame(Player[] players);

    /**
     * Permet d'instancier une nouvelle partie avec des règles customisées
     * @param players les joueurs participant à la partie
     * @param settings règles customisées pour la partie
     * @return la nouvel parti instancié
     */
    T createGame(Player[] players, S settings);

    /**
     * Permet de récupérer une partie grâce à son identifiant
     * @param gameId identifiant de la parti
     * @return
     */
    T getGame(String gameId);

    /**
     * Permet d'arrêt une partie grâce à son identifiant
     * @param gameId identifiant de la parti
     */
    void stopGame(String gameId);

    /**
     * Permet d'arrêter toutes les parties en cours
     */
    void stopAllGame();

    /* gestion loop */

    /**
     * Permet d'arrêter toutes les parties, bloquer la création de nouvel parti et stopper la boucle de mise à jour
     */
    void stop();

    /**
     * Permet de récupérer le lambda pour démarrer la boucle de mise à jour
     * @return le lambda pour démarrer la boucle de mise à jour
     */
    Runnable getLoop();

}
