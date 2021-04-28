[剑指 Offer 68 - I. 二叉搜索树的最近公共祖先](https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/) （简单）

#### 解法

递推工作：
当 p, q 都在 rootroot 的 右子树 中，则开启递归 root->right 并返回；
否则，当 p, q 都在 root 的 左子树 中，则开启递归 root->left 并返回；
返回值： 最近公共祖先 root 。
复杂度分析：
时间复杂度 O(N) ： 其中 N 为二叉树节点数；每循环一轮排除一层，二叉搜索树的层数最小为 logN （满二叉树），最大为 N（退化为链表）。
空间复杂度 O(N) ： 最差情况下，即树退化为链表时，递归深度达到树的层数 N 。


```C++
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(root->val < p->val && root->val < q->val)
            return lowestCommonAncestor(root->left, p, q );
        if(root->val > p->val && root->val > q->val)
            return lowestCommonAncestor(root->right, p, q);
        
        return root;
    }
};
```
