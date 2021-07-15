[剑指 Offer 49. 丑数](https://leetcode-cn.com/problems/chou-shu-lcof/) （中等）

#### 解法

动态规划
先找到前后元素的关系，确定状态转移方程
找递推条件和边界值

本题中，都是2、3、5的倍数，因此可以从前面往后面乘得出下一位。
对于第n位，是由 min(x[a] * 2, x[b] * 3, x[c] * 5) 计算出

**状态定义**
dp[i] 为第n个丑数
**状态转移**
dp[i] = min(dp[a] * 2, dp[b] * 3, dp[c] * 5)

每次计算后，更新a,b,c值，当dp[i] 和 dp[a] * 2 ， dp[a] * 3 ， dp[a] * 5 相等时，索引加1

**初始状态**
dp[1] = 1


```C++
class Solution {
public:
    int nthUglyNumber(int n) {
        vector<int>dp(n+1);
        dp[1] = 1;
        int p2 = 1;
        int p3 = 1;
        int p5 = 1;
        for(int i = 2; i <= n; i++)
        {
            int num2 = dp[p2] * 2;
            int num3 = dp[p3] * 3;
            int num5 = dp[p5] * 5;
            dp[i] = min(min(num2, num3), num5);
            if(dp[i] == num2) p2++;
            if(dp[i] == num3) p3++;
            if(dp[i] == num5) p5++;
        }
        return dp[n];
    }
};
```
