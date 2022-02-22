package id.ac.ui.cs.advancedprogramming.controlwand.core.entity.familiar;

import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.MagicalEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FamiliarTest {
    private final String familiarName = "Name";
    private Familiar familiar;

    @BeforeEach
    public void setUp() {
        familiar = Mockito.mock(Familiar.class,
                Mockito.withSettings()
                        .useConstructor(familiarName)
                        .defaultAnswer(Mockito.CALLS_REAL_METHODS));
    }

    @Test
    public void whenDefinedStateIsCalledItShouldReturnStringStatingCurrentState() {
        FamiliarState sealedFamiliarState = FamiliarState.SEALED;
        String expectedDefineStateOutput = familiarName +
                " is " +
                sealedFamiliarState;
        assertEquals(expectedDefineStateOutput, familiar.defineState(sealedFamiliarState));
    }

    @Test
    public void whenSealIsCalledItShouldSetFamiliarStateToSealed() throws Exception {
        FamiliarState sealedState = FamiliarState.SEALED;

        familiar.seal();

        Field currentStateField = MagicalEntity.class.getDeclaredField("currentState");
        currentStateField.setAccessible(true);
        currentStateField.set(familiar, sealedState);

        assertEquals(sealedState, familiar.getCurrentState());
    }

    @Test
    public void whenSummonIsCalledItShouldSetFamiliarStateToSummoned() throws Exception {
        FamiliarState summonedState = FamiliarState.SUMMONED;

        familiar.summon();

        Field currentStateField = MagicalEntity.class.getDeclaredField("currentState");
        currentStateField.setAccessible(true);
        currentStateField.set(familiar, summonedState);

        assertEquals(summonedState, familiar.getCurrentState());
    }
}
