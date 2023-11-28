package boj.dfs_bfs.mySolution;

/*
 *1.문제 풀이
 *  먼저 데이터를 다음과 같은 형대로 만들고 싶었다.
 *      1 2, 2 3, 1 5, 5 2, 5 6, 4 7
 *      [ [], [2,5], [3], [], [7], [2,6], [], []]
 *  이렇게 데이터 형태를 만들려 한 이유는 각 컴퓨터에 직접적으로 연결이 된 컴퓨터들만을 저장을 하도록 만들려 하였다.
 *  그래서 큐에는 1번 컴퓨터와 먼저 저장이 되고 이후에 1번 컴퓨터와 직간접적으로 연결된 컴퓨터들을 찾아 감연된 컴퓨터의 갯수를 세려고 했다.
 *  그러나 아래의 소스는 boj의 예제에서만 해당이 되었다.
 *  k = 6, n = 5, 1 2, 1 6, 2 4, 3 6, 5 3라는 시나리오에서는 올바른 결과가 나오지 않았다...
 *  정말 하루가 조금 넘게 걸려 풀었는데....
 *
 *  찾으면서 알게된것은 해당 문제는 양방향 그래프로 만들어야 했다....
 *  자료구조가 부족하다는 것이 너무 느껴진다....
 *
 *2.시간복잡도
 *  시간복잡도 : O(n^2)
 *
 *3.배운 것
 *  자료구조! 알고리즘! 열심히 공부!!!
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 바이러스_2606 {
    static int k, n;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static boolean[] v;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());

        for(int i=0; i<=k; i++){
            arr.add(new ArrayList<>());
        }

        v = new boolean[k+1];

        String[] str =  new String[n+1];
        for(int i=1; i<=n; i++){
            str[i] = br.readLine();
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i == Integer.parseInt(str[j].split(" ")[0])){
                    arr.get(i).add(Integer.parseInt(str[j].split(" ")[1]));
                }
            }
        }
    }
    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        v[start] = true;
        int cnt = 0;

        while (!q.isEmpty()){
            int x = q.poll();
            for(int i=0; i<arr.get(x).size(); i++){
                if(!v[arr.get(x).get(i)] ){
                    v[arr.get(x).get(i)] = true;
                    q.add(arr.get(x).get(i));
                    cnt += 1;
                }
            }
        }
        System.out.println(cnt);
    }
    public static void main(String[] args) throws Exception {
        input();
        bfs(1);
    }
}
