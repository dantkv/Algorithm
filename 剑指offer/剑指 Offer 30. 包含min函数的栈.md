[剑指 Offer 30. 包含min函数的栈](https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/) （简单）

#### 解法

维护两个栈，一个是单调递减栈，一个正常存数据。    
入栈时， 当单调栈为空或者入栈值大于等于栈顶元素，那么入栈栈顶元素，小于栈顶元素，正常入栈。

```
class MinStack {
public:
    /** initialize your data structure here. */
    stack<int>smin;
    stack<int>sval;
    MinStack() {

    }
    
    void push(int x) {
        if(smin.empty() || x < smin.top())
        {
            smin.push(x);
        }
        else smin.push(smin.top());

        sval.push(x);
    }
    
    void pop() {
        sval.pop();
        smin.pop();
    }
    
    int top() {
        return sval.top();
    }
    
    int min() {
        return smin.top();
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(x);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->min();
 */
 ```

 其他解法    
 用链表或者数组实现栈，同时存储当前元素值和最小值    
 数组实现时，题目规定最大操作次数为20000次，极端情况全部push操作，那么申请40000的堆空间即可。