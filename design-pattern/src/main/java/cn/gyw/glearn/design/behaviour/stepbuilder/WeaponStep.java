package cn.gyw.glearn.design.behaviour.stepbuilder;

/**
 * @date 2023/4/26
 */
public interface WeaponStep {

    AbilityStep withWeapon(String weapon);

    BuildStep noWeapon();

}
