package fr.tangv.pickdeckcard.api.model.intern;

import fr.tangv.pickdeckcard.api.model.exception.action.ForbidenActionException;
import fr.tangv.pickdeckcard.api.model.exception.action.InvalidActionException;
import fr.tangv.pickdeckcard.api.model.exception.action.TurnActionException;
import fr.tangv.pickdeckcard.model.board.JnGamePlayer;
import fr.tangv.pickdeckcard.model.board.slot.JnBoardSlot;
import fr.tangv.pickdeckcard.model.game.GameType;
import fr.tangv.pickdeckcard.model.game.JnGame;
import fr.tangv.pickdeckcard.model.game.settings.JnGameSettings;
import fr.tangv.pickdeckcard.model.player.PlayerConnection;
import fr.tangv.pickdeckcard.core.user.Player;

import javax.smartcardio.Card;
import java.util.List;

/**
 * Permet d'intéragir avec le model de jeu de carte JnCard
 */
public interface JnFacade extends GameFacade<JnGame, JnGameSettings> {

    /**
     * Permet d'exécuter une action d'attaque classic
     * @param game la partie concernée par l'action
     * @param player le joueur qui réalise l'action
     * @param usedCard la carte utilisée pour l'action
     * @param target la cible de l'attaque
     * @throws TurnActionException si ce n'est pas le tour du joueur
     * @throws ForbidenActionException si le joueur n'a pas le droit de faire l'action
     * @throws InvalidActionException si l'action n'est pas correctement constituée
     */
    void playAttack(JnGame game, JnGamePlayer player, Card usedCard, JnBoardSlot target)
            throws ForbidenActionException, InvalidActionException, TurnActionException;

    /**
     * Permet d'exécuter une action d'attaque cumulué
     * @param game la partie concernée par l'action
     * @param player le joueur qui réalise l'action
     * @param usedCards les cartes utilisées pour l'action
     * @param target la cible de l'attaque
     * @throws TurnActionException si ce n'est pas le tour du joueur
     * @throws ForbidenActionException si le joueur n'a pas le droit de faire l'action
     * @throws InvalidActionException si l'action n'est pas correctement constitué
     */
    void playSumAttack(JnGame game, JnGamePlayer player, List<Card> usedCards, JnBoardSlot target)
            throws ForbidenActionException, InvalidActionException, TurnActionException;

    /**
     * Permet d'exécuter une action d'attaque destructeur
     * @param game la partie concernée par l'action
     * @param player le joueur qui réalise l'action
     * @param usedCards les cartes utilisées pour l'action (attack classic & tête)
     * @param target la cible de l'attaque
     * @throws TurnActionException si ce n'est pas le tour du joueur
     * @throws ForbidenActionException si le joueur n'a pas le droit de faire l'action
     * @throws InvalidActionException si l'action n'est pas correctement constitué
     */
    void playDestructor(JnGame game, JnGamePlayer player, List<Card> usedCards, JnBoardSlot target)
            throws ForbidenActionException, InvalidActionException, TurnActionException;

    /**
     * Permet d'exécuter une action de pose de bouclier
     * @param game la partie concernée par l'action
     * @param player le joueur qui réalise l'action
     * @param usedCard la carte utilisée pour l'action
     * @throws TurnActionException si ce n'est pas le tour du joueur
     * @throws ForbidenActionException si le joueur n'a pas le droit de faire l'action
     * @throws InvalidActionException si l'action n'est pas correctement constituée
     */
    void playShield(JnGame game, JnGamePlayer player, Card usedCard)
            throws ForbidenActionException, InvalidActionException, TurnActionException;

    /**
     * Permet d'exécuter une action spéciale d'une carte (tête)
     * @param game la partie concernée par l'action
     * @param player le joueur qui réalise l'action
     * @param usedCard la carte utilisée pour l'action
     * @throws TurnActionException si ce n'est pas le tour du joueur
     * @throws ForbidenActionException si le joueur n'a pas le droit de faire l'action
     * @throws InvalidActionException si l'action n'est pas correctement constituée
     */
    void playSpecial(JnGame game, JnGamePlayer player, Card usedCard)
            throws ForbidenActionException, InvalidActionException, TurnActionException;

    /**
     * Permet d'exécuter l'action de la prise d'une carte dans la pioche
     * @param game la partie concernée par l'action
     * @param player le joueur qui réalise l'action
     * @throws TurnActionException si ce n'est pas le tour du joueur
     * @throws ForbidenActionException si le joueur n'a pas le droit de faire l'action
     * @throws InvalidActionException si l'action n'est pas correctement constituée
     */
    void pickCard(JnGame game, JnGamePlayer player)
            throws ForbidenActionException, TurnActionException;

    /**
     * Permet de se rendre
     * @param game la partie concernée par l'action
     * @param player le joueur qui abandonne
     */
    void surrend(JnGame game, JnGamePlayer player);

    /**
     * Permet de lier une connexion à un joueur d'une partie
     * <p>
     * Si une ancienne conexion existe, ça termine l'ancienne connexion
     * </p>
     * @param game une partie
     * @param player le joueur
     * @param connection la connexion du joueur
     */
    void linkPlayer(JnGame game, JnGamePlayer player, PlayerConnection connection);

    /**
     * Permet d'instancier une nouvelle partie avec une variante de règles customisées
     * @param type le type de la partie crée
     * @param players les joueurs participant à la partie
     * @param setting règles a appliquer pour la partie
     * @return la nouvel parti instancié
     */
    JnGame createCustomGame(GameType type, Player[] players, JnGameSettings setting);

    /**
     * Permet d'instancier une nouvelle partie avec une des règles règles prédéfinis
     * @param type le type de la partie crée
     * @param players les joueurs participant à la partie
     * @param settingName nom de la règle a appliquer pour la partie
     * @return la nouvel parti instancié
     */
    JnGame createGame(GameType type, Player[] players, String settingName);

    /**
     * Permet de lier une connexion à l'observeur d'une partie
     * <p>
     * Si l'observateur existe, ça termine l'ancienne connexion
     * Si l'observateur n'existe pas, ça crée un nouvel observeur
     * </p>
     * @param game une partie
     * @param player les informations d'un observateur
     * @param connection la connexion d'un observateur
     */
    void linkObserver(JnGame game, Player player, PlayerConnection connection);

}
