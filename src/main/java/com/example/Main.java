package com.example;

import java.util.*;

import static java.lang.System.out;


public class Main {


    private static void doJob() {
        out.println("doJob()");
    }

    private static void intInput() {
        Scanner scanner = new Scanner(System.in);
        int input = 1;
        out.println("== 게시판 앱 ==");
        while (input != 0) {
            out.print("입력 : ");
            try {
                input = scanner.nextInt();
                out.printf("입력된 문자열 : %d\n", input);

                doJob();

                 // scanner.nextInt();
            } catch (InputMismatchException e) {
                out.println("입력 에러..");
                scanner.nextLine();
            }
        }
        scanner.close();
    }


    private static void displayBbs(SequencedMap<String, String> bbs) {
        int count = 0;
        if (bbs.isEmpty()) {
            out.println("게시물이 없습니다.");
            return;
        }

        Iterator<String> iterator = bbs.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            String value = bbs.get(key);
            out.printf("No. %d\n", ++count);
            out.printf("제목 : %s\n", key);
            out.printf("내용 : %s\n", value);
        }
        out.println();
    }

    private static boolean doJob(Scanner scanner, String cmd, SequencedMap<String, String> bbs) {
        boolean result = false;
        if (cmd.equals("등록")) {
            out.print("제목 : ");
            String key = scanner.nextLine();
            out.print("내용 : ");
            String value = scanner.nextLine();
            bbs.put(key, value);

            out.printf("%d번 게시물이 등록 되었습니다.\n\n", bbs.size());
            result = true;
        }

        return result;
    }

    private static void stringInput() {
        SequencedMap<String, String> bbs = new LinkedHashMap<>();
        Scanner scanner = new Scanner(System.in);
        String cmd = "";
        out.println("== 게시판 앱 ==");
        while (! cmd.equals("종료")) {
            out.print("명령 : ");
            try {
                cmd = scanner.nextLine();
                if (doJob(scanner, cmd, bbs))
                    displayBbs(bbs);
                 //scanner.nextLine();
            } catch (InputMismatchException e) {
                out.println("입력 에러..");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {

        // Main.intInput();

        // Main.stringInput();

        Scanner scanner = new Scanner(System.in);

        new APP(scanner).run();

        scanner.close();
    }
}