package boj.구현.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 에라토스테네스의체_2960 {
    static int N, K, cnt, result;
    static List<Integer> nums = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i=2; i<=N; i++) nums.add(i);

        while (!nums.isEmpty()){
            // 최소 값 구하기
            int p = nums
                    .stream()
                    .min(Integer::compare)
                    .orElse(-1);
            // 최소 값 삭제
            removeDecimal(p);

            if (check()) break;
        }
    }
    private static boolean check() {
        if (cnt == K) {
            System.out.println(result);
            return true;
        }
        return false;
    }
    private static void removeDecimal(int p) {
        // 소수의 배열들을 찾아서 삭제
        for(int i=0; i< nums.size(); i++){
            if (nums.get(i) % p == 0) {
                result = nums.get(i);
                nums.remove(nums.indexOf(result));
                cnt += 1;
            }
        }
    }
}
