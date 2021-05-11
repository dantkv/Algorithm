[剑指 Offer 22. 链表中倒数第k个节点](https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/)（简单）



#### 解法
1、先遍历得到链表长度，再走n-k步    
2、双指针，先走k步，再一起走，当快指针到末尾，慢指针就是第k个


```c++
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */

class Solution {
public:
    ListNode* getKthFromEnd(ListNode* head, int k) {
        ListNode *fast = head, *slow =head;
        for(int i = 0; i < k; i++)
        {
            fast = fast->next;
        }
        while(fast != NULL)
        {
            slow = slow->next;
            fast = fast->next;
        }
        return slow;
    }
};
```

