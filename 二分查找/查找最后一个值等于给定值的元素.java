// 最后一个等于给定值的元素位置
public int lastEqualValue(int arr[], int len, int value)
{
    int l = 0;
    int r = len - 1;
    while(l <= r)
    {
        int middle = l + ((r-l)>>1);

        if(arr[middle] < value)
        {
            l = middle+1;
        }
        else if(arr[middle] > value)
        {
            r = middle-1;
        }
        else
        {
            if((middle == len-1) || arr[middle+1] > value) return middle;
            else l = middle+1;
        }
    }

    return -1;

}

