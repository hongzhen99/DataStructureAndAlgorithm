package patterns.template.type1;

/**
 * @ClassName: SoYaMilk
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/22 22:23
 */
public abstract class SoYaMilk {

    final void make(){
        first();
        second();
        three();
        four();
        five();
    }
    private void first(){
        System.out.println("1、选择新鲜豆子");
    }
    public abstract void second();

    private void  three(){
        System.out.println("黄豆和配料进行浸泡，3小时");
    }
    private void four(){
        System.out.println("放入豆浆机去打磨");
    }
    private void five(){
        System.out.println("豆浆制作完成");
    }

}
