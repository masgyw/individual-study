package cn.gyw.glearn.design.behaviour.stepbuilder;

/**
 * @date 2023/4/26
 */
public interface SpellStep {

    AbilityStep willSpell(String spell);

    BuildStep noSpell();

}
