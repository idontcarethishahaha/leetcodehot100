package problem56_合并区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution2 {
    public int[][] merge(int[][] intervals){
        // 空数组直接返回空，处理边界，避免空指针
        if(intervals.length==0) return new int[0][2];

        /*
        Arrays.sort(数组，比较规则);
         */

        // 排序
//        Arrays.sort(intervals,new Comparator<int[]>(){
//           public int compare(int[] a,int[] b){
//               // 二位数组按第0位排序
//               return a[0]-b[0];
//           }
//        });

        // Lambda写法
        // 二维数组按第 0 位升序，也就是按照区间的第一个数字从小到大排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // 装着很多一维数组 int[] 的动态集合
        List<int[]> merged = new ArrayList<>();//结果集合，存合并好的最终区间

        /*
        如果结果集合 是空的 → 直接加
        或者 当前区间的左边 > 结果最后一个区间的右边
        → 两个区间不重叠 → 直接加
        例子：当前区间[8,10]，结果集最后一个区间[1,6]
        6 < 8 → 不重叠 → 直接添加

        merged.size()结果集区间个数，
        merged.size()-1最后一个区间的下标
        merged.get(merged.size()-1)[1]拿到最后一个区间的右端点
         */
        for(int[] curr : intervals){//遍历每一个区间，curr正在看的区间
            if(merged.isEmpty()||curr[0]>merged.get(merged.size()-1)[1]){
                merged.add(curr);
            }else{//当前数组的左边界小于最后一个区间的右边界，区间重叠了，要被合并
                //可以合并就更新右边界，更大的做新的右边界
                merged.get(merged.size()-1)[1]=Math.max(curr[1],merged.get(merged.size()-1)[1]);
            }
        }
        // int[0][]空的二位数组
        // 将合并好的区间转为结果要的二位数组
        return merged.toArray(new int[0][]);
    }
}
