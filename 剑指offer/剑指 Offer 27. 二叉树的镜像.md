[剑指 Offer 27. 二叉树的镜像](https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/) （简单）

#### 解法

使用后续遍历，将左节点指向右子树，右节点指向左子树

递归出口：节点为空

递归条件：左右节点不空，复制当前节点，并将左右节点指向递归返回值


时间复杂度：遍历所有节点1次，O(n)
空间复杂度：如果退化成链表，那么递归栈使用O(n)空间

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
    TreeNode* mirrorTree(TreeNode* root) {
        return copyTree(root);
    }

    TreeNode * copyTree(TreeNode *root)
    {
        if(root == NULL) return NULL;
        TreeNode *ptr = new TreeNode(root->val);
        ptr->right = copyTree(root->left);
        ptr->left = copyTree(root->right);
        return ptr;
    }
};
```

迭代写法

作者：jyd
来源：[力扣（LeetCode）](https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/solution/mian-shi-ti-27-er-cha-shu-de-jing-xiang-di-gui-fu-/)
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

特例处理： 当 root 为空时，直接返回 null ；
初始化： 栈（或队列），并加入根节点 root 。
循环交换： 当栈 stack 为空时跳出；
出栈： 记为 node ；
添加子节点： 将 node 左和右子节点入栈；
交换： 交换 node 的左 / 右子节点。
返回值： 返回根节点 root 。


```C++
class Solution {
public:
    TreeNode* mirrorTree(TreeNode* root) {
        if(root == nullptr) return nullptr;
        stack<TreeNode*> stack;
        stack.push(root);
        while (!stack.empty())
        {
            TreeNode* node = stack.top();
            stack.pop();
            if (node->left != nullptr) stack.push(node->left);
            if (node->right != nullptr) stack.push(node->right);
            TreeNode* tmp = node->left;
            node->left = node->right;
            node->right = tmp;
        }
        return root;
    }
};
```