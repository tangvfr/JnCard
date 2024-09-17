package fr.tangv.pickdeckcard.impl.board;

import fr.tangv.pickdeckcard.impl.util.CountdownFactory;
import fr.tangv.pickdeckcard.model.board.ActionCounter;
import fr.tangv.pickdeckcard.model.board.GamePlayer;
import fr.tangv.pickdeckcard.model.deck.DeckBox;
import fr.tangv.pickdeckcard.model.game.CardGame;
import fr.tangv.pickdeckcard.model.game.GameSettings;
import fr.tangv.pickdeckcard.model.util.countdown.Countdown;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class IGameBoard<T, S extends GameSettings> extends AbstractGameBoard<T, S> {

    private static final int ACTION_BY_TURN = 1;

    private DeckBox<T, S> mainDeckBox;
    private DeckBox<T, S> hearthDeckBox;
    private GamePlayer<T, S> player1;
    private GamePlayer<T, S> player2;
    private final Countdown turnCountdown;
    private final ActionCounter turnActionCounter;
    private final ActionCounter playedActionCounter;

    public IGameBoard(CardGame<T, S> game) {
        super(game);
        this.turnCountdown = CountdownFactory.createSuitable(game.getSettings().getTurnDuration());
        this.turnActionCounter = new IActionCounter(ACTION_BY_TURN);
        this.playedActionCounter = new IActionCounter(0);

        throw new RuntimeException("Not finished");
    }

    @Override
    public void update() {
        throw new RuntimeException("Not finished");
    }

}
