package patterns.mediator;

/**
 * @ClassName: Client
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/6/1 19:24
 */
/**
 * 抽象的中介者类
 */
interface Mediator {

    public void change(Colleague colleague);

}

/**
 * 具体的中介者
 */
class ConcreteMediator implements Mediator {

    //中介者需要知道所有的具体的同事类
    private Colleague concreteColleagueA;
    private Colleague concreteColleagueB;

    public void setConcreteColleagueA(Colleague concreteColleagueA) {
        this.concreteColleagueA = concreteColleagueA;
    }

    public void setConcreteColleagueB(Colleague concreteColleagueB) {
        this.concreteColleagueB = concreteColleagueB;
    }

    /**
     * 当某一个同事类发生变化，需要通知其他的同事类来实现协助行为
     * @param colleague
     */
    @Override
    public void change(Colleague colleague) {
        if(colleague == concreteColleagueA){
            System.out.println("同事类A发生了变化，需要B协助");
            concreteColleagueB.doHelp();

        }else if(colleague == concreteColleagueB){
            System.out.println("同事类B发生了变化，需要A协助");
            concreteColleagueA.doHelp();
        }
    }
}

/**
 * 抽象的同事类
 */
abstract class Colleague {

    //持有一个中介者对象
    private Mediator mediator;

    public Colleague(Mediator mediator){
        this.mediator = mediator;
    }

    //获取中介者对象
    public Mediator getMediator() {
        return mediator;
    }

    //执行某些操作时，需要通知中介者，让中介者去调用被影响的其他同事类
    public abstract void operate();

    //当某一个同事类发生变化时协助其变化
    public abstract void doHelp();
}

/**
 * 具体的同事类
 */
class ConcreteColleagueA extends Colleague {

    public ConcreteColleagueA(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void doHelp() {
        System.out.println("同事类A正在协助");
    }

    /**
     * 执行某些操作时，需要通知中介者，让中介者去调用被影响的其他同事类
     */
    public void operate(){
        getMediator().change(this);
    }
}

/**
 * 具体的同事类
 */
class ConcreteColleagueB extends Colleague {

    public ConcreteColleagueB(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void doHelp() {
        System.out.println("同事类B正在协助");
    }

    /**
     * 执行某些操作时，需要通知中介者，让中介者去调用被影响的其他同事类
     */
    public void operate(){
        getMediator().change(this);
    }
}

/**
 * 客户端
 */
public class Client {

    public static void main(String[] args) {
        //创建中介者
        ConcreteMediator mediator = new ConcreteMediator();

        //创建同事类
        Colleague colleagueA = new ConcreteColleagueA(mediator);
        Colleague colleagueB = new ConcreteColleagueB(mediator);

        //让中介者知道所有的同事
        mediator.setConcreteColleagueA(colleagueA);
        mediator.setConcreteColleagueB(colleagueB);

        //同事类A变化
        colleagueA.operate();
        System.out.println("------------");

        //同事类B变化
        colleagueB.operate();

    }

}
