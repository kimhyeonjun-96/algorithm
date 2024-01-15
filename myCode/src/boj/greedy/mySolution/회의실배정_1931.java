package boj.greedy.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class 회의실배정_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] time = new int[N][2];

        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });

        int cnt = 0;
        int prev_end = 0;

        for(int i=0; i<N; i++){
            if(prev_end <= time[i][0]){
                prev_end = time[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}


//class Node_1931{
//    int start, end;
//
//    public Node_1931(int start, int end) {
//        this.start = start;
//        this.end = end;
//    }
//
//    @Override
//    public String toString() {
//        return "Node_1931{" +
//                "start=" + start +
//                ", end=" + end +
//                '}';
//    }
//}

//public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int N = Integer.parseInt(br.readLine());
//        List<Node_1931> list = new ArrayList<>();
//
//        StringTokenizer st;
//        for(int i=0; i<N; i++){
//            st = new StringTokenizer(br.readLine());
//
//            list.add(new Node_1931(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
//        }
//
//        list.sort(Comparator.comparingInt( node -> node.end));
//
//
//        int cnt = 0;
//        int prev_end = 0;
//
//        for(Node_1931 node : list){
//            // 이전 종료 시간이 다음 회의 시작 시간보다 작거나 같다면 갱신
//            if(prev_end <= node.start){
//                prev_end = node.end;
//                cnt++;
//            }
//        }
//
//        System.out.println(cnt);
//    }


//public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//        List<Map<Integer, Integer>> arr = new ArrayList<Map<Integer, Integer>>();
//
//        StringTokenizer st;
//        for(int i=0; i<n; i++){
//            st = new StringTokenizer(br.readLine());
//
//            arr.add(new HashMap<>());
//            arr.get(i).put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
//        }
//
//        // 종료 시간으로 정렬
//        arr.sort(Comparator.comparingInt(map -> map.values().iterator().next()));
//
//        int cnt = 0;
//        int endTime = 0;
//        for(Map<Integer, Integer> meeting : arr){
//            int start = meeting.keySet().iterator().next();
//            if(start >= endTime){
//                endTime = meeting.values().iterator().next();
//                cnt++;
//            }
//        }
//        System.out.println(cnt);
//    }