package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 먹을 것인가 먹힐 것인가
 * https://www.acmicpc.net/problem/7795
 */
public class BOJ_7795 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int answer = 0;
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            int[] b = new int[m];
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(a);
            Arrays.sort(b);

            int p = 0;

            for (int i = 0; i < n; i++) {
                while (p < m && a[i] > b[p]) {
                    p++;
                }
                answer += p;
            }
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}