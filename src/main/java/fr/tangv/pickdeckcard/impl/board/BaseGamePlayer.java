package fr.tangv.pickdeckcard.impl.board;

import fr.tangv.pickdeckcard.model.board.GameBoard;
import fr.tangv.pickdeckcard.model.board.GamePlayer;
import fr.tangv.pickdeckcard.model.board.GPAfkState;
import fr.tangv.pickdeckcard.model.game.settings.GameSettings;
import fr.tangv.pickdeckcard.core.user.Player;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseGamePlayer<T, S extends GameSettings, P extends GamePlayer<T, S, P, B>, B extends GameBoard<T, S, P, B>>
        implements GamePlayer<T, S, P, B> {

    private static final int DEFAULT_SIZE_HAND = 10;

    //afk fields
    private long noAfkTimestamp;
    //game fields
    private @Getter Player player;
    private @Getter B gameBoard;
    private @Getter P enemy;
    private final List<T> hand = new ArrayList<>(DEFAULT_SIZE_HAND);

    @Override
    public void init(B gameBoard, P enemy, Player player) {
        this.gameBoard = gameBoard;
        this.enemy = enemy;
        this.player = player;
        this.removeAllHand();
        noAFK();
    }

    @Override
    public List<T> getHand() {
        return List.copyOf(this.hand);
    }

    protected void addHand(T card) {
        this.hand.add(card);
    }

    @Override
    public boolean removeHand(T card) {
        return this.hand.remove(card);
    }

    @Override
    public boolean removeIfHand(Predicate<T> predicate) {
        return this.hand.removeIf(predicate);
    }

    @Override
    public void removeAllHand() {
        this.hand.clear();
    }

    @Override
    public void noAFK() {
        this.noAfkTimestamp = System.currentTimeMillis();
    }

    @Override
    public GPAfkState isAfk() {
        S settings = this.gameBoard.getGame().getSettings();
        long afkTime = System.currentTimeMillis() - this.noAfkTimestamp;
        GPAfkState statement;

        if (afkTime > settings.getPunishAFKTime()) {//si punisable
            statement = GPAfkState.PUNISH;
        } else if (afkTime > settings.getAlertAFKTime()) {//s'il doit etre alerté
            statement = GPAfkState.ALERT;
        } else {//s'il n'est pas afk
            statement = GPAfkState.NO;
        }

        return statement;
    }

}
