package boj.백트래킹.mySolution;
/**
 * 구상도
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
 * 시간 복잡도
 *
 */


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N과M01_15649 {
    static int N, M;
    static int[] arr;
    static List<List<Integer>> result = new ArrayList<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = i+1;
        }

        int r = M;
        getCombination(arr, r, result, new ArrayList<>(), 0);


        for(List<Integer> ans : result){
            System.out.println(ans);
        }

        bw.flush();
        bw.close();
    }

    private static void getCombination(int[] arr, int r, List<List<Integer>> result, List<Integer> selected, int idx) throws IOException {
        if(r == 0){
            result.add(new ArrayList<>(selected));
            for(int cur : selected){
                bw.write(cur + " ");
            }
            bw.write("\n");
            return;
        }
        if(idx == arr.length || idx < 0) return;


        selected.add(arr[idx]);
        getCombination(arr, r - 1, result, selected, idx + 1);
        selected.remove(selected.size() - 1);

        getCombination(arr, r, result, selected, idx + 1);
    }
}
