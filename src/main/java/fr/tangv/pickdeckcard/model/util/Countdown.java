package fr.tangv.pickdeckcard.model.util;

import fr.tangv.pickdeckcard.model.exception.countdown.*;

/**
 * Classe qui représente un compte à rebours en millisecondes
 */
public interface Countdown extends Updateable {

    /**
     * Permet de savoir si compte à rebours est arrêté
     * @return true si compte à rebours est arrêté, sinon false
     */
    boolean isStop();

    /**
     * Permet de savoir si compte à rebours est en pause
     * @return true si compte à rebours est en pause, sinon false
     */
    boolean isPause();

    /**
     * Permet de savoir si compte à rebours est démarré
     * @return true si compte à rebours est démarré, sinon false
     */
    boolean isStart();

    /**
     * Permet de savoir si compte à rebours vient de finir (si au cycle d'avant, il n'avait pas fini)
     * @return true si compte à rebours est arrêté et que ce n'était pas le cas au cycle d'avant, sinon false
     */
    boolean isFinish();

    /**
     * Permet de connaitre la durée du compte à rebours
     * @return la durée du compte à rebours
     */
    long getDuration();

    /**
     * Permet de changer la durée du compte à rebours
     * @param duration la durée du compte à rebours
     * @throws CountdownNotStoppedException si le countdown n'est pas à l'arrêt
     * @throws IllegalArgumentException si la durée est négative
     * @return le compte à rebours
     */
    Countdown setDuration(long duration) throws CountdownNotStoppedException;

    /**
     * Permet de connaitre le temps restant du compte à rebours
     * @return le temps restant en millisecondes
     */
    long getRemainingTime();

    /**
     * Permet de connaitre le pourcentage du temps restant sur la durée totale du compte à rebours
     * @return le pourcentage du temps restant sur la durée totale du compte à rebours (entre 0 et 1)
     */
    double getRemainingPercent();

    /**
     * Permet de rajouter du temps au compte à rebours (sans modifier la durée)
     * @param time temps qui sera ajouté au temps restant initiale (au maximum)
     * @return le nouveau temps restant
     * @throws CountdownStoppedException si le compte à rebours est à l'arrêt
     * @throws IllegalArgumentException si le temps donné est négatif
     */
    long addRemainingTime(long time) throws CountdownStoppedException;

    /**
     * Permet de retirer du temps au compte à rebours (sans modifier la durée)
     * @param time temps qui sera retiré au temps restant initiale (au maximum)
     * @return le nouveau temps restant
     * @throws CountdownStoppedException si le compte à rebours est à l'arrêt
     * @throws IllegalArgumentException si le temps donné est négatif
     */
    long removeRemainingTime(long time) throws CountdownStoppedException;

    /**
     * Permet de démarrer le compte à rebours (s'il était en pause ou à l'arrêt)
     * @throws CountdownAlreadyStartException si le compte à rebours est déja démarré
     */
    void start() throws CountdownAlreadyStartException;

    /**
     * Permet de mettre en pause le compte à rebours
     * @throws CountdownAlreadyPauseException si le compte à rebours est déja pause
     * @throws CountdownStoppedException si le compte à rebours est à l'arrêt
     */
    void pause() throws CountdownAlreadyPauseException, CountdownStoppedException;

    /**
     * Permet d'arrêter le compte à rebours (s'il était en pause ou démarré)
     * @throws CountdownAlreadyStopException si le compte à rebours est déja à l'arrêt
     */
    void stop() throws CountdownAlreadyStopException;

    /**
     * Permet de redémarrer le compte à rebours de zero (réinitialize le temps restant)
     */
    void restart();

}
