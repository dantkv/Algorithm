[剑指 Offer 18. 删除链表的节点](https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/)(简单)


#### 解法
双指针记录前后关系，找到后直接放弃指针（具体根据情况释放内存）


```C++
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */

有头结点


class Solution {
public:
    ListNode* deleteNode(ListNode* head, int val) {
        ListNode *ptr = new ListNode(0);
        ptr ->next = head;
        ListNode *fast = head, *slow = ptr;
        while(fast->val != val)
        {
            fast = fast->next;
            slow = slow->next;
        }
        slow->next = fast->next;

        return ptr->next;
    }
};

无头结点


class Solution {
public:
    ListNode* deleteNode(ListNode* head, int val) {
        if(head->val == val )
        {
            return head->next;
        }
        ListNode *pre = head, *cur = head->next;
        while(cur != NULL && cur->val != val)
        {
            pre= pre->next;
            cur=cur->next;
        }
        pre->next = cur->next;
        return head;
    }
};
```

