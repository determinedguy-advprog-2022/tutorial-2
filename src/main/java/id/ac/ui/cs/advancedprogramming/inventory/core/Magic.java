package id.ac.ui.cs.advancedprogramming.inventory.core;

import java.util.Arrays;

public class Magic extends Dummy {

    public Magic(float weight, DummyType type, String weapon) {
        super(weight, type, weapon);
    }

    @Override
    public void weightAdjustment() {}

    @Override
    public void movesetTesting() {
        this.dummyLog.addAll(Arrays.asList("Attack", "Buff", "Attack", "Buff", "Buff", "Attack", "Buff", "Defense", "Attack", "Buff", "Defense"));
    }

    @Override
    public void activation() {
        this.isDummyTrainingActivated = true;
        this.isWeaponActivated = true;
    }

}
