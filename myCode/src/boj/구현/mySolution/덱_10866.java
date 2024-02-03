package boj.구현.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 덱_10866 {

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new ArrayDeque<Integer>();
        while (N-- > 0){
            String[] str = br.readLine().split(" ");
            String cmd = str[0];
            int e = 0;
            if (str.length == 2) {
                e = Integer.parseInt(str[1]);
            }

            checkCmd(cmd, e, dq);
        }
        System.out.println(sb);

    }

    private static void checkCmd(String cmd, int val, Deque<Integer> dq) {
        switch (cmd) {
            case "push_front" :
                dq.addFirst(val);
                break;
            case "push_back":
                dq.addLast(val);
                break;
            case "pop_front":
                int removeFirst = 0;
                try {
                    removeFirst = dq.removeFirst();
                    sb.append(removeFirst + "\n");
                }catch (Exception e){
                    sb.append(-1 + "\n");
                }
                break;
            case "pop_back":

                int removeLast = 0;
                try {
                    removeLast = dq.removeLast();
                    sb.append(removeLast + "\n");
                }catch (Exception e){
                    sb.append(-1 + "\n");
                }
                break;
            case "size":
                sb.append(dq.size() + "\n");
                break;
            case "empty":
                if(dq.isEmpty()){
                    sb.append(1 + "\n");
                }else{
                    sb.append(0 + "\n");
                }
                break;
            case "front":
                int getFirst = 0;
                try {
                    getFirst = dq.getFirst();
                    sb.append(getFirst + "\n");
                }catch (Exception e){
                    sb.append(-1 + "\n");
                }
                break;
            case "back":
                int getLast = 0;
                try {
                    getLast = dq.getLast();
                    sb.append(getLast + "\n");
                }catch (Exception e){
                    sb.append(-1 + "\n");
                }
                break;
        }
    }
}
