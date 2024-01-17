package boj.백트래킹.otherSolution;
/**
 * 나의 구상도
 *  1. N, M을 입력 받는다.
 *  2. N까지의 자연수를 arr에 저장한다.
 *  3. 조합을 시작한다.
 *  3.1. 제약조건1 & 목표 : M이 0이라면 result에 현재의 상태를 추가한다.
 *  3.2. 제약조건2 : 현재의 인덱스가 arr의 길이와 같다면 그만한다.
 *  3.3. 선택1 : selected에 현재의 인덱스에 있는 arr의 요소 값을 선택한다.
 *  3.4. 선택2 : 현재 선택한 요소와 다음 인덱스로 이동하여 다른 요소들을 선택한다.
 *  3.5. 백트래킹 : 이전 선택 요소를 제거하여 이전 상태로 돌아가서 다른 요소를 선택할 수 있도록 한다.
 *  3.6. 선택3 : 현재 요소를 선택하지 않고 다음 인덱스로 이동하여 다음 요소들을 선태한다.
 *  4. result에 담긴 조합 결과물을 출력한다.
 *
 * 다른 분들의 풀이 ( https://st-lab.tistory.com/114 )
 *  1. N과 M이 주어지고 중복되는 수를 제외한 모든 경우의 수를 탐색 -> 기본적으로 재귀를 통해 해결
 *  2. 재귀를 할 때, 이미 방문한 노드라면 다음 노드를 탐색하도록 하기 위해 N크기의 boolean 배열을 생성하고 탐색과정에서 값을 담을 int 배열 arr을 생성
 *  3. dfs에서 N,M 외에도 depth라는 변수를 추가, depth를 통해 재귀가 깊어질 때마다 depth를 1씩 증가시켜 M과 같아지면 더 이상 재귀를 호출하지 않고 탐색 과정중 값을 담았던 arr을 출력하고 return
 *  DFS를 통하여 백트래킹 문제를 해결
 *
 *
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M01_15649_others {
    static int[] arr;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visit = new boolean[N];

        dfs(N, M, 0);
        System.out.println(sb);
    }

    private static void dfs(int N, int M, int depth) {
        if(depth == M){
            for(int val : arr){
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i=0; i<N; i++){
            if(!visit[i]){

                visit[i] = true; // 해당 노드를 방문상태로 변경
                arr[depth] = i + 1; // 해당 깊이를 index로 하여 i+1 값 저장

                dfs((N), M, depth + 1); // 다음 자식노드 방문을 위해 depth+1을 하여 재귀호출

                visit[i] = false; // 자식노드 방문이 끝나고 돌아오면 방문노드를 방문하지 않은 상태로 변경, 즉 백트래킹을 통한 이전 선택 취소
            }
        }
    }
}
