[剑指 Offer 10- I. 斐波那契数列](https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/) （简单）

#### 解法
递推公式给出，直接计算即可

```
class Solution {
public:
    int fib(int n) {
        int a = 0, b = 1;

        if(n == 0) return 0;
        if(n == 1) return 1;

        int ans = 0;
        for(int i = 2; i <= n; i++)
        {
            ans = (a + b)%1000000007;
            a = b;
            b = ans;
        }
        return ans;
    }
};
```