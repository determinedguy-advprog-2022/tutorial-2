package id.ac.ui.cs.advancedprogramming.controlwand.core.entity.familiar;

import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.MagicalEntity;
import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.MagicalEntityState;

public class Familiar extends MagicalEntity {

    public Familiar(String name) {
        super(name);
        currentState = FamiliarState.SEALED;
        defaultState = FamiliarState.SEALED;
    }

    @Override
    protected String defineState(MagicalEntityState state) {
        return this.name + " is " + state.toString();
    }

    public void seal() {
        // Set state to sealed
        currentState = FamiliarState.SEALED;
        // Add current state to history
        addToStateHistory(this.currentState);
    }

    public void summon() {
        // Set state to summoned
        currentState = FamiliarState.SUMMONED;
        // Add current state to history
        addToStateHistory(this.currentState);
    }

}
