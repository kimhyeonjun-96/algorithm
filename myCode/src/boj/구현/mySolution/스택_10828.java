package boj.구현.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 스택_10828 {

    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        LinkedList<Integer> stack = new LinkedList<>();

        while (N-- > 0) {
            String[] str = br.readLine().split(" ");
            String cmd = str[0];
            int x = 0;
            if (str.length == 2) {
                x = Integer.parseInt(str[1]);
            }
            executeCommand(cmd, x, stack);
        }
        System.out.println(sb);
    }

    private static void executeCommand(String cmd, int x, LinkedList<Integer> stack) {
        switch (cmd) {
            case "push" -> {
                stack.offerLast(x);
                break;
            }
            case "pop" -> {
                if(!stack.isEmpty()){
                    int i = stack.pollLast();
                    sb.append(i).append("\n");
                }else{
                    sb.append(-1).append("\n");
                }
                break;
            }
            case "size" -> {
                sb.append(stack.size()).append("\n");
                break;
            }
            case "empty" -> {
                if(!stack.isEmpty()){
                    sb.append(0).append("\n");
                }else{
                    sb.append(1).append("\n");
                }
                break;
            }
            case "top" -> {
                if (!stack.isEmpty()) {
                    int i = stack.getLast();
                    sb.append(i).append("\n");
                }else{
                    sb.append(-1).append("\n");
                }
                break;
            }
        }
    }
}
