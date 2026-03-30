package problem15_三数之和.acm;

import java.util.*;

public class Main {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // 跳过重复的 i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int l = i + 1;
            int r = n - 1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];

                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;

                    // 跳过重复的 l
                    while (l < r && nums[l] == nums[l - 1]) l++;
                    // 跳过重复的 r
                    while (l < r && nums[r] == nums[r + 1]) r--;

                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }

    // ==================== ACM 主函数 ====================
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 输入数组长度
        int n = sc.nextInt();

        // 2. 输入数组
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // 3. 调用方法
        List<List<Integer>> ans = threeSum(nums);

        // 4. 输出结果
        for (List<Integer> list : ans) {
            System.out.println(list);
        }
    }
}
