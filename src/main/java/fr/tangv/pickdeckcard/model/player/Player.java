package fr.tangv.pickdeckcard.model.player;

public interface Player extends Connection {

    String getName();
    String getUUID();
    boolean isGuest();

}
