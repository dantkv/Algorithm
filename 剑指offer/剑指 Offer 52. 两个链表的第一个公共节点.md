[剑指 Offer 52. 两个链表的第一个公共节点](https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/) （简单）

#### 解法
两链表长度总和一定，使用双指针分表从链表头开始遍历，遇到末尾时从另一链表头部开始遍历        
当二者第一次相遇时，就是两链表第一个公共节点。    
如果链表无交点，那么双方同时走到末尾，值为nullptr，退出循环    


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
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB)
    {
        ListNode *ptrA = headA, *ptrB = headB;
        while(ptrA != ptrB)
        {
            ptrA = ptrA != nullptr ?  ptrA->next : headB;
            ptrB = ptrB != nullptr ?  ptrB->next : headA;
        }
        return ptrA;
    }
};
```