/**
 * @program:practice
 * @description：二叉搜索树
 * @Author:xiameng
 * @create:2020-04-07 19:01
 **/
public class BinarySearchTree {
    static class Node {
        public int data;
        public Node left;
        public Node right;
        public Node(int data) {
            this.data = data;
        }
    }
    public Node root = null;

    /**
     * 查找
     * @param val
     * @return
     */
    public Node search(int val) {
        if(root==null){
            return null;
        }
        Node cur = root;
        while (cur != null) {
            if(val == cur.data){
                return cur;
            }else if(val < cur.data){
                cur = cur.left;
            }else {
                cur = cur.right;
            }
        }
        return null;
    }

    /**
     * 插入
     * @param key
     * @return true 表示插入成功, false 表示插入失败
     */
    public boolean insert(int key) {
        Node node = new Node(key);
        if(root == null) {
            root = node;
            return true;
        }
        Node parent = null;
        Node cur = root;
        while (cur!=null){
            if(key > cur.data){
                parent = cur;
                cur = cur.right;
            }
            else if(key < cur.data){
                parent = cur;
                cur = cur.left;
            }else {
                return false;
            }
        }
        //cur为空
        if(key < parent.data){
            parent.left = node;
        }else {
            parent.right = node;
        }
        return true;
    }

    /**
     * 删除
     * @param key
     */
    public void remove(int key) {
        Node parent = null;
        Node cur = root;
        while (cur != null) {
            if(cur.data == key) {
                removeNode(parent,cur);
                return;
            }else if(cur.data < key) {
                parent = cur;
                cur = cur.right;
            }else {
                parent = cur;
                cur = cur.left;
            }
        }
    }
    private void removeNode(Node parent,Node cur) {
        if(cur.left == null) {
            //3种情况
            if(cur == root){
                root = cur.right;
            }else if(cur == parent.left){
                parent.left = cur.right;
            }else{
                parent.right = cur.right;
            }
        }else if(cur.right == null) {
            if(cur == root){
                root = cur.left;
            }else if(cur == parent.left){
                parent.left = cur.left;
            }else{
                parent.right = cur.left;
            }
        }else {
            Node targetParent = cur;
            Node target = cur.right;
            while (target.left!=null){
                targetParent = target;
                target = target.left;
            }
            cur.data = target.data;
            if(target == targetParent.left){
                targetParent.left = target.right;
            }else {
                targetParent.right = target.left;
            }
        }
    }





    public static void preOrder(BinarySearchTree.Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void inOrder(BinarySearchTree.Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }


    public static void main(String[] args) {
        int[] arr = {5, 3, 4, 1, 7, 8, 2 ,6 ,0 ,9};
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        for (int val: arr) {
            binarySearchTree.insert(val);
        }
        binarySearchTree.insert(5);
        preOrder(binarySearchTree.root);
        System.out.println();
        inOrder(binarySearchTree.root);
        System.out.println();
        System.out.println(binarySearchTree.search(9).data);

        binarySearchTree.remove(0);
        preOrder(binarySearchTree.root);
        System.out.println();
        inOrder(binarySearchTree.root);
        System.out.println();

    }
}