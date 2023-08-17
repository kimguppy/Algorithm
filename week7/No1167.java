import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1167 {
	static ArrayList<node>[] al;
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		al = new ArrayList[n+1];
		
		for(int i = 0; i < n+1; i++) {
			al[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			
			while(true) {
				int c = Integer.parseInt(st.nextToken());
				if(c != -1) {
					int w = Integer.parseInt(st.nextToken());
					al[p].add(new node(c,w));
				}else {
					break;
				}
			}
		}

		String temp[] = searchDiameter(new node(1,0)).split(" ");
		
		String result[] = searchDiameter(new node(Integer.parseInt(temp[0]),0)).split(" ");
		System.out.print(result[1]);
		
	}
	
	static String searchDiameter(node start) {
		Queue<node> q = new LinkedList<>();
		boolean visited[] = new boolean[n+1];
		int cost[] = new int[n+1];
		
		q.offer(start);
		visited[start.n] = true; //맨 처음 시작하는 노드,
		
		while(!q.isEmpty()) {
			node cur = q.poll();//큐에서 요소를 제거하고 반환 
			for(node i: al[cur.n]) {
				if(!visited[i.n]) {
					visited[i.n] = true;
					cost[i.n] += cost[cur.n] + i.w;
					q.offer(i);
				}
			}
		}
		
		int maxInd = 0;
		int maxVal = 0;
		
		for(int i = 0; i < n+1; i++) {
			if(maxVal < cost[i]) {
				maxVal = cost[i];
				maxInd = i;
			}
		}
		
		return maxInd+" "+maxVal;
	}
	
	static class node {
		int n;
		int w;
		
		node(int n, int w){
			this.n = n;
			this.w = w;
		}
	}

}