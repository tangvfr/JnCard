package fr.tangv.pickdeckcard.api.model;

import fr.tangv.pickdeckcard.api.model.exception.action.ForbidenActionException;
import fr.tangv.pickdeckcard.api.model.exception.action.InvalidActionException;
import fr.tangv.pickdeckcard.api.model.exception.action.TurnActionException;
import fr.tangv.pickdeckcard.model.board.JnGamePlayer;
import fr.tangv.pickdeckcard.model.game.JnGame;
import fr.tangv.pickdeckcard.model.game.settings.JnGameSettings;
import fr.tangv.pickdeckcard.model.player.Player;

import javax.smartcardio.Card;
import java.util.List;

/**
 * Permet d'interagir avec le model de jeu de carte JnCard
 */
public interface JnFacade extends GameFacade<JnGame, JnGameSettings> {

    /**
     * Permet d'exécuter une action d'attaque classic
     * @param game la partie concernée par l'action
     * @param player le joueur qui réalise l'action
     * @param card la carte associée à l'action
     */
    void playAttack(JnGame game, JnGamePlayer player, Card card)
            throws ForbidenActionException, InvalidActionException, TurnActionException, ;

    void playSumAttack(JnGame game, JnGamePlayer player, List<Card> cards);
    void playDestructor(JnGame game, JnGamePlayer player, List<Card> cards);
    void playShield(JnGame game, JnGamePlayer player, Card cards);
    void playSpell(JnGame game, JnGamePlayer player, Card cards);
    void pickCard(JnGame game, JnGamePlayer player);
    void surrend(JnGame game, JnGamePlayer player);

    /**
     * Permet d'instancier une nouvelle partie avec une variante de règles
     * @param players les joueurs participant à la partie
     * @param settingName noms de la variante de règles pour la partie
     * @return la nouvel parti instancié
     */
    JnGame createGame(Player[] players, String settingName);

}
