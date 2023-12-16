package boj.구현.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 너의평점은_25206 {
    static String subjectName , subjectGrade;
    static double grade;

    static double subjectSum, gradeSum = 0;

    static double check_subjectGrade(String grade){

        switch (grade){
            case "A+" : return 4.5;
            case "A0" : return 4.0;
            case "B+" : return 3.5;
            case "B0" : return 3.0;
            case "C+" : return 2.5;
            case "C0" : return 2.0;
            case "D+" : return 1.5;
            case "D0" : return 1.0;
            default: return 0.0;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<20; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            subjectName = st.nextToken();
            grade = Double.parseDouble(st.nextToken());
            subjectGrade = st.nextToken();

            if(subjectGrade.equals("P")) continue;
            subjectSum += grade*check_subjectGrade(subjectGrade);
            gradeSum += grade;
        }

        System.out.println(subjectSum/gradeSum);
    }
}
