package fr.tangv.pickdeckcard.impl.util;

import fr.tangv.pickdeckcard.model.exception.countdown.CountdownNotStoppedException;
import fr.tangv.pickdeckcard.model.util.Countdown;

public abstract class CountdownFactory {

    /**
     * Permet de créer un compte à rebours infini
     * @return le compte à rebours crée
     */
    public static Countdown createInfinite() {
        return new InfiniteCountdown();
    }

    /**
     * Permet de créer un compte à rebours
     * @param duration la durée qu'aura le compte à rebours crée
     * @throws IllegalArgumentException si la durée est négative
     * @return le compte à rebours crée
     */
    public static Countdown createCountdown(long duration) {
        try {
            return new ICountdown().setDuration(duration);
        } catch (CountdownNotStoppedException e) {
            throw new RuntimeException(e);//n'est théoriquement pas possible
        }
    }

    /**
     * Permet de créer un compte à rebours adapté à la durée donnée
     * @param duration la durée qu'aura le compte à rebours crée
     * @return le compte à rebours crée (compte à rebours infini si durée nulle ou négative)
     */
    public static Countdown createSuitable(long duration) {
        return (duration <= 0) ? createInfinite() : createCountdown(duration);
    }

}
