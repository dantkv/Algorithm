[剑指 Offer 58 - II. 左旋转字符串](https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/) （简单）

#### 解法

使用切割和拼接函数

```C++
class Solution {
public:
    string reverseLeftWords(string s, int n) {
        string str = s.substr(0,n);
        str = s.erase(0, n)+str;
        return str;
    }
};
```

不使用拼接函数，那么遍历字符反转，题目限制了长度小于10000
```C++
class Solution {
public:
    string reverseLeftWords(string s, int n) {
        string str = "";
        for(int i = n; i < s.length(); i++)
        {
            str += s[i];
        }
        for(int i = 0; i < n; i++)
        {
            str += s[i];
        }
        return str;
    }
};
```

