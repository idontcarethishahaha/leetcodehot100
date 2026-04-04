package problem101_对称二叉树;

/*
判断一颗二叉树是否是镜像对称
左边的左边 = 右边的右边
左边的右边 = 右边的左边
交叉
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

// 递归
class Solution {
    public boolean isSymmetric(TreeNode root) {
       return check(root.left,root.right);//根节点不用管，直接看左右子树
    }
    // 检查p和q 这2个节点是否镜像对称
    public boolean check(TreeNode p,TreeNode q){
        // 均为空，对称
        if(p==null&&q==null){
            return true;
        }
        // 只有一边为空
        if(p==null||q==null){
            return false;
        }
        // 2个都不为空
        // 比较值是否相等：p左=q右，p右=q左
         return (p.val==q.val)&&check(p.left,q.right)&&check(p.right,q.left);
    }
}
