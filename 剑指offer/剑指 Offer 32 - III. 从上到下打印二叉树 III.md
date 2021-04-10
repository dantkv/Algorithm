[剑指 Offer 32 - III. 从上到下打印二叉树 III](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/) （中等）

#### 解法
在之前基础上 根据层数逆转临时数组再存储

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
    vector<vector<int>> levelOrder(TreeNode* root) {
        queue<TreeNode *>q;
        vector<vector<int>>ans;
        vector<int>tmp;
        if(root == NULL) return ans;
        int i = 0;
        TreeNode *end = root;
        q.push(root);
        while( !q.empty() )
        {
            TreeNode *ptr = q.front();
            q.pop();
            if(ptr->left) q.push(ptr->left);
            if(ptr->right) q.push(ptr->right);
            tmp.push_back(ptr->val);
            if(end == ptr)
            {
                if(i%2 == 1)
                {
                    int n = tmp.size();
                    for(int k = 0; k < n/2; k++)
                    {
                        int t =tmp[k];
                        tmp[k] = tmp[n-k-1];
                        tmp[n-k-1] = t;
                    }
                }
                end = q.back();
                ans.push_back(tmp);
                tmp.clear();
                i++;
            }
        }
        return ans;
    }
};
```