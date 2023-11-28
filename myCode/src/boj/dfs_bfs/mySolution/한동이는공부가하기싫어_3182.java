package boj.dfs_bfs.mySolution;

/*
 *1.문제 풀이
 *  첫번째 풀이
 *  선배들의 총 수 ( N )을 입력 받은 후 N1, N2, ... , Nn 까지 각 선배들이 누구를 찾아가야하는지를 입력 받는다.
 *  그렇게 입력 받은 값을 n만큼 반복하며 1부터 n까지 없는 수를 찾아 그 중에서 가장 작은 값을 출력하도록 하였다.
 *  만약 모두 방문하였다면 그 중에서 가장 작은 수를 출력하도록 하였다.
 *
 *  두번째 풀이
 *  선배들의 총 수 ( N )을 입력 받는다.
 *  이후 각 선배들의 대답을 입력 받는다. ( arr[] )
 *  N번만큼 반복을 하며, 각 선배들이 한 대답을 가지고 몇번의 선배를 만날 수 있는지 세어 저장한다. ( answer[] )
 *  이후 각 선배의 대답 중 가장 많이 만날 수 있도록 대답해준 선배의 위치를 출력한다.
 *
 *2.시간복잡도
 *  첫번째 풀이 시간복잡도 : O(n^2)
 *  두번째 풀이 시간복잡도 : O(n^2)
 *
 *3.배운 것
 *  첫번째 풀이
 *  문제 잘 읽자... 문제에서 요구하는 것이 무엇인지 정확하게 파악하자...
 *  이것때문에 정말 많은 시간을 허비했다....
 *
 *  두번째 풀이
 *  위처럼 풀이 방법을 정리한 후에는 그래도 쉬워보였다.. 하하.. 교만이다!
 *  그래서 결국은 검색을 했다...!!
 *  ( https://velog.io/@digh0515/%EB%B0%B1%EC%A4%80-3182%EB%B2%88-%ED%95%9C%EB%8F%99%EC%9D%B4%EB%8A%94-%EA%B3%B5%EB%B6%80%EA%B0%80-%ED%95%98%EA%B8%B0-%EC%8B%AB%EC%96%B4java )
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 한동이는공부가하기싫어_3182 {

    static int n, arr[], answer[];
    static boolean[] visitied;

    private static void intput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        answer = new int[n+1];

        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
    }

    private static void dfs(int i){
        visitied[i] = true;
        while (!visitied[arr[i]]){
            dfs(arr[i]);
        }
    }

    private static void findIndex(){
        int max = 0;
        int index = 0;

        for(int i=1; i<answer.length; i++){
            if(max < answer[i]){
                max = answer[i];
                index = i;
            }
        }
        System.out.println(index);
    }
    public static void main(String[] args) throws IOException {
        // 선배들의 총 수 ( N )을 입력 받는다. 이후 각 선배들의 대답을 입력 받는다. ( arr[] )
        intput();

        // N번만큼 반복을 하며, 각 선배들이 한 대답을 가지고 몇번의 선배를 만날 수 있는지 세어 저장한다. ( answer[] )
        for(int i=1; i<=n; i++){
            int cnt = 0;
            visitied = new boolean[n+1];
            dfs(i);

            for(int j=1; j<visitied.length; j++){
                if(visitied[j]){
                    cnt++;
                }
            }
            answer[i] = cnt;
        }

        // 이후 각 선배의 대답 중 가장 많이 만날 수 있도록 대답해준 선배의 위치를 출력한다.
        findIndex();
    }
}

/*  첫번째 문제  */
//    static int n,arr[];
//    static ArrayList<Integer> visitor = new ArrayList();
//
//    private static void input() throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        n = Integer.parseInt(br.readLine());
//        arr = new int[n];
//
//        for(int i=0; i<n; i++){
//            arr[i] = Integer.parseInt(br.readLine());
//        }
//    }
//
//    private static void personToVisit(){
//        for(int i=1; i<=n; i++){
//            boolean found = false;
//            for(int j=0; j< arr.length; j++){
//                if(i == arr[j]){
//                    found = true;
//                    break;
//                }
//            }
//            if(!found){
//                visitor.add(i);
//            }
//        }
//
//        if(visitor.isEmpty()){
//            int min = Arrays.stream(arr).min().orElse(-1);
//            System.out.println(min);
//        }else System.out.println(Collections.min(visitor));
//    }
//    public static void main(String[] args) throws Exception {
//        한동이는공부가하기싫어_3182.input();
//        한동이는공부가하기싫어_3182.personToVisit();
//    }
