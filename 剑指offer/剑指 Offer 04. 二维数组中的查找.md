[剑指 Offer 04. 二维数组中的查找](https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/)（中等）

#### 解法

1、左下角或者右上角开始找，时间复杂度O(m+n)    
左下角开始    
当值比当前小，那么往上退一步，比当前大，往右进一步，直到遇到边界或者找点值。    

```
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int len = matrix.length;
        if(len == 0) return false;
        int widget = matrix[0].length;
        if(widget == 0) return false;
        if(target > matrix[len-1][widget-1] || target < matrix[0][0])
        {
            return false;
        }

        for(int i = 0, j = widget-1; i < len && j >= 0; )
        {
            if(matrix[i][j] == target) return true;
            else if(matrix[i][j] < target) i++;
            else j--;
        }
        return false;
    }
}
```

2、每层用二分法查 时间复杂度O(nlog(m))

```
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int row = matrix.length;
        if(row == 0) return false;
        int column = matrix[0].length;
        if(column == 0) return false;

        for(int i = 0; i < row; i++)
        {
            int left = 0;
            int rigth = column-1;
            while(left <= rigth)
            {
                int middle = (rigth+left)/2;
                if(matrix[i][middle] == target) return true;
                else if(matrix[i][middle] < target) left = middle+1;
                else rigth = middle-1;
            }
        }
        return false;
    }
}
```