package org.wq.jvm.day03;

/**
 * @Author WangQian
 * @Date 2020/10/6 下午 2:54
 */

/**
 * 演示: 1、对象可以在被GC时自我拯救
 * 2、这种自我拯救的机会只有一次，因为对象的finalize()方法最多只会被系统自动调用一次
 */
public class JvmTest_02 {
    public static JvmTest_02 SAVA_HOOK = null;

    public void isAlive() {
        System.out.println("我还活着!");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize 函数执行");
        JvmTest_02.SAVA_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVA_HOOK = new JvmTest_02();

        //第一次对象成功拯救自己
        SAVA_HOOK = null;
        System.gc();
        // finalize方法优先级很低，线程暂停0.5秒
        Thread.sleep(500);
        if (SAVA_HOOK != null) {
            SAVA_HOOK.isAlive();
        } else {
            System.out.println("SAVA_HOOK 对象已被回收");
        }


        //下面代码与上面相同，但对象不能自救，因为finalize方法jvm只调用一次
        SAVA_HOOK = null;
        System.gc();
        // finalize方法优先级很低，线程暂停0.5秒
        Thread.sleep(500);
        if (SAVA_HOOK != null) {
            SAVA_HOOK.isAlive();
        } else {
            System.out.println("SAVA_HOOK 对象已被回收");
        }
    }
}
