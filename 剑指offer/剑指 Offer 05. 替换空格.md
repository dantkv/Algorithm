[剑指 Offer 05. 替换空格](https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/) （简单）

#### 解法

1、string调用replace接口

```
class Solution {
public:
    string replaceSpace(string s) {
        std::size_t index = s.find(" ");
        while(index != string::npos)
        {
            s.replace (index, 1, "%20");
            index = s.find(" ");
        }
        return s;
    }
};
```

2、使用字符数组存储，匹配空格后改为填充“%20”，直到字符串遍历完。

```
class Solution {
public:
    string replaceSpace(string s) {
        char str[30003] = {0};
        for(int i = 0, j = 0; i < s.length(); i++)
        {
            if(s[i] == ' ')
            {
                str[j] = '%';
                str[j+1] = '2';
                str[j+2] = '0';
                j+=3;
            }
            else
            {
                str[j] = s[i];
                j++;
            }
        }
        
        return (string)str;
    }
};
```

字符串过长时使用string来存储
```
class Solution {
public:
    string replaceSpace(string s) {
        string str = "";
        for(int i = 0, j = 0; i < s.length(); i++)
        {
            if(s[i] == ' ')
            {
                str += "%20";
                j+=3;
            }
            else
            {
                str += s[i];
                j++;
            }
        }
        
        return str;
    }
};
```

