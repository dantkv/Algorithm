对于整个数组，每次记录下未排序部分的最大值或者最小值，与末尾元素交换位置
重复n次后完成排序

```Java
public void selectSort(int arr[], int len)
{
    for(int i = 0; i < len; i++)
    {
        int index = i;
        for(int j = i+1; j < len; i++)
        {
            if(arr[j] > arr[index])
            {
                index = j;
            }
        }
        swap(arr, index, i);
    }
}

public void swap(int arr[], int i, int j)
{
    int t = arr[i];
    arr[i] = arr[j];
    arr[j] = t;
}
```

时间复杂度分析

空间复杂度分析

是否原地排序

改进版本
