package patterns.template.type1.improve;

/**
 * @ClassName: Client
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/22 22:30
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("=============制作红豆豆浆============");
        SoYaMilk redBeanSoyMilk = new RedBeanSoyMilk();
        redBeanSoyMilk.make();
        System.out.println("==============制作黑米豆浆==============");
        SoYaMilk blackRiceSoyMilk = new BlackRiceSoyMilk();
        blackRiceSoyMilk.make();
        System.out.println("==============制作原味豆浆==============");
        SoYaMilk plainSoyMilk = new PlainSoyMilk();
        plainSoyMilk.make();

    }
}
