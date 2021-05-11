[剑指 Offer 55 - II. 平衡二叉树](https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/) （简单）

#### 解法

使用后续遍历，递归向上返回状态和深度

递归出口    
1、node为空，返回0    
2、node左右子树深度差大于1，返回-1    
3、node左右子树返回值为-1，表示有子树`不平衡`，返回-1（剪枝）    
4、是平衡的，返回深度    


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
    bool isBalanced(TreeNode* root) {
        if(root == NULL ) return true;
        return treeNodeDeep(root) != -1;
    }

    int treeNodeDeep(TreeNode *root)
    {
        if(root == NULL) return 0;

        int leftdeep = treeNodeDeep(root->left);
        if(leftdeep == -1) return -1;
        
        int rightdeep = treeNodeDeep(root->right) ;
        if(rightdeep == -1) return -1; 
        
        if(abs(leftdeep - rightdeep) <= 1) return max(leftdeep, rightdeep) + 1;
        
        return -1;
    }
};
```
