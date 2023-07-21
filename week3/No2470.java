import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class No2470 {
	static int N;
	static int[] solution;
	static int sol=Integer.MAX_VALUE;
	static int answer1, answer2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());	
		String[] input = br.readLine().split(" ");
		
		solution = new int[N];
		
        for(int i=0; i< N; i++) {
        	solution[i] = Integer.parseInt(input[i]);
        }
        
        Arrays.sort(solution);
        
        int left = 0;
        int right = N - 1;
        
        while (left < right) {
            int tmpDiff = Math.abs(solution[left] + solution[right]);
            if (tmpDiff < sol) { //0에 더 가까우면 정답 갱신
            	sol = tmpDiff;
                answer1 = solution[left];
                answer2 = solution[right];
            }
            
            if (solution[left] + solution[right] > 0) { 
                right--;
            } else {
                left++;
            }
        }
        System.out.println(answer1 + " " + answer2);
    }
		
	

}
