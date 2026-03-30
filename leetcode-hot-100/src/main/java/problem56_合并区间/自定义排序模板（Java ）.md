# 自定义排序模板（Java ）

适用于：数组排序、二维数组排序、LeetCode 刷题、面试手写

## 1. 万能结构（背这一个就够）

```java
Arrays.sort(数组, new Comparator<元素类型>() {
    public int compare(元素a, 元素b) {
        // 升序：a.属性 - b.属性
        // 降序：b.属性 - a.属性
    }
});
```

## 2. 一维数组排序

```java
int[] arr = {5, 2, 9, 1};

Arrays.sort(arr, new Comparator<Integer>() {
    public int compare(Integer a, Integer b) {
        return a - b;  // 从小到大（升序）
        // return b - a; // 从大到小（降序）
    }
});
```

## 3. 二维数组按「第 0 位」排序（合并区间专用）

```java
int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};

Arrays.sort(intervals, new Comparator<int[]>() {
    public int compare(int[] a, int[] b) {
        return a[0] - b[0]; // 按每个区间的左端点升序
    }
});
```

## 4. 二维数组按「第 1 位」排序

```java
int[][] arr = {{1,5},{2,3},{3,1}};

Arrays.sort(arr, new Comparator<int[]>() {
    public int compare(int[] a, int[] b) {
        return a[1] - b[1]; // 按第 1 位升序
    }
});
```

## 5. Lambda 极简写法（推荐面试写）

```java
// 二维数组按第 0 位升序
Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
```

## 6. 核心口诀

- a - b → 从小到大（升序）

- b - a → 从大到小（降序）

- 二维数组：a[0] 按第 0 位，a[1] 按第 1 位