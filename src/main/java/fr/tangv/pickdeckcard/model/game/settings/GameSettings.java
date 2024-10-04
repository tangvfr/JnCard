package fr.tangv.pickdeckcard.model.game.settings;

import fr.tangv.pickdeckcard.model.game.exception.GameSettingException;

public interface GameSettings {
    long getTurnDuration();
    long getGameDuration();
    long getAlertAFKTime();
    long getPunishAFKTime();
    void isValid() throws GameSettingException;
}
