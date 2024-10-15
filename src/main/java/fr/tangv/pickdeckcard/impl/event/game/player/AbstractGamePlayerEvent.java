package fr.tangv.pickdeckcard.impl.event.game.player;

import fr.tangv.pickdeckcard.impl.event.game.AbstractGameEvent;
import fr.tangv.pickdeckcard.model.board.GameBoard;
import fr.tangv.pickdeckcard.model.board.GamePlayer;
import fr.tangv.pickdeckcard.model.game.CardGame;
import fr.tangv.pickdeckcard.model.game.settings.GameSettings;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class AbstractGamePlayerEvent<T, S extends GameSettings, P extends GamePlayer<T, S, P, B>, B extends GameBoard<T, S, P, B>>
        extends AbstractGameEvent<CardGame<T, S, P, B>> {

    private final @NonNull P player;

    public AbstractGamePlayerEvent(@NonNull CardGame<T, S, P, B> game, @NonNull P player) {
        super(game);
        this.player = player;
    }

}
