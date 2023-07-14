import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1788 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine())+ 1000000;
        long dp[] = new long[2000001];

        dp[1000001] = 1;
        
        if(N>=1000002) {
        for(int i=1000002 ; i<= 1000000+N ; i++) {
        	dp[i]=dp[i-1]+dp[i-2]%1000000000;
        	
        }
        }if(N<1000000) {
        for(int i=999999 ; i>= 1000000+N ;i--) {
        	dp[i]=dp[i+2]-dp[i+1]%1000000000;
        	
        }
        }
        
       
        if(dp[N+1000000]>0) {System.out.println(1);
        }if(dp[N+1000000]<0) {System.out.println(-1);
        }if(dp[N+1000000]==0) {System.out.println(0);
	}
        System.out.println((Math.abs(dp[N+1000000])));
}
}