// 最后一个小于等于给定值的元素位置
public int lastLessThanValue(int arr[], int len, int value)
{
    int l = 0;
    int r = len-1;

    while (l <= r)
    {
        int middle = l + ((r-l)>>1);

        if(arr[middle] <= value)
        {
            if(middle == len-1 || (arr[middle+1] > value) ) return middle;
            l = middle+1;
        }
        else if(arr[middle] > value)
        {
            r = middle-1;
        }

    }

    return -1;
}
