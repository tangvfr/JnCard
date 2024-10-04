package fr.tangv.pickdeckcard.model.board.slot;

import java.util.List;

public interface MultipleBoardSlot<T> extends BoardSlot<T> {

    List<T> getAll();
    T poll();
    void offer(T card);
    int size();

}
