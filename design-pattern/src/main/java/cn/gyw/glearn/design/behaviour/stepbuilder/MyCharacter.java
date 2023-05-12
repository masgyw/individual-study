package cn.gyw.glearn.design.behaviour.stepbuilder;

import java.util.List;

/**
 * @date 2023/4/26
 */
public class MyCharacter {

    private String name;

    private String fighterClass;

    private String wizardClass;

    private String weapon;

    private List<String> abilities;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFighterClass() {
        return fighterClass;
    }

    public void setFighterClass(String fighterClass) {
        this.fighterClass = fighterClass;
    }

    public String getWizardClass() {
        return wizardClass;
    }

    public void setWizardClass(String wizardClass) {
        this.wizardClass = wizardClass;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public List<String> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<String> abilities) {
        this.abilities = abilities;
    }
}
