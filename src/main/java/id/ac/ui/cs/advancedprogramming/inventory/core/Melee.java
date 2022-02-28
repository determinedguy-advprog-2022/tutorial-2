package id.ac.ui.cs.advancedprogramming.inventory.core;

import java.util.Arrays;

public class Melee extends Dummy {
    public Melee(float weight, DummyType type, String weapon) {
        super(weight, type, weapon);
    }

    @Override
    public void weightAdjustment() {
        this.weight += 20;
    }

    @Override
    public void movesetTesting() {
        this.dummyLog.addAll(Arrays.asList("Attack", "Attack", "Attack", "Attack", "Defense", "Attack", "Defense"));
    }

}
