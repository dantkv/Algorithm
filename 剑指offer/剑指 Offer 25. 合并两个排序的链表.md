[剑指 Offer 25. 合并两个排序的链表](https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/) （简单）

#### 解法

遍历两个链表，每次从头节点取小值，尾插到新链表，然后把剩余的直接插入后面即可

```C++
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
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        ListNode *head = new ListNode(0);
        ListNode *ptr = head;
        while(l1!=NULL && l2!= NULL)
        {
            if(l1->val <= l2->val)
            {
                ListNode *tmp = l1;
                l1=l1->next;
                tmp->next = NULL;
                ptr->next = tmp;
            }
            else
            {
                ListNode *tmp = l2;
                l2=l2->next;
                tmp->next = NULL;
                ptr->next = tmp;
            }
            ptr=ptr->next;
        }
        if(l1) ptr->next = l1;
        if(l2) ptr->next = l2;
        return head->next;
    }
};
```

递归实现
```
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
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        return mergeList(l1, l2);
    }
    ListNode * mergeList(ListNode *p1, ListNode *p2)
    {
        if(p1 == nullptr && p2 == nullptr)
            return nullptr;
        if(p1 == nullptr) return p2;
        if(p2 == nullptr) return p1;

        ListNode *head = nullptr;
        if(p1->val < p2->val)
        {
            head = new ListNode(p1->val);
            head->next = mergeList(p1->next, p2);
        }
        else
        {
            head = new ListNode(p2->val);
            head->next = mergeList(p1, p2->next);
        }
        return head;
    }
};
```