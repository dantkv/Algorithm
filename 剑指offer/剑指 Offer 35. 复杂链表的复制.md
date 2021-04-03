[剑指 Offer 35. 复杂链表的复制](https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/)（中等）


注意 判断head为空时只判断一次head为空，head->next 不要判断，head节点也要复制。



```
/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;
    
    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};
*/
```

#### 解法1

遍历复制，先遍历一遍，记录下新旧节点映射关系，根据map的映射连接起来新链表的随机节点。
时间复杂度 遍历两遍 O(n)			空间复杂度 使用了unordered_map 存储n个元素，空间复杂度 O(n)

```
class Solution {
public:
    Node* copyRandomList(Node* head) {
        unordered_map<Node *, Node *>mNode;
        Node *ptr = head;
        while(ptr != nullptr)
        {
            mNode[ptr] = new Node(ptr->val);
            ptr = ptr->next;
        }
        ptr = head;
        while(ptr!= nullptr)
        {
            mNode[ptr]->next = mNode[ptr->next];
            mNode[ptr]->random = mNode[ptr->random];
            ptr=ptr->next;
        }
        return mNode[head];
    }
};
```

#### 解法2

构建原节点和新节点，新节点插入到原节点后面，然后根据原节点建立新节点random指针关系，最后拆分成两个链表
时间复杂度 遍历三遍链表 O(n) 		空间复杂度 未使用额外辅助空间 O(1)

```
class Solution {
public:
    Node* copyRandomList(Node* head) {
        if(head == nullptr)
            return head;

        Node *ptr = head;
        //新建节点到后面
        while(ptr != nullptr)
        {
            Node *tmp = new Node(ptr->val);
            tmp->next = ptr->next;
            ptr->next = tmp;
            ptr=tmp->next;
        }
        //建立random关系
        ptr = head;
        while(ptr != nullptr)
        {
            if(ptr->random != nullptr)
                ptr->next->random = ptr->random->next;
            ptr = ptr->next->next;
        }
        //拆分链表
        ptr = head;
        Node *myhead = head->next;
        Node *cur = head->next;
        while(cur->next)
        {
            ptr->next = ptr->next->next;
            cur->next = cur->next->next;
            cur = cur->next;
            ptr = ptr->next;
        }
        ptr->next = nullptr;
        return myhead;
    }
};

```