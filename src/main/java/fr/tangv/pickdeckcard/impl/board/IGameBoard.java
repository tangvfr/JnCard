package fr.tangv.pickdeckcard.impl.board;

import fr.tangv.pickdeckcard.impl.deck.DeckFactory;
import fr.tangv.pickdeckcard.impl.deck.IDeckBox;
import fr.tangv.pickdeckcard.impl.deck.PollerDeckBox;
import fr.tangv.pickdeckcard.model.board.ActionCounter;
import fr.tangv.pickdeckcard.model.card.Card;
import fr.tangv.pickdeckcard.model.deck.DeckBox;
import fr.tangv.pickdeckcard.model.exception.GameNotStartingException;
import fr.tangv.pickdeckcard.model.game.Game;
import fr.tangv.pickdeckcard.model.game.GameStatement;

public class IGameBoard extends AbstractGameBoard<Card> {

    private static final int ACTION_BY_TURN = 1;

    private DeckBox<Card> mainDeckBox;
    private DeckBox<Card> heartDeckBox;
    private ActionCounter turnActionCounter = new IActionCounter(ACTION_BY_TURN);
    private ActionCounter playedActionCounter = new IActionCounter(0);

    public IGameBoard(Game<Card> game) {
        super(game);
        this.heartDeckBox = new IDeckBox<>();
        this.mainDeckBox = PollerDeckBox.createPollerDeckBox(
                this.heartDeckBox,
                this.getGame().getSettings().getNumberHearthInMainDeck()
        );
    }

    @Override
    public void initDecks() throws GameNotStartingException {
        throwIfNotStatement(GameStatement.STARTING, GameNotStartingException.class);

        this.heartDeckBox.initialize(DeckFactory.createEmptyDeck(), DeckFactory.createHearthDeck());
        this.mainDeckBox.initialize(DeckFactory.createEmptyDeck(), DeckFactory.createAttackDeck());
    }

    @Override
    public DeckBox<Card> getMainDeckBox() { return this.mainDeckBox; }

    @Override
    public DeckBox<Card> getHearthDeckBox() { return this.heartDeckBox; }

    @Override
    public ActionCounter getTurnActionCounter() { return this.turnActionCounter; }

    @Override
    public ActionCounter getPlayedActionCounter() { return this.playedActionCounter; }

}
