[剑指 Offer 28. 对称的二叉树](https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/) （简单）

#### 解法

递归比较左右子节点

终止条件
二者均为空：都遇到叶子节点，该路径下对称，返回true
一个为空或者值不等：表示不对称，返回false

递推
两棵树L和R
判断L.lef和R.right
L.right和R.left


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
    bool isSymmetric(TreeNode* root) {
        if(root == nullptr) return true;
        return compareTree(root->left, root->right);
    }

    bool compareTree(TreeNode *left, TreeNode *right)
    {
        if(left == nullptr && right == nullptr) return true;
        if(left == nullptr || right == nullptr || (left->val != right->val))
            return false;
        return compareTree(left->left, right->right) && compareTree(left->right, right->left);
    }
};
```
