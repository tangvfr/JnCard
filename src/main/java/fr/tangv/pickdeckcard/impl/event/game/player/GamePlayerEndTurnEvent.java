package fr.tangv.pickdeckcard.impl.event.game.player;

import fr.tangv.pickdeckcard.model.board.GameBoard;
import fr.tangv.pickdeckcard.model.board.GamePlayer;
import fr.tangv.pickdeckcard.model.game.CardGame;
import fr.tangv.pickdeckcard.model.game.settings.GameSettings;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class GamePlayerEndTurnEvent<T, S extends GameSettings, P extends GamePlayer<T, S, P, B>, B extends GameBoard<T, S, P, B>>
        extends AbstractGamePlayerEvent<T, S, P, B> {

    private final boolean endTime;

    public GamePlayerEndTurnEvent(@NonNull CardGame<T, S, P, B> game, @NonNull P player, boolean endTime) {
        super(game, player);
        this.endTime = endTime;
    }

}
