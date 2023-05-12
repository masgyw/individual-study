package cn.gyw.glearn.design.behaviour.stepbuilder;

/**
 * @date 2023/4/26
 */
public interface AbilityStep {

    AbilityStep withAbility(String ability);

    BuildStep noMoreAbilities();

    BuildStep noAbilities();

}
