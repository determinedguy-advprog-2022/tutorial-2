package id.ac.ui.cs.advancedprogramming.inventory.repository;

import id.ac.ui.cs.advancedprogramming.inventory.core.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DummyStorage {
    final private List<Dummy> dummies;

    public DummyStorage() { dummies = new ArrayList<>(); }

    public List<Dummy> getDummies() { return dummies; }

    public void createDummy(float weight, DummyType type, String weapon) {
        if (type.equals(DummyType.MELEE)) {
            Melee melee = new Melee(weight, type, weapon);
            dummies.add(melee);
            melee.qualityCheck();
        } else if (type.equals(DummyType.RANGED)) {
            Ranged ranged = new Ranged(weight, type, weapon);
            dummies.add(ranged);
            ranged.qualityCheck();
        } else if (type.equals(DummyType.MAGIC)) {
            Magic magic = new Magic(weight, type, weapon);
            dummies.add(magic);
            magic.qualityCheck();
        }
    }

    public void removeDummy(int index) {
        dummies.remove(index);
    }

    public Dummy getDummy(int index) {
        return dummies.get(index);
    }
}
