package problem102_二叉树的层序遍历;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
class TreeNode{
    int val;
    TreeNode left,right;
    TreeNode(){}
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val,TreeNode left,TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
/*
一层一层地遍历二叉树，把每一层的节点值单独放进一个列表，最后返回所有层的结果
    3
   / \
  9  20
    /  \
   15   7
遍历结果：[[3], [9,20], [15,7]]
 */
// bfs
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 准备结果集合，里面每一个小列表就是每层的节点值
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {//根节点为空时直接返回
            return ret;
        }

        // 创建队列
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);//先把根节点放进队列

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();//创建一个列表存放当前层
            int currentLevelSize = queue.size();//获取当前层有多少节点

            for (int i = 1; i <= currentLevelSize; ++i) {//循环处理当前层所有节点
                TreeNode node = queue.poll();//取队首出队
                level.add(node.val);//将它的值加入当前层列表

                // 把左右孩子入队（下一层
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);//当前层处理完，加入结果集
        }

        return ret;
    }
}
/*
    3
   / \
  9  20
    /  \
   15   7

整体流程
队列：[3]
处理 3 → 加入第一层 → 把 9、20 入队
队列：[9,20]
处理 9、20 → 加入第二层 → 把 15、7 入队
队列：[15,7]
处理 15、7 → 加入第三层 → 无孩子
结束
最终结果：[[3], [9,20], [15,7]]
 */
