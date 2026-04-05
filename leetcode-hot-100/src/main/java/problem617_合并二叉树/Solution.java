package problem617_合并二叉树;

/*
题目大意：
给你两棵二叉树 root1 和 root2，要把它们合并成一棵新的二叉树，合并规则非常简单：
如果两个树的同一个位置都有节点（节点重叠）：新节点的值 = 两个节点的值相加
如果只有一个树有节点，另一个是 null：新节点直接用这个非 null 的节点
合并必须从根节点开始，一层一层往下合并
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){}
    TreeNode(int val,TreeNode left,TreeNode right){
        this.val=val;
        this.left=left;
        this.right=right;
    }
}
//dfs
/*
把两棵树对应位置的节点值相加，重叠的地方就加起来，空的地方就直接用另一棵树的节点。
规则超级简单：
两个节点都有值 → 相加
一个有、一个空 → 用有值的那个
两个都空 → 空
 */
class Solution {
   public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
       // t1为空，直接返回t2
       // 若 第一棵树的当前节点为空，则直接返回第二棵树的节点
      if(t1==null){
          return t2;
      }
      // t2为空，直接返回t1
      if(t2==null){
          return t1;
      }
      // 2个节点都不为空，创建新节点，值为两者之和
      TreeNode res=new TreeNode(t1.val+t2.val);
      // 递归合并左子树
      res.left=mergeTrees(t1.left,t2.left);
      // 递归合并右子树
      res.right=mergeTrees(t1.right,t2.right);
      // 返回合并后节点
      return res;
   }
}
