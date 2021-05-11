[剑指 Offer 53 - II. 0～n-1中缺失的数字](https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/) （简单）

#### 解法

1、位运算    
将0 ~ n个数全部放入数组，这样变成只有一个元素不重复的问题。

```C++
class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int ans = 0;
        /*
        i: 0~n-1
        nums[i]: 0~n
        */
        for(int i = 0; i < nums.size(); i++)
        {
            ans ^= nums[i]^i;
        }
        return ans^nums.size();
    }
};

```

2、二分查找    
对于有序数组的查询，首先想到二分查找
```C++
class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int l = 0 ;
        int r = nums.size()-1;
        while(l <= r)
        {
            int middle = l + (r-l)/2;
            if(nums[middle] == middle) l = middle+1;
            else  r = middle-1;
        }
        return l;
    }
};
```


3、数学公式    
因为缺少一个元素，n个元素总和一定，这样相减即答案
```C++
class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int sum = 0;
        for(int i: nums)
        {
            sum += i;
        }
        int total = nums.size()*(nums.size()+1)/2;
        return total-sum;
    }
};
```
