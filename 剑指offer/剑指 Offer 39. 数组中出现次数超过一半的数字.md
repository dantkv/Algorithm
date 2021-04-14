(剑指 Offer 39. 数组中出现次数超过一半的数字)(https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/ ) （简单）

#### 解法

摩尔投票法

设数组众数为x，长度n
推论1：设不是众数的元素得票-1，众数得票为1，那么最终得票数一定大于0
推论2：如果前m个元素投票和为0，那么后面 (n-m) 个元素的众数一定是x

设票数vote，众数下标indx
当票数为0时，假设当前数就是众数 index = i
如果票和当前相等，++操作，如果不等就--操作。最后返回的就是众数下标

```
class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int vote = 0;
        int index = 0;
        for(int i = 0; i < nums.size(); i++)
        {
            if(vote == 0)
            {
                index = i;
            }
            if(nums[index] == nums[i])
            {
                vote ++;
            }
            else vote --;
        }
        return nums[index];
    }

};
```