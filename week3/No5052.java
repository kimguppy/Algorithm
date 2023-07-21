import java.io.*;
import java.util.Arrays;

public class No5052 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		
		while(T --> 0) {
			int N = Integer.parseInt(br.readLine());
			String number_list[] = new String[N];

			for(int i=0; i<N; i++) {
				number_list[i] = br.readLine();
			}

			Arrays.sort(number_list);
	
			if(solution(N, number_list)) {
				sb.append("YES\n");
			}
			else {
				sb.append("NO\n");
			}

		}

		System.out.println(sb);
	}

	static boolean solution(int N, String[] number_list) {

		for(int i=0; i<N-1; i++) {
			if(number_list[i + 1].startsWith(number_list[i])) {

				return false;
			}
		}

		return true;

	} 
}