[剑指 Offer 11. 旋转数组的最小数字](https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/)（简单）

此题与主站[153](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/)题和[154](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/)题思路相同

#### 解法

二分法搜索
旋转数组在一定区间非递减，使用二分查找
当中值大于右值时，那么最小值一定在右侧
当中值等于右值时，由于可能有重复值存在，无法判断在哪侧，只能排除最右值位置一定不是最小值
当中值小于右值时，那么一定在左侧


```
class Solution {
public:

    int minArray(vector<int>& numbers) {
        if(numbers.empty() )
            return 0;
        int left = 0;
        int right = numbers.size()-1;
        
        while(left < right)
        {
            int middle = left +(right-left)/2;
            if(numbers[middle]>numbers[right])
            {
                left = middle+1;
            }
            else if(numbers[middle] < numbers[right])
            {
                right = middle;
            }
            else if(numbers[middle] == numbers[right])
            {
                right--;
            }
        }
        return numbers[left];
    }
};
```
实际上，当出现 nums[m] = nums[j]nums[m]=nums[j] 时，一定有区间 [i, m][i,m] 内所有元素相等 或 区间 [m, j][m,j] 内所有元素相等（或两者皆满足）。对于寻找此类数组的最小值问题，可直接放弃二分查找，而使用线性查找替代。

作者：jyd
链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/solution/mian-shi-ti-11-xuan-zhuan-shu-zu-de-zui-xiao-shu-3/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```
class Solution {
public:

    int minArray(vector<int>& numbers) {
        if(numbers.empty() )
            return 0;
        int left = 0;
        int right = numbers.size()-1;
        
        while(left < right)
        {
            int middle = left +(right-left)/2;
            if(numbers[middle]>numbers[right])
            {
                left = middle+1;
            }
            else if(numbers[middle] < numbers[right])
            {
                right = middle;
            }
            else if(numbers[middle] == numbers[right])
            {
            	int ans = numbers[left];
                for(int i = left+1; i < right; i++)
                {
                	ans = min(numbers[i], ans);
                }
                return ans;
            }
        }
        return numbers[left];
    }
};
```