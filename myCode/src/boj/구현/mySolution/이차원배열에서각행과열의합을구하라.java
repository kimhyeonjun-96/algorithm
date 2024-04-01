package boj.구현.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 이차원배열에서각행과열의합을구하라 {

    static int n;
    static List<ArrayList<Integer>> intList = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            intList.add(new ArrayList<>());
        }

        int element = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                intList.get(i).add(element);
                element++;
            }
        }

        // 각 행의 합
        rowSum();

        sb.setLength(0);

        // 각 열의 합
        columnSum();

    }

    private static void columnSum() {

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += intList.get(j).get(i);
            }
            sb.append(sum).append(" ");
        }
        System.out.println("각 열의 합 : " + sb);
    }

    private static void rowSum() {

        for(int i=0; i<n; i++){
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += intList.get(i).get(j);
            }
            sb.append(sum).append(" ");
        }

        System.out.println("각 행의 합 : " + sb);
    }
}
