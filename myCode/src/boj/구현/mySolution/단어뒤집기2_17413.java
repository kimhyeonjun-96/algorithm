package boj.구현.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 단어뒤집기2_17413 {
    public static void main(String[] args) throws IOException {
        // 문자열 입력
        String s = new BufferedReader(new InputStreamReader(System.in)).readLine();
        // 태그와 뒤집은 단어를 저장
        StringBuilder sb = new StringBuilder();

        // 문자열 길이만큼 반복
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '<'){ // '<'를 만났다면
                while (s.charAt(i) != '>'){ // '>'까지 추가
                    sb.append(s.charAt(i));
                    i++;
                }
                sb.append(s.charAt(i)); // '>' 추가
            } else if(s.charAt(i) == ' '){ // 공백을 만났다면
                sb.append(' '); // 공백 추가
            }else{ // 단어를 만났다면
                int start = i; // 단어의 시작 위치
                while (i < s.length() && s.charAt(i) != ' ' && s.charAt(i) != '<'){ // 공백, 태그의 시작도 아니라면 i 증가, 단어의 길이만큼 i 증가
                    i++;
                }
                int end = i - 1; // 단어의 마지막 위치
                for(int j= end; j>= start; j--){ // 반대의 값으로 문자를 저장
                    sb.append(s.charAt(j));
                }
                i--; // 마지막 문자 처리후 1 감소, 감소하지 않으면 공백이 들어가지 않음 ex. baekjoon online judge -> 원래는 8 => i=7, i=14, i=20
            }
        }
        System.out.println(sb);
    }
}






/**
 * 두번째 풀이
 */
//public static void main(String[] args) throws IOException {
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    StringBuilder sb = new StringBuilder();
//
//    String s = br.readLine();
//    String tmp = "";
//    int i=0;
//    while (i<s.length()){
//        if(s.charAt(i) == '<') {
//            while (s.charAt(i) != '>') {
//                sb.append(s.charAt(i));
//                i++;
//            }
//            sb.append(s.charAt(i));
//        }else {
//            if(s.charAt(i) == ' ') {
//                sb.append(tmp);
//                sb.append(" ");
//                tmp = "";
//                i++;
//            }else if(s.charAt(i) == '<'){
//                i++;
//                break;
//            }else {
//                tmp += s.charAt(i);
//                i++;
//            }
//        }
//        System.out.println(tmp);
//        System.out.println("i = " + i);
//        System.out.println("------------");
//    }
//    System.out.println(sb);
//}

/**
 * 첫번째 풀이
 */
//public static void main(String[] args) throws IOException {
//
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    StringBuilder sb = new StringBuilder();
//
//    String str = br.readLine();
//    String tmpStr = "";
//    for(int i=0; i<str.length(); i++){
//        if(str.charAt(i) == '<') {
//            while (str.charAt(i) != '>') {
//                sb.append(str.charAt(i));
//                i++;
//            }
//            sb.append(str.charAt(i));
//        }else{
//            while (str.charAt(i) != ' '){
//                tmpStr += str.charAt(i);
//                i++;
//                if(str.charAt(i) == '<'){
//                    i--;
//                    break;
//                }
//            }
//            StringBuilder stringBuilder = new StringBuilder(tmpStr).reverse();
//            sb.append(stringBuilder.toString());
//            tmpStr = "";
//        }
//    }
//    System.out.println(sb);
//}
