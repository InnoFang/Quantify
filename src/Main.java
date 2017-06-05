import java.io.BufferedInputStream;
import java.util.*;

/**
 * Created by Inno Fang on 2017/6/3.
 */
public class Main {

    private static final int MAXN = 50 + 5;
    private static final int INF  = Integer.MAX_VALUE;

    private static int[]   arr          = new int[MAXN];       // 数列
    private static int[]   sum          = new int[MAXN];       // 前缀和
    private static int[][] dp           = new int[MAXN][MAXN]; // 保存每个自分块的最优情况
    private static int[][] sumOfSquares = new int[MAXN][MAXN]; // 保存所有分块中数的差的平方的和

    private static Scanner in = new Scanner(new BufferedInputStream(System.in));

    public static void main(String[] args) {

        while (in.hasNextInt()) {
            int cas = in.nextInt();
            for (int i = 0; i < cas; i++) {

                int count = in.nextInt();
                int s = in.nextInt();

                /* input number */
                for (int j = 1; j <= count; j++) {
                    arr[j] = in.nextInt();
                }

                /* sorting */
                Arrays.sort(arr);

                int sum = 0;
                for (int j = 0; j < s; j++) {

                }
                System.out.println(sum);
            }
        }
        in.close();
    }

    public static void initialData(int[] args, int val) {
        for (int i = 0; i < args.length; i++) {
            args[i] = val;
        }
    }

}

/* private static int getTheBestResultOf(List<Integer> list) {
        return sumOfSquares(absOfDiff(averageOf(list), list));
    }


    public static List<Integer> absOfDiff(int aver, List<Integer> list) {
        List<Integer> nums = new ArrayList<>();
        for (int arg : list) {
            nums.add(Math.abs(aver - arg));
        }
        return nums;
    }

    public static int averageOf(List<Integer> list) {
        double sum = 0;
        for (int arg : list) {
            sum += arg;
        }
        return (int) Math.floor((sum / list.size()) + 0.5);
    }

    public static int sumOfSquares(List<Integer> list) {
        int sum = 0;
        for (int arg : list) {
            sum += arg * arg;
        }
        return sum;
    }
*/
/*

109  252  292  297  415  450  474  492  814  846  934
 */

  /*Random random = new Random();

        for (int i = 0; i < 50; i++) {
            int count = random.nextInt(51);
            if (count < 5)
                continue;
            for (int j = 0; j < count; j++) {
                System.out.print(random.nextInt(1000) + " ");
            }
            System.out.println();
        }*/
//        int res = averageOf(/*109, 252, 292, 297, 415, 450, 474, */492, 814, 846, 934);
//        System.out.println(res);
//        absOfDiff(772, 492, 814, 846, 934);
//        System.out.println();
//        System.out.println(sumOfSquares(280, 42, 74, 162));
//        int res = averageOf(744, 755, 777, 980, 897, 902);
//        System.out.println(res);
//        absOfDiff(res, 1,2,3,4,5);
//        System.out.println();
//        System.out.println(sumOfSquares(2, 1, 0, 1, 2));