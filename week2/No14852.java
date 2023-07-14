import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No14852 {
    static int N;
    static long[][] dp;
    static long MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new long[N][3];
        dp[0][0] = 2;
        dp[0][1] = 1;
        dp[0][2] = 1;

        if(N > 1) {
            dp[1][0] = 7;
            dp[1][1] = 3;
            dp[1][2] = 3;
        }

        for (int i = 2; i < N; i++) {
            dp[i][0] = (2 * dp[i - 1][0] + dp[i - 2][0] + dp[i - 1][1] + dp[i - 1][2]) % MOD;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
        }

        System.out.println(dp[N - 1][0] % MOD);
    }
}