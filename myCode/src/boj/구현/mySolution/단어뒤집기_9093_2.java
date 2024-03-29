package boj.구현.mySolution;

import java.util.Scanner;

public class 단어뒤집기_9093_2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strList = str.split(" ");

        for (String s : strList) {
            for (int j = s.length() - 1; j >= 0; j--) {
                System.out.print(s.charAt(j));
            }
        }

    }
}
