#include <iostream>
#include <stdlib.h>
#include <math.h>
#include <string.h>

#define INF (0x6ffffff)
#define MAXN (100 + 5)

using namespace std;

int arr[MAXN];
int sum[MAXN];
int flag[MAXN][MAXN];
int dp[MAXN][10 + 5];

void get_flag(int count) {
    for (int i = 1; i <= count; ++i) {
        for (int j = 1; j <= count; ++j) {
            flag[i][j] = 0;
        }
    }
    for (int i = 1; i < count; ++i) {
        for (int j = i + 1; j <= count; ++j) {
            int aver = (int) floor(((sum[j] - sum[i - 1]) * 1.0 / (j - i + 1)) + 0.5);
            for (int k = i; k <= j; ++k) {
                flag[i][j] += (arr[k] - aver) * (arr[k] - aver);
            }
        }
    }
}

void DP(int count, int s) {
    for (int i = 0; i <= count; ++i) {
        for (int j = 0; j <= s; ++j) {
            dp[i][j] = INF;
        }
    }
    dp[0][0] = 0;
    for (int i = 1; i <= s; ++i) {
        for (int j = 1; j <= count; ++j) {
            for (int k = 0; k <= j - 1; ++k) {
                dp[j][i] = min(dp[k][i - 1] + flag[k + 1][j], dp[j][i]);
            }
        }
    }
    cout << dp[count][s] << endl;
}

int cmp(const void *a, const void *b) {
    return (*(int *) a - *(int *) b);
}

int main() {

    int cas = 0;
    while (scanf("%d", &cas) != EOF) {
        for (int i = 0; i < cas; ++i) {
            int count, s;
            cin >> count >> s;
            arr[0] = 0;

            /* initial array */
            for (int j = 1; j <= count; ++j) {
                cin >> arr[j];
            }

            /* sorting */
            qsort(&arr, count + 1, sizeof(int), cmp);

            /* initial sum */
            memset(sum, 0, count);
            /* compute the sum of range from one to j (j <= count) */
            for (int j = 1; j <= count; ++j) {
                sum[j] = sum[j - 1] + arr[j];
            }

            /* get the flag */
            get_flag(count);

            /* dynamic programming */
            DP(count, s);
        }
    }
    return 0;
}
