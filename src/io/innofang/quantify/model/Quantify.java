package io.innofang.quantify.model;

import io.innofang.quantify.util.FileUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Inno Fang on 2017/6/3.
 */
public class Quantify {

    private static final int MAXN = 100 + 5;
    private static final int INF = 0x6ffffff;

    private static Bean[] arr; // 数列
    private static int[] prefixSum; // 前缀和
    private static int[][] sumOfSquares; // 保存所有分块中数的差的平方的和
    private static int[][] average; // 保存所有分块的平均值
    private static int[][] dp; // 保存每个自分块的最优情况
    private static int[][] path; // 保存每个自分块的分界下标

    private static Scanner in;
    private static StringBuilder stringBuilder;
    private static int caseNumber;
    private static int cas;
    private static List<Data> datas;

    public static List<Data> quantify() {

        try {
            in = new Scanner(new FileInputStream(new File(FileUtil.TEMP_FILE_NAME)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        arr = new Bean[MAXN];
        prefixSum = new int[MAXN];
        sumOfSquares = new int[MAXN][MAXN];
        average = new int[MAXN][MAXN];
        dp = new int[MAXN][10 + 5];
        path = new int[MAXN][10 + 5];
        datas = new ArrayList<>();
        stringBuilder = new StringBuilder();

        if (in.hasNextInt()) {
            caseNumber = in.nextInt();
            for (int i = 0; i < caseNumber; i++) {

                cas = i;
                datas.add(new Data());
                stringBuilder.append("case ").append(cas + 1).append("\n");

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
        return datas;
    }

    private static void initArray(int count) {

        List<Integer> list = new ArrayList<>();
        stringBuilder.append("数 列 : ");

        /* input number */
        arr[0] = new Bean();
        arr[0].before = 0;
        for (int i = 1; i <= count; i++) {
            arr[i] = new Bean();
            arr[i].before = in.nextInt();
            arr[i].index = i;
            list.add(arr[i].before);
            stringBuilder.append(arr[i].before).append(" ");
        }

        datas.get(cas).setBeforeData(list);
        stringBuilder.append("\n");
    }

    private static void initPrefixSum(int count) {
        for (int i = 0; i <= count; i++) {
            prefixSum[i] = 0;
        }

        for (int i = 1; i <= count; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i].before;
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
                average[i][j] = aver;
                for (int k = i; k <= j; k++) {
                    sumOfSquares[i][j] += (arr[k].before - aver) * (arr[k].before - aver);
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

        int tempIndex = -1; // 保存最后一个分界的下标
        for (int i = 1; i <= s; ++i) {
            for (int j = 1; j <= count; ++j) {
                for (int k = 0; k <= j - 1; ++k) {
                    int temp = dp[j][i]; // temp 用于判断 dp[j][i] 是否改变
                    dp[j][i] = Math.min(dp[k][i - 1] + sumOfSquares[k + 1][j], dp[j][i]);
                    if (temp != dp[j][i]) {
                        path[j][i] = k;
                        if (i == s) { // 若为最后一个块的情况，直接修改量化后的值
                            tempIndex = k;
                            for (int l = k + 1; l <= j; l++) {
                                arr[l].after = average[k + 1][j];
                            }

                        }
                    }
                }
            }
        }

        // 直接输出结果
        System.out.println(dp[count][s]);

        // 递归求每一个数量化后的值
        getPath(tempIndex, s);
        // 以下标排序，还原到数列每个数原来的位置
        Arrays.sort(arr, 1, count + 1, (o1, o2) -> o1.index - o2.index);

        // 给 data 添加量化后的数列
        stringBuilder.append("量 化 : ");
        List<Integer> after = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            after.add(arr[i].after);
            stringBuilder.append(arr[i].after).append(" ");

        }
        stringBuilder.append("\n");
        datas.get(cas).setAfterData(after);

        // 添加量化后的差值的描述
        stringBuilder.append("差 值 : ");
        List<Integer> diff = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            int dif = arr[i].before - arr[i].after;
            diff.add(dif);
            stringBuilder.append(dif).append(" ");
        }
        stringBuilder.append("\n");
        datas.get(cas).setDiffereceData(diff);


        // 给 data 添加结果描述
        stringBuilder.append("结 果 : ");
        stringBuilder.append(dp[count][s]).append("\n\n");

        datas.get(cas).setDescription(stringBuilder.toString());
    }

    private static void getPath(int index, int s) {
        if (s == 0) {
            return;
        } else {
            int preIndex = path[index][s - 1];
            for (int i = preIndex + 1; i <= index; i++) {
                arr[i].after = average[preIndex + 1][index];
            }
            getPath(preIndex, s - 1);
        }
    }
}