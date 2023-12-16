package boj.구현.mySolution;

/*
*
* 시간복잡도
*   O(n)
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 그룹단어체커_1316 {

    static boolean isGroupWord(String str){

        for(int i=0; i<str.length()-1; i++){
            char currentChar = str.charAt(i);
            char nextChar = str.charAt(i+1);

            if(currentChar != nextChar){
                if(str.indexOf(currentChar, i+1) != -1){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        for(int i=0; i<n; i++){
            String str = br.readLine();

            if(isGroupWord(str)){
                cnt++;
            }
        }
        System.out.println(cnt);
    }

//    static boolean isOnlyOccurrence(String str){
//
//        for(char findChar : str.toCharArray()){
//            if( str.indexOf(findChar, str.indexOf(findChar)+1) == -1){
//                return true;
//            }
//        }
//        return false;
//    }
//    static boolean isConsecutive(String str){
//
//        for(char findChar : str.toCharArray()){
//            int idx = str.indexOf(findChar);
//            if(findChar == str.charAt(idx+1)){
//                return true;
//            }
//        }
//        return false;
//    }
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        int cnt = 0;
//
//        for(int i=0; i<n; i++){
//            String str = br.readLine();
//
//            if(isOnlyOccurrence(str)) cnt++;
//            else if(isConsecutive(str)) cnt++;
//        }
//        System.out.println(cnt);
//    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//        int cnt =0 ;
//
//        for(int i=0; i<n; i++){
//            String str = br.readLine();
//
//            for(int j=0; j<str.length(); j++){
//                char cur_char = str.charAt(j);
//
//                if(j+1 >= str.length()) break;
//                if( cur_char == str.charAt(j+1) && str.indexOf(cur_char) == -1 ){
//                    cnt++;
//                    j += str.indexOf(cur_char);
//                    System.out.println("cnt = " + cnt + ", j = " + j);
//                }
//            }
//        }
//        System.out.println(cnt);
//    }
}