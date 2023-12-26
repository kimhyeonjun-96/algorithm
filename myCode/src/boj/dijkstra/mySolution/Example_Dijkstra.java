package boj.dijkstra.mySolution;

/*
* 내가 공부하면 이해한 다익스트라 알고리즘의 핵심은 아래와 같다
*
* 1. 그래프의 경우 인접 리스트로 구현을 한다.
* 2. 다익스트라 알고리즘의 경우 우선순위 큐가 가장 효율적이기에 우선순위 큐를 사용하여 문제를 해결할 것
* 3. 큐에 첫번째 노드가 입력이 되면 첫 노드와 인접한 노드들에 대한 정보(노드&거리)가 저장이 된다.
*   최초에는 시작 노드의 거리를 0으로 설정!
*   이후에는 인접한 노드들에 대한 정보를 우선순위 큐에 저장!
* 4. 만약 저장되어 있는 거리보다 더 짧은 거리가 발견이 된다면 정보를 업데이트
*   우선순위 큐에서 꺼낸 노드를 통해 갈 수 있는 더 짧은 거리를 발견하면 해당 노드의 거리를 업데이트 하고 다시 큐에 추가
* 5. 모든 노드를 순회할 때까지 반복
*   우선순위 큐가 빌 때까지 최단 거리를 업데이트 하고 새로운 노드를 탐색하는 과정을 반복
*
* 아래의 에시는 A 정점에서 F 정점까지 각 정점에 대해 최단경로를 구한다.
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Node implements Comparable<Node>{
    char v;
    int w;

    public Node(char v, int w) {
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.w, o.w);
    }
}
public class Example_Dijkstra {
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int[] dist;
//    static boolean[] visited;

    static int[] dijkstra(char start_v, int start_w ){
        // start_v의 거리를 start_w으로 변경
        dist[start_v-'A'] = start_w;

        // 우선순위 큐 생성
        PriorityQueue<Node> pq = new PriorityQueue();
        pq.add(new Node(start_v, dist[start_v-'A']));


        // 모든 정점을 확인할 때 까지 반복
        while (!pq.isEmpty()){
            Node current_node = pq.poll();
            char currrent_v = current_node.v;

            for(Node next : graph.get(currrent_v-'A')){
                int newDist = dist[currrent_v-'A'] + next.w;

                if(newDist < dist[next.v-'A']){
                    dist[next.v-'A'] = newDist;
                    pq.add(new Node(next.v, newDist));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        // 그래프, 거리, 방문처리
        for(char my_cahr='A'; my_cahr<='F'; my_cahr++){
            graph.add(new ArrayList<>());
        }

        dist = new int[graph.size()];
//        visited = new boolean[graph.size()];

        // 그래프 초기화
        graph.get(0).add(new Node('B', 8));
        graph.get(0).add(new Node('C', 1));
        graph.get(0).add(new Node('D', 2));

        graph.get(2).add(new Node('B', 5));
        graph.get(2).add(new Node('D', 2));

        graph.get(3).add(new Node('E', 3));
        graph.get(3).add(new Node('F',5));

        graph.get(4).add(new Node('F', 1));

        graph.get(5).add(new Node('A', 5));

        // 모든 거리를 INF으로 채우기
        Arrays.fill(dist, Integer.MAX_VALUE);

        // 전체 값 확인
        /*System.out.println(graph);
        for(int i=0; i<graph.size(); i++){
            System.out.println(i+"번 : " + dist[i] + ", " + visited[i]);
        }*/

        // 다익스트라 알고리즘
        dijkstra('A', 0);

        // 결과
        for(char my_char='B'; my_char<='F'; my_char++){
            System.out.print("\'" + my_char + "\'" + ":" +  dist[my_char-'A'] + ", ");
        }
    }
}
