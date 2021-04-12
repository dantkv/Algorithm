[剑指 Offer 65. 不用加减乘除做加法](https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/) （简单）

#### 解法

无进位和 与 异或运算 规律相同，进位 和 与运算 规律相同（并需左移一位）
无进位n和进位c运算计算公式如下：
设两数字二进制为a, b
n = a ^ b
c = a & b << 1

s = a + b 可转换为 s = n + c 。循环求n和c，直到进位 c = 0 ，此时s = n。


**注意 C++ 不支持负值左移，需要强制转换为无符号整数**

```
class Solution {
public:
    int add(int a, int b) {
        
        while (b != 0) {
            int temp = a ^ b;
            b = (unsigned int)(a & b) << 1;
            a = temp;
        }
        return a;
    }
};
```