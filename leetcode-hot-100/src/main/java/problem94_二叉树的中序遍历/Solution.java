package problem94_二叉树的中序遍历;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int x) {
        this.val = x;
    }
    TreeNode(int x, TreeNode left, TreeNode right) {
        this.val = x;
        this.left = left;
        this.right = right;
    }
}
// 递归版
class Solution {
    // 主方法，返回中序遍历结果列表
    public List<Integer> inorderTraversal(TreeNode root) {
        // 初始化一个列表，用来存遍历后的节点值
        List<Integer> res = new ArrayList<>();
        // 调用递归函数，传入根节点和结果列表，列表是引用类型会被修改
        inorder(root,res);
        return res;
    }
    // 递归函数，左，根，右 遍历
    public void inorder(TreeNode root, List<Integer> res) {
        // 递归终止条件，若当前节点是null,没有子节点了，直接返回
        if (root == null) return;

        // 先递归遍历当前节点的左子树
        inorder(root.left, res);
        // 记录当前节点的值（根）
        res.add(root.val);
        // 递归遍历当前节点的右子树
        inorder(root.right, res);
    }
}
