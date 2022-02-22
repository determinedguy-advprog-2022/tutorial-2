package id.ac.ui.cs.advancedprogramming.controlwand.repository;

import id.ac.ui.cs.advancedprogramming.controlwand.core.spell.Spell;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ControlWand {

    final private Map<String, Spell> spells;

    public ControlWand() {
        this.spells = new HashMap<>();
    }

    public void registerSpell(Spell spell) {
        spells.put(spell.spellName(), spell);
    }

    public void cast(String spellName) {
        // TODO: Complete Me
    }

    public void undo() {
        // TODO: Complete Me
    }

    public Iterable<String> getSpellNames() {
        return spells.keySet();
    }
}
