[剑指 Offer 58 - I. 翻转单词顺序](https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/)（简单）

#### 解法

使用字符串输入，拼接即可

```C++
class Solution {
public:
    string reverseWords(string s) {
        istringstream istr(s);
        string tmp;
        string ans = "";
        while(istr>>tmp)
        {
            if(ans.length() == 0)
            {
                ans = tmp;
            }
            else ans = tmp +" "+ ans ;
        }
        return ans;

    }
};
```

从后往前遍历，记录下连续非空字符长度，遇到空串时进行一次拼接
```C++
class Solution {
public:
    string reverseWords(string s) {
        string ans = "";
        int len = 0;
        for(int i = s.length()-1; i >= 0; i--)
        {
            if(s[i]!=' ')
            {
                len++;
            }
            if(s[i]==' ' && len != 0) 
            {
                //当前为空，从下个位置开始切割子串
                ans += s.substr(i+1, len) +" ";
                len = 0;
            }
        }
        if(len > 0) ans += s.substr(0, len) + " ";
        if(ans.length()>0) ans.erase(ans.size()-1, 1);
        return ans;
    }
};
```