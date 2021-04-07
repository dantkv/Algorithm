[剑指 Offer 59 - I. 滑动窗口的最大值](https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/) （困难）

#### 解法

暴力双层循环找最大值
```
class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        vector<int>ans;
        if(nums.size() == 0) return ans;
        for(int i = 0; i <= nums.size()-k; i++)
        {
            int m_max = nums[i];
            for(int j = i+1; j < i+k; j++)
            {
                if(m_max < nums[j])
                    m_max = nums[j];
            }
            ans.push_back(m_max);
        }
        return ans;
    }
};
```

用[队列最大值](./剑指%20Offer%2059%20-%20II.%20队列的最大值.md)相同思路，维护两个队列模拟入队出队，每次操作返回一次最大值

优化：只需要维护一个单调队列即可。

```
class Solution {
    queue<int>q;
    deque<int>dq;
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        vector<int>ans;
        if(nums.size() == 0) return ans;
        for(int i = 0; i < k; i++)
        {
            push(nums[i]);
        }
        
        ans.push_back(maxElem());
        for(int i = k; i < nums.size(); i++)
        {
            pop();
            push(nums[i]);
            ans.push_back(maxElem());
        }
        return ans;
    }

    void push(int value)
    {
        q.push(value);
        while(!dq.empty() && value > dq.back())
        {
            dq.pop_back();
        }
        dq.push_back(value);
    }
    void pop()
    {
        int ret = q.front();
        q.pop();
        if(dq.front() == ret)
        {
            dq.pop_front();
        }
    }
    int maxElem()
    {
        return dq.front();
    }
};
```