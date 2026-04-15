package problem56_合并区间.变体;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 区间结构体
class Interval {
    int start;
    int end;
    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

class Solution {
    // ================= 1. 手写快速排序 (不使用内置Sort) =================
    // 基于区间的start进行排序
    private void quickSort(List<Interval> intervals, int left, int right) {
        if (left >= right) return;

        // 选基准 (pivot)
        int pivot = intervals.get(right).start;
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (intervals.get(j).start <= pivot) {
                i++;
                // 交换 i 和 j
                Interval temp = intervals.get(i);
                intervals.set(i, intervals.get(j));
                intervals.set(j, temp);
            }
        }

        // 把基准放到正确的位置
        Interval temp = intervals.get(i + 1);
        intervals.set(i + 1, intervals.get(right));
        intervals.set(right, temp);

        // 递归左右
        quickSort(intervals, left, i);
        quickSort(intervals, i + 2, right);
    }

    // ================= 2. 合并逻辑 =================
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return res;
        }

        // 手写排序：必须按 start 升序排列
        quickSort(intervals, 0, intervals.size() - 1);

        // 初始化第一个区间
        res.add(intervals.get(0));

        for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            Interval last = res.get(res.size() - 1);

            // 判断重叠：当前区间的start <= 上一个区间的end
            if (curr.start <= last.end) {
                // 合并：更新end为较大值
                last.end = Math.max(last.end, curr.end);
            } else {
                // 不重叠：直接加入结果
                res.add(curr);
            }
        }
        return res;
    }
}

// ================= ACM 主程序 =================
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 输入格式：
        // 第一行：区间数量 n
        // 接下来 n 行：每行两个整数 start end
        int n = sc.nextInt();
        List<Interval> intervals = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            intervals.add(new Interval(s, e));
        }

        Solution sol = new Solution();
        List<Interval> ans = sol.merge(intervals);

        // 输出格式：打印每个区间 [start, end]
        for (Interval interval : ans) {
            System.out.printf("[%d,%d] ", interval.start, interval.end);
        }
    }
}

/*
// 冒泡排序实现
private void bubbleSort(List<Interval> intervals) {
    int n = intervals.size();
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (intervals.get(j).start > intervals.get(j + 1).start) {
                // 交换
                Interval temp = intervals.get(j);
                intervals.set(j, intervals.get(j + 1));
                intervals.set(j + 1, temp);
            }
        }
    }
}
 */
