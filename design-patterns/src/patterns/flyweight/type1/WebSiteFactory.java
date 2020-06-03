package patterns.flyweight.type1;

import java.util.HashMap;
import java.util.List;

/**
 * @ClassName: WebSiteFactory
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/21 22:10
 */
//网站工厂
public class WebSiteFactory {

    private HashMap<String, ConcreteWebSite> pool = new HashMap<>();

    public WebSite getWebSite(String type){
        if(!pool.containsKey(type)){
            pool.put(type,new ConcreteWebSite(type));
        }
        return (WebSite) pool.get(type);
    }
    //获取网站分类总数
    public int getWebCont(){
        return pool.size();
    }
}
