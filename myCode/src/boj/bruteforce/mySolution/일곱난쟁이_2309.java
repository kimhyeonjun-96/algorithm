package boj.bruteforce.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class 일곱난쟁이_2309 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arr = new ArrayList<>();

        int total = 0;
        for(int i=0; i<9; i++){
            arr.add(Integer.parseInt(br.readLine()));
            total += arr.get(i);
        }

        Collections.sort(arr);
        
        for(int i=0; i<arr.size(); i++){
            for(int j=i+1; j<arr.size(); j++){
                if(total - arr.get(i) - arr.get(j) == 100){
                    for(int k = 0; k<arr.size(); k++){
                        if(k != i && k != j){
                            System.out.println(arr.get(k));
                        }
                    }
                    return ;
                }
            }
        }
    }
}

// public static void main(String[] args) throws NumberFormatException, IOException {
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     ArrayList<Integer> arr =new ArrayList<>();

    //     int total = 0;
    //     for(int i=0; i<9; i++){
    //         arr.add(Integer.parseInt(br.readLine()));
    //         total += arr.get(i);
    //     }


    //     for(int i=0; i<arr.size(); i++){
    //         int sum = total - arr.get(i);
    //         for(int j=i+1; j<arr.size(); j++){
    //             if(sum - arr.get(j) == 100){
    //                 arr.remove(j);
    //                 arr.remove(i);
    //             }
    //         }
    //     }
    //     Collections.sort(arr);

    //     for(int n : arr){
    //         System.out.println(n);
    //     }
    // }
