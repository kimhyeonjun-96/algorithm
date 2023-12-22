package boj.dfs_bfs.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
    int v;
    int w;

    public Edge(int v, int w) {
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.w, o.w);
    }
}
public class 최단경로_1753 {
    static int V, E, K;
    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    static int[] dist;
    static boolean[] visited;

    static void dijkstra(){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(K, 0));

        while (!pq.isEmpty()){
            Edge current = pq.poll();
            int currentV = current.v;;
            int currentW = current.w;

            if(dist[currentV] < currentW) continue;
            for(Edge next : graph.get(currentV)){
                int weight = currentW + next.w;

                if(weight < dist[next.v]){
                    dist[next.v] = weight;
                    pq.add(new Edge(next.v, weight));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        dist = new int[V+1];
        visited = new boolean[V+1];

        for(int i=0; i<=V; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            graph.get(Integer.parseInt(st.nextToken()))
                 .add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;

        dijkstra();
        for(int i=1; i<=V; i++){
            if(dist[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(dist[i]);
        }

    }
}
