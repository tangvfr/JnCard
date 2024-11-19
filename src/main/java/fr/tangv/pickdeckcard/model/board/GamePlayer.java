package fr.tangv.pickdeckcard.model.board;

import fr.tangv.pickdeckcard.model.game.settings.GameSettings;
import fr.tangv.pickdeckcard.model.player.ConnectedPlayer;
import fr.tangv.pickdeckcard.core.user.Player;

import java.util.List;
import java.util.function.Predicate;

public interface GamePlayer<T, S extends GameSettings, P extends GamePlayer<T, S, P, G>, G extends GameBoard<T, S, P, G>> {

    void init(G gameBoard, P enemy, Player player);
    G getGameBoard();
    P getEnemy();
    ConnectedPlayer getPlayer();
    void distribute(T card);
    boolean isDeath();

    //hand
    List<T> getHand();
    boolean removeHand(T card);
    boolean removeIfHand(Predicate<T> predicate);
    void removeAllHand();

    //afk
    GPAfkState isAfk();
    /**
     * Permet de signaler que le joueur a fait une action et qu'il n'est pas AFK
     */
    void noAFK();

}
