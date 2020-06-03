package patterns.flyweight.type1;

/**
 * @ClassName: Client
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/21 22:14
 */
//享元模式
public class Client {
    public static void main(String[] args) {
        WebSiteFactory webSiteFactory = new WebSiteFactory();
        WebSite news = webSiteFactory.getWebSite("新闻");
        User user = new User();
        user.setName("aaa");
        news.user(user);


        WebSite news1 = webSiteFactory.getWebSite("博客");
        news1.user(new User());

        WebSite news2 = webSiteFactory.getWebSite("博客");
        news2.user(new User());

        System.out.println(webSiteFactory.getWebCont());

    }
}
