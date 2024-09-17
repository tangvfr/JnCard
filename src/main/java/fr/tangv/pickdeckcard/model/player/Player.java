package fr.tangv.pickdeckcard.model.player;

import fr.tangv.pickdeckcard.model.util.Connection;

public interface Player extends Connection {

    String getName();
    String getUUID();
    boolean isGuest();

}
