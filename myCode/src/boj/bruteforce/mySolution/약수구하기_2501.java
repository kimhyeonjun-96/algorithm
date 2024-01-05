package boj.bruteforce.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 
 * 구상도
 *  자연수 N을 1부터 N번까지 반복을 한다. 
 *  반복을 하며 몫이 0 인 경우라면 약수의 개수를 센다. 
 *  약수의 개수가 K와 같다면 K번째의 값을 저장하고 반복을 중단한다.  
 *  저장된 값을 출력한다.
 * 
 * 시간복잡도
 *  O(n)
 * 
 */

public class 약수구하기_2501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int cnt = 0;
        int result = 0;

        for(int i=1; i<=n ;i++){
            if(n%i == 0){
                cnt++;
            }
            if(cnt == k){
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}

// 틀림
// public static void main(String[] args) throws IOException {
//     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//     StringTokenizer st = new StringTokenizer(br.readLine());

//     int n = Integer.parseInt(st.nextToken());
//     int k = Integer.parseInt(st.nextToken());

//     int m = 0;
//     for(int i=1; i<=n; i++){
//         if(n%i == 0){
//             if(k == i){
//                 m = i;
//                 break;
//             }
//         }
//     }
//     System.out.println(m);
// }
