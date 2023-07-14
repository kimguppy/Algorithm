import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No1029 {
	static int N, max;
	static int[][] map, dp;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		
		for (int i = 1; i <= N; ++i) {
			String input = br.readLine();
			for (int j = 1; j <= N; ++j) {
				map[i][j] = input.charAt(j - 1) - '0';
			}
		}
		dfs(1, 1, 1);
		bw.write(max + "\n");
	}


	public static void dfs(int i , int state, int visitCnt) {
		if (max == N) return;
		
		max = Math.max(max, visitCnt);
		if (state == (1 << N) - 1) return;
		
		for (int j = 1; j <= N; ++j) {
			if ((state & (1 << (j - 1))) == 0 && map[i][j] >= dp[state][i]) {
				if (dp[state | (1 << (j - 1))][j] != 0 && dp[state | (1 << (j - 1))][j] <= map[i][j]) continue;
				dp[state | (1 << (j - 1))][j] = map[i][j];
				dfs(j, state | (1 << (j - 1)), visitCnt + 1);
			}
		}
	}
}
