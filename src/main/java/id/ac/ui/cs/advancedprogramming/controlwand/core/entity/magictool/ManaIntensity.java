package id.ac.ui.cs.advancedprogramming.controlwand.core.entity.magictool;

import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.MagicalEntityState;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum ManaIntensity implements MagicalEntityState {
    NONE, LOW, MEDIUM, HIGH;

    public static List<ManaIntensity> getNonNullManaIntensities() {
        return Arrays.stream(ManaIntensity.values())
                .filter(v -> v != ManaIntensity.NONE)
                .collect(Collectors.toList());
    }
}
