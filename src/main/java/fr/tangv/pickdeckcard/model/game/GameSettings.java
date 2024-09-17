package fr.tangv.pickdeckcard.model.game;

public interface GameSettings {
    long getTurnDuration();
    long getGameDuration();
    long getAFKTimeout();
}
