[剑指 Offer 61. 扑克牌中的顺子](https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/) （简单）

#### 解法

5张排连在一起即为顺子，大小王可当任意牌。
没有大小王情况下，从n, n-1, n-2, n-3, n-4 差为4
有大小王时，n, n-2, n-3, 0, 0 或者其他情况，差值小于5时即可填充成顺子

```
class Solution {
public:
    bool isStraight(vector<int>& nums) {
        set<int>s;
        int maxcnt = -1;
        int mincnt = 16;
        for(int i = 0; i < nums.size(); i++)
        {
            if(nums[i] == 0) continue;
            if(s.find(nums[i]) != s.end() )
            {
                return false;
            }
            s.insert(nums[i]);
            maxcnt = max(maxcnt,nums[i]);
            mincnt = min(mincnt, nums[i]);
        }
        
        return maxcnt-mincnt < 5;
    }
};
```