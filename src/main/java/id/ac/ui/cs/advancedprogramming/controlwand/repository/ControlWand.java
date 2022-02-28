package id.ac.ui.cs.advancedprogramming.controlwand.repository;

import id.ac.ui.cs.advancedprogramming.controlwand.core.spell.Spell;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ControlWand {

    final private Map<String, Spell> spells;
    private Spell currentSpell;

    public ControlWand() {
        this.spells = new HashMap<>();
    }

    public void registerSpell(Spell spell) {
        spells.put(spell.spellName(), spell);
        if (currentSpell == null) {
            currentSpell = spell;
        }
    }

    public void cast(String spellName) {
        currentSpell = findByName(spellName);
        currentSpell.cast();
    }

    public void undo() {
        // Prevent undo when spell is not cast yet
        if (currentSpell != null) {
            currentSpell.undo();
        }
    }

    public Iterable<String> getSpellNames() {
        return spells.keySet();
    }

    public Spell findByName(String name) {
        return spells.get(name);
    }
}
