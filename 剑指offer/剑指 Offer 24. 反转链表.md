[剑指 Offer 24. 反转链表](https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/)（简单）


```C++
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
```

#### 解法1

用栈倒序

```
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        stack<ListNode *>sNode;
        while(head!=NULL)
        {
            sNode.push(head);
            head= head->next;
        }
        ListNode *ptr = new ListNode(0);
        ListNode *cur = ptr;
        while(!sNode.empty())
        {
            ListNode * tmp = sNode.top();
            sNode.pop();
            cur->next = tmp;
            tmp->next = NULL;
            cur = cur->next;
        }
        return ptr->next;
    }
};
```


#### 解法2

指针记录当前节点和下一个节点，每次反转一个节点，头插法插入

```
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        ListNode *ptr = new ListNode(0);
        
        while(head != nullptr)
        {
            ListNode *cur = head;
            head = head->next;
            cur->next = ptr->next;
            ptr->next = cur;
        }
        return ptr->next;
    }
};
```

#### 解法3

递归，类似于递归倒序打印

```
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        if (!head || !head->next) {
            return head;
        }
        ListNode* newHead = reverseList(head->next);
        head->next->next = head;
        head->next = nullptr;
        return newHead;
    }
};
```