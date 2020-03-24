import java.util.*;

/**
 * @program:practice
 * @description：二叉树的基本操作
 * @Author:xiameng
 * @create:2020-03-17 20:04
 **/
class   Node1{
    char value;
    Node1 left;
    Node1 right;

    public Node1(char value){
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
public class Tree {
    Node1 root;
    //创建二叉树
    public Node1 createTree(){
        Node1 A = new Node1('A');
        Node1 B = new Node1('B');
        Node1 C = new Node1('C');
        Node1 D = new Node1('D');
        Node1 E = new Node1('E');
        Node1 F = new Node1('F');
        Node1 G = new Node1('G');
        Node1 H = new Node1('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.right = H;
        C.left = F;
        C.right = G;
        return A;
    }

    //前序遍历
    void preOrderTraversal(Node1 root){
        if(root==null){
            return;
        }
        System.out.print(root.value+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    //中序遍历
    void inOrderTraversal(Node1 root){
        if(root==null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.value+" ");
        inOrderTraversal(root.right);
    }

    //后序遍历
    void postOrderTraversal(Node1 root){
        if(root==null){
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.value+" ");
    }

    //整棵树的节点个数 = 左树节点个数 + 右树节点个数 + 1
    int getSize(Node1 root){
        if(root == null){
            return 0;
        }
        return getSize(root.left)+getSize(root.right)+1;
    }

    //叶子节点个数 = 左树的叶子节点个数 + 右树的叶子节点个数
    int getLeafSize(Node1 root){
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return 1;
        }
        return getLeafSize(root.left)+getLeafSize(root.left);
    }

    //第k层节点个数:root.left的第k-1 + root.right的第k-1
    int getKLevelSize(Node1 root,int k){
        if(root==null){
            return 0;
        }
        if(k==1){
            return 1;
        }
        return getKLevelSize(root.left,k-1)+getKLevelSize(root.right,k-1);
    }

    //高度
    int getHight(Node1 root){
        if(root==null){
            return 0;
        }
        int leftHight = getHight(root.left);
        int rightHight = getHight(root.right);
        return leftHight > rightHight ? leftHight+1 : rightHight+1;
    }

    //查找 val 所在结点，没有找到返回 null
    Node1 find(Node1 root, int val){
        if(root == null){
            return null;
        }
        if(root.value == val){
            return root;
        }

        Node1 ret = find(root.left,val);
        if(ret!=null){
            return ret;
        }
        ret = find(root.right,val);
        if(ret!=null){
            return ret;
        }
        return null;
    }

    //层序遍历
    void levelOrderTraversal(Node1 root){
        if(root==null){
            return;
        }
        Queue<Node1> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            Node1 cur = queue.poll();
            System.out.print(cur.value+" ");
            if(cur.left!=null){
                queue.offer(cur.left);
            }
            if(cur.right!=null){
                queue.offer(cur.right);
            }
        }
    }

    //判断是否是完全二叉树
    boolean isCompleteTree(Node1 root){
        if(root == null){
            return true;
        }
        Queue<Node1> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            Node1 cur = queue.poll();
            if(cur!=null){
                queue.offer(cur.left);
                queue.offer(cur.right);
            }else {
                break;
            }
        }

        while (!queue.isEmpty()){
            Node1 cur = queue.peek();
            if(cur!=null){
                return false;
            }else {
                queue.poll();
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Tree tree = new Tree();
        Node1 root = tree.createTree();
        tree.preOrderTraversal(root);
        System.out.println("前序遍历");
        tree.inOrderTraversal(root);
        System.out.println("中序遍历");
        tree.postOrderTraversal(root);
        System.out.println("后序遍历");
        int tmp = tree.getSize(root);
        System.out.println("节点个数："+tmp);
        System.out.println("叶子节点个数："+tree.getLeafSize(root));
        System.out.println("第3层节点个数为："+tree.getKLevelSize(root,3));
        System.out.println("高度为："+ tree.getHight(root));
        Node1 node = tree.find(root,'E');
        System.out.println(node.value);

        tree.levelOrderTraversal(root);
        System.out.println("层序遍历");
        System.out.println("是否是完全二叉树："+tree.isCompleteTree(root));
    }
}
