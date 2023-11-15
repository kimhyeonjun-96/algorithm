package org.boj.dfs_bfs.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NewTime_26876 {

// DFS로 풀었다. 답은 예제에서와 같이 나오지만 계속 틀렸다고 나온다... 다른 방법이 있는 것 같다. 다시 생각을 해야겠다....
/*
* ( 추가 )
* 해당 문제는 BFS로 풀어야한다. 이유는 해당 문제의 요구사항은 올바른 시간까지 버튼을 누르는 최소 횟수를 찾는 것이다.
* BFS의 특성상 한 단계씩 모두 탐색을 하여 특성이 있다. 즉, 올바른 시간까지의 버튼을 누르는 최소 횟수를 찾기 위해 모든 단계의 시간을 검사하며 버튼의 누름의 최소 횟수를 찾아간다.
* 사실 문제를 다시 쭈욱 읽다가 사이트에서 "알고리즘 분류"를 보고 알았다.... 너비 우선 탐색이라고 적혀있었다는...하하하ㅏㅎ
* 처음 이 문제를 보았을 때 왜 그래프 탐색이지? 했었다...으아아ㅏㅏㅏㅏㅏ
 * */
    public static int hh, mm, hh2, mm2, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<2; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), ":");
            if(i == 0){
                hh = Integer.parseInt(st.nextToken());
                mm = Integer.parseInt(st.nextToken());
            }else {
                hh2 = Integer.parseInt(st.nextToken());
                mm2 = Integer.parseInt(st.nextToken());
            }
        }
        // for문으로 대입 X

        cnt = 0;
        dfs(true);
        System.out.println("cnt = " + cnt);
    }

    public static void dfs(boolean sec){
        if(sec){
            if(mm == mm2){
                sec = false;
            }else{
                if(mm >= 59){
                    hh++;
                    mm = 0;
                    cnt++;
                    dfs(sec);
                }else{
                    cnt++;
                    mm++;
                    dfs(sec);
                }
            }
        }
        if(!(hh == hh2)){
            if(hh >= 23){
                hh = 0;
                cnt++;
                dfs(sec);
            }else{
                cnt++;
                hh++;
                dfs(sec);
            }
        }
    }
}
