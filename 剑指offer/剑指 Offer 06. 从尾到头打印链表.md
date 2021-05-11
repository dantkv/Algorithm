[剑指 Offer 06. 从尾到头打印链表](https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/)（简单）



#### 解法
因为返回值是一个vector，必须存储下来

1、先遍历顺序存储，再遍历数组反转    

2、递归存储到数组直接输出

3、遍历链表，头插法存储到数组

4、逆序输出想到栈，先遍历存储链表指针，然后依次出栈存值

```c++
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */

递归1

class Solution {
public:
    vector<int>ans;
    vector<int> reversePrint(ListNode* head) {
        if(head != NULL)
        {
            reversePrint(head->next);
            ans.push_back(head->val);
        }
        return ans;
    }
};

递归2

class Solution {
public:
    vector<int> reversePrint(ListNode* head) {
        if(head == NULL) return {};
        
        vector<int>ans = reversePrint(head->next);
        ans.push_back(head->val);
    
        return ans;
    }
};
```
