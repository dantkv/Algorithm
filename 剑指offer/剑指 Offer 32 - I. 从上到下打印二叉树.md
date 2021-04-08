[剑指 Offer 32 - I. 从上到下打印二叉树](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/) （中等）

#### 解法

使用辅助队列，先把头结点入队，每次出队时将左右子节点放进去，同时记录出队的节点值，直到队列为空。


```
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
    vector<int> levelOrder(TreeNode* root) {
        vector<int>ans;
        if(root == NULL) return ans;
        queue<TreeNode *>q;
        q.push(root);
        while(!q.empty())
        {
            TreeNode *node = q.front();
            ans.push_back(node->val);
            q.pop();
            if(node->left)      q.push(node->left);
            if(node->right)     q.push(node->right);
        }
        return ans;
    }
};
```