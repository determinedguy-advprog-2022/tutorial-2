package id.ac.ui.cs.advancedprogramming.controlwand.core.spell;

import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.MagicalEntityState;
import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.magictool.MagicTool;
import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.magictool.ManaIntensity;

import java.util.List;

// Class Command
public class SpellManaLow implements Spell {

    MagicTool magicTool;

    public SpellManaLow(MagicTool magicTool) {
        this.magicTool = magicTool;
    }

    @Override
    public void cast() {
        if (!this.magicTool.getCurrentState().equals(ManaIntensity.LOW)) {
            this.magicTool.low();
            this.magicTool.addToStateForUndo(ManaIntensity.LOW);
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
        return String.format("%s:LOW", this.magicTool.getName());
    }
}
