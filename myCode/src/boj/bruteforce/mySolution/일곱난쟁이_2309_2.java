package boj.bruteforce.mySolution;
/**
 * 구상도
 *  - 9명 전체의 키의 합에서 2명의 난쟁이들의 키를 빼기를 했을 때 100일 경우 출력
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 일곱난쟁이_2309_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[9];
        int sum = 0;
        for(int i=0; i<9; i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        Arrays.sort(arr);

        for(int i=0; i<9; i++){
            for(int j=i+1; j<9; j++){
                if(sum - arr[i] - arr[j] == 100){
                    for(int k=0; k<9; k++){
                        if(k != i && k != j){
                            System.out.println(arr[k]);
                        }
                    }
                }
            }
        }
    }
}
