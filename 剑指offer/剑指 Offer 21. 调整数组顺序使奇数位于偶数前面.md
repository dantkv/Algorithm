[剑指 Offer 21. 调整数组顺序使奇数位于偶数前面](https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/) （简单）

#### 解法

双指针头尾遍历，分别记录下奇数和偶数的下标，交换直到两指针相遇

```C++
class Solution {
public:
    vector<int> exchange(vector<int>& nums) {
        int i = 0;
        int len = nums.size();
        int j = len-1;
        if(len == 0) return nums;
        
        while(1)
        {
            /*
            * 注意这里运算符优先级 关系运算符优先级高于位运算 需要加括号来控制
            */
            while (i < len && (nums[i] & 1) != 0) i++;
            while (j >= 0 && (nums[j] & 1) == 0) j--;
            if(i >= j ) break;
            swap(nums[i], nums[j]);
            i++;
            j--;
        }
        return nums;
    }
};
```

双指针单向遍历，快指针记录奇数位置，慢指针记录下一个奇数位置
当快指针向前搜索到奇数，重新出现

```C++
class Solution {
public:
    vector<int> exchange(vector<int>& nums) {
        int len = nums.size();
        if(len == 0) return nums;
        int slow = 0;
        int fast = 0;
        while(fast<len)
        {
            if((nums[fast] & 1) == 1)
            {
                swap(nums[slow], nums[fast]);
                slow++;
            }
            fast++;
        }
        return nums;
    }
};
```