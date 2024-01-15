package boj.greedy.oterhSolution;
/**
 * 해당 문제를 풀 때, 중복을 어떻게 처리 해야할지 몰랐다.
 * 검색을 해보니 일반적으로 중복값을 처리할 때는 Set을 이용하여 처리를 한다고 한다.
 * 예를 들어 단어 목록에서 중복된 단어를 제거하거나 특정 조건을 만족하는 고유한 값들을 추출하는 등의 상황이 있다고 한다.
 *
 * 다음으로는 두 포인터이다. 두 포인터라는 알고리즘을 몰랐고, 대신에 브루트포스를 사용하여 모든 가능한 조합으로 확인하려고 했다.
 * 두 포인터
 *  정렬된 알고리즘에서 활용
 *  주어진 조건에 맞게 포인터를 이동시키며 원하는 값을 찾느다
 *  시간복잡도 = O(N)
 *
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 두수의합_3273_others {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int X = Integer.parseInt(br.readLine());


        no_two_points(N, arr, X);
        use_two_point(N, arr, X);
    }
    public static void use_two_point(int N, int[] arr, int X) {

        Arrays.sort(arr);

        // 중복 확인
        HashSet<Integer> set = new HashSet<>();


        // 투 포인터
        int left = 0;
        int right = N - 1;
        int cnt = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == X) {
                if(!set.contains(arr[left])){
                    set.add(arr[left]);
                    cnt++;
                }
                left++;
                right--;
            } else if (sum < X) {
                left++;
            }else {
                right--;
            }
        }
        System.out.println(cnt);
    }

    public static void no_two_points(int N, int[] arr, int X) {
        // 중복 확인
        Set<Integer> set = new HashSet<>();
        int cnt = 0;

        // 완전탐색으로 확인
        for (int i = 0; i < N; i++) {
            int complement = X - arr[i];
            if (set.contains(complement)) {
                cnt++;
            }
            set.add(arr[i]);
        }

        System.out.println(cnt);
    }
}