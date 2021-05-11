[剑指 Offer 68 - II. 二叉树的最近公共祖先](https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/) （简单）

#### 解法

最近公共祖先
设root为p和q的某个公共祖先，那么root的左子节点和右子节点都不是p和q的公共祖先

因此，root为p和q的公共祖先，满足以下几点：    
1、p和q分表在root的左右子树    
2、p=root，那么q在左子树或者右子树    
3、q=root，那么p在右子树或者左子树    

对二叉树进行后续遍历回溯，遇到节点p或q返回。当q和p分别位于root两侧，返回root    

递归出口    
1、node=q || node=p 返回node    
2、node = null 返回node    

递归条件    
递归左子树，返回记为left    
递归右子树，返回记为right    

> 当left和right同时为空，那么表示不包含p和q 返回null    
> 当left和right同时不为空，那么表示node为p和q的最近公共祖先，返回node    
> 当left不空，right为空，返回left。那么分两种情况    
>> p、q其中一个在左子树，left指向p    
>> 都在左子树中，left指向**最近公共祖先**    


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
        if(root == NULL || root == p || root == q) return root;
        TreeNode *left = lowestCommonAncestor(root->left, p, q);
        TreeNode *right = lowestCommonAncestor(root->right, p, q);
        if(left == NULL && right == NULL) return NULL;
        if(left == NULL) return right;
        if(right == NULL) return left;
        return root;
    }
};
```