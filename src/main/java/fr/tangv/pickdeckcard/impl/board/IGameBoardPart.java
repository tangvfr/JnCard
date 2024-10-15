package fr.tangv.pickdeckcard.impl.board;

import fr.tangv.pickdeckcard.model.board.GameBoardPart;
import fr.tangv.pickdeckcard.model.board.slot.BoardSlot;
import fr.tangv.pickdeckcard.model.board.slot.BoardSlotFactory;
import fr.tangv.pickdeckcard.model.board.slot.SlotType;

import java.util.*;
import java.util.function.Predicate;

public abstract class IGameBoardPart<T, B extends BoardSlot<T>> implements GameBoardPart<T, B> {

    private static final int DEFAULT_SIZE_SLOTS = 10;
    private final Map<SlotType, List<B>> slots = new HashMap<>();

    public abstract BoardSlotFactory<T, B> getBoardSlotFactory();

    private List<B> getInstanceOfSlots(SlotType type) {
        return this.slots.computeIfAbsent(type, k -> new ArrayList<>(DEFAULT_SIZE_SLOTS));
    }

    @Override
    public List<B> getSlots(SlotType type) {
        return List.copyOf(this.getInstanceOfSlots(type));
    }

    @Override
    public int sizeSlots(SlotType type) {
        List<B> list = this.slots.get(type);
        return (list == null) ? 0 : list.size();
    }

    @Override
    public B getSlot(SlotType type, int index) {
        List<B> list = this.slots.get(type);
        if (list == null) {
            throw new RuntimeException("List for slot type: " + type.name() + " is empty");
        }
        return list.get(index);
    }

    @Override
    public B appendSlot(SlotType type) {
        List<B> list = this.getInstanceOfSlots(type);
        B slot = this.getBoardSlotFactory().create(type);
        list.add(slot);
        return slot;
    }

    @Override
    public B appendSlot(SlotType type, T card) {
        Objects.requireNonNull(card);
        B slot = this.appendSlot(type);
        slot.defineMain(card);
        return slot;
    }

    @Override
    public boolean removeSlot(SlotType type, B slot) {
        List<B> list = this.getInstanceOfSlots(type);
        if (list == null) return false;
        return list.remove(slot);
    }

    @Override
    public B removeSlot(SlotType type, int index) {
        List<B> list = this.getInstanceOfSlots(type);
        if (list == null) return null;
        return list.remove(index);
    }

    @Override
    public boolean removeSlot(SlotType type, T mainCard) {
        return false;
    }

    @Override
    public boolean removeSlotsIf(SlotType type, Predicate<B> predicate) {
        List<B> list = this.getInstanceOfSlots(type);
        if (list == null) return false;
        return list.removeIf(predicate);
    }

    @Override
    public boolean removeAllSlots(SlotType type) {
        List<B> list = this.slots.get(type);
        return (list != null && !list.isEmpty());
    }

    @Override
    public void removeAllSlots() {
        this.slots.clear();
    }

}
