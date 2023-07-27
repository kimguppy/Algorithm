import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class No20364 {
    static int N;
    static int Q;
    static int ducks;
    static boolean[] numArr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));   
        
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        
        numArr = new boolean[N + 1];
        int havenot;
        
        for(int i = 1; i <= Q; i++) {
            ducks = Integer.parseInt(br.readLine());
            havenot = 0;
            
            for(int root = ducks/2;  root >= 1; root= root/2) {
            	if(numArr[root]==true) havenot = root;
            }if(havenot == 0) numArr[ducks] = true;
           
            bw.write(havenot+"\n");
         } 
        
        System.out.println(Arrays.toString(numArr));

        bw.flush();   //남아있는 데이터를 모두 출력시킴
        bw.close(); 
        
    }
}
