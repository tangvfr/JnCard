package fr.tangv.pickdeckcard.impl.util;

import fr.tangv.pickdeckcard.model.exception.countdown.*;
import fr.tangv.pickdeckcard.model.util.Countdown;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ICountdown implements Countdown {

    private static final byte STARTED =      0b00;
    private static final byte PAUSED =       0b01;
    private static final byte FINISHED =     0b10;
    private static final byte STOPPED =      0b11;
    private static final byte END_MASK =     0b10;

    private byte stat = STOPPED;
    private long duration = 0L;
    private long remainingTime = 0L;
    private long targetTimestamp;

    @Override
    public boolean isStop() {
        return this.stat >= END_MASK;
    }

    @Override
    public boolean isPause() {
        return this.stat == PAUSED;
    }

    @Override
    public boolean isStart() {
        return this.stat == STARTED;
    }

    @Override
    public boolean isFinish() {
        return this.stat == STOPPED;
    }

    @Override
    public long getDuration() {
        return this.duration;
    }

    @Override
    public Countdown setDuration(long duration) throws CountdownNotStoppedException {
        if (duration < 0)
            throw new IllegalArgumentException("Duration must be positive");
        if (!this.isStop())
            throw new CountdownNotStoppedException();

        this.duration = duration;
        return this;
    }

    @Override
    public long getRemainingTime() {
        return this.remainingTime;
    }

    @Override
    public double getRemainingPercent() {
        if (this.remainingTime == 0L || this.duration == 0L)
            return 0D;
        return this.remainingTime / (double) this.duration;
    }

    @Override
    public long addRemainingTime(long time) throws CountdownStoppedException {
        if (isStop())
            throw new CountdownStoppedException();
        if (time < 0)
            throw new IllegalArgumentException("Time must be positive");

        //control pour ne pas dépasser la durée
        long maxDiff = this.duration - this.remainingTime;
        long applicableDiff = Math.min(time, maxDiff);

        this.targetTimestamp += applicableDiff;
        //return this.remainingTime = calcRemainingTime(); autre solution
        return (this.remainingTime += applicableDiff);
    }

    @Override
    public long removeRemainingTime(long time) throws CountdownStoppedException {
        if (isStop())
            throw new CountdownStoppedException();
        if (time < 0)
            throw new IllegalArgumentException("Time must be positive");

        //control pour ne pas passer en dessous de
        long applicableDiff = Math.min(time, this.remainingTime);

        this.targetTimestamp -= applicableDiff;
        //return this.remainingTime = calcRemainingTime(); autre solution
        return (this.remainingTime -= applicableDiff);
    }

    @Override
    public void start() throws CountdownAlreadyStartException {
        if (this.isStart())
            throw new CountdownAlreadyStartException();

        if (this.isPause()) {
            //basé sur le temps restant
            this.targetTimestamp = calcNewTargetDiffPause();
        } else {
            //basé sur la durée du compte à rebours
            this.initTarget();
        }

        this.stat = STARTED;
    }

    @Override
    public void pause() throws CountdownAlreadyPauseException, CountdownStoppedException {
        if (this.isPause())
            throw new CountdownAlreadyPauseException();
        if (this.isStop())
            throw new CountdownStoppedException();

        this.remainingTime = calcRemainingTime();
        this.stat = PAUSED;
    }

    @Override
    public void stop() throws CountdownAlreadyStopException {
        if (this.isStop())
            throw new CountdownAlreadyStopException();

        this.remainingTime = 0L;
        this.stat = FINISHED;
    }

    @Override
    public void restart() {
        this.initTarget();
        this.stat = STARTED;
    }

    /**
     * Permet d'initialiser l'heure d'arrêt et le temps restant par rapport à la durée
     * du compte à rebours
     */
    public void initTarget() {
        this.remainingTime = this.duration;
        this.targetTimestamp = calcTargetTime();
    }

    /**
     * Permet de calculer le temps de fin du compte à rebours en fonction de la durée du compte à rebours
     * @return le temps de fin du compte à rebours
     */
    public long calcTargetTime() {
        return System.currentTimeMillis() + this.duration;
    }

    /**
     * Permet de calculer le nouveau temps de fin du compte à rebours quand il y a eu une pause
     * @return le nouveau temps de fin du compte à rebours
     */
    public long calcNewTargetDiffPause() {
        return System.currentTimeMillis() + this.remainingTime;
    }

    /**
     * Permet de calculer le temps restant du compte à rebours par rapport au temps actuel
     * @return le temps restant du compte à rebours par rapport au temps actuel (au minimum 0)
     */
    public long calcRemainingTime() {
        long timestamp = System.currentTimeMillis();
        long remaining = timestamp - this.targetTimestamp;
        return Math.max(0, remaining);
    }

    @Override
    public void update() {
        switch (this.stat) {
            case FINISHED:
                this.stat = STOPPED;
                break;

            case STARTED:
                this.remainingTime = this.calcRemainingTime();
                if (this.remainingTime == 0L)
                    this.stat = FINISHED;
                break;

            default:
                break;
        }
    }

}
