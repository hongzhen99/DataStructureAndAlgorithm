package patterns.prototype.type1;

/**
 * @ClassName: Client
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/13 11:01
 */
public class Client {
    public static void main(String[] args) {
        Prototype prototype = new Prototype();
        prototype.setName("tom").setAge(1).setColor("白色");
        prototype.per = new Per();
        prototype.per.setName("qweqweqwe");

        Prototype clone1 = (Prototype)prototype.clone();

        System.out.println("prototype="+prototype+""+prototype.per.hashCode());
        System.out.println("clone1="+clone1+""+prototype.per.hashCode());
        System.out.println("========================");


        Prototype copy = (Prototype) prototype.copy();
        System.out.println("prototype="+prototype+""+prototype.per.hashCode());
        System.out.println("copy="+copy+""+copy.per.hashCode());
    }
}
 