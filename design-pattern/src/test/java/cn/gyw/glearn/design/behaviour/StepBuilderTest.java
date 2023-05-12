package cn.gyw.glearn.design.behaviour;

import cn.gyw.glearn.design.behaviour.stepbuilder.CharacterStepBuilder;
import cn.gyw.glearn.design.behaviour.stepbuilder.MyCharacter;
import org.junit.jupiter.api.Test;

/**
 * @date 2023/4/26
 */
public class StepBuilderTest {

    @Test
    public void build() {
        MyCharacter character = CharacterStepBuilder.newBuilder()
                .name("1234")
                .fighterClass("this is class")
                .withWeapon("new weapon")
                .withAbility("new ability")
                .noMoreAbilities().build();
        System.out.println(character);
    }

}
