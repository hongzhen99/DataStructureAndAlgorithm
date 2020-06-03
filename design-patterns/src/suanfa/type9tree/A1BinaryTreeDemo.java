package suanfa.type9tree;

/**
 * @ClassName: A1BinaryTreeDeom
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/25 22:34
 */
public class A1BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        HeroNode root = new HeroNode(1, "松江");
        HeroNode node2 =  new HeroNode(2,"吴用");
        HeroNode node3 = new HeroNode(3,"卢俊义");
        HeroNode node4 = new HeroNode(4,"林冲");
        HeroNode node5 = new HeroNode(5,"关胜");

        node3.setLeft(node5);
        tree.setRoot(root);
        root.setLeft(node2);
        root.setRight(node3);
        root.getRight().setRight(node4);


        System.out.println("前序遍历");
        tree.front();

        tree.delNode(3);
        System.out.println("前序遍历");
        tree.front();

//        System.out.println("中序遍历");
//        tree.infix();
//        System.out.println("后序遍历");
//        tree.postOrder();

//        int val = 4;
//        System.out.println("前序遍历");
//        tree.front(val);
//        System.out.println();
//        System.out.println("中序遍历");
//        tree.infix(val);
//        System.out.println();
//        System.out.println("后序遍历");
//        tree.postOrder(val);

        /*
        1、 1,2,3,5,4
        2、 2,1,5,3,4
        3、 2,5,4,3,1
         */
    }
}
// 定义BinaryTree 二叉树
class BinaryTree {
    private HeroNode root;
    public void setRoot(HeroNode root){
        this.root = root;
    }
    //前序遍历
    public void front(){
        if (this.root != null){
            this.root.front();
        } else {
            System.out.println("二叉树为空");
        }
    }
    //中序遍历
    public void infix(){
        if (this.root != null){
            this.root.infix();
        } else {
            System.out.println("二叉树为空");
        }
    }
    //后序遍历
    public void postOrder(){
        if (this.root != null){
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }
    public HeroNode front(int no){
        if (this.root != null){
            return this.root.front(no);
        } else {
            System.out.println("二叉树为空");
            return null;
        }
    }
    public HeroNode infix(int no){
        if (this.root != null){
            return this.root.infix(no);
        } else {
            System.out.println("二叉树为空");
            return null;
        }
    }
        public HeroNode postOrder(int no){
        if (this.root != null){
            return this.root.postOrder(no);
        } else {
            System.out.println("二叉树为空");
            return null;
        }
    }
    public void delNode(int no){
        if (root != null) {
            if(root.getNo() == no){
                root = null;
            } else {
                root.delNode(no);
            }
        }else {
            System.out.println("空树");
        }
    }
}
//节点
class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;
    public HeroNode(int no,String name){
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    //编写前序遍历方法
    public void front(){
        System.out.println(this);
        //递归向左子树前序遍历
        if(this.left != null){
            this.left.front();
        }
        //递归向右子树前序遍历
        if (this.right != null){
            this.right.front();
        }
    }
    //编写中序遍历方法
    public void infix(){
        //递归向左子树前序遍历
        if(this.left != null){
            this.left.infix();
        }
        System.out.println(this);
        //递归向右子树前序遍历
        if (this.right != null){
            this.right.infix();
        }
    }
    //编写后序遍历方法
    public void postOrder(){
        //递归向左子树前序遍历
        if(this.left != null){
            this.left.postOrder();
        }
        //递归向右子树前序遍历
        if (this.right != null){
            this.right.postOrder();
        }
        System.out.println(this);
    }
    //前序查找
    //编写前序遍历方法
    public HeroNode front(int no){
        System.out.print("="+ this.getNo());
        if (this.getNo() == no)
            return this;
        //递归向左子树前序遍历
        HeroNode resNode = null;
        if(this.left != null){
            resNode = this.left.front(no);
        }
        if (resNode != null)
            return resNode;
        //递归向右子树前序遍历
        if (this.right != null){
            resNode = this.right.front(no);
        }
        return resNode;
    }
    //中序查找
    //编写中序遍历方法
    public HeroNode infix(int no){
        //递归向左子树前序遍历
        HeroNode resNode = null;
        if(this.left != null){
            resNode = this.left.infix(no);
        }
        if (resNode != null)
            return resNode;
        System.out.print("="+ this.getNo());
        if (this.getNo() == no)
            return this;
        //递归向右子树前序遍历
        if (this.right != null){
            resNode = this.right.infix(no);
        }
        return resNode;
    }
    //后序查找
    //编写后序遍历方法
    public HeroNode postOrder(int no){
        //递归向左子树前序遍历
        HeroNode resNode = null;
        if(this.left != null){
            resNode = this.left.postOrder(no);
        }
        if (resNode != null)
            return resNode;
        //递归向右子树前序遍历
        if (this.right != null){
            resNode = this.right.postOrder(no);
        }
        if (resNode != null)
            return resNode;
        System.out.print("="+ this.getNo());
        if (this.getNo() == no)
            return this;
        return null;
    }
    //删除
    public void delNode(int no){
        if (this.left != null && this.left.no == no){
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no){
            this.right = null;
            return;
        }
        if (this.left != null){
            this.left.delNode(no);
        }
        if (this.right != null){
            this.right.delNode(no);
        }
    }
}
