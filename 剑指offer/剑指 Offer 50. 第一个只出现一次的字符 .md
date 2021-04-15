[剑指 Offer 50. 第一个只出现一次的字符](https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/)（简单）

#### 解法

利用hash表存储每个字符出现次数，然后再次遍历，遇到第一个次数为1的即是答案

```C++
class Solution {
public:
    char firstUniqChar(string s) {
        unordered_map<char, int>um;
        for(char c : s)
        {
            if(um.find(c) == um.end())
            {
                um[c] = 1;
            }
            else um[c]++;
        }
        for(char c:s)
        {
            if(um[c] == 1)
                return c;
        }
        return ' ';
    }
};
```

建立key、value为值和对应下标的hash表，当遇到重复值时，将下标置为-1，再次遍历hash表，找到最小的下标值即可
```C++
class Solution {
public:
    char firstUniqChar(string s) {
        unordered_map<char, int>um;
        for(int i = 0; i < s.length(); i++)
        {
            if(um.find(s[i]) == um.end())
            {
                um[s[i]] = i;
            }
            else um[s[i]] = -1;
        }
        int ans = s.length();
        for(auto ite = um.begin(); ite != um.end(); ite++)
        {
            if(ite->second != -1)
            {
                ans = min(ans, ite->second);
            }
        }
        return ans == s.length() ? ' ' : s[ans];
    }
};
```

在值建立hash映射，再使用队列来记录每个不重复的元素，当对hash表操作时出现重复元素，同样下标置为-1，并且对队列头部操作，当头部记录元素对于hash下标为-1时出队列。这样最后队列不为空的情况下，头部元素就是第一个不重复的。遍历一次数据即可出答案。

```C++
class Solution {
public:
    char firstUniqChar(string s) {
        unordered_map<char, int>um;
        queue< pair<char, int> >q;
        for(int i = 0; i < s.length(); i++)
        {
            if(um.find(s[i]) == um.end())
            {
                um[s[i]] = i;
                q.emplace(s[i], i);
            }
            else
            {
                um[s[i]] = -1;

                while(!q.empty() && um[q.front().first] == -1)
                {
                    q.pop();
                } 
            } 
        }
        if(q.empty()) return ' ';
        return q.front().first;
        
    }
};
```