[剑指 Offer 56 - I. 数组中数字出现的次数](https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/) （中等）

#### 解法

xor ： 相同位的值不同做异或结果为1
如果是一个数组中，只有1个数字出现1次，其他都是两次，那么进行异或后结果就是出现1次的数字

在这里，如果能将两个数字分到两组数据里，使只出现1次数字分别在不同组，相同数字分到相同组里，最后就可以得到两个数字

我们根据异或得到的结果某一位来区分。
找到任意一位位值为1的来做区分，这表示对于数字a和b，第ai位和bi位值不同，被分开到不同组
而对于其他的数字，对应位相同，必定被分到同一组里，然后异或 抵消

最后两组数据剩下的只有a和b了

```C++
class Solution {
public:
    vector<int> singleNumbers(vector<int>& nums) {
        int xori = 0;
        for(int i : nums)
        {
            xori ^= i;
        }
        int index = 1;
        while((index & xori) == 0)
            index <<= 1 ;
        int a = 0;
        int b = 0;
        for(int i : nums)
        {
            if(i & index)
            {
                a ^= i;
            }
            else b ^= i;
        }
        return {a, b};
    }
};
```

**二分查找**    
利用二分查找来分组，查找到最小最大的值，根据这个来二分分组
分组异或结果：
1、两边都不为0
2、一边为0，表示在另外一边。

然后需要特别判断下结果里有0的情况，异或找不出0的数字

最后注意二分分区点写法
`int mid = (lo < 0 && hi > 0)? (lo + hi) >> 1: lo + (hi - lo) / 2;`

这里防止整形溢出，还需要考虑到为边界为**负数**的情况，