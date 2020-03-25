package LeetCode;

/**
 * @program:practice
 * @description：构造二叉树
 * @Author:xiameng
 * @create:2020-03-25 15:14
 **/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

//根据一棵树的前序遍历与中序遍历构造二叉树。
class Solution0 {
    public int preIndex = 0;
    public TreeNode buildTreeChild(int[] preorder,int[] inorder,int inbegin,int inend){
        if(inbegin > inend){
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIndex]);
        int rootIndex = findRootIndexOnInorder(inorder,preorder[preIndex],inbegin,inend);
        preIndex++;

        root.left = buildTreeChild(preorder,inorder,inbegin,rootIndex-1);
        root.right = buildTreeChild(preorder,inorder,rootIndex+1,inend);
        return root;
    }

    //在中序遍历的数组当中查找根节点所在的下标
    public int findRootIndexOnInorder(int[] inorder,int val,int inbegin,int inend){
        for(int i = inbegin;i<=inend;i++){
            if(inorder[i]==val){
                return i;
            }
        }
        return -1;
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder==null){
            return null;
        }
        return
                buildTreeChild(preorder,inorder,0,inorder.length-1);
    }
}

//根据一棵树的中序遍历与后序遍历构造二叉树。
class Solution {
    public int proIndex=0;
    public TreeNode buildTreeChild(int[] inorder,int[] postorder,int inbegin,int inend){
        if(inbegin > inend){
            return null;
        }
        TreeNode root = new TreeNode(postorder[proIndex]);
        int rootIndex = findRootIndexOnInorder(inorder,postorder[proIndex],inbegin,inend);
        proIndex--;

        root.right = buildTreeChild(inorder,postorder,rootIndex+1,inend);
        root.left = buildTreeChild(inorder,postorder,inbegin,rootIndex-1);
        return root;
    }

    //在中序遍历的数组当中查找根节点所在的下标
    public int findRootIndexOnInorder(int[] inorder,int val,int inbegin,int inend){
        for(int i = inbegin;i<=inend;i++){
            if(inorder[i]==val){
                return i;
            }
        }
        return -1;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null || postorder==null){
            return null;
        }
        proIndex = postorder.length-1;
        return
                buildTreeChild(inorder,postorder,0,inorder.length-1);
    }
}