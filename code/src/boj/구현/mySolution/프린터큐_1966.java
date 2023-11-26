package boj.구현.mySolution;

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
