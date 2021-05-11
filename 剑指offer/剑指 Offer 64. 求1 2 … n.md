[剑指 Offer 64. 求1+2+…+n](https://leetcode-cn.com/problems/qiu-12n-lcof/) （中等）

#### 解法

使用`&&`运算符    
A && B 假如A为假，那么不会运算B

这样避开if语句

```C++
class Solution {
public:
    int sumNums(int n) {
        n && (n += sumNums(n-1));
        return n;
    }
};
```

使用`||`运算符    
A || B 加入A为真，不会运行B

```C++
class Solution {
public:
    int sumNums(int n) {
        n == 0 || (n += sumNums(n-1)) ;
        return n;
    }
};
```


大神天秀解法

```C++
class Solution {
public:
    int sumNums(int n) {
        // 定义二维数组，计算大小
        bool a[n][n+1];
        return sizeof(a)>>1;
    }
};

//ans=1+2+3+...+n
//   =(1+n)*n/2
//   =sizeof(bool a[n][n+1])/2)
//   =sizeof(a)>>1

作者：moao
链接：https://leetcode-cn.com/problems/qiu-12n-lcof/solution/c-tian-xiu-by-moao-u1am/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```