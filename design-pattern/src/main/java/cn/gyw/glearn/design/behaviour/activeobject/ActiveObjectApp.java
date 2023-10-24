package cn.gyw.glearn.design.behaviour.activeobject;

/**
 * 扩展ActiveCreature的类都将具有自己的控制线程来执行和调用方法
 *
 * @date 2023/10/24
 */
public class ActiveObjectApp {

    public static void main(String[] args) {
        ActiveObjectApp app = new ActiveObjectApp();
        app.run();
    }

    private void run() {
        AbstractCreature creature;
        try {
            for (int i = 0; i < 10; i++) {
                creature = new Ocr(Ocr.class.getSimpleName() + i);
                creature.eat();
                creature.roam();
            }
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Runtime.getRuntime().exit(0);
    }
}
