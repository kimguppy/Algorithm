import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class No10868 {
    static int N;
    static int M;
    static int[] numArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numArr = new int[N + 1];
        
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            numArr[i] = Integer.parseInt(st.nextToken());
        }
        
        SegmentTree sTree = new SegmentTree();
        
        SegmentTree.STNode node = sTree.initSegmentTree(numArr, 1, N);
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            System.out.println(sTree.getVal(node, start, end));
        }
    }
}
 
class SegmentTree{
    public static class STNode {
        int start;
        int end;
        int val;
        STNode leftChild;
        STNode rightChild;
    }
    
    public static STNode initSegmentTree(int[] a, int l, int r) {
        if(l == r) {
            STNode node = new STNode();
            node.start = l;
            node.end = r;
            node.val = a[l];
            return node;
        }
        int mid = (l + r) / 2;
        STNode lNode = initSegmentTree(a, l, mid);
        STNode rNode = initSegmentTree(a, mid + 1, r);
        STNode root = new STNode();
        root.start = l;
        root.end = r;
        root.val = Math.min(lNode.val, rNode.val);
        root.leftChild = lNode;
        root.rightChild = rNode;
        
        return root;
    }
    
    static int getVal(STNode root, int l, int r) {
        if(root.start >= l && root.end <= r) {
            return root.val;
        }
        if(root.start > r || root.end < l) {
            return Integer.MAX_VALUE;
        }
        return Math.min(getVal(root.leftChild, l, r), getVal(root.rightChild, l, r));
    }
}
