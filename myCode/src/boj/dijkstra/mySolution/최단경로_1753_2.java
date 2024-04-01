package boj.dijkstra.mySolution;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class 최단경로_1753_2 {

    static int V, E, K;
    static ArrayList<ArrayList<Edge_2>> graph = new ArrayList<>();
    static int[] dist;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken()); // 정점의 수
        E = Integer.parseInt(st.nextToken()); // 간선의 수
        K = Integer.parseInt(br.readLine()); // 출발 정점
        dist = new int[V+1]; // 최단 거리 저장 배열
        visit = new boolean[V+1]; // 방문 여부 배열

        for(int i=0; i<=V; i++){
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            graph.get(Integer.parseInt(st.nextToken())) // 현재 정점
                    .add(new Edge_2(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))); // 다음 정점, 이동시 발생되는 가중치
        }

        Arrays.fill(dist, Integer.MAX_VALUE); // 최단 거리 배열 초기화
        dist[K] = 0; // 출발 정점은 0으로 초기화

        dijkstra();
        for (int i = 1; i <= V; i++) {
            if(dist[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(dist[i]);
        }
    }

    private static void dijkstra() {

        PriorityQueue<Edge_2> pq = new PriorityQueue<>();
        pq.add(new Edge_2(K, 0)); // 출발 정점을 우선순위 큐에 넣어줌

        while (!pq.isEmpty()) { // 우선순위 큐가 빌 때까지 반복
            Edge_2 current = pq.poll();
            int currentV = current.v; // 현재 정점
            int currentW = current.w; // 현재 가중치

            if(dist[currentV] < currentW) continue; // 현재 정점의 최단 거리가 현재 가중치보다 작으면 continue
            for (Edge_2 next : graph.get(currentV)) { // 현재 정점과 연결된 다음 정점들을 탐색, 1->2, 1->3
                int weight = currentW + next.w; // 현재 정점까지의 가중치 + 다음 정점까지의 가중치

                if (weight < dist[next.v]) { // 다음 정점까지의 가중치가 최단 거리 배열에 저장된 값보다 작으면
                    dist[next.v] = weight; // 최단 거리 배열에 저장
                    pq.add(new Edge_2(next.v, weight)); // 우선순위 큐에 다음 정점과 가중치를 넣어줌
                }
            }
        }
    }

}

class Edge_2 implements Comparable<Edge_2>{

    int v, w; // 다음 정점, 가중치

    public Edge_2(int v, int w) {
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Edge_2 o) {
        return Integer.compare(this.w, o.w);
    }
}
