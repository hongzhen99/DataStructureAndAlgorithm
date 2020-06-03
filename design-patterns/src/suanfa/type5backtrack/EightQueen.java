package suanfa.type5backtrack;

/**
 * @ClassName: EightQueen
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/19 21:58
 */
public class EightQueen {
    //共有多少皇后
    int max = 8;
    //用于存放结果
    int[] array = new int[max];// [0,4,7,5,2,6,1,3] index + 1 == 行   array[index] + 1  =  列
    int count = 0;
    public static void main(String[] args) {
        EightQueen eightQueen = new EightQueen();
        eightQueen.check(0);//0 为第一个皇后
        System.out.println("count = "+eightQueen.count);
    }


    //加入第n个皇后
    public void check(int n){
        if (n == max){
            print();
            return;
        }
        for(int i = 0; i< max ; i++){
            //先把当前皇后放在该行的第一列
            array[n] = i;
            if (judge(n)){ //不冲突
                check(n+1);
            }
        }
    }
    //加入皇后时有没有冲突
    public boolean judge(int n){
        for(int i = 0; i< n ; i++){
            //说判断是否在同一列   判断是否在同一条斜线
            //例子  第一行于第一列 为1  第三行于第三列 为3
            //Math.abs(n-i)为行  == Math.abs(3-1)
            //Math.abs(array[n] - array[i]) 为列 == Math.abs(3 - 1)
            if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i])){
                return false;
            }
        }
        return true;
    }
    //打印皇后的位置
    public void print(){
        this.count++;
        for (int i:array){
            System.out.print(i+"");
        }
        System.out.println();
    }



}
