package aLevel1to100;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class SignInAndSignOut {

    static class Study{
        String name;
        Date in;
        Date out;
    }

    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Study> studyList = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:MM:SS");
        Study minIn = null;
        Study maxOut = null;
        for (int i=0;i<n;i++){
            Study study = new Study();
            study.name = scanner.next();
            study.in = simpleDateFormat.parse(scanner.next());
            study.out = simpleDateFormat.parse(scanner.next());
            if (null == minIn || study.in.getTime() < minIn.in.getTime()){
                minIn = study;
            }
            if (null == maxOut || study.out.getTime() > maxOut.out.getTime()){
                maxOut = study;
            }
        }
        System.out.println(String.format("%s %s",minIn.name,maxOut.name));
    }
}
