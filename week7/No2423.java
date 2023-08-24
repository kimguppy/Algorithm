import java.io.*;
import java.util.*;

public class No2423 {
	static int[][] move1 = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}}; // 대각선
	static int[][] move2 = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우
	static int N, M;
	static char[][] arr;
	static int[][] visit;
	static int INF = 987654321;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new char[N][M]; //기존 배열 하나
		visit = new int[N][M]; // 방문 배열 하나 
		
		for(int i=0; i<N; i++) { //배열 새로 만들기
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				arr[i][j] = str.charAt(j);
				visit[i][j] = INF;
			}
		}
		
		int cnt = arr[N - 1][M - 1] == '\\' ? 0 : 1;
		cnt += arr[0][0] == '\\' ? 0 : 1;
		arr[N - 1][M - 1] = '\\';
		
		dijkstra();
		
		System.out.println(
				visit[N - 1][M - 1] == INF
				? "NO SOLUTION" : (visit[N - 1][M - 1] + cnt));
				
		System.out.println(Arrays.deepToString(visit));
		    }
	
	
	static void dijkstra() {
		PriorityQueue<Circuit> pq = new PriorityQueue<>((o1, o2) -> o1.cnt - o2.cnt); 
		// 두 요소의 차이를 계산하여 큰 값이 우선순위가 높도록 설정한 것

		pq.offer(new Circuit(0, 0, 0, '\\'));
		visit[0][0] = 0;
		
		while(!pq.isEmpty()) {
			Circuit now = pq.poll(); //cnt가 큰 순서대로 빼기
			if( now.r == N - 1 && now.c == M - 1 ) { // 끝까지 도달했다면
				visit[N - 1][M - 1] = now.cnt;
				return;
			}
			
			for(int i=0; i<4; i++) { // 대각선으로 이동하는 경우, 현재 타일과 같아야 연결 가능
				if((now.wire == '\\' && (i == 1 || i == 2)) 
						|| (now.wire == '/' && (i == 0 || i == 3)))
					continue;
				
				int nextR = now.r + move1[i][0];
				int nextC = now.c + move1[i][1];
				
				if(!check(nextR, nextC))
					continue; 
				
				if(now.wire == arr[nextR][nextC] && visit[nextR][nextC] > now.cnt) { // 연결되어 있으면
					visit[nextR][nextC] = now.cnt;
					pq.offer(new Circuit(nextR, nextC, now.cnt, now.wire));
					
				}else if(now.wire != arr[nextR][nextC] && visit[nextR][nextC] > now.cnt + 1
						&& (nextR != N - 1 || nextC != M - 1)) { // 연결되어 있지 않으면 타일 회전 (전구와 연결된 타일은 회전할 수 없음)
					visit[nextR][nextC] = now.cnt + 1; 
					pq.offer(new Circuit(nextR, nextC, now.cnt + 1, now.wire)); 
				}
			}
			
			for(int i=0;i<4;i++) { // 상하좌우로 이동하는 경우, 현재 타일과 달라야 연결 가능
				int nextR = now.r + move2[i][0];
				int nextC = now.c + move2[i][1];
				
				if(!check(nextR, nextC))
					continue;
				
				if(now.wire != arr[nextR][nextC] && visit[nextR][nextC] > now.cnt) { // 연결되어 있으면
					visit[nextR][nextC] = now.cnt;
					pq.offer(new Circuit(nextR, nextC, now.cnt, arr[nextR][nextC]));
				}
				else if(now.wire == arr[nextR][nextC] && visit[nextR][nextC] > now.cnt + 1
						&& (nextR != N - 1 || nextC != M - 1)) { // 연결되어 있지 않으면 타일 회전 (전구와 연결된 타일은 회전할 수 없음)
					visit[nextR][nextC] = now.cnt + 1; 
					pq.offer(new Circuit(nextR, nextC, now.cnt + 1, now.wire == '/' ? '\\' : '/')); 
				}
			}
		}
		
	}
	
	static boolean check(int r, int c) {
		return (r < 0 || r >= N 
				|| c < 0 || c >= M) ? false : true;
	}

	static class Circuit {
		int r, c, cnt;
		char wire;
		
		Circuit(int r, int c, int cnt, char wire) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.wire = wire;
		}
	}
}