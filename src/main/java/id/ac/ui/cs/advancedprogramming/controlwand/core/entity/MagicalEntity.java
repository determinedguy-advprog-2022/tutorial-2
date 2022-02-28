package id.ac.ui.cs.advancedprogramming.controlwand.core.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class MagicalEntity {
    protected String name;
    protected MagicalEntityState currentState;
    protected MagicalEntityState defaultState;
    protected List<MagicalEntityState> stateForUndo;
    protected List<MagicalEntityState> stateHistory;

    public MagicalEntity(String name) {
        this.name = name;
        this.stateForUndo = new ArrayList<>();
        this.stateHistory = new ArrayList<>();
    }

    protected abstract String defineState(MagicalEntityState state);

    public String getName() {
        return name;
    }

    public MagicalEntityState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(MagicalEntityState state) {
        this.currentState = state;
    }

    public List<MagicalEntityState> getStateForUndo() {
        return stateForUndo;
    }

    public List<String> getLifeArchive() {
        return stateHistory.stream().map(this::defineState).collect(Collectors.toList());
    }

    public void addToStateHistory(MagicalEntityState state) {
        this.stateHistory.add(state);
    }

    public void addToStateForUndo(MagicalEntityState state) {
        this.stateForUndo.add(state);
    }

    public void undo() {
        // Do if there's previous state; else, set default state
        if (stateForUndo.size() >= 1) {
            // Remove current state from the list
            stateForUndo.remove(stateForUndo.size() - 1);
        } else {
            // Restore default state
            currentState = defaultState;
        }
    }
}
