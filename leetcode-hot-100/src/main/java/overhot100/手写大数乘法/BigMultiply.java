package overhot100.手写大数乘法;

/**
 * 类说明：
 *
 * @author WuWenJin
 * @version 1.0
 * @date 2026-04-24 21:14
 */
/*
原理：
两个数字 num1、num2 长度为 n、m，乘积最大长度为 n + m；
逆序遍历两数，逐位相乘，累加到对应位置；
处理进位，最后反转、去除前导零。
 */
public class BigMultiply {
    public static String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        // 乘积最大长度 len1 + len2
        int[] res = new int[len1 + len2];

        // 倒序遍历每一位
        for (int i = len1 - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = len2 - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                // 相乘结果 + 原有位置数值
                int sum = n1 * n2 + res[i + j + 1];
                // 低位
                res[i + j + 1] = sum % 10;
                // 进位到高位
                res[i + j] += sum / 10;
            }
        }

        // 拼接结果，去除前导零
        StringBuilder sb = new StringBuilder();
        for (int val : res) {
            if (!(sb.isEmpty() && val == 0)) {
                sb.append(val);
            }
        }
        // 避免 0*0 为空
        return sb.isEmpty() ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        // 测试
        System.out.println(multiply("123", "456"));
        System.out.println(multiply("999", "999"));
        System.out.println(multiply("0", "12345"));
    }
}
