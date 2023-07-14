import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        
        int five= N/5;
        int third;
        boolean finish = false;
        	
		if(N%5 == 0) { result = five; 
		System.out.printf("%d",result);
		finish=true;
    	}else { 
        	for(int i = five; i>=0; i--) {
    		third= N-(five*5);
        	
    		if(third%3 == 0) {result= five+ third/3;
    		System.out.printf("%d",result);
    		finish=true;
    		break;}
    		five--;
    	} 
    	}
    	
    	if(!finish) {System.out.print(-1);}
    	
    }
    }
        