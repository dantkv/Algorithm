[剑指 Offer 03. 数组中重复的数字](https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/) （简单）

#### 解法

1、用set或者map保存已访问过的元素

```
class Solution {
public:
    int findRepeatNumber(vector<int>& nums) {
        unordered_map<int,int>m;
        for(int i : nums)
        {
            if(m.find(i) != m.end())
            {
                return i;
            }
            m[i]=1;
        }
        return 0;
    }
};
```

2、原地置换

题目给出数据范围是在0~n-1之内，那么如果所有元素排好序，那么遇到有重复数字时下标对应值就不一样了
我们从头扫描数组，当前元素值与下标不一致时，假设为m，那么拿下标m的值nums[m]与当前值nums[i]交换，如果有重复值出现就退出循环。

```
class Solution {
public:
    int findRepeatNumber(vector<int>& nums) {
        for(int i = 0; i < nums.size(); i++)
        {
            while(nums[i] != i )
            {
                if(nums[i] == nums[nums[i]])
                {
                    return nums[i];
                }
                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
        }
        return -1;
    }
};
```