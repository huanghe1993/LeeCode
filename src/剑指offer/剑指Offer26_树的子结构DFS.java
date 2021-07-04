package 剑指offer;

import util.TreeNode;

/**
 * https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/solution/jian-zhi-offer-26-shu-de-zi-jie-gou-die-0qjeh/
 */
public class 剑指Offer26_树的子结构DFS {

    private TreeNode B;


    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) return false;
        this.B = B;
        return dfs(A);
    }

    /**
     * dfs方法：遍历树A的节点nodeA，寻找和B根节点值相同的节点
     * 1. 特判：如果nodeA不存在，说明已经遍历完树A，遍历完也没找到和B相同的节点，返回False
     * 2. 如果nodeA.val == B.val，说明已经找到一个相同节点，进入helper方法判断接下来的节点是否相同；相同返回True，不相同则继续遍历树A，找下一个相同节点
     * 3. 继续遍历nodeA的左右节点：dfs(nodeA.left)和dfs(nodeA.right)，只要两者有一个为True就返回True
     * => return dfs(nodeA.left) or dfs(nodeA.right)
     * 这行代码可能不太好理解，可以看以下代码，两者等价
     * <p>
     * 作者：edelweisskoko
     * 链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/solution/jian-zhi-offer-26-shu-de-zi-jie-gou-die-0qjeh/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nodeA A
     * @return
     */
    private boolean dfs(TreeNode nodeA) {
        if (nodeA == null)
            return false;
        if (nodeA.val == B.val)
            if (helper(nodeA, B))
                return true;
        return dfs(nodeA.left) || dfs(nodeA.right);
    }

    /**
     * helper方法：
     * 用于判断从A的子树是否有和B相同的部分
     * 1. 如果遍历完了B也没有返回过False，说明B确实是A的子结构，返回True：if not nodeB: return True
     * 2. 如果B还没有遍历完，但A先遍历完了，返回False：if not nodeA: return False
     * 3. 如果A和B对应节点值不相同，妥妥地返回False：if nodeA.val != nodeB.val: return False
     * 当前这一对节点(nodeA, nodeB)比较完后，开始比较接下来的对应节点，分别是左子树节点对(nodeA.left, nodeB.left)和右子树节点对(nodeA.right, nodeB.right)；只有左子树和右子树也相同才能返回True，所以最后return self.helper(nodeA.left, nodeB.left) and self.helper(nodeA.right, nodeB.right)
     *
     * @param nodeA AS
     * @param nodeB B
     * @return
     */
    private boolean helper(TreeNode nodeA, TreeNode nodeB) {
        if (nodeB == null)
            return true;
        // A为null但是B不为null
        if (nodeA == null || nodeA.val != nodeB.val)
            return false;
        return helper(nodeA.left, nodeB.left) && helper(nodeA.right, nodeB.right);
    }

}
