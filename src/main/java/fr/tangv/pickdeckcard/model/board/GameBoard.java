package fr.tangv.pickdeckcard.model.board;

import fr.tangv.pickdeckcard.model.game.CardGame;
import fr.tangv.pickdeckcard.model.game.settings.GameSettings;
import fr.tangv.pickdeckcard.model.util.Counter;
import fr.tangv.pickdeckcard.model.util.Initializable;
import fr.tangv.pickdeckcard.model.util.Updateable;
import fr.tangv.pickdeckcard.model.util.Countdown;

public interface GameBoard<T, S extends GameSettings, P extends GamePlayer<T, S, P, B>, B extends GameBoard<T, S, P, B>>
        extends Updateable, Initializable {

    CardGame<T, S, P, B> getGame();
    void setGame(CardGame<T, S, P, B> game);
    P getPlayer1();
    void setPlayer1(P player);
    P getPlayer2();
    void setPlayer2(P player);

    //players
    Countdown getTurnCountdown();
    P getTurnPlayer();
    void switchPlayerTurn();

    //action
    Counter getTurnActionCounter();
    Counter getPlayedActionCounter();

}
