package boj.dfs_bfs.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class AtoB_16953 {

    private static long bfs(int a, int b){
        Queue<Node> q = new LinkedList<>();
        
        q.add(new Node(a, 0));  

        while (!q.isEmpty()) {
            Node cur = q.poll();
            
            long multiply_a = cur.a * 2;
            long add_a = Long.parseLong(cur.a + "1");
            long count = cur.cnt;

            if(cur.a == b) {
                return count+1;
            }
            
            if(multiply_a > b && add_a > b) continue;

            q.offer(new Node(multiply_a, count+1));
            q.offer(new Node(add_a, count+1));
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(bfs(a, b));
    }

    static class Node{
        long a;
        long cnt;

        public Node(long a, long cnt){
            this.a = a;
            this.cnt = cnt;
        }        
    }
}