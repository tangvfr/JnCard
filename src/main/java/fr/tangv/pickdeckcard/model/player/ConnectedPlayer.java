package fr.tangv.pickdeckcard.model.player;

import fr.tangv.pickdeckcard.core.user.Player;

public interface ConnectedPlayer extends PacketReceiver {

    Player getPlayer();
    PlayerConnection getConnection();
    boolean isConnected();

}
