package boj.구현.mySolution;

/*
 *1.문제 풀이
 *  근래에 자료구조와 알고리즘 이론 부분을 공부하느라 많이 못 풀었다.
 *  학교시험도 있었고....
 *  해당 문제를 풀기위해 바로 생각이 난것은 우선순위 큐였다.
 *  얼마전 자료구조를 공부했던 것이 바로 사용되어 기분이 좋았다.
 *  하지만 아직 우선순위 큐에 대해서는 잘 모르기에 사용을 하지 않고 풀어보려 했다.
 *  큐가 아닌 배열을 이용해서 풀려고 했는데 생각보다 잘 되지 않았다.
 *  그래서 처음 작성한 로직을 지우고 우선순위 큐를 자바에서 어떻게 구현하는지 공부하며 알고리즘을 만들었다.
 *  여러 시나리오를 만들고 했을 때, 원하던 답을 얻었는데 백준에서는 틀렸다고 나온다...
 *  뭘까..
 *  암튼 문제 풀고 우선순위 큐 공부하고 하느라 하루종일 걸렸다... 문제자체는 어렵다라고 느껴지지 못했다.
 *
 *2.시간복잡도
 *  음... 이렇게 되었을 때, 시간복잡도가 어떻게 구해야하는지 아직 모르겠다..
 *  O(t)...음.. 공부 필요!
 *
 *3.배운 것
 *  시간복잡도 공부 필요..
 *  자료구조와 알고리즘 공부 확실히!
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Document implements Comparable<Document>{
    int index;
    int importance;
    public Document(int index, int importance) {
        this.index = index;
        this.importance = importance;
    }

    @Override
    public int compareTo(Document o) {
        return Integer.compare(o.importance, this.importance);
    }
}
public class 프린터큐_1966 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] cnt_list = new int[t];

        for(int i=0; i<t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            PriorityQueue<Document> pq = new PriorityQueue<>();

            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                pq.add(new Document(j, Integer.parseInt(st.nextToken()) ));
            }

            int cnt = 0;
            while (!pq.isEmpty()){
                Document doc = pq.poll();
                cnt++;

                if(doc.index == m){
                    break;
                }
            }
            cnt_list[i] = cnt;
        }

        for(int i=0; i<cnt_list.length; i++){
            System.out.println(cnt_list[i]);
        }
    }
}


//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int t = Integer.parseInt(br.readLine());
//
//        // testcase만큼 반복
//        for(int j=0; j<t; j++){
//            // 문서의 수, 인쇄 문서 위치 입력
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int n = Integer.parseInt(st.nextToken());
//            int m = Integer.parseInt(st.nextToken());
//            ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
//            for(int i=0; i<n; i++){
//                arr.add(new ArrayList<>());
//            }
//
//            // 우선순위 입력 및 추가
//            st = new StringTokenizer(br.readLine());
//            for(int i=0; i<n; i++){
//                arr.get(i).add(i);
//                arr.get(i).add(Integer.parseInt(st.nextToken()));
//            }
//
//            // 최대값 찾기
//            ArrayList<Integer> tmpList = new ArrayList<>();
//            for(ArrayList<Integer> row : arr){
//                tmpList.addAll(row);
//            }
//            int max = Collections.max(tmpList);
//            System.out.println(max);
//
//            // 재배치
//            for(int i=0; i<arr.size(); i++){
//                for(int k=0; k<arr.size(); k++) {
//                    if (arr.get(k).get(1) < max) {
//                        arr.add(arr.get(k));
//                        arr.remove(k);
//                    }
//                }
//                System.out.println(arr);
//            }
////            int cnt = 0;
////            for(int i=0; i<n; i++){
////                cnt++;
////                if(arr[i][0] == m) break;
////            }
////            System.out.println(cnt);
//        }
//    }
