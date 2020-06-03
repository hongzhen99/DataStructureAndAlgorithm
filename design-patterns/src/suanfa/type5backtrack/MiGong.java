package suanfa.type5backtrack;

/**
 * @ClassName: MiGong
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/19 19:11
 */
public class MiGong {
    public static void main(String[] args) {
        int[][] mg = new int[8][7];

        for (int i = 0 ;i<7;i++){
            mg[0][i] = 1;
            mg[7][i] = 1;
        }
        for (int i = 0 ;i<8;i++){
            mg[i][0] = 1;
            mg[i][6] = 1;
        }
        mg[3][1] = 1;
        mg[3][2] = 1;

        mg[2][3] = 1;
        mg[1][5] = 1;
        for (int[] n :mg){
            for (int m : n){
                System.out.print(m+" ");
            }
            System.out.println();
        }
        System.out.println("小球走过后");
        boolean ball = findBall(mg, 1, 1);

        for (int[] n :mg){
            for (int m : n){
                System.out.print(m+" ");
            }
            System.out.println();
        }
    }

    /**
     * 使用回溯算法找小球
     * @param map 表示地图
     * @param i 从哪个位置开始找
     * @param j
     * @return 找到通路就返回 true 否则 false
     * 开始点(1,1)   小球在map[6][5]
     * 当 map[i][j] 为 0 表示该点没有走过  1 表示墙 2表示通路可以走 3表示已经走过,但是走不通
     * 走迷宫时
     */
    public static boolean findBall(int[][] map ,int i,int j){
        if(map[6][5] == 2){
            return true;
        } else {
            if(map[i][j] == 0){//如果没有走过
                map[i][j] = 2;
                if (findBall(map,i+1,j)){ //向下
                    return true;
                } else if (findBall(map,i,j+1)){//向右
                    return true;
                } else if (findBall(map,i-1,j)){//向上
                    return true;
                } else if (findBall(map,i,j-1)){//想左走
                    return true;
                } else{
                    map[i][j] = 3;
                    return false;
                }
            } else {//map[i][j] = 1墙  2走过   3走不通
                return false;
            }
        }
    }

}
