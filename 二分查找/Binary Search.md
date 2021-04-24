二分查找针对的是一个有序的数据集合，查找思想有点类似分治思想。每次都通过跟区间的中间元素对比，将待查找的区间缩小为之前的一半，直到找到要查找的元素，或者区间被缩小为 0

时间复杂度log(n)

应用场景
必须是有序数组

使用**链表**存储数组，进行二分查找
```
每次获取中间节点时需要遍历整个区间
n + n/2 + ... + 1 = n-1

实际操作过程中，会进行多余操作，因此比顺序查找慢
```

数据太小使用二分查找优势不大（如果进行比较操作比较费时间，那么也可以使用二分。比如字符串查找，使用二分尽可能减少比较次数）
数据太大，内存可能没有很大的连续空间

```Java
public int binarySearch(int arr[], int len, int value)
{
    int l = 0;
    int r = len-1;

    // 循环退出条件 l <= r
    while(l <= r)
    {
        // 注意这里优化除法使用位移运算符
        // 位移运算符优先级低，需要加括号，否则容易进入死循环
        int middle = l + ((r-l) >> 1);
        
        if(arr[middle] == value) return middle;
        else if(arr[middle] < value) l = middle+1;
        else r = middle -1;
    }

    return -1;
}

// 递归实现
public int binarySearch_1(int arr[], int len, int value)
{
    return _binarySearch_1(arr, 0, len-1, value);
}


int _binarySearch_1(int arr[], int l, int r, int value)
{
    if(l > r) return -1;
    int middle = l + (r-l)/2;
    if(arr[middle] == value) return middle;
    else if (arr[middle] < value) return _binarySearch_1(arr, middle+1, r, value);
    else return _binarySearch_1(arr, l, middle-1, value);
}
```

