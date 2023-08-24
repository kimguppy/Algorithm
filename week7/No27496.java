import java.io.*;
import java.util.*;

public class No27496 {
	static int N, M;
	static int[] arr;
	static double[] Alcohol;
	static int sol;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N]; //기존 배열 
		Alcohol = new double[N]; //기존 배열 
		
		String[] input = br.readLine().split(" ");
		
		for(int i=0; i<N; i++) { //배열 새로 만들기
			arr[i] = Integer.parseInt(input[i]);
		}
		
		int A = 0; 
		
		for(int i=0; i<N; i++) { //배열 새로 만들기
			A += arr[i];
			
			if( M <= i) {
				A -= arr[i-M];
			}
			Alcohol[i] = A;
		}
		
		sol=0;
		for(double s : Alcohol ) {
			if( s<= 138 && s>=129 ) sol++; 
	}
		
		System.out.println(sol);
}
}