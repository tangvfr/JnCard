package fr.tangv.pickdeckcard.model.game;

import fr.tangv.pickdeckcard.model.util.Stoppable;
import fr.tangv.pickdeckcard.model.util.Updateable;

public interface Game extends Updateable, Stoppable {

    String getId();
    GameStatement getStatement();
    GameStatement isStatement(GameStatement statement);

}
