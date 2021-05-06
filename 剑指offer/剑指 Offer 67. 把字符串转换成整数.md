[剑指 Offer 67. 把字符串转换成整数](https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/) （中等）

#### 解法

注意边界值的样例

本题**只能存储32位整数**

```C++
class Solution {
public:
    int strToInt(string str) {
        string newstr = removespace(str);
        return myatoi(newstr);
    }

    string removespace(string str){
        int index = 0;
        for (char c : str)
        {
            if(c == ' ')
            {
                index ++;
            }
            else break;
        }
        return str.substr(index, str.length()-index);
    }

    int myatoi(string str)
    {
        if(str.length() == 0) return 0;
        bool flg = false;
        int i = 0;
        if(str[0] == '-') 
        {
            flg = true;
            i++;
        }
        else if(str[0]== '+')
        {i++;}
        int intNum = 0;
        const int INT_MAX_DEC10 = INT_MAX/10;
        while(i < str.length() && isdigit(str[i]))
        {
            // 先进行越界判断，再累加和
            // 对于频繁需要使用的固定值 INT_MAX / 10 ，可以记录下来。
            if(intNum > INT_MAX_DEC10 || (intNum*10 > (INT_MAX - tmp))) return flg ? INT_MIN : INT_MAX;
            
            intNum = intNum * 10 + str[i++]-'0';
        }
        if(flg) intNum = -intNum;
        
        return intNum;
    }
};
```
