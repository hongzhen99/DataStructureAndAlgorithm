package suanfa.type12avl;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @ClassName: AvlTree
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/6/25 12:53
 */
public class AvlTree {
    public static void main(String[] args) {
        //int[] arr = {4, 3, 6, 5, 7, 8};
        //int[] arr = {10, 12, 8, 9, 7, 6};
        int[] arr = {10, 11, 7, 6, 8, 9};
        AVLTreeTree avlTree = new AVLTreeTree();
        for (int i : arr) {
            avlTree.add(new Node(i));
        }
        avlTree.infixOrder();
        System.out.println("平衡处理");
        System.out.println("树的高度" + avlTree.getRoot().height());
        System.out.println("树的左子树高度" + avlTree.getRoot().leftHeight());
        System.out.println("树的右子树高度" + avlTree.getRoot().rightHeight());
        System.out.println("当前根节点"+ avlTree.getRoot());
    }
}

class AVLTreeTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    //查找删除节点
    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    //查找删除节点的父节点
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    //删除节点
    public void delNode(int value) {
        if (root == null) {
            return;
        } else {
            //找到要删除的节点
            Node targetNode = root.search(value);
            if (targetNode == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }
            Node parent = searchParent(value);
            //如果是叶子节点
            if (targetNode.left == null && targetNode.right == null) {
                if (parent.left != null && parent.left.value == value) {
                    parent.left = null;
                } else if (parent.right != null && parent.right.value == value) {
                    parent.right = null;
                }
            } else if (targetNode.left != null && targetNode.right != null) {
                //找到右子树 最小的节点 并删除
                int minVal = delRightTreeMin(targetNode.right);
                //将值赋给要删除的节点
                targetNode.value = minVal;
            } else {//删除只有一颗子树的节点
                //如果要删除的节点有左子节点
                if (targetNode.left != null) {
                    //如果targetNode 是 parent的左子节点
                    if (parent != null) {
                        if (parent.left.value == value) {
                            parent.left = targetNode.left;
                        } else { //如果targetNode 是 parent的右子节点
                            parent.right = targetNode.left;
                        }
                    } else {
                        root = targetNode.left;
                    }

                } else { //如果要删除的节点有右子节点
                    //如果targetNode 是 parent的左子节点
                    if (parent != null) {
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
    public int delRightTreeMin(Node node) {
        Node target = node;
        while (target.left != null) {
            target = target.left;
        }
        delNode(target.value);
        return target.value;
    }

    public void add(Node node) {
        if (root == null) {
            this.root = node;
        } else {
            this.root.add(node);
        }
    }

    public void infixOrder() {
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
     * 左旋转
     */
    public void leftRotate() {
        //新建一个节点
        Node newNode = new Node(value);
        //吧新的节点的左子树 设置成当前节点的左子树
        newNode.left = left;
        //吧新的节点的右子树 设置成当前节点的右子树的左子树
        newNode.right = right.left;
        //吧当前节点的值 替换成 右子节点的
        value = right.value;
        //吧当前节点的右子树 设置成右子树的右子树
        right = right.right;
        //吧当前节点的左子树 设置成新的节点
        left = newNode;
    }

    /**
     * 右旋转
     */
    public void rightRotate() {
        //新建一个节点
        Node newNode = new Node(value);
        //吧新节点的右子树 设置当前节点的右子树
        newNode.right = right;
        //吧新节点的左子树 设置成当前节点的左子树的右子树
        newNode.left = left.right;
        //吧当前节点的值 替换成左子树的值
        value = left.value;
        //吧当前节点的左子树 设置成左子树的左子树
        left = left.left;
        //吧当前节点的右子树 设置成新的节点
        right = newNode;
    }

    /**
     * 返回左子树的高度
     */
    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }

    /**
     * 返回右子树的高度
     */
    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

    /**
     * 返回以当前节点为根节点的高度
     */
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    /**
     * 查找要删除的节点
     *
     * @param value
     * @return
     */
    public Node search(int value) {
        if (value == this.value) {
            return this;
        } else if (value < this.value) {
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else {
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }

    }

    /**
     * 查找要删除节点的父节点
     *
     * @param value
     * @return
     */
    public Node searchParent(int value) {
        if ((this.left != null && this.left.value == value) ||
                (this.right != null && this.right.value == value)) {
            return this;
        } else {
            //向左子树递归查找
            if (value < this.value && this.left != null) {
                return this.left.searchParent(value);
            } else if (value >= this.value && this.right != null) {
                return this.right.searchParent(value);
            } else {
                return null;
            }
        }
    }

    public void add(Node node) {
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

        //当添加完一个节点后 如果（右子树的高度-左子树的高度）> 1 ,左旋转
        if (rightHeight() - leftHeight() > 1) {
            //如果右子树的左子树高度 大于 右子树的右子树的高度 就先进行右旋转
            if (right != null && right.leftHeight() > right.rightHeight()){
                right.rightRotate();
            }
            leftRotate();//左旋转
            return;
        }
        //当添加完一个节点后 如果（左子树的高度 - 右子树的高度）> 1 ,右旋转
        if (leftHeight() - rightHeight() > 1) {
            //如果左子树的右子树高度 大于 左子树的左子树的高度 就先进行左旋转
            if(left != null && left.rightHeight() > left.leftHeight()){
                left.leftRotate();
            }
            //右旋转
            rightRotate();
        }
    }

    //中序遍历
    public void infixOrder() {
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

