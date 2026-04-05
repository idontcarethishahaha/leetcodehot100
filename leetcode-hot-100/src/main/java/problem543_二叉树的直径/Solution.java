package problem543_二叉树的直径;

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
class Solution{
    private int maxd=0;//全局最大直径
    public int diameterOfBinaryTree(TreeNode root) {
        // 递归计算深度，同时更新最大直径
        depth(root);
        return maxd;
    }
    // 计算以t为根的子树的最大节点深度
    private int depth(TreeNode t){
        //空节点深度为0
        if(t==null) return 0;

        // 递归计算左右子树的深度
        int ld=depth(t.left);
        int rd=depth(t.right);
        // 以当前节点为中间节点的路径长度=左深度+右深度
        maxd=Math.max(maxd,ld+rd);//更新全局最大直径
        //返回当前节点最大深度，供父节点计算
        return Math.max(ld,rd)+1;//父节点：子节点最大节点数 + 自己这个节点
    }
}// 路径的边数=节点数-1
//depth 算节点数，所以要 +1直径是边数，所以直接 left + right
/*
节点 1：
    1
   / \
  2   3
 / \
4   5
2 返回 ld = 2
3 返回 rd = 1
直径 = 2 + 1 = 3 条边 ✅
（4-2-1-3，正好 3 条边）

depth 返回的是：子树的 “节点数”
直径 = 左孩子节点数 + 右孩子节点数
因为这两个数加起来，正好等于路径的 “边数”
 */