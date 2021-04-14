[剑指 Offer 57. 和为s的两个数字](https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/) （简单）

#### 解法

双指针前后同时遍历，将两下标值和与target比较，如果大于那么后面下标左移，小于那么就右移

```C++
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int i = 0;
        int j = nums.size()-1;
        vector<int>ret;
        while(i < j)
        {
            int ans = nums[i]+nums[j];
            if(ans > target) j--;
            else if(ans < target) i++;
            else 
            {
                ret.push_back(nums[i]);
                ret.push_back(nums[j]);
                break;
            }

        }
        return ret;
    }
};
```