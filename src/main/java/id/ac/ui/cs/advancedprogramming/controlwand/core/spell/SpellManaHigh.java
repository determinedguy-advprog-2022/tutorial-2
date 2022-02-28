package id.ac.ui.cs.advancedprogramming.controlwand.core.spell;

import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.MagicalEntityState;
import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.familiar.FamiliarState;
import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.magictool.MagicTool;
import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.magictool.ManaIntensity;

import java.util.List;

// Class Command
public class SpellManaHigh implements Spell {

    MagicTool magicTool;

    public SpellManaHigh(MagicTool magicTool) {
        this.magicTool = magicTool;
    }

    @Override
    public void cast() {
        if (!this.magicTool.getCurrentState().equals(ManaIntensity.HIGH)) {
            this.magicTool.high();
            this.magicTool.addToStateForUndo(ManaIntensity.HIGH);
        }
    }

    @Override
    public void undo() {
        List<MagicalEntityState> stateForUndo = this.magicTool.getStateForUndo();
        if (stateForUndo.size() >= 2) {
            MagicalEntityState latestState = stateForUndo.get(stateForUndo.size()-2);
            if (latestState.equals(ManaIntensity.NONE)) {
                this.magicTool.off();
            } else if (latestState.equals(ManaIntensity.LOW)) {
                this.magicTool.low();
            } else if (latestState.equals(ManaIntensity.MEDIUM)) {
                this.magicTool.medium();
            } else if (latestState.equals(ManaIntensity.HIGH)) {
                this.magicTool.high();
            }
        } else if (stateForUndo.size() == 1) {
            this.magicTool.off();
        }
        this.magicTool.undo();
    }

    @Override
    public String spellName() {
        return String.format("%s:HIGH", this.magicTool.getName());
    }
}
