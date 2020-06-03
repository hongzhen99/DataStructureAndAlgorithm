package suanfa.type5backtrack;

/**
 * @ClassName: BackTrack
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/19 18:41
 */
public class BackTrack {
    public static void main(String[] args) {
        int i = jieCh(3);
        System.out.println("i="+i);
    }
    public static int jieCh(int n){
        return n == 1 ? 1 : jieCh(n-1) * n;
    }
}
