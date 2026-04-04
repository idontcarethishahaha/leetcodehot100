package problem94_二叉树的中序遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 迭代版
//用栈模拟递归”是一种将递归转化为迭代的技术手段
public class Solution2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        // 循环条件：当前节点不为null 或 栈不为空
        while (cur != null || !stack.isEmpty()) {
            // 1. 先把当前节点的所有左子节点压入栈（摸左路到底）
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // 2. 弹出栈顶节点（最左的节点），记录值
            cur = stack.pop();
            res.add(cur.val);
            // 3. 处理该节点的右子树
            cur = cur.right;
        }
        return res;
    }
}
