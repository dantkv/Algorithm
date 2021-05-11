[剑指 Offer 32 - II. 从上到下打印二叉树 II](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/)（简单）

#### 解法

与[剑指 Offer 32 - I. 从上到下打印二叉树](./剑指%20Offer%2032%20-%20I.%20从上到下打印二叉树.md)思路类似

记录下每层的数量，每个元素出队时入队其子节点，同时记录节点值。


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
        // 记录最后的右节点
        queue<TreeNode*>q;
        vector<vector<int>>ans;
        if(root == NULL) return ans;
        
        q.push(root);
        
        while(!q.empty())
        {
            int len = q.size();
            vector<int>tmp;
            for(int i =0; i < len; i++)
            {
                TreeNode *node = q.front();
                q.pop();
                tmp.push_back(node->val);
                if(node->left)  q.push(node->left);
                if(node->right) q.push(node->right);
            }
            ans.push_back(tmp);
        }
        return ans;
    }
};
```


标记每层的最后节点

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
        vector<vector<int>>ans;
        vector<int>tmp;
        if(root == NULL)
        {
            return ans;
        }
        queue<TreeNode *>q;
        q.push(root);
        TreeNode *endNode = root;
        while(!q.empty())
        {
            TreeNode *tmpNode = q.front();
            q.pop();
            if(tmpNode->left) q.push(tmpNode->left);
            if(tmpNode->right) q.push(tmpNode->right);
            tmp.push_back(tmpNode->val);
                
            if(endNode == tmpNode)
            {
                endNode = q.back();
                ans.push_back(tmp);
                tmp.clear();
            }
        }
        return ans;
    }
};
```

深度优先搜索    
利用层数来判断每个节点

```Java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private List< List<Integer> > ret;
    public List<List<Integer>> levelOrder(TreeNode root) {
        ret = new ArrayList<>();
        dfs(0, root);
        return ret;
    }

    void dfs(int depth, TreeNode root)
    {
        if(root == null)
            return ;

        if(ret.size() == depth)
        {
            ret.add(new ArrayList<>());
        }
        ret.get(depth).add(root.val);
        dfs(depth+1, root.left);
        dfs(depth+1, root.right);
    }

}
```