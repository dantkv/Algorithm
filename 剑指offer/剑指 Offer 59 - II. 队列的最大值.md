[剑指 Offer 59 - II. 队列的最大值](https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/) （中等）

#### 解法

双队列实现，维护一个单调递减队列
入栈：dq不为空时，末尾元素和要入栈的值比较大小，当大于末尾元素，那么对末尾元素pop操作，直到大于等于要入栈值
出栈：由于入栈时维护操作使栈单调递减，那么头部元素永远最大。当出栈元素值e和头部相等，那么表示该元素就是当前最大的，进行pop操作
在头尾插入删除使用deque效率较高


时间复杂度分析
入栈时，在尾部直接插入，双端队列会进行pop操作，极端情况下每次都全部pop，那么最多进行n * O(1) = O(n)，均摊时间复杂度就是O(1);
出栈时，也为O(1)

入栈时间复杂度证明：
入栈操作，总共有n个元素，加上其他操作，操作数为k，极端情况下每次入栈都pop，那么总共操作数为n+k，均摊就是
(n+k) / k = n/k + 1。而n<=k 所以时间复杂度为O(1)


```
class MaxQueue {
public:
    queue<int>que;
    deque<int>addque;

    MaxQueue() {

    }

    int max_value() {
        if (!addque.empty())
        {
            return addque.front();
        }
        return -1;
    }

    void push_back(int value) {
        que.push(value);
        while(!addque.empty() && value > addque.back())
        {
            addque.pop_back();
        }
        addque.push_back(value);
    }

    int pop_front() {
        if(que.empty())
        {
            return -1;
        }
        
        int ret = que.front();
        que.pop();
        if(ret == addque.front())
        {
            addque.pop_front();
        }
        return ret;
    }
};


/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue* obj = new MaxQueue();
 * int param_1 = obj->max_value();
 * obj->push_back(value);
 * int param_3 = obj->pop_front();
 */
```