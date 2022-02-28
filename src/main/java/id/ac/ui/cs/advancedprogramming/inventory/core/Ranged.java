package id.ac.ui.cs.advancedprogramming.inventory.core;

import java.util.Arrays;

public class Ranged extends Dummy {
    public Ranged(float weight, DummyType type, String weapon) {
        super(weight, type, weapon);
    }

    @Override
    public void weightAdjustment() {
        this.weight *= 0.8;
    }

    @Override
    public void movesetTesting() {
        this.dummyLog.addAll(Arrays.asList("Attack", "Attack", "Buff", "Attack", "Attack"));
    }

    @Override
    public void activation() {
        this.isDummyTrainingActivated = true;
        this.dummyLog.add("Dummy training is activated.");
        this.isWeaponActivated = true;
        this.dummyLog.add(String.format("Weapon %s is activated.", this.weapon));
    }

}
