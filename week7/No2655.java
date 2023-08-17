import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class No2665 {
    
    static int n;
    static int[][] board;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] dist;
    
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
        board = new int[n][n];
        dist = new int[n][n];
        
        for(int i = 0; i < n; i++) {
            String temp = br.readLine();
            for(int j = 0; j < n; j++) {
                board[i][j] = temp.charAt(j) - '0';
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        bfs();
        System.out.println(dist[n - 1][n - 1]);
    }
    
    public static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0));
        dist[0][0] = 0;
        
        while(!q.isEmpty()) {
            Node current = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                
                if(nx >= 0 && ny >= 0 && nx < n && ny < n && dist[nx][ny] > dist[current.x][current.y]) {
                    if(board[nx][ny] == 1) dist[nx][ny] = dist[current.x][current.y]; //흰벽
                    else dist[nx][ny] = dist[current.x][current.y] + 1; //검은벽
                    q.offer(new Node(nx, ny));
                }
            }
        }
    }
    
    public static class Node {
        int x;
        int y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}