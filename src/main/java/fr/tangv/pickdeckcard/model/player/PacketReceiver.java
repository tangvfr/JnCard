package fr.tangv.pickdeckcard.model.player;

import fr.tangv.pickdeckcard.model.packet.Packet;

public interface PacketReceiver {

    void sendPacket(Packet packet);

}
