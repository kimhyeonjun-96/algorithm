package boj.백트래킹;

import java.util.ArrayList;
import java.util.List;

public class Backtracking_example {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int r = 3;
        List<List<Integer>> result = new ArrayList<>();

        backtracking(arr, r, result, new ArrayList<>(), 0);

        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

    private static void backtracking(int[] arr, int r, List<List<Integer>> result, List<Integer> selected, int idx) {
//        System.out.println("idx : " + idx + " , selected : " + selected );

        if(r == 0){
            result.add(new ArrayList<>(selected));
            return;
        }

        if (idx == arr.length) {
            return;
        }

        selected.add(arr[idx]);
        backtracking(arr, r - 1, result, selected, idx + 1);
        selected.remove(selected.size() - 1);

        backtracking(arr, r, result, selected, idx + 1);
    }
}
