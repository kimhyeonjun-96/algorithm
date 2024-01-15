package boj.bruteforce.mySolution;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Consulting{
    int day, pay;

    public Consulting(int day, int pay) {
        this.day = day;
        this.pay = pay;
    }
}
public class 퇴사_14501 {
    static int n;
    static ArrayList<Consulting> arr = new ArrayList<>();
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr.add(new Consulting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int max = 0;
        for (int i = n; i >= 1; i--) {
            int nextDay = i + arr.get(i - 1).day;

            if (nextDay <= n + 1) {
                dp[i] = Math.max(dp[i + 1], arr.get(i - 1).pay + dp[nextDay]);
            } else {
                dp[i] = dp[i + 1];
            }

            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
//        for(int i=1; i<=n; i++){
//            int cur = i;
//            int sum = 0;
//
//            System.out.println("cur = " + cur);
//            if(cur+arr.get(cur).get(0) < n+1){
//                sum += arr.get(cur).get(1);
//            }
//            for(int next=1; next<=n; next=cur+arr.get(cur).get(0)){
//                if(cur == next) continue;
//                System.out.println("next : " + next);
//                cur = next;
//            }
//            System.out.println("----------------");
//            System.out.println("sum = " + sum);
//            System.out.println("================");
//        }
    }
}
