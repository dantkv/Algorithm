import java.util.Arrays;


/**
 * 大小固定的有序数组，支持动态增删改操作
 *
 * 增加元素：按照大小关系插入
 *
 * 修改元素：修改后保持顺序关系
 */
public class OrderedArray implements java.io.Serializable
{
    private static final long serialVersionUID = -3121725268712311483L;

    private int result[];

    private int length;
    private int capacity;

    /**
     * 默认大小
     */
    private int DEFAULT_CAPACITY = 15;

    public OrderedArray(int arr[])
    {
        result = new int[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
        this.length = arr.length;
        for(int i = 0, j = 0; i < this.length; i++, j++)
        {
            result[j] = arr[i];
        }
    }

    /**
     * 插入一个元素，使数组仍然有序
     * 这里没有做超出长度处理，一般抛出异常即可
     * @param val
     */
    public void insertValue(int val)
    {
        int index = binarySearch(result, length, val);

        for(int i = length; i > index+1; i--)
        {
            result[i] = result[i-1];
        }

        result[index+1] = val;
        this.length++;
    }

    public int get(int index)
    {
        return result[index];
    }

    public void resetValue(int index, int val) {
        /**
         * 如果和原值相等，不做修改
         */
        if (result[index] == val) {
            return;
        }

        int tmp = result[index];

        int i = binarySearch(result, length, val);

        // 在index前面
        if (i < index)
        {
            for(int j = index; j > i+1; j--)
            {
                result[j] = result[j-1];
            }

            result[i+1] = val;
            return;
        }
        if(i >= index)
        {
            for(int j = index; j <= i-1 ; j++)
            {
                result[j] = result[j+1];
            }

            result[i] = val;
            return;
        }
    }

    /**
     * 二分查找
     * @param arr 数组
     * @param val 待查找元素
     * @return 返回第一个小于等于val的元素位置，未找到返回-1
     */
    public int binarySearch(int arr[], int length, int val)
    {
        int l = 0;
        int r = length-1;

        if(val < arr[l]) return -1;
        if(val > arr[r]) return r;

        while(l <= r)
        {
            int middle = l + ((r-l)>>1);

            if(arr[middle] <= val)
            {
                if((middle == arr.length-1) || (arr[middle+1] > val) ) return middle;
                l = middle+1;
            }
            else if(arr[middle] > val)
            {
                r = middle-1;
            }
        }

        return -1;
    }

    @Override
    public String toString() {
        return "OrderedArray{" +
                "result=" + Arrays.toString(result) +
                ", length=" + length +
                ", capacity=" + capacity +
                '}';
    }
}
