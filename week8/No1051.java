import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

public class No1051 {
    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//선언

        String[] input = bf.readLine().split(" ");
        int[] mn = Stream.of(input).mapToInt(Integer::parseInt).toArray();

        ArrayList<ArrayList<String>> board = new ArrayList<>();
        for(int i=0; i<mn[0]; i++){
            String[] rows = bf.readLine().split("");
            ArrayList<String> rowdata = new ArrayList<>();
            Collections.addAll(rowdata, rows); 
            board.add(rowdata);
        }

        int minNumber= Math.min(mn[0], mn[1]);
        int result = 1;
        for(int curRow=0; curRow < mn[0]; curRow++){
            for(int curCol=0; curCol <mn[1]; curCol++){
                String lt = board.get(curRow).get(curCol);
                for(int i=1; i<minNumber+1; i++){
                    if(curRow + i >= mn[0]|| curCol + i >= mn[1]) break;

                    String rt = board.get(curRow).get(curCol+i);
                    String lb = board.get(curRow+i).get(curCol);
                    String rb = board.get(curRow+i).get(curCol+i);

                    if(rt.equals(lt) && lb.equals(lt) && rb.equals(lt) ){
                        int temp = result;
                        result = (i+1)*(i+1);
                        if(temp > result) result = temp;
                    }

                }
            }
        }

        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
    }

}