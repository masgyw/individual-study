package cn.gyw.glearn.design.behaviour.stepbuilder;

/**
 * @date 2023/4/26
 */
public class CharacterStepBuilder {

    // 私有化构造器
    private CharacterStepBuilder() {

    }

    public static NameStep newBuilder() {
        return new CharacterSteps();
    }

}
