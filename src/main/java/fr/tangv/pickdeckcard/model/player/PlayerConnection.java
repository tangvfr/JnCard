package fr.tangv.pickdeckcard.model.player;

import java.net.InetAddress;

public interface PlayerConnection extends PacketReceiver {

    //boolean isConnected();
    InetAddress getAddress();

}
