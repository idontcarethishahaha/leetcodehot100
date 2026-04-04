package problem543_二叉树的直径;

//import javax.swing.tree.TreeNode;

/*
求二叉树中，两个叶子节点之间 最长的那条路径 的长度。
注意：
路径可以不经过根节点
长度 = 这条路径上有多少条边（不是节点数）
 */

/*
对任意一个节点：以它为转折点的最长路径 =
左子树深度 + 右子树深度
因为：左边最深 ← 节点 → 右边最深这就是穿过这个节点的最长路径。
 */

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){}
    TreeNode(int x,TreeNode left,TreeNode right){
        this.val=x;
        this.left=left;
        this.right=right;
    }
}
class Solution {
    int res;//保存全局最大直径

    public int diameterOfBinaryTree(TreeNode root) {
       res=1;//初值
       depth(root);//计算递归深度
       return res-1;//直径=醉成节点数-1（算边数）
    }
    // 返回以node为根的子树的深度
    public int depth(TreeNode node){
        if(node==null) return 0;//访问到空节点了，返回0

        int ld=depth(node.left);//左子树深度
        int rd=depth(node.right);//右子树深度

        // 计算当前节点作为转折点的路径长度（节点数）
        res=Math.max(res,ld+rd+1);//经过当前节点的路径长度（节点数）=左深度+右深度+自己
        return Math.max(ld,rd)+1;//返回以当前节点为根的数的深度
        // 取左、右更深的那个，再加上自己这一层
    }
}
/*
      1
     / \
    2   3
   / \
  4   5
节点 2：左深度 1，右深度 1 → 路径 1+1=2
节点 1：左深度 2，右深度 1 → 路径 2+1=3
最大是 3（边数），就是直径。
 */
