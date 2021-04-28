[剑指 Offer 54. 二叉搜索树的第k大节点](https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/) （简单）

#### 解法

排序二叉树中序遍历，使用数组存放，最后直接访问倒数第k个元素

递归栈最坏情况下保存所有中间节点，全部元素都遍历了一遍，使用的辅助空间大小为O(n)，因此时空复杂度均为O(n)

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
    
    int kthLargest(TreeNode* root, int k) {
        vector<int>v;
        inOrder(root, v);
        
        int cnt = v.size()-k;
        return v[cnt];
    }   

    void inOrder(TreeNode *root, vector<int> &que)
    {
        if(root->left) inOrder(root->left, que);
        que.push_back(root->val);
        if(root->right) inOrder(root->right, que);
    }
};
```

逆中序遍历，第k次就返回。
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
    int cnt = 0;
    int ans = 0;
    int kthLargest(TreeNode* root, int k) {
        cnt = k;
        reinOrder(root);
        return ans;
    }

    void reinOrder(TreeNode *root)
    {
        if(root == nullptr) return ;

        reinOrder(root->right);
        
        if(--cnt == 0)
        {
            ans = root->val;
            return ;
        }
        reinOrder(root->left);
    }
};
```
