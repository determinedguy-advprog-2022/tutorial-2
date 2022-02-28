package id.ac.ui.cs.advancedprogramming.controlwand.core.spell;

import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.MagicalEntityState;
import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.familiar.Familiar;
import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.familiar.FamiliarState;

import java.util.List;

// Class Command
public class SpellFamiliarSeal implements Spell {

    Familiar familiar;

    public SpellFamiliarSeal(Familiar familiar) {
        this.familiar = familiar;
    }

    @Override
    public void cast() {
        if (!this.familiar.getCurrentState().equals(FamiliarState.SEALED)) {
            this.familiar.seal();
            this.familiar.addToStateForUndo(FamiliarState.SEALED);
        }
    }

    @Override
    public void undo() {
        List<MagicalEntityState> stateForUndo = this.familiar.getStateForUndo();
        if (stateForUndo.size() >= 2) {
            MagicalEntityState latestState = stateForUndo.get(stateForUndo.size()-2);
            if (latestState.equals(FamiliarState.SUMMONED)) {
                this.familiar.summon();
            } else if (latestState.equals(FamiliarState.SEALED)) {
                this.familiar.seal();
            }
        } else if (stateForUndo.size() == 1) {
            this.familiar.seal();
        }
        this.familiar.undo();
    }

    @Override
    public String spellName() {
        return String.format("%s:SEALED", this.familiar.getName());
    }
}
