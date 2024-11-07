package fr.tangv.pickdeckcard.model.deck;

import fr.tangv.pickdeckcard.model.board.GameBoard;
import fr.tangv.pickdeckcard.model.board.GamePlayer;
import fr.tangv.pickdeckcard.model.exception.deck.EmptyDeckException;
import fr.tangv.pickdeckcard.model.game.settings.GameSettings;

/**
 * Permet de gérer le piochage des cartes et de les mettre dans le bon emplacement du joueur
 * @param <T> le type de carte utilisé
 */
public interface CardPoller<T, S extends GameSettings, P extends GamePlayer<T, S, P, B>, B extends GameBoard<T, S, P, B>> {

    /**
     * Permet de faire piocher "amount" carte à un joueur
     * @param player le joueur
     * @param amount le nombre de cartes piochées
     * @throws EmptyDeckException si plus de carte a piocher deck
     */
    void playerPollCard(P player, int amount) throws EmptyDeckException;

    /**
     * Permet de faire piocher une carte à un joueur
     * @param player le joueur
     * @throws EmptyDeckException si plus de carte a piocher deck
     */
    void playerPollCard(P player) throws EmptyDeckException;

    /**
     * Permet de récupérer une carte de la pioche
     * @return la première carte du tat de la pioche, ou null si plus de carte dans la pioche
     */
    T poll();

}
