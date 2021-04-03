[剑指 Offer 10- II. 青蛙跳台阶问题](https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/) （简单）

#### 解法
动态规划，当想要跳到第n阶台阶时，只能从n-1或者n-2跳一次到达
到达n-1阶 有F(n-1) 种方法
到达n-2阶 有F(n-2) 种方法
那么递推公式 F(n) = F(n-1) + F(n-2)

第0阶，不移动。算作一种方式


```
class Solution {
public:
    int numWays(int n) {
        int arr[105] = {0};
        arr[0] = 1; arr[1] = 1;
        for(int i = 2; i <= n; i++)
        {
            arr[i] = (arr[i-1]%1000000007 + arr[i-2]%1000000007)%1000000007;
        }
        return arr[n];
    }
};

class Solution {
public:
    int numWays(int n) {
        int a0 = 1, a1 = 1;

        if(n == 0 || n == 1) return 1;

        int ans = 0;
        for(int i = 2; i <= n; i++)
        {
            ans = (a0 + a1)%1000000007;
            a1 = a0;
            a0 = ans;
        }
        return ans;
    }
};

```