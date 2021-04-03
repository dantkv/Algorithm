[剑指 Offer 09. 用两个栈实现队列](https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/) （简单）

#### 解法

两个栈A，B
保证出栈时先进先出，入栈时用A栈存，出栈时把元素移到B栈再出栈，注意边界条件，为空返回-1。

```
class CQueue {

    private Stack<Integer> stackA;
    private Stack<Integer> stackB;
    public CQueue() {
        stackA = new Stack();
        stackB = new Stack();
    }
    
    public void appendTail(int value) {
        stackA.push(value);
    }
    
    public int deleteHead() {
        if(!stackB.isEmpty())
        {
            return stackB.pop();
        }
        while(!stackA.isEmpty())
        {
            stackB.push(stackA.pop());
        }
        return stackB.isEmpty() ? -1 : stackB.pop();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
 ```