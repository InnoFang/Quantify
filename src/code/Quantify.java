package code;

import java.io.BufferedInputStream;
import java.util.*;

/**
 * Created by Inno Fang on 2017/6/3.
 */
public class Quantify {

    private static final int MAXN = 50 + 5;
    private static final int INF = 0x6ffffff;

    private static int[] arr            = new int[MAXN];         // 数列
    private static int[] prefixSum      = new int[MAXN];         // 前缀和
    private static int[][] dp           = new int[MAXN][MAXN];   // 保存每个自分块的最优情况
    private static int[][] sumOfSquares = new int[MAXN][10 + 5]; // 保存所有分块中数的差的平方的和

    private static Scanner in = new Scanner(new BufferedInputStream(System.in));

    public static void main(String[] args) {

        while (in.hasNextInt()) {
            int cas = in.nextInt();
            for (int i = 0; i < cas; i++) {

                int count = in.nextInt();
                int s = in.nextInt();

                /* 初始化数列 */
                initArray(count);

                /* 将数列排序 */
                Arrays.sort(arr, 1, count + 1);

                /* 计算并保存前缀和 */
                initPrefixSum(count);

                /* 计算并保存所有分块中的数的差的平方的和 */
                initSumOfSquares(count);

                /* 使用动态规划 */
                dynamicProgramming(count, s);
            }
        }
        in.close();
    }

    private static void initArray(int count) {
        /* input number */
        arr[0] = 0;
        for (int i = 1; i <= count; i++) {
            arr[i] = in.nextInt();
        }
    }

    private static void initPrefixSum(int count) {
        for (int i = 0; i <= count; i++) {
            prefixSum[i] = 0;
        }

        for (int i = 1; i <= count; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }
    }

    private static void initSumOfSquares(int count) {

        for (int i = 1; i <= count; i++) {
            for (int j = 1; j <= count; j++) {
                sumOfSquares[i][j] = 0;
            }
        }

        for (int i = 1; i < count; i++) {
            for (int j = i + 1; j <= count; j++) {
                int aver = averageOf(i, j);
                for (int k = i; k <= j; k++) {
                    sumOfSquares[i][j] += (arr[k] - aver) * (arr[k] - aver);
                }
            }
        }
    }

    private static int averageOf(int from, int to) {
        return (int) Math.floor(
                (prefixSum[to] - prefixSum[from - 1]) * 1.0
                        / (to - from + 1) + 0.5);
    }

    private static void dynamicProgramming(int count, int s) {
        for (int i = 0; i <= count; i++) {
            for (int j = 0; j <= s; j++) {
                dp[i][j] = INF;
            }
        }
        dp[0][0] = 0;

        for (int i = 1; i <= s; ++i) {
            for (int j = 1; j <= count; ++j) {
                for (int k = 0; k <= j - 1; ++k) {
                    dp[j][i] = Math.min(dp[k][i - 1] + sumOfSquares[k + 1][j], dp[j][i]);
                }
            }
        }
        System.out.println(dp[count][s]);
    }
}