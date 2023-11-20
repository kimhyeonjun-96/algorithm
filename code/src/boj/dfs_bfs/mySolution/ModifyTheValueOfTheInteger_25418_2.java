package boj.dfs_bfs.mySolution;
/*
* 1.문제 풀이
*   a와 k를 입력 받는다.
*   큐에는 정수 a와 연산의 수가 정수 배열로 할당된다. ( q.offer(new int[]{a,0} )
*   그리고 현재의 위치를 방문 처리한다.
*   큐가 없을 빌 때까지 반복을 한다.
*       현재의 값을 받는다.
*       현재의 값이 k와 같다면 연산 수를 출력하고 종료한다.
*       값*2가 k 이하라면 방문 처리 후 큐에 추가한다.
*       값+1의 위치에 방문 되어있지 않다면 큐에 추가한다.
*
* 2.시간복잡도
*   해당 문제는 배열 BFS로 문제를 해결하였다.
*   최악의 경우에는 모든 연산을 수행을 해야 확인이 가능하다.
*   결국 K에 영향을 받으며 O(k)라고 할 수 있겠다.
*
* 3.배운 것
*   음...
*   우선 해당 문제를 풀 때 a가 k가 되기 위해서 +1, *2 연산을 모두 수행을 했다.
*   결국 k가 될 때까지 두 연산을 모두 수행 하며 연산의 최소 수를 찾으려 했다.
*   그런데 고민인 것은 어떻게 현재의 값과 연산 수를 계산을 하고 저장을 하느냐였다.
*   이건... 내가 BFS를 잘 몰라서 그런것이다....
*   https://nahwasa.com/entry/BFS-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%84%88%EB%B9%84-%EC%9A%B0%EC%84%A0-%ED%83%90%EC%83%89-%EB%B0%B0%EC%97%B4-BFS-%EA%B7%B8%EB%9E%98%ED%94%84-BFS
*   이 블로그에서 나오는 것을 여러번 보았고 따라 하며 조금 이해가 되었다.
*   그래서 해당 문제가 정말 bfs로 해결하기 위해 만들어진 문제라는 것도 알게되었다..
* */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class ModifyTheValueOfTheInteger_25418_2 {
    public static void main(String[] args) throws IOException {
        bfs();
    }
    private static void bfs() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정수 a와 k를 빈칸을 사이에 두고 순서대로 입력
        int a = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<int[]> q = new LinkedList<>();
        boolean[] v = new boolean[k+1];

        q.offer(new int[]{a,0});
        v[a] = true;

        while (!q.isEmpty()){
            int[] value = q.poll();

            if(value[0] == k){
                System.out.println(value[1]);
                return;
            }
            if(value[0]*2 <= k){
                v[value[0]*2] = true;
                q.add(new int[]{value[0]*2, value[1]+1});
            }
            if(!v[value[0]+1]){
                q.add(new int[]{value[0]+1, value[1]+1});
            }

        }
    }
}
