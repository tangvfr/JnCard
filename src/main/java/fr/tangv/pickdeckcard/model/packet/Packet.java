package fr.tangv.pickdeckcard.model.packet;

/**
 * Réprésente les données de mise à jour du plateau et du jeu envoyé au joueur
 */
public interface Packet {

    PacketType getType();

}
