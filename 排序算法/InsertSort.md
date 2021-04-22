插入排序

---

将数组分成已排好序部分和未完成排序的部分
然后依次从未排序部分“取”一个元素，插入到已完成排序部分。

具体实现
```Java
public void insertSort(int arr[], int len)
{
    for(int i = 1; i < len; i++)
    {
        int j = i-1;
        int tmp = arr[i];
        for(j >= 0; j--)
        {
            if(arr[j] > arr[j+1])
            {
                arr[j+1] = arr[j];
            }
            else break;
        }
        arr[j+1] = tmp;
    }
}

```