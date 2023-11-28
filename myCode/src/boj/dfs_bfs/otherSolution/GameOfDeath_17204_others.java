package boj.dfs_bfs.otherSolution;//No17204_죽음의 게임
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GameOfDeath_17204_others {
    static int[] num, sequenceArr;
    static boolean[] isVisited;
    static int sequence = 0;

    static void dfs(int n){
        isVisited[n] = true;
        sequenceArr[n] = sequence++;
        if(!isVisited[num[n]]) dfs(num[n]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        num = new int[n];
        sequenceArr = new int[n];
        isVisited = new boolean[n];

        for(int i = 0; i < n; i++) num[i] = Integer.parseInt(br.readLine());
        dfs(0);

        System.out.println(sequenceArr[m] == 0 ? -1 : sequenceArr[m]);
    }
}