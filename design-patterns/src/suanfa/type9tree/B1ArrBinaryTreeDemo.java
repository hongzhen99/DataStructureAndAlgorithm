package suanfa.type9tree;

/**
 * @ClassName: B1ArrBinaryTree
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/26 21:40
 */
public class B1ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.front();
    }
}
class  ArrBinaryTree{
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }
    public void front(){
        this.front(0);
    }
    public void front(int index){
        if (arr == null || arr.length == 0){
            System.out.println("数组为空");
            return;
        }
//        //输出当前元素 前序遍历
        System.out.print(arr[index]+"\t");
        //向左递归  并判断数组越界
        if (index * 2 + 1 < arr.length) {
            front(index * 2 + 1);
        }
        //输出当前元素  中序遍历
//        System.out.print(arr[index]+"\t");
        //向右递归  并判断数组越界
        if (index * 2 + 2 < arr.length) {
            front(index * 2 + 2);
        }
        //后序遍历
        //System.out.print(arr[index]+"\t");
    }
}