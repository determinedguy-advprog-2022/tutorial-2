package id.ac.ui.cs.advancedprogramming.inventory.core;

import java.util.ArrayList;
import java.util.List;

public abstract class Dummy {
    protected DummyType type;
    protected String weapon;
    protected List<String> dummyLog;
    protected float weight;
    protected boolean isDummyTrainingActivated;
    protected boolean isWeaponActivated;

    public Dummy(float weight, DummyType type, String weapon) {
        this.weight = weight;
        this.type = type;
        this.weapon = weapon;
        dummyLog = new ArrayList<>();
    }

    public DummyType getType() {
        return type;
    }

    public String getWeapon() {
        return weapon;
    }

    public float getWeight() {
        return weight;
    }

    public List<String> getDummyLog() {
        return dummyLog;
    }

    public void qualityCheck() {
        weightAdjustment();
        activation();
        movesetTesting();
        deactivation();
    }

    public abstract void weightAdjustment();
    public abstract void movesetTesting();
    public abstract void activation();

    public void deactivation() {
        this.isWeaponActivated = false;
        this.dummyLog.add(String.format("Weapon %s is deactivated.", this.weapon));
        this.isDummyTrainingActivated = false;
        this.dummyLog.add("Dummy training is deactivated.");
    }

}
