import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * Created by Inno Fang on 2017/6/3.
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));

        in.close();
    }

    public static int sumOfSquares(int... args) {
        int sum = 0;
        for (int arg : args) {
            sum += arg * arg;
        }
        return sum;
    }

}
