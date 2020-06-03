package patterns.flyweight.type1;

/**
 * @ClassName: ConcreteWebSite
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/21 22:08
 */
public class ConcreteWebSite extends WebSite{

    private String type = "";

    public ConcreteWebSite(String type){
        this.type = type;
    }

    @Override
    public void user(User user) {
        System.out.println("网站的发布形式位.."+type+"..."+user.getName());
    }
}
