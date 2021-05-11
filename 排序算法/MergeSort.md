归并排序

采用分治思想，将排序化解为小规模子问题，分别对子数组排序，再合并到一起，这样整个数组有序了

首先将数组分为两部分，然后分别对两部分做同样操作，最后将分开的数组合并。

**性能分析**
* 由于merge函数没有只移动比哨兵大的，并未改变前后关系，因此是稳定排序算法

* 时间复杂度
T(n) = T(a) + T(b) + k
k为将两数组合并的时间复杂度

对于规模为n的数组，merge操作时间复杂度为O(n)，而将分解成两个子问题时间复杂度为2 * T(n/2)

因此时间复杂度公式为
```

T(1) = C；               n=1时，只需要常量级的执行时间，所以表示为C。
T(n) = 2*T(n/2) + n；    n>1
```
通过推导，可以得到 T(n) = 2^kT(n/2^k)+kn 。当 T(n/2^k)=T(1) 时，也就是 n/2^k=1，我们得到 k=log2n 。我们将 k 值代入上面的公式，得到 T(n)=Cn+nlog2n 。如果我们用大 O 标记法来表示的话，T(n) 就等于 O(nlogn)。所以归并排序的时间复杂度是 O(nlogn)。


空间复杂度    
同一时刻，最多只有大小为n的临时空间，因为用完就被释放掉。因此平均空间复杂度O(n)

伪代码
```Java
// 归并排序算法, A是数组，n表示数组大小
merge_sort(A, n) {
  merge_sort_c(A, 0, n-1)
}

// 递归调用函数
merge_sort_c(A, p, r) {
  // 递归终止条件
  if p >= r  then return

  // 取p到r之间的中间位置q
  q = (p+r) / 2
  // 分治递归
  merge_sort_c(A, p, q)
  merge_sort_c(A, q+1, r)
  // 将A[p...q]和A[q+1...r]合并为A[p...r]
  merge(A[p...r], A[p...q], A[q+1...r])
}


merge(A[p...r], A[p...q], A[q+1...r]) {
  var i := p，j := q+1，k := 0 // 初始化变量i, j, k
  var tmp := new array[0...r-p] // 申请一个大小跟A[p...r]一样的临时数组
  while i<=q AND j<=r do {
    if A[i] <= A[j] {
      tmp[k++] = A[i++] // i++等于i:=i+1
    } else {
      tmp[k++] = A[j++]
    }
  }
  
  // 判断哪个子数组中有剩余的数据
  var start := i，end := q
  if j<=r then start := j, end:=r
  
  // 将剩余的数据拷贝到临时数组tmp
  while start <= end do {
    tmp[k++] = A[start++]
  }
  
  // 将tmp中的数组拷贝回A[p...r]
  for i:=0 to r-p do {
    A[p+i] = tmp[i]
  }
}
```


最终实现：

```Java
void mergeSort(int arr[], int len)
{
    _mergeSort(arr, 0, len-1);
}

void  _mergeSort(int arr[], int l, int r)
{
    if(l >= r) return;

    int middle = l + (r-l)/2;
    _mergeSort(arr, l, middle);
    _mergeSort(arr, middle+1, r);

    mergeArr(arr, l, middle, r);
}

void mergeArr(int arr[], int l, int middle, int r)
{
    int []tmp = new int[r-l+1];
    int k = 0;
    int i = l, j = middle+1;

    while(i <= middle && j<= r)
    {
        if(arr[i] <= arr[j])
        {
            tmp[k++] = arr[i++];
        }
        else
        {
            tmp[k++] = arr[j++];
        }
    }

    while(i<= middle) tmp[k++] = arr[i++];
    while(j <= r) tmp[k++] = arr[j++];

    i = l; k = 0;
    while( i <= r )
    {
        arr[i++] = tmp[k++];
    }
}
```