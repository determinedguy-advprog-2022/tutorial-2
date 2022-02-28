package id.ac.ui.cs.advancedprogramming.controlwand.core.entity.magictool;

import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.MagicalEntity;
import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.MagicalEntityState;

public class MagicTool extends MagicalEntity {

    public MagicTool(String name) {
        super(name);
        currentState = ManaIntensity.NONE;
        defaultState = ManaIntensity.NONE;
    }

    @Override
    protected String defineState(MagicalEntityState state) {
        return this.name + "'s mana intensity has been set to " + state.toString();
    }

    public void off() {
        // Set intensity to none
        currentState = ManaIntensity.NONE;
        // Add current intensity to history
        addToStateHistory(this.currentState);
    }

    public void low() {
        // Set intensity to low
        currentState = ManaIntensity.LOW;
        // Add current intensity to history
        addToStateHistory(this.currentState);
    }

    public void medium() {
        // Set intensity to medium
        currentState = ManaIntensity.MEDIUM;
        // Add current intensity to history
        addToStateHistory(this.currentState);
    }

    public void high() {
        // Set intensity to high
        currentState = ManaIntensity.HIGH;
        // Add current intensity to history
        addToStateHistory(this.currentState);
    }
}
