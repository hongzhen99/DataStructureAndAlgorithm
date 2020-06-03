package suanfa.type9tree;

import java.util.Queue;

/**
 * @ClassName: C1XianSuoHuaBinaryTree
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/27 11:14
 */
public class C1XianSuoHuaBinaryTree {
    public static void main(String[] args) {
        HeroNode1 root = new HeroNode1(1, "TOM1");
        HeroNode1 node2 = new HeroNode1(2, "TOM2");
        HeroNode1 node3 = new HeroNode1(3, "TOM3");
        HeroNode1 node4 = new HeroNode1(4, "TOM4");
        HeroNode1 node5 = new HeroNode1(5, "TOM5");
        HeroNode1 node6 = new HeroNode1(6, "TOM6");

        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        XianSuoHuaBinaryTree binaryTree = new XianSuoHuaBinaryTree(root);
        binaryTree.xianSuoHuaNodeFront(root);
        binaryTree.xianSuoHuaListQan();
    }
}
class XianSuoHuaBinaryTree{
    private HeroNode1 root;
    //为了实现线索化 ，需要创建要给指向当前节点的前驱节点
    private HeroNode1 pre = null;

    public XianSuoHuaBinaryTree(HeroNode1 root) {
        this.root = root;
    }

    //遍历线索化二叉树
    public void xianSuoHuaList(){
        HeroNode1 node = root;
        while (node != null){
            //找到前驱为1的节点
            while (node.getLeftType() == 0){
                node = (HeroNode1) node.getLeft();
            }
            System.out.println(node);
            //如果当前节点的右指针指向后继节点
            while (node.getRightType() == 1){
                node = (HeroNode1) node.getRight();
                System.out.println(node);
            }
            //替换遍历节点
            node = (HeroNode1) node.getRight();
        }

    }
    //遍历线索化二叉树
    public void xianSuoHuaListQan(){
        HeroNode1 node = root;
        while (node != null) {
            while (node.getLeftType() == 0) {
                System.out.println(node);
                node = (HeroNode1) node.getLeft();
            }
            System.out.println(node);
            //替换遍历节点
            node = (HeroNode1) node.getRight();
        }
    }
    //编写对二叉树进行前序线索化
    public void xianSuoHuaNodeFront(HeroNode1 node){
        if (node==null) {
            return;
        }
        if (node.getLeft()==null) {
            //当前节点的做指针指向前驱节点
            node.setLeft(pre);
            //修改当前  节点为前驱节点
            node.setLeftType(1);
        }
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;

        //先线索化 左子树
        if (node.getLeftType() != 1 ) {
            xianSuoHuaNodeFront((HeroNode1) node.getLeft());
        }
        if (node.getRightType() != 1 ){
            //线索化右子树
            xianSuoHuaNodeFront((HeroNode1) node.getRight());
        }
    }
    //编写对二叉树进行中序线索化
    public void xianSuoHuaNode(HeroNode1 node){
        if (node==null) {
            return;
        }
        //先线索化 左子树
        xianSuoHuaNode((HeroNode1) node.getLeft());
        //线索化当前节点
        if (node.getLeft()==null) {
            //当前节点的做指针指向前驱节点
            node.setLeft(pre);
            //修改当前  节点为前驱节点
            node.setLeftType(1);
        }
        //继续处理后继节点
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        //没处理一个节点后 让当前节点是下一个节点的前驱节点
        pre = node;
        //线索化右子树
        xianSuoHuaNode((HeroNode1) node.getRight());
    }
}
class HeroNode1 extends HeroNode {
    //如果leftType == 0 表示指向的是左子树 == 1 表示指向前驱节点
    //如果rightType == 0 表示指向的是右子树 == 1 表示指向后继节点

    private int leftType;
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public HeroNode1(int no, String name) {
        super(no, name);
    }

}