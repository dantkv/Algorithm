import java.util.Arrays;

/**
 * 支持动态扩容的数组
 * 每次扩容2倍大小
 */

public class ArrayList {
    private int length;
    private int size;
    private int arr[];

    public ArrayList(int length)
    {
        if(length > 0)
        {
            initArrayList(length);
        }
    }

    public ArrayList()
    {
        initArrayList(10);
    }

    private void initArrayList (int length)
    {
        this.arr = new int[length];
        this.length = length;
        this.size = 0;
    }

    public void push_back(int value)
    {
        if(size >= length)
        {
            int[] temp = new int[length * 2];
            for (int i = 0; i < length; i++) {
                temp[i] = arr[i];
            }
            arr = temp;
            length *= 2;
        }
        arr[size++] = value;
    }

    /**
     * 删除下标为index的元素
     * @param index 下标
     * @return 返回删除的值，超范围抛出异常
     */
    public int erase(int index)
    {
        if(index >= size || index < 0) throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        int ret = arr[index];
        for(int i = index; i < size-1; i++)
        {
            arr[i] = arr[i+1];
        }
        arr[size-1] = 0;
        size--;

        return ret;
    }

    /**
    * 获取下标为index的元素
    */
    public int get(int index)
    {
        if(index >= size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        return arr[index];
    }
    
    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }

    public int getLength() {
        return length;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "ArrayList{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }
}
