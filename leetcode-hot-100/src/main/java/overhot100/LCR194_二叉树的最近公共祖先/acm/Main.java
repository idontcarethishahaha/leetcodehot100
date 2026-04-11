package overhot100.LCR194_二叉树的最近公共祖先.acm;

import java.util.*;

// 1. 二叉树节点定义
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    // 🔥 你写的 5 行无敌代码（完全没动）
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }

        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);

        return l == null ? r : (r == null ? l : root);
    }
}

// 2. ACM 主类
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ===================== 输入格式 =====================
        // 第一行：树的节点数 n
        // 第二行：层序遍历数组（-1 表示 null）
        // 第三行：p 的值
        // 第四行：q 的值
        // =====================================================
        int n = sc.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            arr[i] = num == -1 ? null : num;
        }
        int pVal = sc.nextInt();
        int qVal = sc.nextInt();

        // 构建二叉树
        TreeNode root = buildTree(arr);
        // 找到 p、q 节点
        TreeNode p = findNode(root, pVal);
        TreeNode q = findNode(root, qVal);

        // 调用 LCA 方法
        Solution solution = new Solution();
        TreeNode lca = solution.lowestCommonAncestor(root, p, q);

        // 输出结果
        System.out.println(lca.val);
    }

    // ===================== 工具：层序数组建树 =====================
    public static TreeNode buildTree(Integer[] arr) {
        if (arr == null || arr.length == 0) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            TreeNode cur = q.poll();

            // 左孩子
            if (i < arr.length && arr[i] != null) {
                cur.left = new TreeNode(arr[i]);
                q.offer(cur.left);
            }
            i++;

            // 右孩子
            if (i < arr.length && arr[i] != null) {
                cur.right = new TreeNode(arr[i]);
                q.offer(cur.right);
            }
            i++;
        }
        return root;
    }

    // ===================== 工具：根据值找节点 =====================
    public static TreeNode findNode(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        TreeNode left = findNode(root.left, val);
        if (left != null) return left;
        return findNode(root.right, val);
    }
}