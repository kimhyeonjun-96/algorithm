package boj.dfs_bfs.otherSolution;
/*
* 내가 만든 로직에서 어느 부분을 수정해야할지를 GPT를 이용하여 수정하였다.
* 수정 부분
*   1. DFS 호출 시 시작 노드 선택
*      루트 노드가 1이라고 명시되어 있었다.
*      나는 루트 노드를 기준으로 다른 로직을 처리하려고 했는데.. 실패했고 털렸다..
*   2. DFS에서의 부모 노드 처리
*      손으로 확인을 해보니 부모 노드를 저장하는 배열이 계속해서 업데이트가 되었다...
*
* 시간복잡도
*   dfs로 반복을 하지만 결국은 n만큼만 반복을하기에 O(n)
* */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 트리의부모찾기_11725_others {
    static int n;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] root_tree_list;

    static void dfs(int start, int parent){
        visited[start] = true;
        root_tree_list[start] = parent;

        for(int i=0; i<graph.get(start).size(); i++){
            int child = graph.get(start).get(i);
            if(!visited[child]) dfs(child, start);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        root_tree_list = new int[n+1];

        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int i=1; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(y).add(x);
            graph.get(x).add(y);
        }
        dfs(1,0);

        for(int i=2; i< root_tree_list.length; i++){
            System.out.println(root_tree_list[i]);
        }
    }
}
//static void dfs(int start){
//    visited[start] = true;
//
//    for(int i=0; i<graph.get(start).size(); i++){
//        int parent_node = graph.get(start).get(i);
//
//        root_tree_list[start] = parent_node;
//        if(!visited[parent_node]){
//            visited[parent_node] = true;
//            dfs(parent_node);
//        }
//    }
//}
//public static void main(String[] args) throws IOException {
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    n = Integer.parseInt(br.readLine());
//    visited = new boolean[n+1];
//    root_tree_list = new int[n+1];
//
//    for(int i=0; i<=n; i++){
//        graph.add(new ArrayList<Integer>());
//    }
//
//    for(int i=1; i<n; i++){
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int x = Integer.parseInt(st.nextToken());
//        int y = Integer.parseInt(st.nextToken());
//
//        graph.get(y).add(x);
//        graph.get(x).add(y);
//    }
//
//    dfs(n);
//
//    for(int i=2; i< root_tree_list.length; i++){
//        System.out.println(root_tree_list[i]);
//    }
//}
