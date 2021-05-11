快速排序

首先选取一个分区点，然后遍历数组，将小于分区点的放在左边，其他放在右边。这样一趟遍历完确定分区点位置，然后对分区点左右进行相同操作

与归并排序区别    
归并排序是非原地排序算法，归并过程不能实现原地处理，内存占用比较大。    
而且归并排序处理是先处理子问题，然后再处理合并，快速排序先分区，再分为子问题处理。    

**性能分析**
最坏情况下数组有序，每次都扫描整个未分区数组，类似冒泡排序，时间复杂度O(n^2)    
最好情况下，每次都恰好分成规模差不多的两部分，这样时间复杂度O(nlogn)

**改进思路**
快速排序时间复杂度变高的主要原因是由于分区点选取不合理，尽量选取分区点都能平均拆分数组，可以降低复杂度。    
1、三数取中：每次选取数组头、中、尾节点中的中间值    
2、随机选取    

快速排序使用递归实现    
因此还要考虑限制递归深度或者在堆模拟调用栈防止堆栈溢出。


```Java
public void quickSort(int arr[], int len)
    {
        _quicksort(arr, 0, len-1);
    }

    void _quicksort(int arr[], int l ,int r)
    {
        if(l >= r) return;

        int pivot = partition(arr,l, r);
        _quicksort(arr, l, pivot-1);
        _quicksort(arr, pivot+1, r);
    }

    int partition(int arr[], int l , int r)
    {
        // 首先设置区间中点值做分区点
        int pivot = arr[r];

        // 使用双指针，i记录比pivot大的元素， j记录在这之后第一个比pivot小的元素
        int i = l;

        for(int j = l; j <= r-1; j++)
        {
            if(arr[j] < pivot)
            {
                swap(arr, j, i);
                i++;
            }
        }
        // 剩下的i就是分区点位置
        swap(arr, i, r);
        return i;
    }
```