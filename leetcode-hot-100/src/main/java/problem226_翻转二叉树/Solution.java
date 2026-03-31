package problem226_翻转二叉树;

// 翻转二叉树，根节点不变，所有非叶子节点交换左右孩子，把整棵树沿垂直中轴线做镜像翻转
/*
        4
      /   \
     2     7
    / \   / \
   1  3  6  9

        4
      /   \
     7     2
    / \   / \
   9  6  3  1
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int x){
        this.val=x;
    }
    TreeNode(int x,TreeNode left,TreeNode right){
        this.val=x;
        this.left=left;
        this.right=right;
    }
}
// 递归
class Solution {
  public TreeNode invertTree(TreeNode root){
      // 递归终止，节点为空，直接返回
      if(root==null) return null;

      // 交换当前节点的左右节点
      TreeNode temp=root.left;
      root.left=root.right;
      root.right=temp;

      // 递归翻转左右子树
      invertTree(root.left);
      invertTree(root.right);

      return root;
  }
}
