[剑指 Offer 55 - I. 二叉树的深度](https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/) （简单）

#### 解法

深度优先搜索，比较深度并记录

时间复杂度：遍历所有节点    
空间复杂度：退化为链表时，栈空间记录n个节点    
均为O(n)    

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
    int maxDepth(TreeNode* root) {
        int deep = 1;
        int ans = 0;
        dfs(root, deep, ans);
        return ans;
    }
    void dfs(TreeNode *root, int deep, int &maxdeep)
    {
        if(root == nullptr)
            return ;
        maxdeep = max(deep, maxdeep);
        dfs(root->left, deep+1, maxdeep);
        dfs(root->right, deep+1, maxdeep);
    }
};
```
更优雅的写法
```Java
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}

作者：jyd    
链接：https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/solution/mian-shi-ti-55-i-er-cha-shu-de-shen-du-xian-xu-bia/
来源：力扣（LeetCode）    
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```
