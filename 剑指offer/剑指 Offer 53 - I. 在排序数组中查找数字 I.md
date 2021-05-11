[剑指 Offer 53 - I. 在排序数组中查找数字 I](https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/)（简单）

#### 解法

> 对于有序数组中查找问题，首先想到二分查找    
搜索到相等值后向两边遍历计算总数。    

```C++
class Solution {
public:
    int search(vector<int>& nums, int target) {
        int left = 0;
        int right = nums.size()-1;
        //第一个相等的位置
        int ans = 0;
        while(left <= right)
        {
            int middle = left + (right-left)/2;
            if(nums[middle] < target)
            {
                left = middle+1;
            }
            else if(nums[middle] > target)
            {
                right = middle-1;
            }
            else
            {
                for(int i = middle;i >=0; i--)
                {
                    if(nums[middle] == nums[i])
                    {
                        ans++;
                    }
                }
                for(int j = middle+1; j<nums.size(); j++)
                {
                    if(nums[middle] == nums[j])
                    {
                        ans++;
                    }
                }
                break;
            }
        }
        return ans;
    }
};
```

分两次查找，分别找左右边界，最后相减。    
优化：    
查找target-1和target右边界位置    
第一次二分后如果i>1&& nums[i-1] != target,可以确定没有该元素，直接返回    
第二次二分时，右边界可以使用之前找到的右边界，这样缩小二分范围。    
```C++
class Solution {
public:
    int search(vector<int>& nums, int target) {
        int left = 0;
        int right = nums.size()-1;
        int ans = 0;
        while(left <= right)
        {
            int middle = left + (right-left)/2;
            if(nums[middle] <= target)
                left= middle+1;
            else 
                right = middle-1;
        }
        ans = left;
        if(left >1 && nums[left-1]!=target)
            return 0;
        //查找左边界
        left = 0;
        while(left <= right)
        {
            int middle = left + (right-left)/2;
            if(nums[middle] < target)
            {
                left= middle+1;
            }
            else if(nums[middle] >= target)
            {
                right = middle-1;
            }
        }
        ans = ans-right -1;

        return ans;
    }
};
```
