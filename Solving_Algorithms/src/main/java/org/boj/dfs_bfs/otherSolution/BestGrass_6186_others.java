package org.boj.dfs_bfs.otherSolution;

/*
도움 받은 사이트 : https://chung-develop.tistory.com/127 [춍춍 블로그:티스토리]

해당 문제의 경우 비슷한 문제를 푼 경험이 있었다.
당시의 기억으로는 DFS로 문제를 풀었으며 상하좌우 모두 확인을 했어야 했다.
하짐나 나는 해당 문제를 상하, 좌우 이렇게 따로 보아야 한다라고 생각을 했었다.

그런데 다른 사람들이 구현한 것을 보면 상하좌우는 중요한 것이 아닌듯 하다....하하

또 " map[i][j] = (c == '#') ? 1 : 0; " 삼항연산자를 사용하여 불필요한 if문을 줄일 수 있다는 것에 배웠다.

그래도 DFS에 대해서 이전보다 조금 더 이해를 했고 문제를 풀었다는 것에 감사하다!!
* */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BestGrass_6186_others {
    static boolean[][] visited = new boolean[101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int row = Integer.parseInt(split[0]);
        int col = Integer.parseInt(split[1]);

        int[][] map = new int[row][col];
        for (int i = 0; i < row; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);
                map[i][j] = (c == '#') ? 1 : 0;
            }
        }

        int answer = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    answer++;
                    drawWith(i, j, map);
                }
            }
        }

        System.out.println(answer);
    }

    static void drawWith(int x, int y, int[][] map) {
        if (map[x][y] == 1 && !visited[x][y]) {
            visited[x][y] = true;

            //상
            if (x + 1 < map.length && check(x + 1, y, map)) {
                drawWith(x + 1, y, map);
            }

            //하
            if (x - 1 > 0 && check(x - 1, y, map)) {
                drawWith(x - 1, y, map);
            }

            //좌
            if (y - 1 > 0 && check(x, y - 1, map)) {
                drawWith(x, y - 1, map);
            }

            //우
            if (y + 1 < map[0].length && check(x, y + 1, map)) {
                drawWith(x, y + 1, map);
            }
        }
    }

    static boolean check(int x, int y, int[][] map) {
        return map[x][y] == 1;
    }
}
