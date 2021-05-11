[剑指 Offer 15. 二进制中1的个数](https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/)（简单）

#### 解法

暴力循环求解，每次记录最后一位是否为1    
注意**运算符优先级** n&1>1 条件语句比位运算优先级高，这里不加括号变死循环。 而且不容易查出问题。

```C++
class Solution {
public:
    int hammingWeight(uint32_t n) {
        int cnt = 0;
        while(n)
        {
            if(n&1){
                cnt ++;
            } 
            n = n>>1;
        }
        return cnt;
    }
};
```


(n−1)      解析： 二进制数字 n 最右边的 1 变成 0 ，此 1 右边的 0 都变成 1 。
n&(n−1)    解析： 二进制数字 n 最右边的 1 变成 0 ，其余不变。



```C++
class Solution {
public:
    int hammingWeight(uint32_t n) {
        int cnt = 0;
        while(n)
        {
            n = n&(n-1);
            cnt++;
        }
        return cnt;
    }
};
```