package boj.백트래킹.mySolution;

/**
 * - 구상도
 *     1. N, M을 입력 받는다.
 *     2. N까지의 자연수를 arr 배열에 저장한다.
 *     3. 수열을 만들기 위한 조합을 탐색한다
 *         1. 제약조건01 & 목표 : M이 0이라면 bw에 현재의 상태를 추가한 후 종료한다.
 *         2. 제약조건02 : 현재의 인덱스가 arr의 길이와 같다면 종료한다.
 *         3. 선택01 : selected 리스트에 현재의 인덱스에 있는 arr 요소 값을 선택하여 저장한다.
 *         4. 선택02 : 현재 선택한 요소와 함께 다음 인덱스로 이동하여 다른 요소들을 선택한다.
 *         5. 백트래킹 : 이전에 추가한 요소를 제거하여 이전 상태로 돌아간다.
 *         6. 선택03 : 현재 요소를 선택하지 않은 상태, 즉 이전상태에서 다음 인덱스로 이동하여 다음 요소들을 선택한다.
 *     4. bw 담긴 결과물을 출력한다.
 * - 시간복잡도
 *
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N과M02_15650 {
    static int N, M;
    static int[] arr;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = i + 1;
        }

        getCombination(arr, M, new ArrayList<Integer>(), 0);

        bw.flush();
        bw.close();
    }

    private static void getCombination(int[] arr, int r, List<Integer> seleted, int idx) throws IOException {

        // 제약조건
        if(r == 0){
            for(int result : seleted){
                bw.write(result + " ");
            }
            bw.write("\n");
            return;
        }

        // 제약조건
        if(idx == arr.length) return;

        // 현재 요소 선택
        seleted.add(arr[idx]);
        getCombination(arr, r - 1, seleted, idx + 1);
        // 백트래킹으로 이전 상태로 되돌림
        seleted.remove(seleted.size() - 1);

        // 현재 요소 선택하지 않고( 이전 단계 상태 ) 다음 인덱스로 이동
        getCombination(arr, r, seleted, idx+1);
    }
}
