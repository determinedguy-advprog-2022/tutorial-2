package id.ac.ui.cs.advancedprogramming.controlwand.service;

import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.MagicalEntity;
import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.familiar.Familiar;
import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.magictool.MagicTool;
import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.magictool.ManaIntensity;

import id.ac.ui.cs.advancedprogramming.controlwand.core.spell.*;
import id.ac.ui.cs.advancedprogramming.controlwand.repository.ControlWand;
import id.ac.ui.cs.advancedprogramming.controlwand.repository.EntityCollection;
import org.springframework.stereotype.Service;

import java.util.EnumSet;

@Service
public class ControlWandServiceImpl implements ControlWandService {
    private final ControlWand controlWand;
    private final EntityCollection entities;

    public ControlWandServiceImpl(ControlWand controlWand, EntityCollection entities) {
        this.controlWand = controlWand;
        this.entities = entities;
    }

    @Override
    public void castSpell(String spellName) {
        controlWand.cast(spellName);
    }

    @Override
    public void undoSpell() {
        controlWand.undo();
    }

    @Override
    public Iterable<String> getSpellNames() {
        return controlWand.getSpellNames();
    }

    @Override
    public Iterable<MagicalEntity> getMagicalEntities() {
        return entities.getMagicalEntities();
    }

    @Override
    public void contractFamiliar(String name) {
        Familiar familiar = new Familiar(name);
        entities.registerEntity(familiar);

        SpellFamiliarSeal spellFamiliarSeal = new SpellFamiliarSeal(familiar);
        SpellFamiliarSummon spellFamiliarSummon = new SpellFamiliarSummon(familiar);

        controlWand.registerSpell(spellFamiliarSeal);
        controlWand.registerSpell(spellFamiliarSummon);
    }

    @Override
    public void buyMagicTool(String name, EnumSet<ManaIntensity> requiredSpells) {
        MagicTool tool = new MagicTool(name);
        entities.registerEntity(tool);

        SpellManaOff spellManaOff = new SpellManaOff(tool);
        controlWand.registerSpell(spellManaOff);

        if (requiredSpells.contains(ManaIntensity.LOW)) {
            SpellManaLow spellManaLow = new SpellManaLow(tool);
            controlWand.registerSpell(spellManaLow);
        }
        if (requiredSpells.contains(ManaIntensity.MEDIUM)) {
            SpellManaMedium spellManaMedium = new SpellManaMedium(tool);
            controlWand.registerSpell(spellManaMedium);
        }
        if (requiredSpells.contains(ManaIntensity.HIGH)) {
            SpellManaHigh spellManaHigh = new SpellManaHigh(tool);
            controlWand.registerSpell(spellManaHigh);
        }
    }
}
