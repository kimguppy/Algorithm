import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1010 {
    static int K;
    static int M;
    static int N;
    static long temp, temp2;
    static long sol;
    static long[] numArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        
        numArr = new long[K + 1];

        
        for (int i = 1; i <= K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if (N == M) {
            	numArr[i] = 1;
            } else {
                temp = 1;
                temp2 = 1;

                for (int j = 1; j <= N; j++, M--) { 
                	temp *= M;
                	temp /= j;
                }

                numArr[i] = temp;
            }
        }
        for (int i = 1; i <= K; i++) {
        	System.out.println(numArr[i]);
        }
        }
        
    }
