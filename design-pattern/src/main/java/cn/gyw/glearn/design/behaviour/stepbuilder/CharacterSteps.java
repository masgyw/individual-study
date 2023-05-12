package cn.gyw.glearn.design.behaviour.stepbuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2023/4/26
 */
public class CharacterSteps implements NameStep, ClassStep, SpellStep, WeaponStep, AbilityStep, BuildStep {

    private String name;

    private String fighterClass;

    private String wizardClass;

    private String weapon;

    private List<String> abilities;

    CharacterSteps() {}

    @Override
    public ClassStep name(String name) {
        this.name = name;
        return this;
    }

    @Override
    public WeaponStep fighterClass(String fighterClass) {
        this.fighterClass = fighterClass;
        return this;
    }

    @Override
    public SpellStep wizardClass(String wizardClass) {
        this.wizardClass = wizardClass;
        return this;
    }

    @Override
    public AbilityStep withWeapon(String weapon) {
        this.weapon = weapon;
        return this;
    }

    @Override
    public BuildStep noWeapon() {
        return this;
    }

    @Override
    public AbilityStep willSpell(String spell) {
        this.abilities = new ArrayList<>();
        return this;
    }

    @Override
    public BuildStep noSpell() {
        return this;
    }

    @Override
    public AbilityStep withAbility(String ability) {
        this.abilities.add(ability);
        return this;
    }

    @Override
    public BuildStep noMoreAbilities() {
        return this;
    }

    @Override
    public BuildStep noAbilities() {
        return this;
    }

    @Override
    public MyCharacter build() {
        MyCharacter myCharacter = new MyCharacter();
        myCharacter.setName(this.name);
        myCharacter.setFighterClass(fighterClass);
        myCharacter.setWizardClass(wizardClass);
        myCharacter.setWeapon(weapon);
        myCharacter.setAbilities(abilities);
        return myCharacter;
    }
}
