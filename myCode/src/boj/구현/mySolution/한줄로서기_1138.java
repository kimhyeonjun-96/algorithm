package boj.구현.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 한줄로서기_1138 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 사람 수
        int[] line = new int[N]; // 실제 사람이 서 있었 던리에 사람을 저장 -> 출력

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){ // i = 현재의 사람
            int front = Integer.parseInt(st.nextToken()); // i번째 사람의 앞에 있는 큰 사람들의 수

            System.out.println((i+1) + "번째 사람, 왼쪽 앞에 있는 사람의 수 = " + front);

            int idx = findPosition(line, front, N); // i번째 사람의 실제 위치 탐색

            System.out.println((i+1) + "번째 사람이 실제로 있었던 자리 = " + (idx+1));

            line[idx] = i + 1; // 실제로 있었던 자리에 사람을 저장
        }
        // 출력
        for (int i : line) {
            System.out.print(i + " ");
        }

    }

    private static int findPosition(int[] line, int front, int n) {
        for (int i = 0; i < n; i++) {

            System.out.println(line[i]);

            if (front == 0 && line[i] == 0) { // 현재 사람이 front 수만큼 키가큰 사람이 앞에 있고 위치에 아무도 서있지 않다면 위치로 간다면
                return i; // 위치를 반환
            }
            if(line[i] == 0) front--; // 앞의 사람의 수가 1 이상이고 줄에 사람이 없다면 앞의 사람 수를 줄인다. 즉  줄에 설 수 있어도 앞의 사람의 수가 맞지 않으면 뒤로 더 가야한다.
        }
        return -1;
    }
}
