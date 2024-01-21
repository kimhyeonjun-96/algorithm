package boj.bruteforce.mySolution;

/**
 * 구상도
 *  1. 테스트케이스와 각 테스트케이스에 맞는 자연수가 주어진다.
 *  2. 테스트케이스만큼 반복을 하며 자연수가 3개의 삼각수의 합으로 자연수를 구할 수 있다면 1, 아니라면 0을 출력한다.
 *
 * 결과
 *  시간초과...
 *
 * 구상도02
 *  1. 모든 삼각수를 구한다. 여기서는 범위가 3 ~ 1000까지이다. 즉, 1삼국수의 합이 1000까지인 삼각수까지만 구하면 된다. 여기서는 44까지이다.
 *  2. 주어진 자연수를 3개의 삼각수의 합으로 구할수 있는지 확인한다.
 */

import java.io.*;

public class 유레카이론_10448 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1000의 값을 가지는 삼각수 까지 반복하여 모든 삼각수를 구한다.
        int[] arr = new int[45];
        for(int i=1; i<45; i++){
            arr[i] = i * (i + 1) / 2;
        }

        // 테스트케이스만큼 반복
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0){
            // 자연수 입력
            int k = Integer.parseInt(br.readLine());

            // 해당 자연수를 세 개의 삼각수 합으로 만들 수 있는지 확인
            if(check(arr, k)){
                bw.write(1 + "\n");
            }else{
                bw.write(0 + "\n");
            }
        }
        bw.flush();
        bw.close();
    }

    public static boolean check(int[] arr, int k){
        for(int i=1; i<arr.length; i++){
            for(int j=i; j<arr.length; j++){
                for(int l=j; l<arr.length; l++){
                    if((arr[i] + arr[j] + arr[l]) == k) return true;
                }
            }
        }
        return false;
    }

}

//static boolean[] check;
//public static void main(String[] args) throws IOException {
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//    T = Integer.parseInt(br.readLine());
//    check = new boolean[T];
//    for(int i=0; i<T; i++){
//        N = Integer.parseInt(br.readLine());
//
//        int sum = 0;
//        for(int j=1; j<=N; j++){
//            for(int k=j+1; k<=N; k++){
//                for(int l=k+1; l<=N; l++){
//                    sum = (j * (j + 1) / 2) + (k * (k + 1) / 2) + (l * (l + 1) / 2);
//
//                    if(sum == N) check[i] = true;
//                }
//            }
//        }
//    }
//
//    for(boolean cur : check){
//        if(cur) System.out.println(1);
//        else System.out.println(0);
//    }
//}
