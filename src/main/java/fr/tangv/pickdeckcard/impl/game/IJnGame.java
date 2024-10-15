package fr.tangv.pickdeckcard.impl.game;

import fr.tangv.pickdeckcard.impl.event.game.GameStopEvent;
import fr.tangv.pickdeckcard.impl.event.manager.SingletonEventManager;
import fr.tangv.pickdeckcard.model.board.JnGameBoard;
import fr.tangv.pickdeckcard.model.board.JnGamePlayer;
import fr.tangv.pickdeckcard.model.card.JnCard;
import fr.tangv.pickdeckcard.model.event.EventManager;
import fr.tangv.pickdeckcard.model.game.JnGame;
import fr.tangv.pickdeckcard.model.game.settings.JnGameSettings;

public class IJnGame extends BaseCardGame<JnCard, JnGameSettings, JnGamePlayer, JnGameBoard> implements JnGame {

    @Override
    public EventManager getInstanceOfEventManager() {
        return SingletonEventManager.getInstance(SingletonEventManager.JN_GAME_TYPE);
    }

    @Override
    public void init() {
        super.init();
        this.board.init();
    }

    @Override
    public void update() {
        super.update();
        this.board.update();
    }

    @Override
    public void stop(boolean forced) {
        this.fire(new GameStopEvent<>(this, forced));
    }

}
