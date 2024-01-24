package boj.bruteforce.mySolution;
/**
 * 구상도
 *  1. N이 주어지면 N*N 크기의 2차원 배열을 만든다.
 *  2. 서로 다른 색의 사탕들을 입력 받아 배열에 저장한다.
 *  3. 배열 전체를 탐색을 하며 상하좌우로 서로 다른 색을 가진 사탕들이 있는지 찾는다. 서로 다른 사탕들이 있다면, 둘의 위치를 바꾼다.
 *  4. 각 색별로 얼마나 먹을 수 있는지 확인하여, 각 사탕 중 가장 많이 먹은 개수를 저장한다.
 *  5. 각 색들 중 가장 많이 먹을 수 있는 수를 비교하여 제일 많이 먹은 수를 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 사탕게임_3085 {
    static int N, resultMax = Integer.MIN_VALUE;
    static char[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[] colors = {'C', 'P', 'Z', 'Y'};
    static int[] colorsCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new char[N][N]; // 사탕들을 저장
        colorsCount = new int[N+1]; // 색깔별 사탕의 최대값을 저장

        for(int i=0; i<N; i++){
            char[] chars = br.readLine().toCharArray();
            for(int j=0; j<N; j++){
                arr[i][j] = chars[j];
            }
        }

        // 서로 다른 색의 사탕이 인접한 위치 찾기
        for(int i=0; i<N; i++){
            char[][] copyArr = deepCopy(arr);
            for(int j=0; j<N; j++){
                char[][] otherColor = findOtherColor(i, j, copyArr);
                colosCnadyMaxCount(otherColor);
            }
        }
    }

    private static char[][] deepCopy(char[][] original) {
        char[][] result = new char[original.length][original[0].length];
        for(int i=0; i< original.length; i++){
            System.arraycopy(original[i], 0, result[i], 0, original[i].length);
        }
        return result;
    }

    static char[][] findOtherColor(int x, int y, char[][]tmpArr) {
        for(int k=0; k<4; k++){
            int nx = x + dx[k];
            int ny = y + dy[k];

            if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
            if(tmpArr[x][y] != tmpArr[nx][ny]){
                char tmp = tmpArr[nx][ny];
                tmpArr[nx][ny] = tmpArr[x][y];
                tmpArr[x][y] = tmp;
                break;
            }
        }

//        for(int i=0; i<N; i++){
//            for(int j=0; j<N; j++){
//                System.out.print(tmpArr[i][j]);
//            }
//            System.out.println();
//        }
//        System.out.println("-----------------------");
        return tmpArr;
    }

    static void colosCnadyMaxCount(char[][] otherColor){
        boolean[][] visit = new boolean[N][N];

        for(int i=0; i<4; i++){
            colorsCount[i] = dfs(otherColor, colors[i], visit, 0);
            System.out.println("colorsCount[" + i + "] = " + colorsCount[i]);
        }
    }

    private static int dfs(char[][]otherColor, char color, boolean[][] visit, int sum) {
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<4; k++){
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
                    if(!visit[nx][ny] && color == otherColor[nx][ny]){
                        visit[nx][ny] = true;
                        sum = Math.max(sum, dfs(otherColor, color, visit, sum + 1));
                    }
                }
            }
        }
        return sum;
    }

}
