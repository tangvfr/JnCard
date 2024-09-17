package fr.tangv.pickdeckcard.impl.util;

import fr.tangv.pickdeckcard.model.util.countdown.Countdown;

public class InfiniteCountdown implements Countdown {

    @Override
    public boolean isStop() {
        return false;
    }

    @Override
    public boolean isPause() {
        return false;
    }

    @Override
    public boolean isStart() {
        return true;
    }

    @Override
    public boolean isFinish() {
        return false;
    }

    @Override
    public long getDuration() {
        return 0;
    }

    @Override
    public Countdown setDuration(long duration) {
        throw new RuntimeException("It's not implemented");
    }

    @Override
    public long getRemainingTime() {
        return 0;
    }

    @Override
    public double getRemainingPercent() {
        return 1;
    }

    @Override
    public long addRemainingTime(long time) {
        throw new RuntimeException("It's not implemented");
    }

    @Override
    public long removeRemainingTime(long time) {
        throw new RuntimeException("It's not implemented");
    }

    @Override
    public void start() {}

    @Override
    public void pause() {}

    @Override
    public void stop() {}

    @Override
    public void restart() {}

    @Override
    public void update() {}

}
