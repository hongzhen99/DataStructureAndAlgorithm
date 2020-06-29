package suanfa.type11BinaryTree;

/**
 * @ClassName: BinaryTree
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/6/8 16:25
 */
public class BinaryTree {
    public static void main(String[] args) {
        int[] arr = {7,3,10,12,5,1,9,2};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i : arr) {
            binarySortTree.add(new Node(i));
        }
        binarySortTree.infixOrder();

        //测试删除叶子节点
        binarySortTree.delNode(7);
        binarySortTree.delNode(3);
        binarySortTree.delNode(10);
        binarySortTree.delNode(12);
        binarySortTree.delNode(5);
        binarySortTree.delNode(1);
        binarySortTree.delNode(9);
        binarySortTree.delNode(2);
        System.out.println("删除节点后");
        binarySortTree.infixOrder();

    }
}


class BinarySortTree {
    private Node root;
    //查找删除节点
    public Node search(int value) {
        if(root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }
    //查找删除节点的父节点
    public Node searchParent(int value) {
        if(root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }
    //删除节点
    public void delNode(int value){
        if(root == null) {
            return;
        } else {
            //找到要删除的节点
            Node targetNode = root.search(value);
            if (targetNode == null){
                return;
            }
            if (root.left == null && root.right == null){
                root = null;
                return;
            }
            Node parent = searchParent(value);
            //如果是叶子节点
            if (targetNode.left == null && targetNode.right == null){
                if (parent.left != null && parent.left.value == value){
                    parent.left = null;
                } else if(parent.right != null && parent.right.value == value){
                    parent.right = null;
                }
            } else if(targetNode.left != null && targetNode.right != null){
                //找到右子树 最小的节点 并删除
                int minVal = delRightTreeMin(targetNode.right);
                //将值赋给要删除的节点
                targetNode.value = minVal;
            } else {//删除只有一颗子树的节点
                //如果要删除的节点有左子节点
                if (targetNode.left != null){
                    //如果targetNode 是 parent的左子节点
                    if(parent != null){
                        if(parent.left.value == value){
                            parent.left = targetNode.left;
                        } else { //如果targetNode 是 parent的右子节点
                            parent.right = targetNode.left;
                        }
                    } else {
                        root = targetNode.left;
                    }

                } else { //如果要删除的节点有右子节点
                    //如果targetNode 是 parent的左子节点
                    if(parent != null) {
                        if (parent.left.value == value) {
                            parent.left = targetNode.right;
                        } else { //如果targetNode 是 parent的右子节点
                            parent.right = targetNode.right;
                        }
                    } else {
                        root = targetNode.right;
                    }
                }
            }
        }
    }
    //删除最小右子树节点
    public int delRightTreeMin(Node node){
        Node target = node;
        while(target.left != null){
            target = target.left;
        }
        delNode(target.value);
        return target.value;
    }

    public void add(Node node){
        if (root == null) {
            this.root = node;
        } else {
            this.root.add(node);
        }
    }

    public void infixOrder(){
        if (root == null) {
            return;
        } else {
            root.infixOrder();
        }

    }
}
class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    /**
     * 查找要删除的节点
     * @param value
     * @return
     */
    public Node search(int value){
        if( value == this.value ) {
            return this;
        }else if(value < this.value){
            if (this.left == null){
                return null;
            }
            return this.left.search(value);
        }else {
            if (this.right == null){
               return null;
            }
            return this.right.search(value);
        }

    }

    /**
     * 查找要删除节点的父节点
     * @param value
     * @return
     */
    public Node searchParent(int value) {
        if ((this.left != null && this.left.value == value) ||
                (this.right != null && this.right.value == value)){
            return this;
        } else {
            //向左子树递归查找
            if(value < this.value && this.left != null){
                return this.left.searchParent(value);
            } else if(value >= this.value && this.right != null){
                return this.right.searchParent(value);
            } else {
                return null;
            }
        }
    }
    public void add(Node node){
        if (node == null) {
            return;
        }
        if (node.value < this.value) {
            if (this.left != null) {
                this.left.add(node);
            } else {
                this.left = node;
            }
        } else {
            if (this.right != null) {
                this.right.add(node);
            } else {
                this.right = node;
            }
        }
    }
    //中序遍历
    public void infixOrder(){
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
