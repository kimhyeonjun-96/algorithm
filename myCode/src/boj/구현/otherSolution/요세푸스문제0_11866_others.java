package boj.구현.otherSolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 요세푸스문제0_11866_others {

    static int n, k;
    static ArrayList<Integer> arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>();
        for (int i = 0; i < n; i++) arr.add(i + 1);

        sb.append('<');
        int idx = 0;
        while (arr.size() > 1) {
            idx = (idx + (k - 1)) % arr.size();
            sb.append(arr.remove(idx)).append(", ");
            System.out.println(arr);
        }
        sb.append(arr.get(arr.size() - 1)).append('>');
        System.out.println(sb);
    }
}
