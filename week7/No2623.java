import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No2623 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		
        int N = Integer.parseInt(st.nextToken()); // 가수의 수
        int M = Integer.parseInt(st.nextToken()); // 보조 PD의 수
		
        ArrayList<Integer>[] list = new ArrayList[N + 1];
        int[] indegree = new int[N + 1]; // 진입 차수
		
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
		
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()); // 보조 PD가 담당한 가수의 수

            int first = Integer.parseInt(st.nextToken());
			
            for (int j = 0; j < num - 1; j++) {
                int sec = Integer.parseInt(st.nextToken());
				
                list[first].add(sec);
                indegree[sec]++;
				
                first = sec;
            }
        }
		
        Queue<Integer> queue = new LinkedList<>();
		
        // 진입 차수가 0인 경우 해당 가수를 큐에 넣음
        for (int i = 1; i < N + 1; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
	
        ArrayList<Integer> result = new ArrayList<>();
		
        while (!queue.isEmpty()) {
            int current = queue.poll();
            result.add(current);
			
            // 특정 가수에 연결된 다른 가수들의 진입 차수를 감소시키고 진입 차수가 0이라면 큐에 넣음
            for (int next : list[current]) {
                indegree[next]--;
				
                if (indegree[next] == 0) {
                    queue.add(next);
                }
            }
        }
        if (result.size() != N) {
            System.out.println(0);
            return;
        }
		
        for (int singer : result) {
            System.out.println(singer);
        }	
    }

}